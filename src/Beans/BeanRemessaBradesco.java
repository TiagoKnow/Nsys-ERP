package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanRemessaBradesco {
    
    //Variaveis Do Registro Header
    public int      HCodigoDoRegistro                       = 0;    //9(01)
    public int      HCodigoDeOperacao                       = 0;    //9(01)
    public String   HIdentificacaoPorExtenso                = "";   //X(07)
    public int      HCodigoDoServico                        = 0;    //9(02)
    public String   HIdentificacaoDoServico                 = "";   //X(15)
    public int      HCodigoDaEmpresa                        = 0;    //9(20)
    public String   HNomeDaEmpresa                          = "";   //X(30)
    public int      HNumeroDoBancoCamaraCompensacao         = 0;    //9(03)
    public String   HNomeDoBanco                            = "";   //X(15)
    public String   HDataDeGeracao                          = "";   //9(06)
        public String HDiaDeGeracao                         = "";
        public String HMesDeGeracao                         = "";
        public String HAnoDeGeracao                         = "";
    public String   HComplementoDeRegistro1                 = "";   //X(08)
    public String   HIdentificacaoDoSistema                 = "";   //X(02)
    public int      HNumeroSequencialDeRemessa              = 0;    //9(07)
    public String   HComplementoDeRegistro2                 = "";   //X(277)
    public int      HNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
    //Variaveis Do Registro Detalhe
    public int      DCodigoDoRegistro                       = 0;    //9(01)
    public int      DNumeroDaAgencia                        = 0;    //9(05)
    public String   DDigitoAutoConferenciaAgencia           = "";   //X(01)
    public int      DRazaoContaCorrente                     = 0;    //9(05)
    public int      DNumeroDaContaCorrente                  = 0;    //9(07)
    public String   DDigitoContaCorrente                    = "";   //X(01)
    public String   DIdentificacaoEmpresaBeneficiariaBanco  = "";   //X(17)
    public String   DNumeroDeControleDoParticipante         = "";   //X(25)
    public int      DNumeroDoBancoCamaraCompensacao         = 0;    //9(03)
    public int      DCampoDeMulta                           = 0;    //9(01)
    public int      DPercentualDeMulta                      = 0;    //9(04)
    public String   DIdentificacaoDoTituloNoBanco           = "";   //9(11)
    public String   DDigitioAutoConferenciaNumeroBancario   = "";   //X(01)
    public int      DDescontoBonificacaoPorDia              = 0;    //9(10)
    public int      DCondicaoPapeletaDeCobranca             = 0;    //9(01)
    public String   DIdentificacaoEmiteBoletoDebAutomatico  = "";   //X(01)
    public String   DIdentificacaoDaOperacaoNoBanco         = "";   //X(10)
    public String   DIndicadorRateioCredito                 = "";   //X(01)
    public int      DEnderecamentoAvisoDebAutEmConCorrente  = 0;    //9(01)
    public String   DComplementoDeRegistro1                 = "";   //X(02)
    public int      DIdentificacaoDaOcorrencia              = 0;    //9(02)
    public String   DNumeroDoDocumento                      = "";   //X(10)
    public String   DDataDeVencimentoDoTitulo               = "";   //9(06)
        public String DDiaDeVencimentoDoTitulo              = "";
        public String DMesDeVencimentoDoTitulo              = "";
        public String DAnoDeVencimentoDoTitulo              = "";
    public String   DValorNominalDoTitulo                   = "";   //9(11)V9(2)
    public int      DBancoEncarregadoDaCobranca             = 0;    //9(03)
    public int      DNumeroDaAgenciaCobradoraDoTitulo       = 0;    //9(05)
    public String   DEspecieDoTitulo                        = "";   //X(02)
    public String   DIdentificacao                          = "";   //X(01)
    public String   DDataEmissaoDoTitulo                    = "";   //9(06)
        public String DDiaEmissaoDoTitulo                   = "";
        public String DMesEmissaoDoTitulo                   = "";
        public String DAnoEmissaoDoTitulo                   = "";
    public String   DPrimeiraInstrucaoDeCobranca            = "";   //X(02)
    public String   DSegundaInstrucaoDeCobranca             = "";   //X(02)
    public String   DValorASerCobradoPorDiaDeAtraso         = "";   //9(11)V9(2)
    public String   DDataLimiteParaConcessaoDeDesconto      = "";   //9(06)
    public String   DValorDoDesconto                        = "";   //9(11)V9(2)
    public String   DValorDoIOF                             = "";   //9(11)V9(2)
    public String   DValorDoAbatimentoASerConcedido         = "";   //9(11)V9(2)
    public int      DIdentificacaoDoTipoDeIncricaoPagador   = 0;    //9(02)
    public String   DNumeroDeIncricaoDoPagador              = "";   //9(14)
    public String   DNomeDoPagador                          = "";   //X(40)
    public String   DRuaNumeroEComplementoDoPagador         = "";   //X(40)
    public String   DPrimeiraMensagem                       = "";   //X(12)
    public String   DCepDoPagador                           = "";   //9(08)
    public String   DNomeDoSacadoOuAvalista                 = "";   //X(40)
    public int      DNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
//    public String   DCodigoDeInscricao                      = "";   //9(02)
//    public String   DNumeroDeInscricaoDaEmpresa             = "";   //9(14)
//    public String   DComplementoDeRegistro2                 = "";   //X(04)
//    public int      DCodigoAlegacaoASerCancelada            = 0;    //9(04)
//    public String   DIdentificacaoDoTituloNaEmpresa         = "";   //X(25)
//    public String   DQtdMoedaVariavel                       = "";   //9(08)V9(5)
//    public String   DNumeroDaCarteiraNoBanco                = "";   //9(03)
//    public String   DCodigoDaCarteira                       = "";   //X(01)
//    public String   DTituloAceiteOuNaoAceite                = "";   //X(01)
//    public String   DBairroDoPagador                        = "";   //X(12)
//    public String   DCidadeDoPagador                        = "";   //X(15)
//    public String   DUfDoPagador                            = "";   //X(02)
//    public String   DComplementoDeRegistro4                 = "";   //X(04)
//    public String   DDataDeMora                             = "";   //9(06)
//    public int      DQtdDeDia                               = 0;    //9(02)
//    public String   DComplementoDoRegistro5                 = "";   //X(01)
    
    //Variaveis Do Registro Trailer
    public int      TCodigoDoRegistro                       = 0;    //9(01)
    public String   TComplementoDoRegistro1                 = "";   //X(393)
    public int      TNumeroSequencialDoRegistroNoArquivo    = 0;    //9(06)
    
}
