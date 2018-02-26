package Beans;

/**
 * @author Tiago e Paulo
 */
public class BeanFornecedor {
     
    public int    idFornecedor          = 0;    //0
    public int    idEmpresa             = 0;    //1
    public int    codigoGrupo           = 0;    //2
    public int    codigoEmpresa         = 0;    //3
    public int    codigoFornecedor      = 0;    //4
    public int    statusFornecedor      = 0;    //5
    public String cnpj                  = "";   //6
        public String cnpj1             = "";
        public String cnpj2             = "";
        public String cnpj3             = "";
    public String dataCadastro          = "";   //7
    public String nome                  = "";   //8
    public String contato               = "";   //9
    public String telefone              = "";   //10
    public String email                 = "";   //11
    public String cep                   = "";   //12
        public String cep1              = "";
        public String cep2              = "";
    public String cidade                = "";   //13
    public String endereco              = "";   //14
    public String numero                = "";   //15
    public String bairro                = "";   //16
    public String uf                    = "";   //17
    public int    codigoPais            = 0;    //18
    public String observacoes           = "";   //19
    public String dataAlterou           = "";   //20
    public String horaAlterou           = "";   //21
    public int    usuarioAlterou        = 0;    //22
    public int    idEmpresaAlterou      = 0;    //23
    public int    codigoGrupoAlterou    = 0;    //24
    public int    codigoEmpresaAlterou  = 0;    //25
    
    public void RecarregaCEP(){
        cep     = cep1 + "-" + cep2;
    }
    
    public void RecarregaCEPs(){
        cep     = cep.replace("-", "");
        cep1    = cep.substring(0, 5).replace(" ", "");
        cep2    = cep.substring(5, 8).replace(" ", "");
        cep     = cep1 + cep2;
    }
  
}
