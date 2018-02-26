package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanUsuarios {
    
    public int    idUsuario             = 0;    //0
    public int    idEmpresa             = 0;    //1
    public int    codigoGrupo           = 0;    //2
    public int    codigoEmpresa         = 0;    //3
    public int    codigoUsuario         = 0;    //4
    public String dataCriacao           = "";   //5
    public String nome                  = "";   //6
    public String usuario               = "";   //7
    public String senha                 = "";   //8
    public String telefone              = "";   //9
    public int    codigoDepartamento    = 0;    //10
    public int    nivelUsuario          = 0;    //11
    public int    podeMudarEmpresa      = 0;    //12
    public String observacoes           = "";   //13
    public String nomeConexao           = "";   //14
    public String dataAlterou           = "";   //15
    public String horaAlterou           = "";   //16
    public int    usuarioAlterou        = 0;    //17
    public int    idEmpresaAlterou      = 0;    //18
    public int    codigoGrupoAlterou    = 0;    //29
    public int    codigoEmpresaAlterou  = 0;    //20
    public byte[] imagemUsuario         = null; //21

    public byte[] getimagemUsuario() {
        return imagemUsuario;
    }

    public void setimagemUsuario(byte[] imagemUsuario) {
        this.imagemUsuario = imagemUsuario;
    }
    
}