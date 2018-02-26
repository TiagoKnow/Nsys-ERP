package FuncoesInternas;

import Parametros.parametrosNS;

/*
 @author Tiago e Paulo
 */
public class FormataCampoCpfCnpj {
    String CpfCnpj              = "";
    String cpfcnpj1             = "";
    String cpfcnpj2             = "";
    String cpfcnpj3             = "";
    
    FormataCampo fc = new FormataCampo();
    
    public String FormataCampoCpfCnpj(String cpfCnpj){
        if(cpfCnpj.equals("")){
            cpfCnpj = parametrosNS.fc.FormataCampo("", 15, 0);
        }
        CpfCnpj = cpfCnpj;
        if(Double.parseDouble(CpfCnpj) == 0){
            return CpfCnpj;
        }
        if(CpfCnpj.length() < 14){
            FormataCpf();
        }
        if(CpfCnpj.length() == 14){
            CpfCnpj = fc.FormataCampo(CpfCnpj, 15, 0);
        }
        return CpfCnpj;
    }
    
    public void FormataCpf(){
        cpfcnpj1 = CpfCnpj.substring(0, 9);
        cpfcnpj2 = "    ";
        cpfcnpj3 = CpfCnpj.substring(9,11);
        CpfCnpj  = cpfcnpj1 + cpfcnpj2 + cpfcnpj3;
    }
    
}
