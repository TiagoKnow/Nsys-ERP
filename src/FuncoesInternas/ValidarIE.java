package FuncoesInternas;
/*
 @author Tiago e Paulo 26/10/2016 13:46
 */
public class ValidarIE {
    //String's
    String Valor                            = "";
    String Valor1                           = "";
    String Valor2                           = "";
    
    //int's
    int    Peso                             = 0;
    int    Soma                             = 0;
    int    Senha1                           = 0;
    int    Senha2                           = 0;
    int    Digito1                          = 0;
    int    Digito2                          = 0;
    int    Resto                            = 0;
    
    //boolean
    boolean Resultado                       = true;
    
    public boolean ValidadorDeIE(String valor){
        Valor = valor.replace(".", "");
        Valor = Valor.replace(" ", "");
        if( Valor.equals(""))                return false;
        if(!Valor.equalsIgnoreCase("ISENTO"))return false;
        if( Valor.equalsIgnoreCase("ISENTO"))return true;
        
        try{Long.parseLong(Valor);}catch(Exception erro){return false;}
        
        Resultado = true;
        CalculaIE();
        
        if(Digito1 != Senha1)Resultado = false;
        if(Digito2 != Senha2)Resultado = false;
        
        return Resultado;
    }
    
    private void CalculaIE(){
        Valor1      = Valor.substring(0, 8);
        Valor2      = Valor.substring(0, 11);
        Senha1      = Integer.parseInt(Valor.substring(8 , 9));
        Senha2      = Integer.parseInt(Valor.substring(11,12));
        PegaDigito1();
        PegaDigito2();
    }
    
    private void PegaDigito1(){
        Soma = 0;
        Peso = 1;
        for(int i = 0; i < Valor1.length(); i++){
            if(Peso == 2)Peso++;
            if(Peso == 9)Peso++;
            
            Soma += Integer.parseInt(Valor1.substring(i, i + 1)) * Peso;
            Peso++;
        }
        Resto = Soma % 11;
        if(Resto > 9){
            Digito1 = 0;
        }else{
            Digito1 = Resto;
        }
    }
    
    private void PegaDigito2(){
        Soma = 0;
        Peso = 3;
        for(int i = 0; i < Valor2.length(); i++){
            if(Peso < 2)Peso = 10;
            
            Soma += Integer.parseInt(Valor.substring(i, i + 1)) * Peso;
            Peso--;
        }
        Resto = Soma % 11;
        if(Resto > 9){
            Digito2 = 0;
        }else{
            Digito2 = Resto;
        }
    }
    
}
