package FuncoesInternas;
/*
 @author Tiago e Paulo 02/10/2017 13:36
 */
public class FormataPorcentagem {
    //String
    String valorTexto   = "";
    
    public String FormataPorcentagem(double ValorPorcentagem){
        valorTexto = String.valueOf(ValorPorcentagem);
        if(valorTexto.length() > 6){
            if(valorTexto.substring(1, 2).equals(".")){
                valorTexto = valorTexto.substring(0, 4);
            }
            if(valorTexto.substring(2, 3).equals(".")){
                valorTexto = valorTexto.substring(0, 5);
            }
        }
        valorTexto = valorTexto + "%";
        return valorTexto;
    }
    
}
