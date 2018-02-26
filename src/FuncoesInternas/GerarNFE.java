//package FuncoesInternas;
//
//import java.util.ArrayList;
//
///**
// * @author Tiago 07/09/2017 18:01
// */
//public class GerarNFE {
//    //Vetores
//    ArrayList<ArrayList> dados = new ArrayList();
//        
//    public String gerarDetalhes(ArrayList<ArrayList> dados1){
//        dados = dados1;
//                
//            //v_nfeB = cmd.buscarRPS(dataInicial,dataFinal);//Passar como parâmetros as datas Incial e Final
//            v_nfeB = cmd.buscarRPS(dataI, dataF);
//
//       //Vector v_nfeB = new Vector();
//
//        for(int i = 0; i < v_nfeB.size(); i++){
//            beanDetalhe detalhe = new beanDetalhe();
//
//            detalhe.setNContrato(((beanDetalhe)(v_nfeB.get(i))).getNContrato());
//            detalhe.setLContrato(((beanDetalhe)(v_nfeB.get(i))).getLContrato());
//
//            detalhe.setTipoRegistro(2);
//            //este campo já está OK - pois é uma constante
//
//            detalhe.setTipoRPS("RPS  ");
//            //campos alfanuméricos deveração ser alinhados a esquerda. E preecher o restando com 0
//            //até completar o seu tamanho máximo.
//
//            detalhe.setSerieDoRPS("B    ");
//            // Série é o tipo de serviço prestado, porém de controle interno
//            //A - Manutenção do Jazigo
//            //B - Outros Serviços
//
//
//            String var_numeroDoRPS = "" + ((beanDetalhe)(v_nfeB.get(i))).getNumeroDoRPS();
//            int t_numero = var_numeroDoRPS.length();
//                if(t_numero < 12){
//                    String var_n1 = null;
//                    StringBuffer n2 = new StringBuffer(var_numeroDoRPS);
//                    var_n1 = n2.reverse().toString();
//                    detalhe.setNumeroDoRPS(var_n1);
//                    
//                    while (var_n1.length() < 12) {
//                        var_n1 = var_n1 + "0";
//                    }
//
//                    String var_n2 = null;
//                    StringBuffer n1 = new StringBuffer(var_n1);
//                    var_n2 = n1.reverse().toString();
//                    detalhe.setNumeroDoRPS(var_n2);
//
//                } 
//            //Número sequencial que irá identificar o RPS (Chave Primária)
//
//
//            detalhe.setDataEmissaoRPS(((beanDetalhe)(v_nfeB.get(i))).getDataEmissao());
//            //Aqui é a data
//
//
//            //detalhe.setSituacaoDoRPS(((beanDetalhe)(v_nfeB.get(i))).getSituacaoDoRPS());
//            //System.out.println((((beanDetalhe)(v_nfeB.get(i))).getSituacaoDoRPS()));
//            String situacao = (((beanDetalhe)(v_nfeB.get(i))).getSituacaoDoRPS());
//            situacao = situacao.toUpperCase();
//
//            //System.out.println(situacao);
//            
//            detalhe.setSituacaoDoRPS(situacao);
//            /*Situações possíveis:
//                T - Operação normal(tributação conforme documento emitido)
//                I - Operação insenta ou não tributavel, executadas no Município de São Paulo - ESTA OPÇÃO
//                F - Operação insenta ou não tributavel pelo municipio de são paulo, executada em outro Municipio
//                C - Cancelado
//                E - Extraviado
//                J - ISS Suspenso por Decisao Judicial (neste caso, informar no campo Discriminação dos Serviços, o número do processo judicial na 1a instancia).
//            */
//
//            
//            String valor = (((beanDetalhe)(v_nfeB.get(i))).getValorDosServicos());
//            String valorSemVirgula = null;
//            String valorSemPonto = null;
//            valorSemPonto = valor.replace(".", "");
//            valorSemVirgula = valorSemPonto.replace(",", "");
//            
//
//            String var_valor = valorSemVirgula;
//            int t_valor = var_valor.length();
//                if(t_valor < 15){
//                    String var_n1 = null;
//                    StringBuffer n2 = new StringBuffer(var_valor);
//                    var_n1 = n2.reverse().toString();
//
//
//
//                    while (var_n1.length() < 15) {
//                        var_n1 = var_n1 + "0";
//                    }
//
//                    String var_n2 = null;
//                    StringBuffer n1 = new StringBuffer(var_n1);
//                    var_n2 = n1.reverse().toString();
//                    detalhe.setValorDosServicos(var_n2);
//
//                }
//
//            detalhe.setValorDasDeducoes("000000000000000");
//            //nos campos numéricos o valor tem sempre que ser alinhado a direita, e preencher o restante
//
//
//
//            //verificar se dentro da string Discriminação dos serviços existe o código 19300, se existir o código do serviço prestado
//            //deverá ser preenchido com: 06610, caso contrário deverá ser preenchido com: 06572
//            String descriminacao = null;
//            String textoProcurado = "19300";
//            descriminacao = (((beanDetalhe)(v_nfeB.get(i))).getDiscriminacaoDosServicos());
//
//            if(descriminacao.contains(textoProcurado)){
//                detalhe.setCodigoDoServicoPrestado("06610");//Eu coloquei este para TESTE Manutenção e conservação de jazigos e cemitérios
//            }else{
//                detalhe.setCodigoDoServicoPrestado("06572");//Eu coloquei este para TESTE Manutenção e conservação de jazigos e cemitérios
//            }
//
//
//
//            detalhe.setAliquota("0000");
//            detalhe.setInssRetido(2);//PERGUNTAR
//            /*Situações Possíveis:
//              1 - para ISS Retido
//              2 - para Nota Fiscal sem ISS Retido
//            */
//
//            detalhe.setIndicadorCPFCNPJ(((beanDetalhe)(v_nfeB.get(i))).getIndicadorCPFCNPJ());
//                /*Situações Possíveis:
//                  1 - para CPF
//                  2 - para CNPJ
//                  3 - para CPF não informado
//                */
//
//
//            String var_cpfCNPJ = (((beanDetalhe)(v_nfeB.get(i))).getCPFouCNPJ());
//            int t_cpfCNPJ = var_cpfCNPJ.length();
//                if(t_cpfCNPJ < 15){
//                    String var_n1 = null;
//                    StringBuffer n2 = new StringBuffer(var_cpfCNPJ);
//                    var_n1 = n2.reverse().toString();
//
//                    while (var_n1.length() < 14) {
//                        var_n1 = var_n1 + "0";
//                    }
//
//                    String var_n2 = null;
//                    StringBuffer n1 = new StringBuffer(var_n1);
//                    var_n2 = n1.reverse().toString();
//                    detalhe.setCPFouCNPJ(var_n2);
//
//                }
//
//
//            detalhe.setInscricaoMunicipalDoTomador("00000000");
//            detalhe.setInscricaoEstadualDoTomador("000000000000");
//
//
//            //O procedimento a seguir pega o nome do concessionário e deve avaliar se
//            //a String cabe dentro do campo pré-estabelecido para ela. Que no caso são 75 posições.
//            String var_nome = ((((beanDetalhe)(v_nfeB.get(i))).getNomeRazaoSocialDoTomador()));
//            
//            int t_nome = var_nome.length();
//                if(t_nome < 75){
//                    while (var_nome.length() < 75) {
//                        var_nome = var_nome + " ";
//                    }
//                    detalhe.setNomeRazaoSocialDoTomador(var_nome);
//                }else{
//                    //Caso a string seja maior do que cabe no campo, temos que truncar ela
//                    //temos que pegar no máximo 75 caracteres.
//                    String v_nomeCorrigido = new String();
//                    v_nomeCorrigido = var_nome.substring(0, 75);
//                    
//                    while (v_nomeCorrigido.length() < 75) {
//                        v_nomeCorrigido = v_nomeCorrigido + " ";
//                    }
//                    detalhe.setNomeRazaoSocialDoTomador(v_nomeCorrigido);
//                    
//                    JOptionPane.showMessageDialog(null, "O nome não cabe no campo específico, pois ele tem: " + t_nome +" - Posições!");
//                }
//
//            detalhe.setTipoEndDoTomador("RUA");
//
//
//            String var_Endereco = ((beanDetalhe)(v_nfeB.get(i))).getEnderecoDoTomador();
//            int t_endereco = var_Endereco.length();
//                if(t_endereco < 50){
//                    while (var_Endereco.length() < 50) {
//                        var_Endereco = var_Endereco + " ";
//                    }
//                }
//            detalhe.setEnderecoDoTomador(var_Endereco);
//
//
//            detalhe.setNumeroDoEnderecoDoTomador("0000000000");
//            
//            
//            
//            
//            
//            String var_complemento = ((beanDetalhe)(v_nfeB.get(i))).getComplementoEnderecoDoTomador();
//            int t_complemento = var_complemento.length();
//                if(t_complemento < 30){
//                    while (var_complemento.length() < 30) {
//                        var_complemento = var_complemento + " ";
//                    }
//                }
//            detalhe.setComplementoEnderecoDoTomador(var_complemento);
//
//
//
//
//
//            String var_bairro = ((beanDetalhe)(v_nfeB.get(i))).getBairroDoTomador();
//            int t_bairro = var_bairro.length();
//                if(t_bairro < 30){
//                    while (var_bairro.length() < 30) {
//                        var_bairro = var_bairro + " ";
//                    }
//                }
//            detalhe.setBairroDoTomador(var_bairro);
//
//
//
//            String var_cidade = ((beanDetalhe)(v_nfeB.get(i))).getCidadeDoTomador();
//            int t_cidade = var_cidade.length();
//                if(t_cidade < 50){
//                    while (var_cidade.length() < 50) {
//                        var_cidade = var_cidade + " ";
//                    }
//                }
//            detalhe.setCidadeDoTomador(var_cidade);
//
//
//            detalhe.setUfDoTomador(((beanDetalhe)(v_nfeB.get(i))).getUfDoTomador());
//            
//            
//            String var_cep = ((beanDetalhe)(v_nfeB.get(i))).getCEPdoTomador();
//            int t_cep = var_cep.length();
//                if(t_cep < 8){
//                    while (var_cep.length() < 8) {
//                        var_cep = var_cep + " ";
//                    }
//                }
//            detalhe.setCEPdoTomador(var_cep);
//
//
//
//            String var_email = ((beanDetalhe)(v_nfeB.get(i))).getEmailDoTomador();
//
//            if(var_email == null){
//                var_email = "0";
//            }
//            
//            var_email = var_email.toLowerCase();
//            
//            int t_email = var_email.length();
//                if(t_email < 75){
//                    while (var_email.length() < 75) {
//                        var_email = var_email + " ";
//                    }
//                }
//            detalhe.setEmailDoTomador(var_email);
//
//
//
//
//
//
//            detalhe.setDiscriminacaoDosServicos(((beanDetalhe)(v_nfeB.get(i))).getDiscriminacaoDosServicos());
////----------by Marcio------ Ajustando erro na geração da NF-e Série B 
//            String ajusteDiscriminacao = detalhe.getDiscriminacaoDosServicos();
//            String numerocontrato = detalhe.getNContrato();
//            int qtdCaracteres = ajusteDiscriminacao.length();
//            System.out.println("Carateres Antes: " + ajusteDiscriminacao.length()+ " - " + numerocontrato);
//            if(qtdCaracteres > 200){
//                String strOrigem = ajusteDiscriminacao;
//                strOrigem = strOrigem.replaceAll(" ","");
//                int qtdCaracteresBefore = strOrigem.length();
//                //System.out.println(strOrigem);
//                System.out.println("Carateres Depois: " + qtdCaracteresBefore);
//            detalhe.setDiscriminacaoDosServicos(strOrigem);
//            }
//            else detalhe.setDiscriminacaoDosServicos(((beanDetalhe)(v_nfeB.get(i))).getDiscriminacaoDosServicos());
////----------by Marcio
//            detalhe.setCaractereFimDeLinha("|");
//            //detalhe.setCaractereFimDeLinha("char(13)+char(10)");
//            
//            v_nfeComDados.add(detalhe);
//        }//fecha o for
//
//        int qtdRegistros = 0;
//        double valorTotal = 0;
//        
//        beanValorQuantidadeA vq = new beanValorQuantidadeA();
//        vq = cmd.calcularRodapeB(dataI, dataF);
//
//        qtdRegistros = vq.getQtdRegistros();
//
//        valorTotal = vq.getValorTotal();
//
//
//        cmd.inserirNFE(v_nfeComDados, dataI, dataF, valorTotal, qtdRegistros);//pega o vetor com todos os dados, ou seja, com todos os beans e envia
//                                      //para o pacote DAO, função inserirNFE
//
//        if(1==1/*colocar uma condição, que se houverem erros ele listar os erros atraves dos numeros do contrato*/){
//            JOptionPane.showMessageDialog(null, "NFE gerada com sucesso!");
//        }else{
//            JOptionPane.showMessageDialog(null, "Houveram erros no processo!");
//            /*Listar os erros por número dos contratos
//             *Ou fazer isso em um arquivo ou em uma lista?
//            */
//        }
//        return null;
//
//        }catch(Exception t){
//            JOptionPane.showMessageDialog(null, t);
//            return null;
//        }
//    }//fecha a classe
//
//    public String inverterValor(String valorDigitado){
//        try {
//            String var_n1 = new String();
//            String var_n2 = new String();
//            String var_n3 = new String();
//
//            var_n1 = valorDigitado;
//
//            StringBuffer n1 = new StringBuffer(var_n1);
//
//            var_n2 = n1.reverse().toString();
//
//            while(var_n2.length() < 15){
//                var_n2 = var_n2 + "0";
//            }
//
//            StringBuffer resultado = new StringBuffer(var_n2);
//
//            var_n3 = resultado.reverse().toString();
//            //na variável var_n3, teremos o valor invertido com 15 posições
//
//
//
//            return var_n3;
//
//            }//fecha o try
//                catch (Exception e) {
//                System.out.println("O erro foi: " + e);
//                return null;
//            }//fecha o catch
//        }
//}
