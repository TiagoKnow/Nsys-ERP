package FuncoesInternas;
/*
 @author Paulo
 */
public class FormataCPFCNPJ {
    String valor            = "";
    String retorno          = "";
    String cpfcnpj1         = "";
    String cpfcnpj2         = "";
    String cpfcnpj3        = "";
    String CpfCnpj1         = "";
    String CpfCnpj2         = "";
    String CpfCnpj3         = "";
    
    public String FormataCPFCNPJ(String Valor){
        valor = Valor.replace(" ", "");
        valor = valor.replace(".", "");
        valor = valor.replace("/", "");
        valor = valor.replace("-", "");
        if(Double.parseDouble(valor) == 0){
            valor = "000000000000000";
        }
        if(valor.length() < 11){
            return Valor;
        }
        if(valor.length() < 14){
            FormataCPF();
        }
        if(valor.length()>= 14){
            FormataCNPJ();
        }
        return retorno;
    }

    private void FormataCPF() {
        CpfCnpj1    = valor   .substring(0 , 9);
        cpfcnpj1    = CpfCnpj1.substring(0 , 3);
        cpfcnpj2    = CpfCnpj1.substring(3 , 6);
        cpfcnpj3    = CpfCnpj1.substring(6 , 9);
        CpfCnpj3    = valor   .substring(9 ,11);
        retorno     = cpfcnpj1 + "." + cpfcnpj2 + "." + cpfcnpj3 + "-" + CpfCnpj3;
    }

    private void FormataCNPJ() {
        if(valor.length() > 14){
            valor = valor.substring(1, 15);
        }
        CpfCnpj1    = valor   .substring(0 , 8);
        cpfcnpj1    = CpfCnpj1.substring(0 , 2);
        cpfcnpj2    = CpfCnpj1.substring(2 , 5);
        cpfcnpj3    = CpfCnpj1.substring(5 , 8);
        CpfCnpj2    = valor   .substring(8 ,12);
        CpfCnpj3    = valor   .substring(12,14);
        retorno     = cpfcnpj1 + "." + cpfcnpj2 + "." + cpfcnpj3 + "/" + CpfCnpj2 + "-" + CpfCnpj3;
    }
}
