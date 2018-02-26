package FuncoesInternas;

import Beans.BeanRetorno;
import Dao.DaoMySQL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;

/*
 @author Tiago e Paulo 11/08/2016 20:10
 */
public class ArquivoRetornoItau {
    //Boolean
    boolean Retorno                         = false;
    
    //String's
    String Diretorio                        = "";
    String Mensagem                         = "";
    String ValorTexto                       = "";
    
    //int's
    int    TamanhoDoArquivo                 = 0;
    
    //Bean's
    BeanRetorno                 bret    = new BeanRetorno();
    
    //Vetores
    ArrayList dadosRetorno                  = new ArrayList();
    ArrayList dadosArquivo                  = new ArrayList();
    
    //Especiais para Leitura de Arquivos
    FileReader      LerArquivo;
    BufferedReader  LeuArquivo;
    
    public ArrayList lerArquivo(String diretorio){
        Diretorio = diretorio;
        
        if(!Diretorio.substring(Diretorio.length() - 3, Diretorio.length()).equals("RET")){
            Mensagem = "O arquivo selecionado não possui uma extensão de retorno!";
            new MostraMensagem(Mensagem);
            dadosArquivo.clear();
            return dadosArquivo;
        }
        
        try{
            LerArquivo          = new FileReader(Diretorio);
            LeuArquivo          = new BufferedReader(LerArquivo);
            
            while(LeuArquivo.ready()){
                dadosRetorno.add(LeuArquivo.readLine());
            }
            
            TamanhoDoArquivo    = dadosRetorno.size();
            
            LerArquivo.close();
            LeuArquivo.close();
            
            SalvarDados();
        }catch(Exception erro){
            Mensagem = "Erro ao ler o arquivo de Retorno: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            dadosArquivo.clear();
        }
        return dadosArquivo;
    }
    
