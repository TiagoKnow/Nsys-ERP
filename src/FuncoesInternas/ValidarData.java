package FuncoesInternas;

import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class ValidarData{
    String  Bissexto        = "N";
    String  Dia, Mes, Ano   = "";
    int     dia, mes, ano   = 0;
    String  Mensagem        = "";
    String  Fatal           = "N";
    String  Resultado       = "N";
    
    int DiaValido = 0;
    
    public String ValidaData(String Data){  //A data tem que ser no formato dd/MM/yyyy
        Fatal = "N";
        Bissexto = "N";
        Data = Data.replace("/", "");
        Data = Data.replace("-", "");
        Data = Data.replace(" ", "");
        
        if(Data.length() < 8){
            return Resultado;
        }
        if(Data.equals("")){
            return Resultado;
        }
        
        Dia = Data.substring(0,  2);
        Mes = Data.substring(2,  4);
        Ano = Data.substring(4,  8);
        
        dia = Integer.parseInt(Dia);
        mes = Integer.parseInt(Mes);
        ano = Integer.parseInt(Ano);
        
        VerificaData();
        
        return Resultado;
    }
    
    private void VerificaData (){
        VerificarAno();
        if(Fatal.equals("S")){return;}
        VerificarMes();
        if(Fatal.equals("S")){return;}
        VerificarDia();
        if(Fatal.equals("S")){return;}
        Resultado = "S";
    }
    
    private void VerificarAno(){
        if(ano % 4 != 0){  //Ano Bissexto
            return;
        }
        Bissexto = "S";
    }
    
    private void VerificarMes(){
        if(mes < 1 || mes > 12){
            Fatal = "S";
//            Mensagem = "Mês inválido!!!";
//            new MostraMensagem(Mensagem);
            return;
        }
        if(mes == 2){
            DiaValido = 28;
            if(Bissexto.equals("S")){
                DiaValido = 29;
            }
            return;
        }
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11){// Meses que possuem 30 dias
            DiaValido = 30;
            return;
        }
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            DiaValido = 31;
        }
    }
    
    private void VerificarDia(){
        if(dia < 1 || dia > DiaValido){
            Fatal = "S";
//            Mensagem = "Dia Inválido!!!";
//            new MostraMensagem(Mensagem);
        }
    }
    
}