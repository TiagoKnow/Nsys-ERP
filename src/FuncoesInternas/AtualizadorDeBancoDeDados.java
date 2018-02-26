package FuncoesInternas;

import Dao.DaoMySQL;
import Parametros.parametrosNS;
import Telas.MenuPrincipal;
import daoConexao.fabricaConexaoMySQL;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Tiago
 */

//Lembrando que essa classe vai precisar fazer exatamente 
//um espelho do que ocorre na base de dados local

//Insert, update e delete

//Pensar numa lógica para comparar todas as colunas

//Se não houver conexão com o banco de dados online

//Encerrar e efetuar esse detalhe depois

/**
 *
 * @author Paulo
 */
public class AtualizadorDeBancoDeDados {
    
    //Fábricas de conexão
    Connection conLoc = null; // Local (Se houver)
    Connection conOnl = null; // Base de dados online (NS3)
    
    //Operações DAO
    DaoMySQL dLoc; // opr1
    DaoMySQL dOnl; // opr2
    
    //Vetores - tabelas (Banco de dados)
    ArrayList            config                = new ArrayList();
    ArrayList<ArrayList> dadosNomeTabelas      = new ArrayList();
    ArrayList            dadosNomeSubTabelas   = new ArrayList();
    ArrayList<ArrayList> dadosTabelas          = new ArrayList();
    ArrayList<ArrayList> dadosTabelasParc      = new ArrayList();
    ArrayList<ArrayList> dadosColunasTabela    = new ArrayList();
    ArrayList<ArrayList> dadosColunasSubTabela = new ArrayList();
    ArrayList<ArrayList> dadosSubSubTabelas    = new ArrayList();
    
    //String
    String mensagem           = "";
    String tipoDadoJava       = "";
    String sql                = "";
    String fatal              = "";
    String sqlparc            = "";
    String sqlstate           = "";
    String nomesColunas       = "";
    String nomesColunasUpdate = "";
    String nomeColunaChave    = "";
    String nomeColunaChave2   = "";
    String nomeSubColunaChave = "";
    String nomeSubColunaChave2= "";
    String verificaTabelasFilhas  = "";
    String variaveisColunasInsert = "";
    String variaveisColunasUpdate = "";
    String chaveSubTabela     = "";
    String nomeTabela         = "";
    String nomeSubTabela      = "";
    String tela               = "";
    
    //Int
    int qtdColunas = 0;
    int contador2  = 0;
    int gii        = 0;
    
    //String
    String valorAtualizadoTabelas   = "";
    String valorAtualizadoRegistros = "";
    //double
    double quantidadeAtualizadaTabelas   = 0.00;
    double quantidadeAtualizadaRegistros = 0.00;
    
    //Configurações da base de dados online
    String servidor  = "mysql.ns3info.com.br";
    int    porta     = 3306;
    String nomeBanco = "ns3info03";
    String usuario   = "ns3info03";
    String senha     = "adm2322";
    
    //Telas
    MenuPrincipal      Mp;
    AtualizadorCluster AtuClu;
    
    public AtualizadorDeBancoDeDados(MenuPrincipal mp, AtualizadorCluster atuClu, String Tela){
        Mp     = mp;
        AtuClu = atuClu;
        tela   = Tela;
        new Thread(){
            public void run(){
                Atualizar();
            }
        }.start();
    }
    
