package Beans;

/**
 * @author Tiago e Paulo
 */
public class BeanClientes {
    
    public int    idCliente                         = 0;    //0
    public int    idEmpresa                         = 0;    //1
    public int    codigoGrupo                       = 0;    //2
    public int    codigoEmpresa                     = 0;    //3
    public int    codigoCliente                     = 0;    //4
    public int    statusCliente                     = 0;    //5
    public int    fisicaJuridica                    = 0;    //6
    public int    cpfCnpjNaoInformado               = 0;    //7
    public String cpfCnpj                           = "";   //8
        public String cpfCnpj1                      = "";
        public String cpfCnpj2                      = "";
        public String cpfCnpj3                      = "";
    public String InscricaoEstadual                 = "";   //9
        public String InscricaoEstadual1            = "";
        public String InscricaoEstadual2            = "";
        public String InscricaoEstadual3            = "";
        public String InscricaoEstadual4            = "";
    public String dataNascAber                      = "";   //10
    public String dataCadastro                      = "";   //11
    public String nome                              = "";   //12
    public int    sexo                              = 0;    //13
    public int    estadoCivil                       = 0;    //14
    public String telefone                          = "";   //15
    public String contato                           = "";   //16
    public String email                             = "";   //17
    public String cei                               = "";   //18
    public String celular                           = "";   //19
    public String profissao                         = "";   //20
    public String site                              = "";   //21
    public String contrato                          = "";   //22
    public String cep                               = "";   //23
    public String cidade                            = "";   //24
    public String endereco                          = "";   //25
    public String numero                            = "";   //26
    public String bairro                            = "";   //27
    public String uf                                = "";   //28
    public int    codigoPais                        = 0;    //29
    public String observacoes                       = "";   //30
    public String dataAlterou                       = "";   //31
    public String horaAlterou                       = "";   //32
    public int    usuarioAlterou                    = 0;    //33
    public int    idEmpresaAlterou                  = 0;    //34
    public int    codigoGrupoAlterou                = 0;    //35
    public int    codigoEmpresaAlterou              = 0;    //36
    
    public void RecarregaInscricaoEstadual(){
        InscricaoEstadual   = InscricaoEstadual1 + "." + InscricaoEstadual2 + "." + InscricaoEstadual3 + "." + InscricaoEstadual4;
    }
    
}
