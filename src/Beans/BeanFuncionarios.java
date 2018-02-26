package Beans;

/**
 * @author Tiago e Paulo
 */
public class BeanFuncionarios {
    
    public int    idFuncionario             = 0;    //0
    public int    idEmpresa                 = 0;    //1
    public int    codigoGrupo               = 0;    //2
    public int    codigoEmpresa             = 0;    //3
    public int    codigoFuncionario         = 0;    //4
    public int    codigoDepartamento        = 0;    //5
    public int    statusFuncionario         = 0;    //6
    public String dataCadastro              = "";   //7
    public int    tipoPessoa                = 0;    //8
    public String cpfCnpj                   = "";   //9
    public String dataAdmissao              = "";   //10
    public String nomeFuncionario           = "";   //11
    public String rg                        = "";   //12
    public int    sexo                      = 0;    //13
    public int    estadoCivil               = 0;    //14
    public String profissao                 = "";   //15
    public String dataNascimento            = "";   //16
    public String nacionalidade             = "";   //17
    public String naturalidade              = "";   //18
    public String ufNaturalidade            = "";   //19
    public String cep                       = "";   //20
    public String cidade                    = "";   //21
    public String municipio                 = "";   //22
    public String endereco                  = "";   //23
    public String complemento               = "";   //24
    public String bairro                    = "";   //25
    public String numero                    = "";   //26
    public String uf                        = "";   //27
    public int    codigoPais                = 0;    //28
    public String telefone                  = "";   //29
    public String celular                   = "";   //30
    public String email                     = "";   //31
    public String observacoes               = "";   //32
    public String dataAlterou               = "";   //33
    public String horaAlterou               = "";   //34
    public int    usuarioAlterou            = 0;    //35
    public int    idEmpresaAlterou          = 0;    //36
    public int    codigoGrupoAlterou        = 0;    //37
    public int    codigoEmpresaAlterou      = 0;    //38
    public byte[] imagemFuncionario         = null; //39

    public byte[] getimagemFuncionario() {
        return imagemFuncionario;
    }

    public void setimagemFuncionario(byte[] imagemFuncionario) {
        this.imagemFuncionario = imagemFuncionario;
    }
    
    
    
}
