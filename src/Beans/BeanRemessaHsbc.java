package Beans;
/*
 @author Tiago e Paulo 31/08/2016 18:53
 */
public class BeanRemessaHsbc {
    
    //Variaveis Do Registro Header
    public int      HCodigoDoRegistro                           = 0;    //9(01)
    public int      HCodigoDeOperacao                           = 0;    //9(01)
    public String   HIdentificacaoPorExtenso                    = "";   //X(07)
    public int      HCodigoDoServico                            = 0;    //9(02)
    public String   HIdentificacaoDoServico                     = "";   //X(15)
    public int      HZero1                                      = 0;    //9(01)
    public int      HNumeroDaAgencia                            = 0;    //9(04)
    public int      HSubConta                                   = 0;    //9(02)
    public String   HNumeroDaContaCorrente                      = "";   //9(11)
    public String   HComplementoDeRegistro1                     = "";   //X(02)
    public String   HNomeDaEmpresa                              = "";   //X(30)
    public int      HCodigoDoBanco                              = 0;    //9(03)
    public String   HNomeDoBanco                                = "";   //X(15)
    public String   HDataDeGeracao                              = "";   //9(06)
        public String HDiaDeGeracao                             = "";
        public String HMesDeGeracao                             = "";
        public String HAnoDeGeracao                             = "";
    public String   HDensidadeDeGravacao                        = "";   //X(05)
    public String   HUnidadeDeDensidadeDeGravacao               = "";   //X(03)
    public String   HComplementoDeRegistro2                     = "";   //X(02)
    public String   HSiglaDoLayutTecnico                        = "";   //X(07)
    public String   HComplementoDeRegistro3                     = "";   //X(277)
    public int      HNumeroSequencialDoRegistroNoArquivo        = 0;    //9(06)
    
    //Variaveis Do Registro Detalhe
    public int      DCodigoDoRegistro                           = 0;    //9(01)
    public String   DCodigoDeInscricao                          = "";   //9(02)
    public String   DNumeroDeInscricaoDaEmpresa                 = "";   //X(14)
    public int      DZero1                                      = 0;    //9(01)
    public int      DNumeroDaAgencia                            = 0;    //9(04)
    public int      DSubConta                                   = 0;    //9(02)
    public String   DNumeroDaContaCorrente                      = "";   //9(11)
    public String   DComplementoDeRegistro1                     = "";   //X(02)
    public int      DIdentificacaoDoTituloNoSistemaDoCliente    = 0;    //X(25)
    public String   DNossoNumero                                = "";   //X(11)
    public String   DDataLimiteParaDesconto2                    = "";   //X(06)
    public double   DValorDoDesconto2                           = 0;    //9(09)V9(2)
    public String   DDataLimiteParaDesconto3                    = "";   //X(06)
    public double   DValorDoDesconto3                           = 0;    //9(09)V9(2)
    public String   DCodigoDaCarteira                           = "";   //9(01)
    public String   DIdentificacaoDaOcorrencia                  = "";   //9(02)
    public String   DSeuNumero                                  = "";   //X(10)
    public String   DDataDeVencimentoDoTitulo                   = "";   //X(06)
        public String DDiaDeVencimentoDoTitulo                  = "";
        public String DMesDeVencimentoDoTitulo                  = "";
        public String DAnoDeVencimentoDoTitulo                  = "";
    public String   DValorNominalDoTitulo                       = "";   //9(13)
    public int      DNumeroDoBancoCobrador                      = 0;    //9(03)
    public int      DNumeroDaAgenciaEncarregadaDaCobranca       = 0;    //9(05)
    public String   DEspecieDoTitulo                            = "";   //9(02)
    public String   DTituloAceiteOuNaoAceite                    = "";   //X(01)
    public String   DDataEmissaoDoTitulo                        = "";   //X(06)
        public String DDiaEmissaoDoTitulo                       = "";
        public String DMesEmissaoDoTitulo                       = "";
        public String DAnoEmissaoDoTitulo                       = "";
    public String   DPrimeiraInstrucaoDeCobranca                = "";   //9(02)
    public String   DSegundaInstrucaoDeCobranca                 = "";   //9(02)
    public String   DValorDeMoraPorDiaDeAtraso                  = "";   //9(13)
    public String   DDataLimiteParaDesconto                     = "";   //9(06)
    public String   DValorDoDescontoAserConcecido               = "";   //9(11)V9(2)
    public String   DValorDoIOFRecolhidoPeloBanco               = "";   //9(11)V9(2)
    public String   DValorDoAbatimentoASerConcedido             = "";   //9(11)V9(2)
    public int      DIdentificacaoDoTipoDeInscricaoDoSacado     = 0;    //9(02)
    public String   DNumeroDeIncricaoDoSacado                   = "";   //X(14)
    public String   DNomeDoSacado                               = "";   //X(40)
    public String   DRuaNumeroEComplementoDoSacado              = "";   //X(38)
    public int      DInstrucaoDeNaoRecebimentoDeBloqueio        = 0;    //9(02)
    public String   DBairroDoSacado                             = "";   //X(12)
    public String   DCepDoSacado                                = "";   //9(08)
    public String   DCidadeDoSacado                             = "";   //X(15)
    public String   DUfDoSacado                                 = "";   //X(02)
    public String   DNomeDoSacadoOuAvalista                     = "";   //X(39)
    public String   DTipoDeBloqueioUtilizado                    = "";   //X(01)
    public int      DNumeroDeDiasParaProtesto                   = 0;    //9(02)
    public int      DTipoDeMoeda                                = 0;    //9(01)
    public int      DNumeroSequencialDoRegistroNoArquivo        = 0;    //9(06)
    
    //Variavies do Registro Trailer
    public int      TCodigoDoRegistro                           = 0;    //9(01)
    public String   TComplementoDeRegistro1                     = "";   //X(393)
    public int      TNumeroSequencialDoRegistroNoArquivo        = 0;    //9(06)
    
}
