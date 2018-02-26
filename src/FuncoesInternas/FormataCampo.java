package FuncoesInternas;
/*
 @author Tiago e Paulo
 */
public class FormataCampo {
    int    length         = 0;
    int    lengthValor    = 0;
    String valorFormatado = "";
    
    public String FormataCampo(String ValorFormatado, int tamanho, int QTD){
        if(tamanho == 0){
            return "";
        }
        valorFormatado  = ValorFormatado;
        valorFormatado  = valorFormatado.replace(" ", "");
        valorFormatado  = valorFormatado.replace("/", "");
        length          = tamanho - QTD;
        lengthValor     = valorFormatado.length();
        for(int i = lengthValor; i < length; i = valorFormatado.length()){
            valorFormatado = "0" + valorFormatado;
        }
        return valorFormatado;
    }
    
}
