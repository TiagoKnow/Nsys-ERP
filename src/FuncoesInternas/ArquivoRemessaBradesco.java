package FuncoesInternas;

import BeansNS.BeanBanco;
import Beans.BeanBoletos;
import Beans.BeanBoletosInstrucoes;
import Beans.BeanClientes;
import Beans.BeanComputadores;
import Beans.BeanContaCorrente;
import Beans.BeanFormasPagamentos;
import Beans.BeanRemessaItau;
import Beans.BeanUsuarios;
import Parametros.parametrosNS;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
 @author Tiago e Paulo
 */
public class ArquivoRemessaBradesco {
    //String
    String sql                              = "";
    String fatal                            = "";
    String Mensagem                         = "";
    String DataDoDiretorio                  = "";
    String AnoDoDiretorio                   = "";
        String anodoDiretorio               = "";
    String MesDoDiretorio                   = "";
        String mesDoDiretorio               = "";
    String DiaDoDiretorio                   = "";
    
    //int
    int    NumeroSequencial                 = 0;
    
    //Vetores
    ArrayList            dadosRegistro                 = new ArrayList();
    ArrayList            dadosParaGravacao             = new ArrayList();
    ArrayList<ArrayList> dadosAgenciaEContaCorrente    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBanco                    = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBoletos                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosCliente                  = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosFormasPagamentos         = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosBoletosInstrucoes        = new ArrayList<ArrayList>();
    ArrayList<ArrayList> dadosUsuario                  = new ArrayList<ArrayList>();
    
    //Beans
    BeanBanco                       bb      = new BeanBanco();
    BeanBoletos                     bbol    = new BeanBoletos();
    BeanBoletosInstrucoes           bbi     = new BeanBoletosInstrucoes();
    BeanClientes                    bc      = new BeanClientes();
    BeanComputadores                bcomp   = new BeanComputadores();
    BeanContaCorrente               bcc     = new BeanContaCorrente();
    BeanFormasPagamentos            bfp     = new BeanFormasPagamentos();
    BeanRemessaItau                     brem    = new BeanRemessaItau();
    BeanUsuarios                    bu      = new BeanUsuarios();
    
    //Funções
    CapturarDataHora                cdh             = new CapturarDataHora();
    FormataCampoCpfCnpj             FCampoCpfCnpj   = new FormataCampoCpfCnpj();
    FormataCampo                    fc              = new FormataCampo();
    FormataCampoComEspacos          fccc            = new FormataCampoComEspacos();
    InverterData                    invdata         = new InverterData();
    RemoveCaracteresEspeciais       rce             = new RemoveCaracteresEspeciais();
    TransformaValorStringeDouble    TransStrDou     = new TransformaValorStringeDouble();
    
    //Funções de diretorio
    File        NomeDoArquivo;
    boolean     ArquivoExiste;
    FileWriter  GravarArquivo;
    PrintWriter Gravar;
    
    //Telas
    
