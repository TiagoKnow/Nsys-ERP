package FuncoesInternas;
/*
 @author Paulo
 */
public class ValidarRG {
    int     Digito            = 0;
    int     Resto             = 0;
    String  DigitoVerificador = "";
    String  Resultado         = "";
    String  Valor             = "";
    String  ValorTexto        = "";
    boolean Retorno;
    public boolean ValidarRG(String valor){
        Resultado = "";
        Digito    = 0;
        Valor     = valor.replace(" ", "");
        Valor     = Valor.replace(".", "");
        Valor     = Valor.replace("-", "");
        if(Valor.equals("")){
            return false;
        }
        if(Valor.length() < 9){
            return false;
        }
        DigitoVerificador = Valor.substring(Valor.length() - 1, Valor.length());
        Valor = Valor.substring(0, Valor.length() - 1);
        for(int i = 0; i < Valor.length(); i++){
            ValorTexto = Valor.substring(i, i + 1);
            Digito += (9 - i) * Integer.parseInt(ValorTexto);
        }
        Resto = Digito % 11;
        Resultado = String.valueOf(Resto);
        if(Resto == 10){
            Resultado = "X";
        }
        Retorno = Resultado.equals(DigitoVerificador);
        return Retorno;
    }
    
}
