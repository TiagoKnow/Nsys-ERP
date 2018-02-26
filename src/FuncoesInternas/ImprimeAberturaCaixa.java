package FuncoesInternas;

import Beans.BeanCaixaAbertura;
import Beans.BeanComputadores;
import Beans.BeanParametrosVendas;
import Beans.BeanUsuarios;
import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import Parametros.parametrosNS;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo 15/02/2018
 */
public class ImprimeAberturaCaixa {
    //String
    String sql              = "";
    String mensagem         = "";
    String nomeArquivo      = "";
    String codigoGrupo      = "";
    String codigoEmpresa    = "";
    String codigoComputador = "";
    String codigoUsuario    = "";
    
    //Beans
    BeanCaixaAbertura       bca     = new BeanCaixaAbertura();
    BeanComputadores        bcomp   = new BeanComputadores();
    BeanEmpresas            be      = new BeanEmpresas();
    BeanGrupoEmpresa        bge     = new BeanGrupoEmpresa();
    BeanParametrosVendas    bparven = new BeanParametrosVendas();
    BeanUsuarios            bu      = new BeanUsuarios();
    
    //Vetores
    ArrayList            linhasArquivo         = new ArrayList();
    ArrayList<ArrayList> dadosParametrosVendas = new ArrayList();
    
    //booleans
    boolean gravouArquivo;
    
    //Outros
    File        novoArquivo;
    FileWriter  gravadorArquivo;
    PrintWriter impressaoArquivo;
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void gerarImpressaoAberturaCaixa(BeanCaixaAbertura BCA){
        PegaParametros();
        
        bca = BCA;
        
        bge.codigoGrupo     = parametrosNS.bge.CodigoGrupo;
        bge.CodigoGrupo     = bge.codigoGrupo;
        bge.nomeGrupo       = parametrosNS.bge.NomeGrupo;
        bge.NomeGrupo       = bge.nomeGrupo;
        
        be.idEmpresa        = parametrosNS.be.IdEmpresa;
        be.IdEmpresa        = be.idEmpresa;
        be.codigoGrupo      = bge.CodigoGrupo;
        be.CodigoGrupo      = be .codigoGrupo;
        be.codigoEmpresa    = parametrosNS.be.CodigoEmpresa;
        be.CodigoEmpresa    = be .codigoEmpresa;
        be.nomeEmpresa      = parametrosNS.be.NomeEmpresa;
        be.NomeEmpresa      = be .nomeEmpresa;
        be.nomeFantasia     = parametrosNS.be.NomeFantasia;
        be.NomeFantasia     = be .nomeFantasia;
        
        bcomp.idEmpresa         = be .IdEmpresa;
        bcomp.codigoGrupo       = bge.codigoGrupo;
        bcomp.codigoEmpresa     = be .codigoEmpresa;
        bcomp.codigoComputador  = parametrosNS.bcomp.codigoComputador;
        bcomp.nomeComputador    = parametrosNS.bcomp.nomeComputador;
        
        bu.idEmpresa        = be .IdEmpresa;
        bu.codigoGrupo      = bge.CodigoGrupo;
        bu.codigoEmpresa    = be .CodigoEmpresa;
        bu.codigoUsuario    = parametrosNS.bu.codigoUsuario;
        bu.nome             = parametrosNS.bu.nome;
        bu.usuario          = parametrosNS.bu.usuario;
        
        codigoGrupo     = parametrosNS.fc.FormataCampo(String.valueOf(bge.CodigoGrupo ), 2, 0);
        codigoEmpresa   = parametrosNS.fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0);
        
        codigoComputador    = parametrosNS.fc.FormataCampo(String.valueOf(bcomp.codigoComputador), 2, 0);
        
        codigoUsuario   = parametrosNS.fc.FormataCampo(String.valueOf(bu.codigoUsuario), 3, 0);
        
