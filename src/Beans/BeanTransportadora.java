package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanTransportadora {
    
    public int    idTransportadora                  = 0;    //0
    public int    idEmpresa                         = 0;    //1
    public int    codigoGrupo                       = 0;    //2
    public int    codigoEmpresa                     = 0;    //3
    public int    codigoTransportadora              = 0;    //4
    public int    fisicaJuridica                    = 0;    //5
    public String cpfCnpj                           = "";   //6
        public String cpfCnpj1                      = "";
        public String cpfCnpj2                      = "";
        public String cpfCnpj3                      = "";
    public String InscricaoEstadual                 = "";   //6
        public String InscricaoEstadual1            = "";
        public String InscricaoEstadual2            = "";
        public String InscricaoEstadual3            = "";
        public String InscricaoEstadual4            = "";
    public String NomeTransportadora                = "";   //7
    public String Cep                               = "";   //8
        public String Cep1                          = "";
        public String Cep2                          = "";
    public String Uf                                = "";   //9
    public String Cidade                            = "";   //10
    public String Bairro                            = "";   //11
    public String Endereco                          = "";   //12
    public String Numero                            = "";   //13
    public int    codigoPais                        = 0;    //14
    
    public void RecarregaInscricaoEstadual(){
        InscricaoEstadual   = InscricaoEstadual1 + "." + InscricaoEstadual2 + "." + InscricaoEstadual3 + "." + InscricaoEstadual4;
    }
    
}
