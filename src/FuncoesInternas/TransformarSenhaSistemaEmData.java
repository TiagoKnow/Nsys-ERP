package FuncoesInternas;

import FuncoesInternas.Criptografia;
import FuncoesInternas.TestarData;
import FuncoesInternas.CapturarDataHora;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class TransformarSenhaSistemaEmData {
    //String's
    String DataAtual                 = "";
    String DataDeValidacao           = "";
    String Mensagem                  = "";
    String sql                       = "";
    String SqlState                  = "";
    String SenhaTotal                = "";
    String SenhaDescriptografada     = "";
    String Fatal                     = "N";
    
    //Telas
    CapturarDataHora cdh = new CapturarDataHora();
    TestarData Test      = new TestarData();
    Criptografia crpt    = new Criptografia();
    
    //int's
    long   SenhaSistema              = 0;
    int    Valor1                    = 0;
    int    Valor2                    = 0;
    int    Valor3                    = 0;
    int    Valor4                    = 0;
    int    Valor5                    = 0;
    int    Valor6                    = 0;
    int    Valor7                    = 0;
    int    Valor8                    = 0;
    int    Valor9                    = 0;
    int    Senha1                    = 0;
    int    Senha2                    = 0;
    int    Senha3                    = 0;
    
    int    DataHoje                  = 0;
    long   Data                      = 0;
    int    SomaCalculo               = 0;
    int    Digito1                   = 0;
    int    Digito2                   = 0;
    int    Digito3                   = 0;
    
    public Long TransformarSenhaSistemaEmData(String DataValor){
        if(DataValor.equals("")){
            return Data;
        }
        SenhaDescriptografada = crpt.Criptografa(DataValor, "Descriptografar");
        CalculaValidacao();
        if(Fatal.equals("S")){
            Data = 0;
        }
        return Data;
    }
    
    public void CalculaValidacao(){
        Fatal = "N";
        SenhaTotal = SenhaDescriptografada;
        if(SenhaTotal.equals("")){
            Mensagem = "Senha em Branco!!!";
            new MostraMensagem(Mensagem);
            Fatal = "S";
            return;
        }
        SenhaSistema = Long.valueOf(SenhaTotal.substring(0, 9));
        DataDeValidacao = String.valueOf(SenhaSistema);
        Valor1 = Integer.parseInt(SenhaTotal.substring(0 ,  1));
        Valor2 = Integer.parseInt(SenhaTotal.substring(1 ,  2));
        Valor3 = Integer.parseInt(SenhaTotal.substring(2 ,  3));
        Valor4 = Integer.parseInt(SenhaTotal.substring(3 ,  4));
        Valor5 = Integer.parseInt(SenhaTotal.substring(4 ,  5));
        Valor6 = Integer.parseInt(SenhaTotal.substring(5 ,  6));
        Valor7 = Integer.parseInt(SenhaTotal.substring(6 ,  7));
        Valor8 = Integer.parseInt(SenhaTotal.substring(7 ,  8));
        Valor9 = Integer.parseInt(SenhaTotal.substring(8 ,  9));
        Senha1 = Integer.parseInt(SenhaTotal.substring(9 , 10));
        Senha2 = Integer.parseInt(SenhaTotal.substring(10, 11));
        Senha3 = Integer.parseInt(SenhaTotal.substring(11, 12));
        
        PegaDigito1();
        PegaDigito2();
        PegaDigito3();
        VerificaDigitos();
    }
    
    public void PegaDigito1(){
        SomaCalculo = 0;
        SomaCalculo = SomaCalculo + ((Valor1 * 1) + (Valor2 * 2));
        SomaCalculo = SomaCalculo + ((Valor3 * 3) + (Valor4 * 4));
        SomaCalculo = SomaCalculo + ((Valor5 * 5) + (Valor6 * 6));
        SomaCalculo = SomaCalculo + ((Valor7 * 7) + (Valor8 * 8));
        SomaCalculo = SomaCalculo +  (Valor9 * 9);
        Digito1 = Integer.parseInt(String.valueOf(SomaCalculo).substring(String.valueOf(SomaCalculo).length() - 1, String.valueOf(SomaCalculo).length()));
    }
    
    public void PegaDigito2(){
        SomaCalculo = 0;
        SomaCalculo = SomaCalculo + ((Valor1 * 9) + (Valor2 * 8));
        SomaCalculo = SomaCalculo + ((Valor3 * 7) + (Valor4 * 6));
        SomaCalculo = SomaCalculo + ((Valor5 * 5) + (Valor6 * 4));
        SomaCalculo = SomaCalculo + ((Valor7 * 3) + (Valor8 * 2));
        SomaCalculo = SomaCalculo +  (Valor9 * 1);
        Digito2 = Integer.parseInt(String.valueOf(SomaCalculo).substring(String.valueOf(SomaCalculo).length() - 1, String.valueOf(SomaCalculo).length()));
    }
    
    public void PegaDigito3(){
        SomaCalculo = 0;
        SomaCalculo = SomaCalculo + ((Valor1 * 1) + (Valor2 * 5));
        SomaCalculo = SomaCalculo + ((Valor3 * 2) + (Valor4 * 6));
        SomaCalculo = SomaCalculo + ((Valor5 * 3) + (Valor6 * 7));
        SomaCalculo = SomaCalculo + ((Valor7 * 4) + (Valor8 * 8));
        SomaCalculo = SomaCalculo +  (Valor9 * 9);
        Digito3 = Integer.parseInt(String.valueOf(SomaCalculo).substring(String.valueOf(SomaCalculo).length() - 1, String.valueOf(SomaCalculo).length()));
    }
    
    public void VerificaDigitos(){
        Fatal = "N";
        if(Digito1 != Senha1){Mensagem = "Senha Inválida!!!";Fatal = "S";new MostraMensagem(Mensagem);return;}
        if(Digito2 != Senha2){Mensagem = "Senha Inválida!!!";Fatal = "S";new MostraMensagem(Mensagem);return;}
        if(Digito3 != Senha3){Mensagem = "Senha Inválida!!!";Fatal = "S";new MostraMensagem(Mensagem);return;}
        
        Data = SenhaSistema / 9;
        
//        if(DataHoje > Data){
//            Mensagem = "Senha expirada!!!";
//            new MostraMensagem(Mensagem);
//            Fatal = "S";
////            return;
//        }
    }
    
}
