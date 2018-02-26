package FuncoesInternas;
/*
 @author Tiago e Paulo
 */
public class ConverteValorDigitadoEmDouble {
    String formatoDouble    = "";
    String tiraPonto        = "";
    double valor            = 0;
    
    public double ConverteValorDigitadoEmDouble(String FormatoDouble, String TiraPonto){
        try{
            formatoDouble   = FormatoDouble;
            if(formatoDouble.equals(""))
                return 0;
            tiraPonto       = TiraPonto;
            if(tiraPonto.equals("S"))
                formatoDouble = formatoDouble.replace(".", "");
            formatoDouble = formatoDouble.replace(",", ".");
            formatoDouble = formatoDouble.replace("R$ ", "");
            formatoDouble = formatoDouble.replace("R$", "");
            valor = Double.parseDouble(formatoDouble);
        }catch(Exception erro){
            ConverteValorDigitadoEmDouble(FormatoDouble, "S");
        }
        return valor;
    }
    
}
