package FuncoesInternas;
/*
 @author Paulo
 */
public class TransformaValorStringeDouble {
    //String's
    String valorRetorno     = "";
    String valorTexto       = "";
    String texto            = "";
    String valorFormatado   = "";
    String cifrao           = "";
    String AddPonto         = "";
    String verificaPonto    = "";
    String verificaVirgula  = "";
    
    //int'd
    String centenaDeTrilhoes    = "";
    String dezenaDeTrilhoes     = "";
    String unidadeDeTrilhoes    = "";
    String centenaDeBilhoes     = "";
    String dezenaDeBilhoes      = "";
    String unidadeDeBilhoes     = "";
    String centenaDeMilhoes     = "";
    String dezenaDeMilhoes      = "";
    String unidadeDeMilhoes     = "";
    String centenaDeMilhar      = "";
    String dezenaDeMilhar       = "";
    String unidadeDeMilhar      = "";
    String centena              = "";
    String dezena               = "";
    String unidade              = "";
    String centenaDecimais      = "";
    String dezenaDecimais       = "";
//    String unidadeDecimais      = "";
    
    //int's
    int addEsquerda     = 0;
    int addDireita      = 0;
    
    //Especiais
    FormataCampo            fc   = new FormataCampo();
    FormataCampoADireita    fcad = new FormataCampoADireita();
    
    public String TransformaValorStringeDouble(String Valor, int tipo){
        String Valor2 = "";
        verificaPonto = "";
        for(int i = 0; i < Valor.length() - 1; i++){
            if(verificaPonto.equals("S")){
                break;
            }
            if(Valor.substring(i, i + 1).equals(".")){
                verificaPonto = "S";
            }
        }
        verificaVirgula = "";
        for(int i = 0; i < Valor.length() - 1; i++){
            if(verificaVirgula.equals("S")){
                break;
            }
            if(Valor.substring(i, i + 1).equals(",")){
                verificaVirgula = "S";
            }
        }
        valorRetorno    = String.valueOf(Valor);
        
        if(tipo == 0){
            Valor2 = Valor .replace("R$ ", "");
            Valor2 = Valor2.replace(".", "");
            Valor2 = Valor2.replace(",", ".");
            if(Double.parseDouble(Valor2) < 1){
                if(verificaPonto.equals("") && verificaVirgula.equals("")){
                    valorRetorno += "00";
                }
            }
        }
        if(valorRetorno.length() > 2){
            if(valorRetorno.substring(valorRetorno.length() - 2, valorRetorno.length() - 1).equals(".")){
                valorRetorno = valorRetorno + "0";
            }
            if(!valorRetorno.substring(0, 2).equals("R$")){
                if(verificaPonto.equals("S")){
                    if(valorRetorno.substring(valorRetorno.lastIndexOf(".") + 1, valorRetorno.length()).length() > 2){
                        if(valorRetorno.substring(0, valorRetorno.lastIndexOf(".") + 2).length() == 1){
                            valorRetorno = valorRetorno.substring(0, valorRetorno.lastIndexOf(",") + 3);
                        }else{
                            valorRetorno = valorRetorno.substring(0, valorRetorno.lastIndexOf(".") + 3);
                        }
                    }
                }
                if(verificaVirgula.equals("S")){
                    if(valorRetorno.substring(valorRetorno.lastIndexOf(",") + 1, valorRetorno.length()).length() > 2){
                        if(valorRetorno.substring(0, valorRetorno.lastIndexOf(",") + 2).length() == 1){
                            valorRetorno = valorRetorno.substring(0, valorRetorno.lastIndexOf(".") + 3);
                        }else{
                            valorRetorno = valorRetorno.substring(0, valorRetorno.lastIndexOf(",") + 3);
                        }
                    }
                }
            }
        }
        valorRetorno    = valorRetorno.replace(" "  , "");
        valorRetorno    = valorRetorno.replace("R$" , "");
        valorRetorno    = valorRetorno.replace("."  , "");
        valorRetorno    = valorRetorno.replace(","  , "");
        texto           = valorRetorno;
        if(valorRetorno.equals("")){
            return "";
        }
        
        valorTexto      = String.valueOf(Valor);
        valorRetorno    = texto;
        valorFormatado  = "";
        if(tipo == 0){
            TransformaParaString();
        }else{
            TransformaParaDouble();
        }
        
        return valorRetorno;
    }
    
