package FuncoesInternas;

public class ValidarCpfCnpj {
        int     Digito1                 = 0;
        int     Digito2                 = 0;
        int     Resto                   = 0;
        String  DigitosVerificadores    = "";
        String  Resultado               = "";
        String  Valor                   = "";
        boolean Retorno;
        public boolean VALIDARCPFCNPJ(String valor){
            Resultado = "";
            if(valor.replace(" ", "").equals("")){
                return false;
            }
            if(valor.length() < 11){
                return false;
            }
            if(Double.parseDouble(valor) == 0){
                return false;
            }
            DigitosVerificadores = valor.substring((valor.length() - 2), valor.length());
            if(valor.length() == 11) {//CPF
                Digito1 = 0;
                Digito2 = 0;
                Resultado = "";
                for(int i = 1; i < (valor.length() - 1); i++) {
//                    System.out.print(valor.substring((i - 1), i));
                    Valor = valor.substring((i - 1), i);
                    Digito1 += (11 - i) * Integer.valueOf(Valor);
                }
                for(int i = 1; i < valor.length(); i++) {
//                    System.out.print(valor.substring((i - 1), i));
                    Valor = valor.substring((i - 1), i);
                    Digito2 += (12 - i) * Integer.valueOf(Valor);
                }
                Resto = Digito1 % 11;
                if(Resto < 2){
                    Resultado = "0";
                }else{
                    Resultado = String.valueOf(11 - Resto);
                }
                Resto = Digito2 % 11;
                if(Resto < 2){
                    Resultado = Resultado + "0";
                }else{
                    Resultado = Resultado + String.valueOf(11 - Resto);
                }
                Retorno = Resultado.equals(DigitosVerificadores);
            }
            if(valor.length() >= 14){ //CNPJ
                if(valor.length() > 14){
                    valor = valor.substring(1, 15);
                }
                Digito1 = 0;
                Digito2 = 0;
                Resultado = "";
                for(int i = 1; i < 5; i++) {
//                    System.out.print(valor.substring(i, i + 1));
                    Valor = valor.substring((i - 1), i);
                    Digito1 += (i + 5) * Integer.parseInt(Valor);
                }
                for(int i = 5; i < 13; i++) {
//                    System.out.print(valor.substring(i, i + 1));
                    Valor = valor.substring((i - 1), i);
                    Digito1 += (i - 3) * Integer.parseInt(Valor);
                }
                Resto = Digito1 % 11;
                if(Resto > 9){
                    Resultado = "0";
                }else{
                    Resultado = String.valueOf(Resto);
                }
                for(int i = 1; i < 6; i++) {
//                    System.out.print(valor.substring(i, i + 1));
                    Valor = valor.substring((i - 1), i);
                    Digito2 += (i + 4) * Integer.parseInt(Valor);
                }
                for(int i = 6; i < 14; i++) {
//                    System.out.print(valor.substring(i, i + 1));
                    Valor = valor.substring((i - 1), i);
                    Digito2 += (i - 4) * Integer.parseInt(Valor);
                }
                Resto = Digito2 % 11;
                if(Resto > 9){
                    Resultado = Resultado + "0";
                }else{
                    Resultado = Resultado + String.valueOf(Resto);
                }
                Retorno = Resultado.equals(DigitosVerificadores);
            }
            return Retorno;
    }
}