    public boolean gerarArquivo(ArrayList DadosRegistro){
        dadosRegistro       = DadosRegistro;
        
        DataDoDiretorio     = cdh.CapturarData().replace("/", "");
        DiaDoDiretorio      = DataDoDiretorio.substring(0, 2);
        MesDoDiretorio      = DataDoDiretorio.substring(2, 4);
        mesDoDiretorio      = MesDoDiretorio;
        switch(Integer.parseInt(MesDoDiretorio)){
            case  1: MesDoDiretorio = MesDoDiretorio + " - Janeiro"   ; break;
            case  2: MesDoDiretorio = MesDoDiretorio + " - Fevereiro" ; break;
            case  3: MesDoDiretorio = MesDoDiretorio + " - Março"     ; break;
            case  4: MesDoDiretorio = MesDoDiretorio + " - Abril"     ; break;
            case  5: MesDoDiretorio = MesDoDiretorio + " - Maio"      ; break;
            case  6: MesDoDiretorio = MesDoDiretorio + " - Junho"     ; break;
            case  7: MesDoDiretorio = MesDoDiretorio + " - Julho"     ; break;
            case  8: MesDoDiretorio = MesDoDiretorio + " - Agosto"    ; break;
            case  9: MesDoDiretorio = MesDoDiretorio + " - Setembro"  ; break;
            case 10: MesDoDiretorio = MesDoDiretorio + " - Outubro"   ; break;
            case 11: MesDoDiretorio = MesDoDiretorio + " - Novembro"  ; break;
            case 12: MesDoDiretorio = MesDoDiretorio + " - Dezembro"  ; break;
        }
        AnoDoDiretorio      = DataDoDiretorio.substring(4, 8);
            anodoDiretorio  = AnoDoDiretorio .substring(2, 4);
            
        NomeDoArquivo       = new File(parametrosNS.PastaSistema + "/Remessa/Bradesco/" + AnoDoDiretorio + "/" + MesDoDiretorio + "/" + anodoDiretorio + mesDoDiretorio + DiaDoDiretorio + ".REM");
        ArquivoExiste       = NomeDoArquivo.exists();
        dadosParaGravacao.clear();

        if(ArquivoExiste == true){
            Mensagem = "O arquivo já existe!";
            new MostraMensagem(Mensagem);
            return false;
        }
        
        PegaBanco();
        
        try{
            //Inicia Geração do Arquivo Header de Remessa
            NumeroSequencial = 0;
            NumeroSequencial++;
            brem.HCodigoDoRegistro                          = 0;
            brem.HCodigoDeOperacao                          = 1;
            brem.HIdentificacaoPorExtenso                   = "REMESSA";
            brem.HCodigoDoServico                           = 01;
            brem.HIdentificacaoDoServico                    = fccc.FormatarCampoComEspacos("COBRANCA", 15, 0);
            brem.HNomeDaEmpresa                             = fccc.FormatarCampoComEspacos(rce.RemoveCaracteresEspeciais(parametrosNS.be.NomeEmpresa.toUpperCase()), 30, 0);
            brem.HCodigoDoBanco                             = Integer.parseInt(bb.codigoBanco);
            brem.HNomeDoBanco                               = fccc.FormatarCampoComEspacos(rce.RemoveCaracteresEspeciais(bb.nomeBanco.toUpperCase().replace(".", "")), 15, 0);
            brem.HDataDeGeracao                             = cdh.CapturarData().replace("/", "");
                brem.HDiaDeGeracao                          = brem.HDataDeGeracao.substring(0, 2);
                brem.HMesDeGeracao                          = brem.HDataDeGeracao.substring(2, 4);
                brem.HAnoDeGeracao                          = brem.HDataDeGeracao.substring(6, 8);
            brem.HDataDeGeracao                             = brem.HDiaDeGeracao + brem.HMesDeGeracao + brem.HAnoDeGeracao;
            brem.HComplementoDeRegistro1                    = fc.FormataCampo("", 8, 0);
            brem.HIdentificacaoDoSistema                    = "MX";
            
            brem.HComplementoDeRegistro2                    = fc.FormataCampo("", 277, 0);
            brem.HNumeroSequencialDoRegistroNoArquivo       = NumeroSequencial;
            
            dadosParaGravacao.add(
                fc.FormataCampo(String.valueOf(brem.HCodigoDoRegistro), 1, 0)   +
                fc.FormataCampo(String.valueOf(brem.HCodigoDeOperacao), 1, 0)   +
                brem.HIdentificacaoPorExtenso   +
                fc.FormataCampo(String.valueOf(brem.HCodigoDoServico), 2, 0)    +
                brem.HIdentificacaoDoServico    +
                
                brem.HNomeDaEmpresa             +
                fc.FormataCampo(String.valueOf(brem.HCodigoDoBanco), 3, 0)      +
                brem.HNomeDoBanco               +
                brem.HDataDeGeracao             +
                brem.HComplementoDeRegistro1    +
                brem.HIdentificacaoDoSistema    +
                
                brem.HComplementoDeRegistro2    +
                fc.FormataCampo(String.valueOf(brem.HNumeroSequencialDoRegistroNoArquivo), 6, 0)
            );
            
            //Arquivo Inicia o Detalhe
            for(int i = 0; i < dadosRegistro.size(); i++){
                NumeroSequencial++;
                bbol.codigoBoleto   = (int) dadosRegistro.get(i);
                brem = new BeanRemessaItau();
                PegaBoleto();
                
                brem.DCodigoDoRegistro                      = 1;
                brem.DNumeroDaAgencia                       = bcc.numeroAgencia;
                brem.DDigitoAutoConferenciaAgencia          = bcc.digitoVerificadorAgencia;            }
                
            
            return true;
        }catch(Exception e){
            Mensagem = "O erro foi na função Gerar Arquivo de Remessa do Bradesco: " + e.getMessage();
            new MostraMensagem(Mensagem);
            return false;
        }
    }
    
