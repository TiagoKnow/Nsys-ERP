package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanNotasFiscaisEletronicas {
    
    public int    codigoNFe                             = 0;
    public int    ModeloNFe                             = 0;
    public int    SerieNFe                              = 0;
    public int    codigoUsuario                         = 0;
    public int    codigoCliente                         = 0;
    public int    codigoTransportadora                  = 0;
    public String DataEmissao                           = "";
    public String HoraEmissao                           = "";
    public int    TipoDoDocumento                       = 0;    //0-Entrada,1 - Saída
    public String DataEntradaSaida                      = "";
    public String HoraEntradaSaida                      = "";
    public int    FormaDePagamento                      = 0;    //0-Pagamento à vista,1-Pagamaento à prazo,2-Outros
    public String FormaDeEmissao                        = "";   //0-Normal,1-Contigência FS-IA,2-Contigência via EPEC,3-Contigência FS-DA,4-Contigência SVC-AN,5-Contigência SVC-RS
    public String DataEntradaEmContigência              = "";
    public String HoraEntradaEmContigência              = "";
    public String JustificativaDeEntradaEmContigencia   = "";
    public int    FinalidadeDeEmissao                   = 0;    //1-NF-Normal,2-NFe complementar,3-NFe de Ajuste,4-Devolução de Mercadoria
    public int    TipoDeImpressao                       = 0;    //0-Retrato,1- Paisagem
    public int    ConsumidorFinal                       = 0;    //0-Não    ,1- Sim
    public int    DestinoDeOperacao                     = 0;    //1-Operação Interna,2-Operação InterEstadual,3-Operação com Exterior
    public int    TipoDeAtendimento                     = 0;    //0-Não se aplica;1-Operação Presencial;2-Operação Não Presencial, pela INTERNET;3-Operação Não Presencial, pela TELEATENDIMENTO;4-Operação Não Presencial, OUTROS
    public String NaturezaDaOperacao                    = "";
    public String Uf                                    = "";
    public String CidadeDeOcorrencia                    = "";
    public String DataAlterou                           = "";
    public String HoraAlterou                           = "";
    public int    UsuarioAlterou                        = 0;
    
}