    private void SalvarDados(){
        ValorTexto      = String.valueOf(dadosRetorno.get(0));
        bret.HCodigoDoRegistro                                  = Integer.parseInt(  ValorTexto.substring(0  ,  1));
        bret.HCodigoDeOperacao                                  = Integer.parseInt(  ValorTexto.substring(1  ,  2));
        bret.HIdentificacaoPorExtenso                           =                    ValorTexto.substring(2  ,  9);
        bret.HCodigoDoServico                                   = Integer.parseInt(  ValorTexto.substring(9  , 11));
        bret.HIdentificacaoDoServico                            =                    ValorTexto.substring(11 , 26);
        bret.HNumeroDaAgencia                                   = Integer.parseInt(  ValorTexto.substring(26 , 30));
        bret.HComplementoDeRegistro1                            =                    ValorTexto.substring(30 , 32);
        bret.HNumeroDaContaCorrente                             =                    ValorTexto.substring(32 , 37);
        bret.HDigitoAutoConferencia                             = Integer.parseInt(  ValorTexto.substring(37 , 38));
        bret.HComplementoDeRegistro2                            =                    ValorTexto.substring(38 , 46);
        bret.HNomeDaEmpresa                                     =                    ValorTexto.substring(46 , 76);
        bret.HCodigoDoBanco                                     = Integer.parseInt(  ValorTexto.substring(76 , 79));
        bret.HNomeDoBanco                                       =                    ValorTexto.substring(79 , 94);
        bret.HDataDeGeracao                                     =                    ValorTexto.substring(94 ,100);
        bret.HUnidadeDaDensidade                                = Integer.parseInt(  ValorTexto.substring(100,105));
        bret.HDensidadeDeGravacao                               =                    ValorTexto.substring(105,108);
        bret.HNumeroSequencialDoArquivoRetorno                  = Integer.parseInt(  ValorTexto.substring(108,113));
        bret.HDataDeCreditoDosLancamentos                       =                    ValorTexto.substring(113,119);
        bret.HComplementoDeRegistro3                            =                    ValorTexto.substring(119,394);
        bret.HNumeroSequencialDoRegistroNoArquivo               = Integer.parseInt(  ValorTexto.substring(394,400));
        
        dadosArquivo.add(bret);
        
        for(int i = 1; i < TamanhoDoArquivo - 1; i++){
            ValorTexto  = String.valueOf(dadosRetorno.get(i));
            
            bret = new BeanRetorno();
            bret.DCodigoDoRegistro                              = Integer.parseInt(  ValorTexto.substring(0  ,  1));
            bret.DCodigoDeInscricao                             =                    ValorTexto.substring(1  ,  3);
            bret.DNumeroDeInscricaoDaEmpresa                    =                    ValorTexto.substring(3  , 17);
            bret.DNumeroDaAgencia                               = Integer.parseInt(  ValorTexto.substring(17 , 21));
            bret.DComplementoDeRegistro1                        =                    ValorTexto.substring(21 , 23);
            bret.DNumeroDaContaCorrente                         =                    ValorTexto.substring(23 , 28);
            bret.DDigitoAutoConferencia                         = Integer.parseInt(  ValorTexto.substring(28 , 29));
            bret.DComplementoDeRegistro2                        =                    ValorTexto.substring(29 , 37);
            bret.DIdentificacaoDoTituloNaEmpresa                =                    ValorTexto.substring(37 , 62);
            bret.DIdentificacaoDoTituloNoBanco1                 =                    ValorTexto.substring(62 , 70);
            bret.DComplementoDeRegistro3                        =                    ValorTexto.substring(70 , 82);
            bret.DNumeroDaCarteira                              =                    ValorTexto.substring(82 , 85);
            bret.DIdentificacaoDoTituloNoBanco2                 =                    ValorTexto.substring(85 , 93);
            bret.DDacDoNossoNumero                              = Integer.parseInt(  ValorTexto.substring(93 , 94));
            bret.DComplementoDeRegistro4                        =                    ValorTexto.substring(94 ,107);
            bret.DCodigoDaCarteira                              =                    ValorTexto.substring(107,108);
            bret.DIdentificacaoDaOcorrencia                     =                    ValorTexto.substring(108,110);
            bret.DDataDaOocorrenciaNoBanco                      =                    ValorTexto.substring(110,116);
            bret.DNumeroDoDocumentoDeCobranca                   =                    ValorTexto.substring(116,126);
            bret.DConfirmacaoDoNumeroDoTituloNoBanco            = Integer.parseInt(  ValorTexto.substring(126,134));
            bret.DComplementoDeRegistro5                        =                    ValorTexto.substring(134,146);
            bret.DDataDeVencimentoDoTitulo                      =                    ValorTexto.substring(146,152);
            bret.DValorNominalDoTitulo                          = Double.parseDouble(ValorTexto.substring(152,163) + "." + ValorTexto.substring(163,165));
            bret.DNumeroDoBancoCamaraCompensacao                = Integer.parseInt(  ValorTexto.substring(165,168));
            bret.DAgenciaCobradoraLiquidacaoOuBaixa             = Integer.parseInt(  ValorTexto.substring(168,172));
            bret.DDacDaAgenciaCobradora                         = Integer.parseInt(  ValorTexto.substring(172,173));
            bret.DEspecieDoTitulo                               =                    ValorTexto.substring(173,175);
            bret.DValorDaDespesaDeCobranca                      = Double.parseDouble(ValorTexto.substring(175,186) + "." + ValorTexto.substring(186,188));
            bret.DComplementoDeRegistro6                        =                    ValorTexto.substring(188,214);
            bret.DValorDoIOFRecolhidoParaNotasSeguro            = Double.parseDouble(ValorTexto.substring(214,225) + "." + ValorTexto.substring(225,227));
            bret.DValorDoAbatimentoASerConcedido                = Double.parseDouble(ValorTexto.substring(227,238) + "." + ValorTexto.substring(238,240));
            bret.DValorDoDescontoConcedido                      = Double.parseDouble(ValorTexto.substring(240,251) + "." + ValorTexto.substring(251,253));
            bret.DValorLancadoEmContaCorrente                   = Double.parseDouble(ValorTexto.substring(253,264) + "." + ValorTexto.substring(264,266));
            bret.DValorDeMoraEMulta                             = Double.parseDouble(ValorTexto.substring(266,277) + "." + ValorTexto.substring(277,279));
            bret.DValorDeOutrosCreditos                         = Double.parseDouble(ValorTexto.substring(279,290) + "." + ValorTexto.substring(290,292));
            bret.DIndicadorDeBoletoDDA                          =                    ValorTexto.substring(292,293);
            bret.DComplementoDeRegistro7                        =                    ValorTexto.substring(293,295);
            bret.DDataDeCreditoDestaLiquidacao                  =                    ValorTexto.substring(295,301);
            bret.DCodigoDaInstrucaoCancelada                    = Integer.parseInt(  ValorTexto.substring(301,305));
            bret.DComplementoDeRegistro8                        =                    ValorTexto.substring(305,311);
            bret.DComplementoDeRegistro9                        =                    ValorTexto.substring(311,324);
            bret.DNomeDoPagador                                 =                    ValorTexto.substring(324,354);
            bret.DComplementoDeRegistro10                       =                    ValorTexto.substring(354,377);
            bret.DRegRejOuAleDoPagOuRegDeMenInf                 =                    ValorTexto.substring(377,385);
            bret.DComplementoDeRegistro11                       =                    ValorTexto.substring(385,392);
            bret.DMeioPeloQualOTituloFoiLiquidado               =                    ValorTexto.substring(392,394);
            bret.DNumeroSequencialDoRegistroNoArquivo           = Integer.parseInt(  ValorTexto.substring(394,400));
            
            dadosArquivo.add(bret);
        }
        
        TamanhoDoArquivo    = TamanhoDoArquivo - 1;
        ValorTexto          = String.valueOf(dadosRetorno.get(TamanhoDoArquivo));
        
        bret.TCodigoDoRegistro                                  = Integer.parseInt(  ValorTexto.substring(0  ,  1));
        bret.TCodigoDoArquivoDeRetorno                          = Integer.parseInt(  ValorTexto.substring(1  ,  2));
        bret.TCodigoDoServico                                   = Integer.parseInt(  ValorTexto.substring(2  ,  4));
        bret.TCodigoDoBancoNaCompensacao                        = Integer.parseInt(  ValorTexto.substring(4  ,  7));
        bret.TComplementoDeRegistro1                            =                    ValorTexto.substring(7  , 17);
        bret.TQtdDeTitulosEmCobrancaSimples                     = Integer.parseInt(  ValorTexto.substring(17 , 25));
        bret.TValorTotalDosTitulosEmCobrancaSimples             = Double.parseDouble(ValorTexto.substring(25 , 37) + "." + ValorTexto.substring(37 , 39));
        bret.TReferenciaDoAvisoBancario1                        =                    ValorTexto.substring(39 , 47);
        bret.TComplementoDeRegistro2                            =                    ValorTexto.substring(47 , 57);
        bret.TQtdDeTitulosEmCobrancaVinculada                   = Integer.parseInt(  ValorTexto.substring(57 , 65));
        bret.TValorTotalDosTitulosEmCobrancaVinculada           = Double.parseDouble(ValorTexto.substring(65 , 77) + "." + ValorTexto.substring(77 , 79));
        bret.TReferenciaDoAvisoBancario2                        =                    ValorTexto.substring(79 , 87);
        bret.TComplementoDeRegistro3                            =                    ValorTexto.substring(87 ,177);
        bret.TQtdDeTitulosEmCobrancaDiretaEscritural            = Integer.parseInt(  ValorTexto.substring(177,185));
        bret.TValorTotalDosTitulosEmCobrancaDiretaEscritural    = Double.parseDouble(ValorTexto.substring(185,197) + "." + ValorTexto.substring(197,199));
        bret.TReferenciaDoAvisoBancario3                        =                    ValorTexto.substring(199,207);
        bret.TNumeroSequencialDoArquivoDeRetorno                = Integer.parseInt(  ValorTexto.substring(207,212));
        bret.TQtdDeRegistrosDeTransacao                         = Integer.parseInt(  ValorTexto.substring(212,220));
        bret.ValorTotalDosTitulosInformadosNoArquivo            = Double.parseDouble(ValorTexto.substring(220,232) + "." + ValorTexto.substring(232, 234));
        bret.TComplementoDeRegistro4                            =                    ValorTexto.substring(234,394);
        bret.TNumeroSequencialDoRegistroNoArquivo               = Integer.parseInt(  ValorTexto.substring(394,400));
        
        dadosArquivo.add(bret);
    }
    
    
}