    private void PegaBanco(){
        bb.codigoBanco  = "237";
        if(bb.codigoBanco.equals(""))
            return;
        sql = "select * from ns_bancos where codigoBanco = '" + bb.codigoBanco + "';";
        dadosBanco.clear();
        dadosBanco = parametrosNS.dao.Consulta(sql);
        if(dadosBanco.isEmpty()){
            Mensagem = "Banco " + bb.codigoBanco + " não encontrado!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosBancoBradesco();
    }
    
    private void PegaDadosBancoBradesco(){
        for(int i = 0; i < dadosBanco.size(); i++){
            bb.idBanco          = Integer.parseInt(  String.valueOf(dadosBanco.get(i).get(0)));
            bb.nomeBanco        =                    String.valueOf(dadosBanco.get(i).get(1));
            bb.codigoBanco      =                    String.valueOf(dadosBanco.get(i).get(2));
        }
        bcc.idBanco             = bb.idBanco;
        sql = "select * from tb_contacorrente where idBanco = " + bcc.idBanco + " and contaCorrentePadrao = 1;";
        PegaAgenciaEContaCorrentePadraoBradesco();
    }
    
    private void PegaAgenciaEContaCorrentePadraoBradesco(){
        dadosAgenciaEContaCorrente.clear();
        dadosAgenciaEContaCorrente = parametrosNS.dao.Consulta(sql);
        if(dadosAgenciaEContaCorrente.isEmpty()){
            Mensagem = "Não foi encontrada Conta Corrente para o Banco n°" + bb.codigoBanco + "!";
            new MostraMensagem(Mensagem);
            return;
        }
        PegaDadosAgenciaEContaCorrentePadraoBradesco();
    }
    
    private void PegaDadosAgenciaEContaCorrentePadraoBradesco(){
        for(int i = 0; i < dadosAgenciaEContaCorrente.size(); i++){
            bcc.idContaCorrente             = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(0)));
            bcc.idEmpresa                   = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(1)));
            bcc.codigoGrupo                 = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(2)));
            bcc.codigoEmpresa               = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(3)));
            bcc.codigoContaCorrente         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(4)));
            bcc.idBanco                     = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(5)));
            bcc.numeroAgencia               = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(6)));
            bcc.digitoVerificadorAgencia    = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(7)));
            bcc.numeroContaCorrente         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(8)));
            bcc.digitoVerificador           = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(9)));
            bcc.contaCorrentePadrao         = Integer.parseInt(  String.valueOf(dadosAgenciaEContaCorrente.get(i).get(10)));
            bcc.numeroDaCarteira            =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(11));
            bcc.especieDoDocumento          =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(12));
            bcc.AceiteOuNaoAceite           =                    String.valueOf(dadosAgenciaEContaCorrente.get(i).get(13));
        }
    }
    
    private void PegaBoleto(){
        sql = "select * from tb_boletos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoleto = " + bbol.codigoBoleto + ";";
        dadosBoletos.clear();
        dadosBoletos = parametrosNS.dao.Consulta(sql);
        if(dadosBoletos.isEmpty()){
            Mensagem = "Boleto n°" + bbol.codigoBoleto + " não encontrado!";
            new MostraMensagem(Mensagem);
            fatal = "S";
            return;
        }
        PegaDadosBoleto();
    }
    
    private void PegaDadosBoleto(){
        for(int i = 0; i < dadosBoletos.size(); i++){
            bbol = new BeanBoletos();
            if(dadosBoletos.get(i).get(0) != null)
                bbol.idBoletos              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(0)));
            if(dadosBoletos.get(i).get(1) != null)
                bbol.idEmpresa              = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(1)));
            if(dadosBoletos.get(i).get(2) != null)
                bbol.codigoGrupo            = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(2)));
            if(dadosBoletos.get(i).get(3) != null)
                bbol.codigoEmpresa          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(3)));
            if(dadosBoletos.get(i).get(4) != null)
                bbol.codigoBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(4)));
            if(dadosBoletos.get(i).get(5) != null)
                bbol.codigoCliente          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(5)));
            if(dadosBoletos.get(i).get(6) != null)
                bbol.codigoContaCorrente    = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(6)));
            if(dadosBoletos.get(i).get(7) != null)
                bbol.codigoBoletoInstrucao  = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(7)));
            if(dadosBoletos.get(i).get(8) != null)
                bbol.codigoUsuario          = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(8)));
            if(dadosBoletos.get(i).get(9) != null)
                bbol.codigoPagamento        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(9)));
                bbol.tipoDeFaturamento      =                    String.valueOf(dadosBoletos.get(i).get(10));
                bbol.nossoNumero            =                    String.valueOf(dadosBoletos.get(i).get(11));
                bbol.dataEmissao            =                    String.valueOf(dadosBoletos.get(i).get(12));
                bbol.numeroDocumento        =                    String.valueOf(dadosBoletos.get(i).get(13));
                bbol.numeroDAC              =                    String.valueOf(dadosBoletos.get(i).get(14));
            if(dadosBoletos.get(i).get(15) != null)
                bbol.valorDevido            = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(15)));
                bbol.dataDeVencimento       =                    String.valueOf(dadosBoletos.get(i).get(16));
            if(dadosBoletos.get(i).get(17) != null)
                bbol.valorPago              = Double.parseDouble(String.valueOf(dadosBoletos.get(i).get(17)));
                bbol.dataDePagamento        =                    String.valueOf(dadosBoletos.get(i).get(18));
                bbol.Instrucao1             =                    String.valueOf(dadosBoletos.get(i).get(19));
                bbol.Instrucao3             =                    String.valueOf(dadosBoletos.get(i).get(20));
                bbol.CodigoDeBarras1        =                    String.valueOf(dadosBoletos.get(i).get(21));
                bbol.CodigoDeBarras2        =                    String.valueOf(dadosBoletos.get(i).get(22));
                bbol.CodigoDeBarras3        =                    String.valueOf(dadosBoletos.get(i).get(23));
                bbol.CodigoDeBarras4        =                    String.valueOf(dadosBoletos.get(i).get(24));
                bbol.CodigoDeBarras5        =                    String.valueOf(dadosBoletos.get(i).get(25));
                bbol.CodigoDeBarras         =                    String.valueOf(dadosBoletos.get(i).get(26));
            if(dadosBoletos.get(i).get(27) != null)
                bbol.ocorrenciaRemessa      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(27)));
            if(dadosBoletos.get(i).get(28) != null)
                bbol.ocorrenciaRetorno      = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(28)));
            if(dadosBoletos.get(i).get(29) != null)
                bbol.ParcelaAtual           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(29)));
            if(dadosBoletos.get(i).get(30) != null)
                bbol.TotalDeParcelas        = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(30)));
            if(dadosBoletos.get(i).get(31) != null)
                bbol.statusBoleto           = Integer.parseInt(  String.valueOf(dadosBoletos.get(i).get(31)));
            
            bc.codigoCliente            = bbol.codigoCliente;
            PegaCliente();
            
            bcc.idEmpresa           = bbol.idEmpresa;
            bcc.codigoGrupo         = bbol.codigoGrupo;
            bcc.codigoEmpresa       = bbol.codigoEmpresa;
            bcc.codigoContaCorrente = bbol.codigoContaCorrente;
            sql = "select * from tb_contacorrente where idEmpresa = " + bcc.idEmpresa + " and codigoContaCorrente = " + bcc.codigoContaCorrente + ";";
            PegaAgenciaEContaCorrentePadraoBradesco();
            
            bbi.codigoBoletoInstrucao   = bbol.codigoBoletoInstrucao;
            PegaInstrucoes();
            
