package FuncoesInternas;

/**
 * @author Tiago
 */
public class converterCampoFormatadoDouble {
    
    public String converter(String valor){
        String formatoDouble = valor;
        //formatoDouble = formatoDouble.replace(".", "");
        formatoDouble = formatoDouble.replace(",", ".");
        formatoDouble = formatoDouble.replace("R$ ", "");
        formatoDouble = formatoDouble.replace("R$", "");
        valor = String.valueOf(formatoDouble);
        return valor;
    }
}
