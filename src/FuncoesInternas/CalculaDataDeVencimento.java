package FuncoesInternas;

import java.util.Calendar;
import java.util.Date;

/*
 @author Tiago e Paulo 05/08/2016 19:26
 */
public class CalculaDataDeVencimento {
    String dataCompleta         = "";
        String dia              = "";
        String mes              = "";
        String ano              = "";
        
    String data                 = "";
        int    Dia              = 0;
        int    Mes              = 0;
        int    Ano              = 0;
    
    Calendar    cal             = Calendar.getInstance();
    ValidarData valData         = new ValidarData();
    
    int    diasUteis            = 0;
    public String CalculaDataDeVencimento(String Data, int qtdMeses, int DiasUteis){
        data            = Data; //Tem q ser no Formato Americano yyyy/MM/dd
        data            = data.replace("/", "");
        data            = data.replace("-", "");
        diasUteis       = DiasUteis;
        
        Ano             = Integer.parseInt(data.substring(0, 4));
        Mes             = Integer.parseInt(data.substring(4, 6));
        Dia             = Integer.parseInt(data.substring(6, 8));
        
        Ano += Integer.parseInt(String.valueOf((Mes + qtdMeses) / 12).substring(0, 1));
        
        Mes = (Mes + qtdMeses) % 12;
        if(Mes == 0){
            Mes     = 12;
            Ano     = Ano - 1;
        }
        
        if(Ano % 4 == 0)
            if(Mes == 2)
                if(Dia > 29){
                    Mes = 3;
                    Dia = 1;
                }
        if(Ano % 4 != 0)
            if(Mes == 2)
                if(Dia > 28){
                    Mes = 3;
                    Dia = 1;
                }
        
        VerificaDiaSemana();
        if(Dia > 31){
            Dia = 1;
            Mes = Mes + 1;
        }
        VerificaDiaSemana();
        
//        if(valData.ValidaData(dataCompleta).equals("N"))
//            dataCompleta = CalculaDataDeVencimento(dataCompleta, qtdMeses, DiasUteis);
        
        return dataCompleta;
    }
    
    private void CompletaData(){
        ano             = String.valueOf(Ano);
        mes             = String.valueOf(Mes);
        dia             = String.valueOf(Dia);
        
        if(mes.length() == 1)
            mes = "0" + mes;
        if(dia.length() == 1)
            dia = "0" + dia;
        
        dataCompleta    = ano + "-" + mes + "-" + dia;
    }
    
    private void VerificaDiaSemana(){
        CompletaData();
        if(diasUteis == 0)return;
        cal.setTime(new Date(dataCompleta.replace("-", "/")));
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            Dia += 2;
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
            Dia += 1;
        CompletaData();
    }
    
}