    private void Atualizar(){
        //Configurações do banco de dados ao vetor
        config.clear();        // ok - Limpar vetor
        config.add(servidor);  // ok - 1
        config.add(porta);     // ok - 2
        config.add(usuario);   // ok - 3
        config.add(senha);     // ok - 4
        config.add(nomeBanco); // ok - 5
        
        //Abrindo as conexões
        conLoc = Parametros.parametrosNS.con; // Pegando a conexão o qual o sistema já está sendo executado
        conOnl = fabricaConexaoMySQL.AbrirConexao(config);
        
        //Instanciando as operações dao
        dLoc = new DaoMySQL(conLoc);
        dOnl = new DaoMySQL(conOnl);
        
//        System.out.println("Saída do atualizador: conLoc = " + conLoc);
//        System.out.println("Saída do atualizador: conOnl = " + conOnl);
        
//        sql = "show tables from " + Parametros.parametrosNS.bbd.nomeBanco + ";";
        sql = "show tables from " + parametrosNS.bbd.nomeBanco + " where (substring(Tables_in_" + parametrosNS.bbd.nomeBanco + ", 1, 3) <> 'ns_' and Tables_in_" + parametrosNS.bbd.nomeBanco + " <> 'tb_etiquetas' and Tables_in_" + parametrosNS.bbd.nomeBanco + " <> 'usuarios'and Tables_in_" + parametrosNS.bbd.nomeBanco + " <> 'tb_versao');";
        dadosNomeTabelas = dLoc.Consulta(sql);
        
        if(tela.equalsIgnoreCase("mp")){
            Mp.barra_tabelas    .setMaximum(dadosNomeTabelas.size());
        }else if(tela.equalsIgnoreCase("AT")){
            AtuClu.barra_tabelas.setMaximum(dadosNomeTabelas.size());
        }
        
        for(int i = 0; i < dadosNomeTabelas.size(); i++){
            nomeTabela = (String) dadosNomeTabelas.get(i).get(0);
//            txt_tabela.setText(nomeTabela);
            
            //Ignorar essas dadosNomeTabelas
//            if(nomeTabela.equals("ns_bancodados"))            continue;
//            if(nomeTabela.equals("ns_bancos"))                continue;
//            if(nomeTabela.equals("ns_cep"))                   continue;
//            if(nomeTabela.equals("ns_cidades"))               continue;
//            if(nomeTabela.equals("ns_empresas"))              continue;
//            if(nomeTabela.equals("ns_estados"))               continue;
//            if(nomeTabela.equals("ns_grupoempresa"))          continue;
//            if(nomeTabela.equals("ns_modulos_acesso"))        continue;
//            if(nomeTabela.equals("ns_paises"))                continue;
//            if(nomeTabela.equals("ns_plano_referencial"))     continue;
//            if(nomeTabela.equals("consulta_logacesso_dia"))   continue;
//            if(nomeTabela.equals("consulta_pagamentos_caixa"))continue;
//            if(nomeTabela.equals("usuarios"))                 continue;
//            if(nomeTabela.equals("lc_cat"))                   continue;
//            if(nomeTabela.equals("lc_movimento"))             continue;
//            if(nomeTabela.equals("tb_etiquetas"))             continue;
//            if(nomeTabela.equals("tb_logacesso"))              continue;
            if(nomeTabela.equals(nomeSubTabela))              continue;
            
            VerificarNomeColunaChave(nomeTabela);
            
            ProcessoLerTabelas(nomeTabela, i);
            if(fatal.equals("S")){
                break;
            }
            gii = i;
            
            CarregaBarraTotalTabelas(i);
        }
        if(tela.equalsIgnoreCase("mp")){
            Mp.barra_tabelas              .setValue(0);
            Mp.label_processamentoTabelas .setText("");
            Mp.barra_processoAtual        .setValue(0);
            Mp.label_contadorProcessoAtual.setText("");
        }else if(tela.equalsIgnoreCase("AT")){
            AtuClu.barra_tabelas              .setMaximum(0);
            AtuClu.label_processamentoTabelas .setText("");
            AtuClu.barra_processoAtual        .setValue(0);
            AtuClu.label_contadorProcessoAtual.setText("");
        }
    }
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    private void CarregaBarraTotalTabelas(int i) {
        i++;
        if(i != 0){
            quantidadeAtualizadaTabelas = (i * 100);
            quantidadeAtualizadaTabelas = quantidadeAtualizadaTabelas / dadosNomeTabelas.size();
            valorAtualizadoTabelas      = String.valueOf(quantidadeAtualizadaTabelas);
//                System.out.println("(" + i + " * 100) / " + dadosNomeTabelas.size() + " = " + quantidadeAtualizadaTabelas + "        Valor texto: " + valorAtualizadoTabelas);
        }
        if(valorAtualizadoTabelas.length() > 2){
            if(valorAtualizadoTabelas.substring(1, 2).equals(".")){
                valorAtualizadoTabelas = "00" + valorAtualizadoTabelas.substring(0, 3) + "% / 100.0%";
            }
            if(valorAtualizadoTabelas.substring(2, 3).equals(".")){
                valorAtualizadoTabelas = "0"  + valorAtualizadoTabelas.substring(0, 4) + "% / 100.0%";
            }
        }
        if(quantidadeAtualizadaTabelas == 100){
            valorAtualizadoTabelas = "100.0% / 100.0%";
        }
        System.out.println("Tabela: " + valorAtualizadoTabelas);
        if(tela.equalsIgnoreCase("mp")){
            Mp.barra_tabelas.setValue(i);
            Mp.barra_tabelas.repaint();
            Mp.label_processamentoTabelas.setText(valorAtualizadoTabelas);
        }else{
            AtuClu.barra_tabelas.setValue(i);
            AtuClu.barra_tabelas.repaint();
            AtuClu.label_processamentoTabelas.setText(valorAtualizadoTabelas);
        }
    }
    