//            bu.codigoUsuario            = bbol.codigoUsuario;
//            PegaUsuario();
            
//            bfp.codigoPagamento         = bbol.codigoPagamento;
//            PegaPagamento();
        }
    }
    
    private void PegaCliente(){
        sql = "select idCliente, idEmpresa, codigoGrupo, codigoEmpresa, codigoCliente, nome, cep, cidade, endereco, numero, bairro, uf from tb_clientes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoCliente = " + bc.codigoCliente + ";";
        bc = new BeanClientes();
        dadosCliente.clear();
        dadosCliente = parametrosNS.dao.Consulta(sql);
        if(dadosCliente.isEmpty())
            return;
        PegaDadosCliente();
    }
    
    private void PegaDadosCliente(){
        for(int i = 0; i < dadosCliente.size(); i++){
            bc.idCliente            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(0)));
            bc.idEmpresa            = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(1)));
            bc.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(2)));
            bc.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(3)));
            bc.codigoCliente        = Integer.parseInt(  String.valueOf(dadosCliente.get(i).get(4)));
            bc.nome                 =                    String.valueOf(dadosCliente.get(i).get(5));
            bc.cep                  =                    String.valueOf(dadosCliente.get(i).get(6));
            bc.cidade               =                    String.valueOf(dadosCliente.get(i).get(7));
            bc.endereco             =                    String.valueOf(dadosCliente.get(i).get(8));
            bc.numero               =                    String.valueOf(dadosCliente.get(i).get(9));
            bc.bairro               =                    String.valueOf(dadosCliente.get(i).get(10));
            bc.uf                   =                    String.valueOf(dadosCliente.get(i).get(11));
        }
    }
    
    private void PegaInstrucoes(){
        sql = "select * from tb_boletos_instrucoes where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoBoletoInstrucao = " + bbi.codigoBoletoInstrucao + ";";
        bbi = new BeanBoletosInstrucoes();
        dadosBoletosInstrucoes.clear();
        dadosBoletosInstrucoes = parametrosNS.dao.Consulta(sql);
        if(dadosBoletosInstrucoes.isEmpty())
            return;
        PegaDadosInstrucoes();
    }
    
    private void PegaDadosInstrucoes(){
        for(int i = 0; i < dadosBoletosInstrucoes.size(); i++){
            bbi = new BeanBoletosInstrucoes();
            bbi.idBoletoInstrucao       = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(0)));
            bbi.idEmpresa               = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(1)));
            bbi.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(2)));
            bbi.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(3)));
            bbi.codigoBoletoInstrucao   = Integer.parseInt(  String.valueOf(dadosBoletosInstrucoes.get(i).get(4)));
            bbi.descricaoInstrucao      =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(5));
            bbi.primeiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(6));
            bbi.segundaInstrucao        =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(7));
            bbi.terceiraInstrucao       =                    String.valueOf(dadosBoletosInstrucoes.get(i).get(8));
        }
    }
    
