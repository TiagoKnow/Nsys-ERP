package FuncoesInternas;
/*
 @author Tiago e Paulo
 */
public class FormataCampoADireita {
    int    length         = 0;
    int    lengthValor    = 0;
    String valorFormatado = "";
    
    public String FormataCampoADireita(String ValorFormatado, int tamanho, int QTD){
        if(tamanho == 0)
            return "";
        valorFormatado  = ValorFormatado;
        valorFormatado  = valorFormatado.replace(" ", "");
        valorFormatado  = valorFormatado.replace("/", "");
        length          = tamanho - QTD;
        lengthValor     = valorFormatado.length();
        for(int i = lengthValor; i < length; i = valorFormatado.length()){
            valorFormatado = valorFormatado + "0";
        }
        return valorFormatado;
    }
    
}