    private void CarregaBarraProcessoAtual(int i2) {
        i2++;
        if(i2 != 0){
            quantidadeAtualizadaRegistros = (i2 * 100);
            quantidadeAtualizadaRegistros = quantidadeAtualizadaRegistros / dadosTabelas.size();
            valorAtualizadoRegistros      = String.valueOf(quantidadeAtualizadaRegistros);
//            System.out.println("(" + i + " * 100) / " + dadosNomeTabelas.size() + " = " + quantidadeAtualizadaTabelas + "        Valor texto: " + valorAtualizadoTabelas);
        }
        if(valorAtualizadoRegistros.length() > 2){
            if(valorAtualizadoRegistros.substring(1, 2).equals(".")){
                valorAtualizadoRegistros = "00" + valorAtualizadoRegistros.substring(0, 3) + "% / 100.0%";
            }
            if(valorAtualizadoRegistros.substring(2, 3).equals(".")){
                valorAtualizadoRegistros = "0"  + valorAtualizadoRegistros.substring(0, 4) + "% / 100.0%";
            }
        }
        if(quantidadeAtualizadaRegistros == 100){
            valorAtualizadoRegistros = "100.0% / 100.0%";
        }
        System.out.println("Registros: " + valorAtualizadoRegistros);
        if(tela.equalsIgnoreCase("mp")){
            Mp.barra_processoAtual.setValue(i2);
            Mp.barra_processoAtual.repaint();
            Mp.label_contadorProcessoAtual.setText(valorAtualizadoRegistros);
        }else{
            AtuClu.barra_processoAtual.setValue(i2);
            AtuClu.barra_processoAtual.repaint();
            AtuClu.label_contadorProcessoAtual.setText(valorAtualizadoRegistros);
        }
    }
    
