package BeansNS;

/**
 * @author Tiago e Paulo
 */
public class BeanEmpresas {
    
    public int    idEmpresa                 = 0;    //0
    public int    codigoGrupo               = 0;    //1
    public int    codigoEmpresa             = 0;    //2
    public int    idBancoDados              = 0;    //3
    public String nomeEmpresa               = "";   //4
    public String nomeFantasia              = "";   //5
    public String cnpjEmpresa               = "";   //6
        public String cnpjEmpresa1          = "";
        public String cnpjEmpresa2          = "";
        public String cnpjEmpresa3          = "";
    public String inscricaoEstadual         = "";   //7
    public String regimeTributario          = "";   //8
    public String cepEmpresa                = "";   //9
    public String cidadeEmpresa             = "";   //10
    public String bairroEmpresa             = "";   //11
    public String enderecoEmpresa           = "";   //12
    public String numeroEmpresa             = "";   //13
    public String ufEmpresa                 = "";   //14
    public String telefoneEmpresa           = "";   //15
    public String pastaImagemUsuario        = "";   //16
    public String extensaoImagemUsuario     = "";   //17
    public String dataValidade              = "";   //18
    public byte[] imagemLogotipoEmpresa     = null; //19

    public byte[] getimagemLogotipoEmpresa() {
        return imagemLogotipoEmpresa;
    }

    public void setimagemLogotipoEmpresa(byte[] imagemLogotipoEmpresa) {
        this.imagemLogotipoEmpresa = imagemLogotipoEmpresa;
    }
    
    //Variaveis Reservas
    public int    IdEmpresa                 = 0;
    public int    CodigoGrupo               = 0;
    public int    CodigoEmpresa             = 0;
    public int    IdBancoDados              = 0;
    public String NomeEmpresa               = "";
    public String NomeFantasia              = "";
    public String CnpjEmpresa               = "";
        public String CnpjEmpresa1          = "";
        public String CnpjEmpresa2          = "";
        public String CnpjEmpresa3          = "";
    public String InscricaoEstadual         = "";
    public String RegimeTributario          = "";
    public String CepEmpresa                = "";
    public String CidadeEmpresa             = "";
    public String BairroEmpresa             = "";
    public String EnderecoEmpresa           = "";
    public String NumeroEmpresa             = "";
    public String UfEmpresa                 = "";
    public String TelefoneEmpresa           = "";
    public String PastaImagemUsuario        = "";
    public String ExtensaoImagemUsuario     = "";
    public String DataValidade              = "";
    public byte[] ImagemLogotipoEmpresa     = null;
    
}