        try{
            linhasArquivo.add("==================================================");
            linhasArquivo.add("GRUPO  :  " + codigoGrupo   + "-" + bge.NomeGrupo);
            linhasArquivo.add("EMPRESA: "  + codigoEmpresa + "-" + be .NomeEmpresa);
            linhasArquivo.add("==================================================");
            linhasArquivo.add("");
            linhasArquivo.add("                ABERTURA DE CAIXA                 ");
            linhasArquivo.add("");
            linhasArquivo.add("DATA DE ABERTURA: " + parametrosNS.invdata.inverterData(bca.dataAbertura, 1));
            linhasArquivo.add("HORA DE ABERTURA: " + bca.horaAbertura);
            linhasArquivo.add("OPERADOR: " + codigoUsuario + "-" + bu.usuario);
            linhasArquivo.add("CAIXA: " + codigoComputador + "-" + bcomp.nomeComputador);
            linhasArquivo.add("==================================================");
            linhasArquivo.add("SALDO DE ABERTURA...: " + parametrosNS.TransStrDou.TransformaValorStringeDouble(String.valueOf(bca.valorDoCaixa), 0));
            linhasArquivo.add("==================================================");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("   ____________________________________________   ");
            linhasArquivo.add("                ASSINATURA DO CAIXA               ");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("");
            linhasArquivo.add("   ____________________________________________   ");
            linhasArquivo.add("               ASSINATURA DO GERENTE              ");
            
            nomeArquivo = "AberCaix-"+ codigoGrupo + codigoEmpresa + "-" + bca.dataAbertura.replace("-", "") + bca.horaAbertura.replace(":", "") + "-" + codigoComputador + "-" + codigoUsuario + bu.usuario;
            gravouArquivo = GravarRegistro();
        }catch(Exception erro){
            mensagem = "O erro foi na função gerar arquivo de abertura de caixa: " + erro.getMessage();
            mostraMensagem();
        }
        if(gravouArquivo == true){
            mensagem = "Arquivo gravado com êxito!";
        }
    }

    public boolean GravarRegistro(){
        boolean retorno;
        novoArquivo = null;
        novoArquivo = new File(bparven.pastaImpressaoAberturaCaixa + "\\" + nomeArquivo + ".txt");
        try {
            if(novoArquivo.exists() == true){
                mensagem = "O arquivo já existe!";
                mostraMensagem();
                return true;
            }
            novoArquivo.createNewFile();
            
            gravadorArquivo  = new FileWriter(novoArquivo,true);
            impressaoArquivo = new PrintWriter(gravadorArquivo, true);
            
            for(int i = 0; i < linhasArquivo.size(); i++){
                impressaoArquivo.println((String)(linhasArquivo.get(i)));
            }
            mensagem = "Recibo gerado ao tef com sucesso!";
            mostraMensagem();
            retorno = true;
        }catch (Exception erro){
            mensagem = "O erro foi ao criar fisicamente o arquivo: " + erro;
            mostraMensagem();
            retorno = false;
        }
        return retorno;
    }
    
    private void PegaParametros(){
        sql = "select * from tb_parametrosvendas where idEmpresa = " + parametrosNS.be.IdEmpresa + ";";
        dadosParametrosVendas = new ArrayList();
        dadosParametrosVendas = parametrosNS.dao.Consulta(sql);
        if(dadosParametrosVendas.isEmpty()){
            mensagem = "Não foram encontrados parametros para vendas!";
            mostraMensagem();
            return;
        }
        PegaDadosParametros();
    }
    
    private void PegaDadosParametros(){
        for(int i = 0; i < dadosParametrosVendas.size(); i++){
            if(dadosParametrosVendas.get(i).get(0) != null){bparven.idParametrosVendas          = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(0)));}
            if(dadosParametrosVendas.get(i).get(1) != null){bparven.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(1)));}
            if(dadosParametrosVendas.get(i).get(2) != null){bparven.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(2)));}
            if(dadosParametrosVendas.get(i).get(3) != null){bparven.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(3)));}
            if(dadosParametrosVendas.get(i).get(4) != null){bparven.infQtdMenor                 = Integer.parseInt(  String.valueOf(dadosParametrosVendas.get(i).get(4)));}
            if(dadosParametrosVendas.get(i).get(5) != null){bparven.valorDeMeta                 = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(5)));            }
            if(dadosParametrosVendas.get(i).get(6) != null){bparven.porcentagemDeComissao       = Double.parseDouble(String.valueOf(dadosParametrosVendas.get(i).get(6)));}
            if(dadosParametrosVendas.get(i).get(7) != null){bparven.pastaImpressaoAberturaCaixa =                    String.valueOf(dadosParametrosVendas.get(i).get(7));}
        }
        if(bparven.pastaImpressaoAberturaCaixa.equals("")){
            if(parametrosNS.bbd.so.equalsIgnoreCase("Windows")){
                bparven.pastaImpressaoAberturaCaixa = parametrosNS.PastaSistema;
            }
        }
    }
    
}