    private void VerificarNomeColunaChave(String nomeTabela){
        dadosNomeSubTabelas = new ArrayList();
        verificaTabelasFilhas = "N";
        nomeColunaChave  = "";
        nomeColunaChave2 = "";
        if(nomeTabela.equalsIgnoreCase("tb_boletos")){           nomeColunaChave = "codigoBoleto";return;}
        if(nomeTabela.equalsIgnoreCase("tb_boletos_instrucoes")){nomeColunaChave = "codigoBoletoInstrucao";return;}
        if(nomeTabela.equalsIgnoreCase("tb_boletos_retorno")){   nomeColunaChave = "codigoBoleto";return;}
        if(nomeTabela.equalsIgnoreCase("tb_caixa_abertura")){    nomeColunaChave = "codigoAbertura";       return;}
        if(nomeTabela.equalsIgnoreCase("tb_caixa_fechamento")){
            verificaTabelasFilhas = "S";
            nomeColunaChave       = "codigoFechamento";
            dadosNomeSubTabelas.add("tb_caixa_fechamento_detalhes");
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_caixa_motivo_saida")){       nomeColunaChave = "codigoMotivoSaida"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_caixa_saida")){              nomeColunaChave = "codigoCaixaSaida";  return;}
        if(nomeTabela.equalsIgnoreCase("tb_cancelamento")){             nomeColunaChave = "codigoCancelamento";return;}
        if(nomeTabela.equalsIgnoreCase("tb_clientes")){                 nomeColunaChave = "codigoCliente";     return;}
        if(nomeTabela.equalsIgnoreCase("tb_clientes_historico")){
            nomeColunaChave  = "codigoCliente";
            nomeColunaChave2 = "codigoHistorico";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_clientes_historico_listas")){nomeColunaChave = "codigoPredefenido"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_comandas")){                 nomeColunaChave = "codigoComanda";     return;}
        if(nomeTabela.equalsIgnoreCase("tb_comandas_itens")){
            nomeColunaChave  = "codigoComanda";
            nomeColunaChave2 = "codigoComandaItem";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_computadores")){    nomeColunaChave = "codigoComputador";   return;}
        if(nomeTabela.equalsIgnoreCase("tb_contacorrente")){   nomeColunaChave = "codigoContaCorrente";return;}
        if(nomeTabela.equalsIgnoreCase("tb_contratos")){       nomeColunaChave = "codigoContrato";     return;}
        if(nomeTabela.equalsIgnoreCase("tb_departamento")){    nomeColunaChave = "codigoDepartamento"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_despesas")){        nomeColunaChave = "codigoDespesa";      return;}
        if(nomeTabela.equalsIgnoreCase("tb_despesas_tipo")){   nomeColunaChave = "codigoDespesaTipo";  return;}
        if(nomeTabela.equalsIgnoreCase("tb_fabricante")){      nomeColunaChave = "codigoFabricante";   return;}
        if(nomeTabela.equalsIgnoreCase("tb_formaspagamentos")){nomeColunaChave = "codigoPagamento";    return;}
        if(nomeTabela.equalsIgnoreCase("tb_fornecedor")){      nomeColunaChave = "codigoFornecedor";   return;}
        if(nomeTabela.equalsIgnoreCase("tb_funcionarios")){    nomeColunaChave = "codigoFuncionario";  return;}
        if(nomeTabela.equalsIgnoreCase("tb_grupoproduto")){    nomeColunaChave = "codigoGrupoProduto"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_logacesso")){       nomeColunaChave = "codigoLogAcesso";    return;}
        if(nomeTabela.equalsIgnoreCase("tb_modulos")){
            nomeColunaChave  = "codigoEmpresa";
            nomeColunaChave2 = "usuarioModulo";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_movimentacaobancaria")){
            nomeColunaChave  = "codigoUsuario";
            nomeColunaChave2 = "idTabela";
        }
        if(nomeTabela.equalsIgnoreCase("tb_oc")){              nomeColunaChave = "codigoOrdemCompra";     return;}
        if(nomeTabela.equalsIgnoreCase("tb_oc_itens")){
            nomeColunaChave  = "codigoOrdemCompra";
            nomeColunaChave2 = "codigoOrdemCompraItem";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_orcamentos")){      nomeColunaChave = "codigoOrcamento";       return;}
        if(nomeTabela.equalsIgnoreCase("tb_orcamentos_itens")){
            nomeColunaChave  = "codigoOrcamento";
            nomeColunaChave2 = "codigoOrcamentoItem";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_os")){              nomeColunaChave = "codigoOrdemServico";    return;}
        if(nomeTabela.equalsIgnoreCase("tb_os_itens")){
            nomeColunaChave  = "codigoOrdemServico";
            nomeColunaChave2 = "codigoOrdemServicoItem";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_os_pagamentos")){
            nomeColunaChave  = "codigoOrdemServico";
            nomeColunaChave2 = "codigoPagamento";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_os_pagamentos_credito")){
            nomeColunaChave  = "codigoOrdemServico";
            nomeColunaChave2 = "codigoPagamento";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_parametros")){                 nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametroscc")){               nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametroscontabil")){         nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametrosestoque")){          nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametrosgestao")){           nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametrosproducao")){         nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_parametrosvendas")){           nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_planodecontas")){              nomeColunaChave = "codigoPlanoDeContas";return;}
        if(nomeTabela.equalsIgnoreCase("tb_planodecontasmovimentos")){    nomeColunaChave = "codigoPlanoDeContas";return;}
        if(nomeTabela.equalsIgnoreCase("tb_planodecontasrelacionamento")){nomeColunaChave = "codigoEmpresa"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_produtos")){                   nomeColunaChave = "codigoProduto"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_produtos_detalhes")){          nomeColunaChave = "codigoProduto"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_servicos")){                   nomeColunaChave = "codigoServico"; return;}
        if(nomeTabela.equalsIgnoreCase("tb_situacoes")){                  nomeColunaChave = "codigoSituacao";return;}
        if(nomeTabela.equalsIgnoreCase("tb_subgrupoproduto")){
            nomeColunaChave  = "codigoGrupoProduto";
            nomeColunaChave2 = "codigoSubGrupoProduto";
            return;
        }
        if(nomeTabela.equalsIgnoreCase("tb_transportadoras")){  nomeColunaChave = "codigoTransportadora";return;}
        if(nomeTabela.equalsIgnoreCase("tb_usuarios")){         nomeColunaChave = "codigoUsuario";       return;}
        if(nomeTabela.equalsIgnoreCase("tb_usuarios_email")){   nomeColunaChave = "codigoUsuario";       return;}
        if(nomeTabela.equalsIgnoreCase("tb_veiculos")){         nomeColunaChave = "codigoVeiculo";       return;}
    }
    
    private void ProcessoLerTabelas(String nomeTabela, int i){
        sql = "show columns from " + nomeTabela + ";";
        dadosColunasTabela = new ArrayList();
        dadosColunasTabela = dLoc.Consulta(sql);
        
        sql = "select * from " + nomeTabela + " where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosTabelas = new ArrayList();
        dadosTabelas = dLoc.Consulta(sql); // Popular o vetor com as suas linhas
        nomesColunas = "";
        if(tela.equalsIgnoreCase("Mp")){
            Mp.barra_processoAtual        .setMaximum(dadosTabelas.size());
        }else{
            AtuClu.barra_processoAtual        .setMaximum(dadosTabelas.size());
        }
        
        for(int i2 = 0; i2 < dadosTabelas.size(); i2++){
            PegaColunasTabela(nomeTabela, i, i2);
            if(fatal.equals("S")){
                return;
            }
            CarregaBarraProcessoAtual(i2);
        }
        gii = i;
    }
    
    private void PegaColunasTabela(String nomeTabela, int i, int i2){
        String varChave  = "";
        String varChave2 = "";
        
        String nomeCampo     = "";
        String nomeCampo2    = "";
        String tipoDadoMySQL = "";
        String nomeExtra     = "";
        
        String nomeColunaFilha   = "";
        String verificouSeExiste = "N";
        String aux1     = "";
        String aux2     = "";
        String auxparc  = "";
        
        variaveisColunasInsert = "";
        variaveisColunasUpdate = "";
        nomesColunas = "";
        dadosTabelasParc = new ArrayList();
        for(int i3 = 0; i3 < dadosColunasTabela.size(); i3++){
//            if(nomeTabela.equals("tb_os")){
//                if(i3 == dadosColunasTabela.size() - 1){
//                    System.out.println("");
//                }
//            }
            
            aux1 = String.valueOf(dadosTabelas.get(i2).get(i3));
            
            nomeCampo     = (String) dadosColunasTabela.get(i3).get(0);
            tipoDadoMySQL = (String) dadosColunasTabela.get(i3).get(1); //Tratar os casos previstos no projeto
            nomeExtra     = (String) dadosColunasTabela.get(i3).get(5); //Pegar a observação se o campo é AI
            
            if(tipoDadoMySQL.equalsIgnoreCase("longblob"))  continue;
//            if(nomeCampo.equals("imagemProduto"))      continue; // #01
//            if(nomeCampo.equals("imagemUsuario"))      continue; // #02
//            if(nomeCampo.equals("imagemFuncionario"))  continue; // #03
//            if(nomeCampo.equals("imagemBoletos"))      continue; // #04
            
            if(verificaTabelasFilhas.equals("S")){
                if(!nomeExtra.equals("")){
                    nomeColunaFilha = nomeCampo;
                    auxparc = aux1;
                    continue;
                }
            }
            if(verificaTabelasFilhas.equals("N")){if(!nomeExtra.equals(""))continue;}
            
            if(tipoDadoMySQL.substring(0, 3).equals("int"     )){tipoDadoJava = "int";}
            else if(tipoDadoMySQL.substring(0, 4).equals("date"    )){tipoDadoJava = "data";}
            else if(tipoDadoMySQL.substring(0, 4).equals("time"    )){tipoDadoJava = "Hora";}
            else if(tipoDadoMySQL.substring(0, 6).equals("double"  )){tipoDadoJava = "double";}
            else if(tipoDadoMySQL.substring(0, 7).equals("varchar" )){tipoDadoJava = "String";}
            else if(tipoDadoMySQL.substring(0, 8).equals("longblob")){tipoDadoJava = "blob";}
            
            variaveisColunasInsert = variaveisColunasInsert + MontaInstrucao(aux1, i, "I", nomeCampo);
            if(verificouSeExiste.equals("S")){variaveisColunasUpdate = variaveisColunasUpdate + MontaInstrucao(aux1, i, "U", nomeCampo);}
            
            if(nomeColunaChave.equals(nomeCampo)){
                varChave = aux1;
                verificouSeExiste = "S";
                nomeCampo2    = (String) dadosColunasTabela.get(i3 + 1).get(0);
                sql = "select * from " + nomeTabela + " where idEmpresa = " + parametrosNS.be.IdEmpresa;
                if(!nomeColunaChave.equals("idEmpresa")){
                    sql += " and " + nomeColunaChave + " = " + aux1;
                }
                if(!nomeColunaChave2.equals("")){
                    if(!nomeColunaChave2.equals(nomeCampo2)){
                        continue;
                    }
                    aux2 = String.valueOf(dadosTabelas.get(i2).get(i3 + 1));
                    varChave2 = aux2;
                    sql += " and " + nomeColunaChave2 + " = " + aux2;
                }
                sql += ";";
                dadosTabelasParc = new ArrayList();
                System.out.println(dOnl + " : " + sql);
                dadosTabelasParc = dOnl.Consulta(sql);
            }
            
            if(verificouSeExiste.equals("S")){
                if(dadosTabelasParc.isEmpty()){
                    variaveisColunasUpdate = "";
                }else{
                    variaveisColunasInsert = "";
                }
            }
        }
        if(!dadosTabelasParc.isEmpty()){
            AlterarRegistro(nomeTabela, varChave, varChave2);
        }else{
            IncluirRegistro(nomeTabela, varChave, varChave2,i);
        }
        if(fatal.equals("S")){
            return;
        }
        PegaSubTabelas(nomeColunaFilha, auxparc, i);
    }
    
    private String MontaInstrucao(String aux1, int i, String tipo, String nomeDoCampo){
        String var;
        String aux2 = "";
        nomesColunasUpdate = "";
        if(gii != i || gii == 0){
            if(tipo.equals("I")){
                nomesColunas = nomesColunas + nomeDoCampo + ", ";
            }else{
                nomesColunasUpdate = nomesColunasUpdate + nomeDoCampo + " = ";
            }
        }
        if(tipoDadoJava.equalsIgnoreCase("int")){
            if(aux1.equalsIgnoreCase("")){aux1 = "null";}
            if(aux1.isEmpty()){aux1 = "null";}

            aux2 = aux1;

            var = aux2 + ", ";
        }else if(tipoDadoJava.equalsIgnoreCase("String")){
            aux2 = "'" + aux1 + "'";

            if(aux1.equalsIgnoreCase("null")){aux2 = "null";}
            if(aux1.equalsIgnoreCase("")){aux2 = "null";}
            if(aux1.isEmpty()){aux2 = "null";}

            var = aux2 + ", ";
        }else if(tipoDadoJava.equalsIgnoreCase("double")){
            if(aux1.equalsIgnoreCase("")){aux1 = "null";}
            if(aux1.isEmpty()){aux1 = "null";}

            aux2 = aux1;

            var = aux2 + ", ";
        }else if(tipoDadoJava.equalsIgnoreCase("Data")){
            aux2 = "'" + aux1 + "'";

            if(aux1.equalsIgnoreCase("null")){aux2 = "null";}
            if(aux1.equalsIgnoreCase("")){aux2 = "null";}
            if(aux1.isEmpty()){aux2 = "null";}

            var = aux2 + ", ";
        }else if(tipoDadoJava.equalsIgnoreCase("Hora")){
            aux2 = "'" + aux1 + "'";

            if(aux1.equalsIgnoreCase("null")){aux2 = "null";}
            if(aux1.equalsIgnoreCase("")){aux2 = "null";}
            if(aux1.isEmpty()){aux2 = "null";}

            var = aux2 + ", ";
        }else{
            var = aux2 + ", ";
        }
        if(tipo.equals("S")){
            return var;
        }else{
            return nomesColunasUpdate + var;
        }
    }
    
    private void IncluirRegistro(String nomeTabela, String varChave, String varChave2, int i){
        if(gii != i || gii == 0){
            variaveisColunasInsert = variaveisColunasInsert    .substring(0, variaveisColunasInsert    .length() - 2);
        }
        nomesColunas           = nomesColunas.substring(0, nomesColunas.length() - 2);
        
        sql = "insert into " + nomeTabela + " (" + nomesColunas + ") values (" + variaveisColunasInsert + ");";
//        System.out.println(sql);
//        sqlstate = dOnl.incluirRegistro(sql);
        sqlstate = "00000";
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir registro n°" + varChave + " da tabela: " + nomeTabela + ";";
            mostraMensagem();
            fatal = "S";
            return;
        }
    }
    
    private void AlterarRegistro(String nomeTabela, String varChave, String varChave2){
        variaveisColunasUpdate = variaveisColunasUpdate.substring(0, variaveisColunasUpdate.length() - 2);
        sql = "update " + nomeTabela + " set " + variaveisColunasUpdate + " where " +
                "idEmpresa = " + parametrosNS.be.IdEmpresa + " and " +
                nomeColunaChave + " = " + varChave;
        if(!nomeColunaChave2.equals("")){
            sql += " and " + nomeColunaChave2 + " = " + varChave2;
        }
        sql += ";";
//        System.out.println(sql);
//        sqlstate = dOnl.AlterarRegistroOuConsultaSeTabelaExiste(sql, "N");
        sqlstate = "00000";
        if(!sqlstate.equals("00000")){
            mensagem = "Erro ao incluir registro n°" + varChave + " da tabela: " + nomeTabela + ";";
            mostraMensagem();
            fatal = "S";
            return;
        }
    }
    
    private void VerificarSubNomeColunaChave(String nomeSubTabela){
        if(nomeSubTabela.equalsIgnoreCase("tb_caixa_fechamento_detalhes")){nomeSubColunaChave = "idFechamento";  chaveSubTabela = "N";return;}
    }
    
    private void PegaSubTabelas(String nomeColunaFilha, String auxparc, int i){
        ArrayList<ArrayList> dadosSubTabelas     = new ArrayList();
        for(int i3 = 0; i3 < dadosNomeSubTabelas.size(); i3++){
            nomeSubTabela = String.valueOf(dadosNomeSubTabelas.get(i3));
            VerificarSubNomeColunaChave(nomeSubTabela);
            sql = "select * from " + nomeSubTabela + " where " + nomeColunaFilha + " = " + auxparc + ";";
            
            dadosSubTabelas = new ArrayList();
            dadosSubTabelas = dLoc.Consulta(sql);
            
            ProcessoLerSubTabelas(dadosSubTabelas, auxparc, i, i3);
        }
    }
    
    private void ProcessoLerSubTabelas(ArrayList<ArrayList> dadosSubTabelas, String auxparc, int i, int i3){
        sql = "select * from " + nomeSubTabela + " where " + nomeSubColunaChave + " = " + auxparc + ";";
        dadosSubSubTabelas = new ArrayList();
        dadosSubSubTabelas = dOnl.Consulta(sql);
        if(!dadosSubSubTabelas.isEmpty()){
            return;
        }
        sql = "show columns from " + nomeSubTabela + ";";
        dadosColunasSubTabela = new ArrayList();
        dadosColunasSubTabela = dLoc.Consulta(sql);
        for(int i4 = 0; i4 < dadosSubTabelas.size(); i4++){
            PegaColunasSubTabelas(dadosSubTabelas, i, i3, i4);
        }
    }
    
    private void PegaColunasSubTabelas(ArrayList<ArrayList> dadosSubTabelas, int i, int i3, int i4){
        String aux3     = "";
        int qtdItensLoc = 0;
        int qtdItensOnl = 0;
        
        String nomeSubCampo       = "";
        String tipoSubDadoMySQL   = "";
        String nomeSubExtra       = "";
        
        variaveisColunasInsert = "";
        variaveisColunasUpdate = "";
        nomesColunas = "";
        for(int i5 = 0; i5 < dadosColunasSubTabela.size(); i5++){
            aux3 = String.valueOf(dadosSubTabelas.get(i4).get(i5));
            
            nomeSubCampo     = (String) dadosColunasSubTabela.get(i5).get(0);
            tipoSubDadoMySQL = (String) dadosColunasSubTabela.get(i5).get(1); //Tratar os casos previstos no projeto
            nomeSubExtra     = (String) dadosColunasSubTabela.get(i5).get(5); //Pegar a observação se o campo é AI
            
            if(!nomeSubExtra.equals(""))continue;
            
            if(tipoSubDadoMySQL.substring(0, 3).equals("int"     )){tipoDadoJava = "int";}
            else if(tipoSubDadoMySQL.substring(0, 4).equals("date"    )){tipoDadoJava = "data";}
            else if(tipoSubDadoMySQL.substring(0, 4).equals("time"    )){tipoDadoJava = "Hora";}
            else if(tipoSubDadoMySQL.substring(0, 6).equals("double"  )){tipoDadoJava = "double";}
            else if(tipoSubDadoMySQL.substring(0, 7).equals("varchar" )){tipoDadoJava = "String";}
            else if(tipoSubDadoMySQL.substring(0, 8).equals("longblob")){tipoDadoJava = "blob";}
            
            variaveisColunasInsert = variaveisColunasInsert + MontaInstrucao(aux3, i3, "I", nomeSubCampo);
            if(nomeSubColunaChave.equals(nomeSubCampo)){
                sql = "select count(*) from " + nomeSubTabela + " where " + nomeSubColunaChave + " = " + aux3 + ";";
                qtdItensLoc = dLoc.ConsultaQTD(sql, "count(*)");
                qtdItensOnl = dOnl.ConsultaQTD(sql, "count(*)");
            }
        }
        if(dadosSubSubTabelas.isEmpty()){
            IncluirRegistro(nomeSubTabela, String.valueOf(i4), String.valueOf(0), i);
        }
    }
    
}