//    private void PegaUsuario(){
//        sql = "select * from tb_usuarios where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoUsuario = " + bu.codigoUsuario + ";";
//        bu = new BeanUsuarios();
//        dadosUsuario.clear();
//        dadosUsuario = parametrosNS.dao.Consulta(sql);
//        if(dadosUsuario.isEmpty())
//            return;
//        PegaDadosUsuario();
//    }
//    
//    private void PegaDadosUsuario(){
//        for(int i = 0; i < dadosUsuario.size(); i++){
//            bu = new BeanUsuarios();
//            bu.idUsuario            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(0)));
//            bu.idEmpresa            = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(1)));
//            bu.codigoGrupo          = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(2)));
//            bu.codigoEmpresa        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(3)));
//            bu.codigoUsuario        = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(4)));
//            bu.dataCriacao          =                    String.valueOf(dadosUsuario.get(i).get(5));
//            bu.servidorEmail        =                    String.valueOf(dadosUsuario.get(i).get(6));
//        if(dadosUsuario.get(i).get(7) != null)
//            bu.portaEmail           = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(7)));
//            bu.usuarioServidorEmail =                    String.valueOf(dadosUsuario.get(i).get(8));
//            bu.senhaServidorEmail   =                    String.valueOf(dadosUsuario.get(i).get(9));
//            bu.email                =                    String.valueOf(dadosUsuario.get(i).get(10));
//        if(dadosUsuario.get(i).get(11) != null)
//            bu.autenticacaoSSL      = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(11)));
//            bu.nome                 =                    String.valueOf(dadosUsuario.get(i).get(12));
//            bu.usuario              =                    String.valueOf(dadosUsuario.get(i).get(13));
//            bu.senha                =                    String.valueOf(dadosUsuario.get(i).get(14));
//            bu.telefone             =                    String.valueOf(dadosUsuario.get(i).get(15));
//        if(dadosUsuario.get(i).get(16) != null)
//            bu.codigoDepartamento   = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(16)));
//        if(dadosUsuario.get(i).get(17) != null)
//            bu.nivelUsuario         = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(17)));
//        if(dadosUsuario.get(i).get(18) != null)
//            bu.podeMudarEmpresa     = Integer.parseInt(  String.valueOf(dadosUsuario.get(i).get(18)));
//            bu.observacoes          =                    String.valueOf(dadosUsuario.get(i).get(19));
//            bu.nomeConexao          =                    String.valueOf(dadosUsuario.get(i).get(20));
//        }
//    }
    
    private void PegaPagamento(){
        sql = "select * from tb_formaspagamentos where idEmpresa = " + parametrosNS.be.IdEmpresa + " and codigoPagamento = " + bfp.codigoPagamento + ";";
        dadosFormasPagamentos.clear();
        dadosFormasPagamentos = parametrosNS.dao.Consulta(sql);
        if(dadosFormasPagamentos.isEmpty())
            return;
        PegaDadosPagamentos();
    }
    
    private void PegaDadosPagamentos(){
        for(int i = 0; i < dadosFormasPagamentos.size(); i++){
            bfp = new BeanFormasPagamentos();
            bfp.idPagamento             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(0)));
            bfp.idEmpresa               = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(1)));
            bfp.codigoGrupo             = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(2)));
            bfp.codigoEmpresa           = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(3)));
            bfp.codigoPagamento         = Integer.parseInt(  String.valueOf(dadosFormasPagamentos.get(i).get(4)));
            bfp.descricaoPagamento      =                    String.valueOf(dadosFormasPagamentos.get(i).get(5));
        }
    }
    
}
