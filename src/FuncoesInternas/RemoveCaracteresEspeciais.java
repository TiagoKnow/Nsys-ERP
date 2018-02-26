package FuncoesInternas;
/*
 @author Tiago e Paulo09/08/2016 20:40
 */
public class RemoveCaracteresEspeciais {
    String Texto                    = "";
    String Texto1                   = "";
    String Retorno                  = "";
    
    public String RemoveCaracteresEspeciais(String texto){
        Texto   = texto;
        Retorno = "";
        for(int i = 0; i < Texto.length(); i++){
            Texto1 = Texto.substring(i, i + 1);
            RemoveCaracteres();
            Retorno = Retorno + Texto1;
        }
        return Retorno.toUpperCase();
    }
    
    public void RemoveCaracteres(){
        if(Texto1.equalsIgnoreCase("Á"))Texto1 = "A";
        if(Texto1.equalsIgnoreCase("Ã"))Texto1 = "A";
        if(Texto1.equalsIgnoreCase("À"))Texto1 = "A";
        if(Texto1.equalsIgnoreCase("Â"))Texto1 = "A";
        if(Texto1.equalsIgnoreCase("Ä"))Texto1 = "A";
        if(Texto1.equalsIgnoreCase("É"))Texto1 = "E";
        if(Texto1.equalsIgnoreCase("È"))Texto1 = "E";
        if(Texto1.equalsIgnoreCase("Ê"))Texto1 = "E";
        if(Texto1.equalsIgnoreCase("Ë"))Texto1 = "E";
        if(Texto1.equalsIgnoreCase("Í"))Texto1 = "I";
        if(Texto1.equalsIgnoreCase("Ì"))Texto1 = "I";
        if(Texto1.equalsIgnoreCase("Î"))Texto1 = "I";
        if(Texto1.equalsIgnoreCase("Ï"))Texto1 = "I";
        if(Texto1.equalsIgnoreCase("Ó"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Õ"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Ò"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Ô"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Ö"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Ú"))Texto1 = "U";
        if(Texto1.equalsIgnoreCase("Ù"))Texto1 = "U";
        if(Texto1.equalsIgnoreCase("Û"))Texto1 = "U";
        if(Texto1.equalsIgnoreCase("Ü"))Texto1 = "U";
        if(Texto1.equalsIgnoreCase("°"))Texto1 = "O";
        if(Texto1.equalsIgnoreCase("Ç"))Texto1 = "C";
    }
    
}
