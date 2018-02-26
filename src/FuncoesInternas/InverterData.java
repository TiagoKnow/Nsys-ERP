package FuncoesInternas;

public class InverterData {
    String DataCompleta     = "";
    String Data             = "";
    String Dia              = "";
    String Mes              = "";
    String Ano              = "";
    
    public String inverterData(String data, int tipo){
        Data = data;
        Data = Data.replace(" ", "");
        Data = Data.replace("-", "");
        Data = Data.replace("/", "");
        if(Data.equals("")){
            return Data;
        }
        if(Data.length() < 8){
            return "";
        }
        if(tipo == 1){
            Ano = Data.substring(0, 4);
            Mes = Data.substring(4, 6);
            Dia = Data.substring(6, 8);

            DataCompleta = Dia + "/" + Mes + "/" + Ano;
            //DataCompleta = "00/00/0000";
        }
        if(tipo == 2){
            Dia = Data.substring(0, 2);
            Mes = Data.substring(2, 4);
            Ano = Data.substring(4, 8);

            DataCompleta = Ano + "-" + Mes + "-" + Dia;
            // DataCompleta = "0000-00-00";
        }
        if(tipo == 3){
            Dia = Data.substring(0, 2);
            Mes = Data.substring(2, 4);
            Ano = Data.substring(4, 8);

            DataCompleta = Mes + "/" + Dia + "/" + Ano;
            // DataCompleta = "00/00/0000";
        } 
        return DataCompleta;
    }
}
