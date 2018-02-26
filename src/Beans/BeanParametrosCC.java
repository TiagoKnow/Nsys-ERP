package Beans;
/*
 @author Tiago e Paulo 10/08/2016 16:08
 */
public class BeanParametrosCC {
    
    public int    idParametrosCC = 0;    //0
    public int    idEmpresa      = 0;    //1
    public int    codigoGrupo    = 0;    //2
    public int    codigoEmpresa  = 0;    //3
    public byte[] imagemBoletos  = null; //4

    public byte[] getImagemBoletos() {
        return imagemBoletos;
    }

    public void setImagemBoletos(byte[] imagemBoletos) {
        this.imagemBoletos = imagemBoletos;
    }
    
}
