package FuncoesInternas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 @author Paulo e Tiago
 */
public class CapturarDataHora {
    DateFormat dataFormat, hourformat;
    Date data1, hr;
    String date, hour;
    public int      DataAtual   = 0;
    
    public String CapturarData(){
        dataFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        data1 = new Date();
        date = String.valueOf(dataFormat.format(data1));
        return date;
    }
    
    public String CapturaHora(){
        hourformat = new SimpleDateFormat("HH:mm:ss");
        hr = new Date();
        hour = String.valueOf(hourformat.format(hr));
        return hour;
    }
}
