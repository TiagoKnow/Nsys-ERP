package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanRemessaItau {
    
    //Variaveis Do Registro Header
    public int      HCodigoDoRegistro                       = 0;    //9(01)
    public int      HCodigoDeOperacao                       = 0;    //9(01)
    public String   HIdentificacaoPorExtenso                = "";   //X(07)
    public int      HCodigoDoServico                        = 0;    //9(02)
    public String   HIdentificacaoDoServico                 = "";   //X(15)
    public int      HNumeroDaAgencia                        = 0;    //9(04)
    public String   HComplementoDeRegistro1                 = "";   //9(02)
    public String   HNumeroDaContaCorrente                  = "";   //9(05)
    public int      HDigitoAutoConferencia                  = 0;    //9(01)
    public String   HComplementoDeRegistro2                 = "";   //X(08)
    public String   HNomeDaEmpresa                          = "";   //X(30)
    public int      HCodigoDoBanco                          = 0;    //9(03)
    public String   HNomeDoBanco                            = "";   //X(15)
    public String   HDataDeGeracao                          = "";   //9(06)
        public String HDiaDeGeracao                         = "";
        public String HMesDeGeracao                         = "";
        public String HAnoDeGeracao                         = "";
    public String   HComplementoDeRegistro3                 = "";   //X(294)
    public String   HIdentificacaoDoSistema                 = "";   //X(02)
    public int      HNumeroSequencialDeRemessa              = 0;    //9(07)
    public int      HNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
    //Variaveis Do Registro Detalhe
    public int      DCodigoDoRegistro                       = 0;    //9(01)
    public String   DCodigoDeInscricao                      = "";   //9(02)
    public String   DNumeroDeInscricaoDaEmpresa             = "";   //9(14)
    public int      DNumeroDaAgencia                        = 0;    //9(04)
    public int      DDigitoAutoConferenciaAgencia           = 0;    //9(01)
    public String   DComplementoDeRegistro1                 = "";   //9(02)
    public String   DNumeroDaContaCorrente                  = "";   //9(05)
    public int      DDigitoAutoConferencia                  = 0;    //9(01)
    public String   DComplementoDeRegistro2                 = "";   //X(04)
    public int      DCodigoAlegacaoASerCancelada            = 0;    //9(04)
    public String   DIdentificacaoDoTituloNaEmpresa         = "";   //X(25)
    public String   DIdentificacaoDoTituloNoBanco           = "";   //9(08)
    public String   DQtdMoedaVariavel                       = "";   //9(08)V9(5)
    public String   DNumeroDaCarteiraNoBanco                = "";   //9(03)
    public String   DIdentificacaoDaOperacaoNoBanco         = "";   //X(21)
    public String   DCodigoDaCarteira                       = "";   //X(01)
    public int      DIdentificacaoDaOcorrencia              = 0;    //9(02)
    public String   DNumeroDoDocumentoDeCobranca            = "";   //X(10)
    public String   DDataDeVencimentoDoTitulo               = "";   //9(06)
        public String DDiaDeVencimentoDoTitulo              = "";
        public String DMesDeVencimentoDoTitulo              = "";
        public String DAnoDeVencimentoDoTitulo              = "";
    public String   DValorNominalDoTitulo                   = "";   //9(11)V9(2)
    public int      DNumeroDoBancoCamaraCompensacao         = 0;    //9(03)
    public int      DNumeroDaAgenciaCobradoraDoTitulo       = 0;    //9(05)
    public String   DEspecieDoTitulo                        = "";   //X(02)
    public String   DTituloAceiteOuNaoAceite                = "";   //X(01)
    public String   DDataEmissaoDoTitulo                    = "";   //9(06)
        public String DDiaEmissaoDoTitulo                   = "";
        public String DMesEmissaoDoTitulo                   = "";
        public String DAnoEmissaoDoTitulo                   = "";
    public String   DPrimeiraInstrucaoDeCobranca            = "";   //X(02)
    public String   DSegundaInstrucaoDeCobranca             = "";   //X(02)
    public String   DValorDeMoraPorDiaDeAtraso              = "";   //9(11)V9(2)
    public String   DDataLimiteParaConcessaoDeDesconto      = "";   //9(06)
    public String   DValorDoDescontoAserConcecido           = "";   //9(11)V9(2)
    public String   DValorDoIOFRecolhidoParaNotasSeguro     = "";   //9(11)V9(2)
    public String   DValorDoAbatimentoASerConcedido         = "";   //9(11)V9(2)
    public int      DIdentificacaoDoTipoDeIncricaoPagador   = 0;    //9(02)
    public String   DNumeroDeIncricaoDoPagador              = "";   //9(14)
    public String   DNomeDoPagador                          = "";   //X(30)
    public String   DComplementoDeRegistro3                 = "";   //X(10)
    public String   DRuaNumeroEComplementoDoPagador         = "";   //X(40)
    public String   DBairroDoPagador                        = "";   //X(12)
    public String   DCepDoPagador                           = "";   //9(08)
    public String   DCidadeDoPagador                        = "";   //X(15)
    public String   DUfDoPagador                            = "";   //X(02)
    public String   DNomeDoSacadoOuAvalista                 = "";   //X(30)
    public String   DComplementoDeRegistro4                 = "";   //X(04)
    public String   DDataDeMora                             = "";   //9(06)
    public int      DQtdDeDia                               = 0;    //9(02)
    public String   DComplementoDoRegistro5                 = "";   //X(01)
    public int      DNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
    //Variaveis Do Registro Trailer
    public int      TCodigoDoRegistro                       = 0;    //9(01)
    public String   TComplementoDoRegistro1                 = "";   //X(393)
    public int      TNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
}
