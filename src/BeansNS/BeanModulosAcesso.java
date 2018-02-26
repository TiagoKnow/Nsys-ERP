package BeansNS;
/*
 @author Tiago e Paulo
 */
public class BeanModulosAcesso {
    public int    idModuloAcesso        = 0;
    public int    codigoGrupo           = 0;
    public String modulosAcesso         = "";
    public int    moduloFaturamento     = 0;
    public int    moduloVendas          = 0;
    public int    moduloEstoque         = 0;
    public int    moduloContabil        = 0;
    public int    moduloFiscal          = 0;
    public int    moduloContasAReceber  = 0;
    public int    moduloContasAPagar    = 0;
    public int    moduloProducao        = 0;
    public int    moduloGestao          = 0;
    public int    moduloCompras         = 0;
    public int    moduloRecebimento     = 0;
    public int    moduloCRM             = 0;
    public int    moduloCC              = 0;
    public int    moduloRH              = 0;
    
    public void RecarregaVariavies(){
        moduloFaturamento       = Integer.parseInt(modulosAcesso.substring(0 , 1));
        moduloVendas            = Integer.parseInt(modulosAcesso.substring(1 , 2));
        moduloEstoque           = Integer.parseInt(modulosAcesso.substring(2 , 3));
        moduloContabil          = Integer.parseInt(modulosAcesso.substring(3 , 4));
        moduloFiscal            = Integer.parseInt(modulosAcesso.substring(4 , 5));
        moduloContasAReceber    = Integer.parseInt(modulosAcesso.substring(5 , 6));
        moduloContasAPagar      = Integer.parseInt(modulosAcesso.substring(6 , 7));
        moduloProducao          = Integer.parseInt(modulosAcesso.substring(7 , 8));
        moduloGestao            = Integer.parseInt(modulosAcesso.substring(8 , 9));
        moduloCompras           = Integer.parseInt(modulosAcesso.substring(9 ,10));
        moduloRecebimento       = Integer.parseInt(modulosAcesso.substring(10,11));
        moduloCRM               = Integer.parseInt(modulosAcesso.substring(11,12));
        moduloCC                = Integer.parseInt(modulosAcesso.substring(12,13));
        moduloRH                = Integer.parseInt(modulosAcesso.substring(13,14));
    }
        
}
