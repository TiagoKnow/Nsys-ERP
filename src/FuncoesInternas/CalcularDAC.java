package FuncoesInternas;
/*
 @author Tiago e Paulo 04/08/2016 19:12
 */
public class CalcularDAC {
    String Agencia              = "";
    String Conta                = "";
    String Carteira             = "";
    String NossoNumero          = "";
    String Dac                  = "";
    String Valor                = "";
    int    Soma                 = 0;
    int    SomaParcial          = 0;
    int    ValorM               = 0;
    int    RestoCalculo         = 0;
    int    ValorDAC             = 0;
    String ValorDAC1            = "";
    
    public String CalculaNossoNumeroBradesco(String nossoNumero){
        Soma        = 0;
        SomaParcial = 0;
        NossoNumero = nossoNumero;
        ValorM      = 2;
        for(int i = 0; i < NossoNumero.length(); i++){
            if(ValorM < 2)ValorM = 7;
            SomaParcial = Integer.parseInt(NossoNumero.substring(i, i + 1));
            
            Soma   += SomaParcial * ValorM;
            ValorM--;
        }
        RestoCalculo    = Soma % 11;
        ValorDAC        = 11 - RestoCalculo;
        
        ValorDAC1       = String.valueOf(ValorDAC);
        
        if(ValorDAC == 10)ValorDAC1 = "P";
        if(ValorDAC == 11)ValorDAC1 = "0";
        
        return ValorDAC1;
    }
    
    public int CalculaNossoNumeroSantander(String nossoNumero){
        Soma        = 0;
        SomaParcial = 0;
        NossoNumero = nossoNumero;
        ValorM      = 2;
        for(int i = NossoNumero.length(); i > 0; i--){
            if(ValorM > 9)ValorM = 2;
            SomaParcial = Integer.parseInt(NossoNumero.substring(i - 1, i));
            
            Soma   += SomaParcial * ValorM;
            ValorM++;
        }
        RestoCalculo    = Soma % 11;
        
        if(RestoCalculo == 10)ValorDAC = 1;
        if(RestoCalculo >= 0 && RestoCalculo < 2)ValorDAC = 0;
        if(RestoCalculo != 0 && RestoCalculo != 1 && RestoCalculo != 10)ValorDAC    = 11 - RestoCalculo;
        
        return ValorDAC;
    }
    
    public int CalcularDAC(String agencia, String conta, String carteira, String nossoNumero){
        Soma        = 0;
        SomaParcial = 0;
        Agencia     = agencia;
        Conta       = conta;
        Carteira    = carteira;
        NossoNumero = nossoNumero;
        Valor   = Agencia + Conta + Carteira + NossoNumero;
        for(int i = 0; i < 20; i++){
            SomaParcial = Integer.parseInt(Valor.substring(i, i + 1));
            if(i % 2 == 0){
                ValorM = 1;
            }else{
                ValorM = 2;
            }
            SomaParcial = SomaParcial * ValorM;
            if(SomaParcial > 9)SomaParcial = Integer.parseInt(String.valueOf(SomaParcial).substring(0, 1)) + Integer.parseInt(String.valueOf(SomaParcial).substring(1, 2));
            Soma += SomaParcial;
        }
        
        RestoCalculo    = Soma % 10;
        ValorDAC        = 10 - RestoCalculo;
        
        if(ValorDAC == 10){
            ValorDAC = 0;
        }
        
        return ValorDAC;
    }
    
    public String CalcularDACCampo1(String valor){
        Soma        = 0;
        SomaParcial = 0;
        Valor   = valor.replace(".", "");
        for(int i = 0; i < 9; i++){
            SomaParcial = Integer.parseInt(Valor.substring(i, i + 1));
            if(i % 2 == 0){
                ValorM = 2;
            }else{
                ValorM = 1;
            }
            SomaParcial = SomaParcial * ValorM;
            if(SomaParcial > 9)SomaParcial = Integer.parseInt(String.valueOf(SomaParcial).substring(0, 1)) + Integer.parseInt(String.valueOf(SomaParcial).substring(1, 2));
            Soma += SomaParcial;
        }
        
        RestoCalculo    = Soma % 10;
        ValorDAC        = 10 - RestoCalculo;
        
        if(ValorDAC == 10){
            ValorDAC = 0;
        }
        
        return String.valueOf(ValorDAC);
    }
    
    public String CalcularDACCampo2e3(String valor){
        Soma        = 0;
        SomaParcial = 0;
        Valor       = valor.replace(".", "");
        for(int i = 0; i < 10; i++){
            SomaParcial = Integer.parseInt(Valor.substring(i, i + 1));
            if(i % 2 == 0){
                ValorM = 1;
            }else{
                ValorM = 2;
            }
            SomaParcial = SomaParcial * ValorM;
            if(SomaParcial > 9)SomaParcial = Integer.parseInt(String.valueOf(SomaParcial).substring(0, 1)) + Integer.parseInt(String.valueOf(SomaParcial).substring(1, 2));
            Soma += SomaParcial;
        }
        
        RestoCalculo    = Soma % 10;
        ValorDAC        = 10 - RestoCalculo;
        
        if(ValorDAC == 10){
            ValorDAC = 0;
        }
        
        return String.valueOf(ValorDAC);
    }
    
    public String CalcularDACCodigoDeBarras(String valor){
        Soma        = 0;
        SomaParcial = 0;
        Valor       = valor;
        int     j   = 4;
        for(int i = 0; i < 43; i++){
            SomaParcial = Integer.parseInt(Valor.substring(i, i + 1));
            SomaParcial = SomaParcial * j;
//            System.out.println("Var_" + i + " substring: " + i + " * " + j);
            j--;
            if(j == 1)j = 9;
            Soma += SomaParcial;
        }
        
        RestoCalculo    = Soma % 11;
        ValorDAC        = 11 - RestoCalculo;
        
        if(ValorDAC < 1 || ValorDAC > 9)
            ValorDAC = 1;
        
        return String.valueOf(ValorDAC);
    }
    
}