    private void TransformaParaString(){
        addEsquerda = 17;
        addDireita  = 0;
        if(valorTexto.length() < 3){
            addDireita  = 2;
            addEsquerda = 15;
        }
        
        valorFormatado     += fc.FormataCampo(valorRetorno, addEsquerda, 0);
        valorFormatado     += fcad.FormataCampoADireita(valorFormatado, addDireita, 0);
        centenaDeTrilhoes   = valorFormatado.substring(0 , 1);
        dezenaDeTrilhoes    = valorFormatado.substring(1 , 2);
        unidadeDeTrilhoes   = valorFormatado.substring(2 , 3);
        centenaDeBilhoes    = valorFormatado.substring(3 , 4);
        dezenaDeBilhoes     = valorFormatado.substring(4 , 5);
        unidadeDeBilhoes    = valorFormatado.substring(5 , 6);
        centenaDeMilhoes    = valorFormatado.substring(6 , 7);
        dezenaDeMilhoes     = valorFormatado.substring(7 , 8);
        unidadeDeMilhoes    = valorFormatado.substring(8 , 9);
        centenaDeMilhar     = valorFormatado.substring(9 ,10);
        dezenaDeMilhar      = valorFormatado.substring(10,11);
        unidadeDeMilhar     = valorFormatado.substring(11,12);
        centena             = valorFormatado.substring(12,13);
        dezena              = valorFormatado.substring(13,14);
        unidade             = valorFormatado.substring(14,15);
        centenaDecimais     = valorFormatado.substring(15,16);
        dezenaDecimais      = valorFormatado.substring(16,17);
        
        AddPonto        = "S";
        cifrao          = "R$ ";
        valorFormatado  = "";
        if(!centenaDeTrilhoes.equals("0")){
            valorFormatado  += centenaDeTrilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centenaDeTrilhoes;
            }
        }
        if(!dezenaDeTrilhoes.equals("0")){
            valorFormatado  += dezenaDeTrilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezenaDeTrilhoes;
            }
        }
        if(!unidadeDeTrilhoes.equals("0")){
            valorFormatado  += unidadeDeTrilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += unidadeDeTrilhoes;
            }
        }
        if(!centenaDeBilhoes.equals("0")){
            valorFormatado  += centenaDeBilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centenaDeBilhoes;
            }
        }
        if(!dezenaDeBilhoes.equals("0")){
            valorFormatado  += dezenaDeBilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezenaDeBilhoes;
            }
        }
        if(!unidadeDeBilhoes.equals("0")){
            valorFormatado  += unidadeDeBilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += unidadeDeBilhoes;
            }
        }
        if(!centenaDeMilhoes.equals("0")){
            valorFormatado  += centenaDeMilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centenaDeMilhoes;
            }
        }
        if(!dezenaDeMilhoes.equals("0")){
            valorFormatado  += dezenaDeMilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezenaDeMilhoes;
            }
        }
        if(!unidadeDeMilhoes.equals("0")){
            valorFormatado  += unidadeDeMilhoes;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += unidadeDeMilhoes;
            }
        }
        if(!centenaDeMilhar.equals("0")){
            valorFormatado  += centenaDeMilhar;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centenaDeMilhar;
            }
        }
        if(!dezenaDeMilhar.equals("0")){
            valorFormatado  += dezenaDeMilhar;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezenaDeMilhar;
            }
        }
        if(!unidadeDeMilhar.equals("0")){
            valorFormatado  += unidadeDeMilhar;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += unidadeDeMilhar;
            }
        }
        if(!centena.equals("0")){
            valorFormatado  += centena;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centena;
            }
        }
        if(!dezena.equals("0")){
            valorFormatado  += dezena;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezena;
            }
        }
        if(!unidade.equals("0")){
            valorFormatado  += unidade;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += unidade;
            }else{
                valorFormatado  += "0";
            }
        }
        AddPonto = "N";
        if(!centenaDecimais.equals("0")){
            valorFormatado  += centenaDecimais;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += centenaDecimais;
            }
        }
        if(!dezenaDecimais.equals("0")){
            valorFormatado  += dezenaDecimais;
        }else{
            if(!valorFormatado.equals("")){
                valorFormatado  += dezenaDecimais;
            }
        }
        
        if(valorFormatado.equals("")){valorFormatado = "000";}
        String ValorFormatado   = valorFormatado.substring(0, valorFormatado.length() - 2);
        String ValorFormatado2  = valorFormatado.substring(valorFormatado.length() - 2, valorFormatado.length());
        valorFormatado = "";
        for(int i = ValorFormatado.length(); i >= 0; i--){
//            System.out.println("i = " + i + "    i % 3 = " + i % 3);
            if(ValorFormatado.length() % 3 == 0){
                if(i == ValorFormatado.length()){
                    continue;
                }
                if(i != 0){
                    if(i % 3 == 0){
                        valorFormatado = "." + ValorFormatado.substring(i, i + 3) + valorFormatado;
                    }
                }
                if(i < 3){
                    valorFormatado = ValorFormatado.substring(i, i + 1) + valorFormatado;
                }
            }
            if(ValorFormatado.length() % 3 == 2){
                if(i == ValorFormatado.length()){
                    continue;
                }
                if(i != 0){
                    if(i % 3 == 2){
                        valorFormatado = "." + ValorFormatado.substring(i, i + 3) + valorFormatado;
                    }
                }
                if(i < 2){
                    valorFormatado = ValorFormatado.substring(i, i + 1) + valorFormatado;
                }
            }
            if(ValorFormatado.length() % 3 == 1){
                if(i == ValorFormatado.length()){
                    continue;
                }
                if(i != 0){
                    if(i % 3 == 1){
                        valorFormatado = "." + ValorFormatado.substring(i, i + 3) + valorFormatado;
                    }
                }
                if(i < 1){
                    valorFormatado = ValorFormatado.substring(i, i + 1) + valorFormatado;
                }
            }
        }
        valorFormatado  = valorFormatado + "," + ValorFormatado2;
        
        valorRetorno = cifrao + valorFormatado;
    }
    
    private void TransformaParaDouble(){
        valorRetorno    = String.valueOf(valorTexto);
        if(valorRetorno.length() > 3){
            if(!valorRetorno.subSequence(valorRetorno.length() - 3, valorRetorno.length() - 2).equals(".")){
                if(!valorRetorno.subSequence(valorRetorno.length() - 2, valorRetorno.length() - 1).equals(".")){
                    valorRetorno    = valorRetorno.replace("."  , "");
                }
            }
        }
        valorRetorno    = valorRetorno.replace(" "  , "");
        valorRetorno    = valorRetorno.replace("R$" , "");
        valorRetorno    = valorRetorno.replace(","  , ".");
    }
    
}
