package FuncoesInternas;
/*
 @author Tiago e Paulo 08/08/2016 21:21
 */
public class FormataCampoComEspacos {
    int    length         = 0;
    int    lengthValor    = 0;
    String valorFormatado = "";
    
    public String FormatarCampoComEspacos(String valor, int Tamanho, int QTD){
        valorFormatado = valor;
        length = Tamanho - QTD;
        lengthValor = valorFormatado.length();
        if(lengthValor >= Tamanho){
            valorFormatado = valorFormatado.substring(0, Tamanho);
            return valorFormatado;
        }
        for(int i = 0; i < length; i = valorFormatado.length()){
            valorFormatado = valorFormatado + " ";
        }
        return valorFormatado;
    }
    
}
