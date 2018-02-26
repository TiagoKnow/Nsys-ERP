package BeansNS;
/*
 @author Paulo e Tiago
 */
public class BeanCEP {
    public String cep      = "";
        public String cep1 = "";
        public String cep2 = "";
    public String endereco = "";
    public String cidade   = "";
    public String bairro   = "";
    public String uf       = "";
    public int    idCep    = 0;
    
    public void RecarregaCEP(){
        cep     = cep1 + "-" + cep2;
    }
    
    public void RecarregaCEPs(){
        cep     = cep.replace("-", "");
        cep1    = cep.substring(0, 5);
        cep2    = cep.substring(5, 8);
    }
    
}
