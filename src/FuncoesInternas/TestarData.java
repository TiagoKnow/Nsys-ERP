package FuncoesInternas;
/*
 @author Paulo e Tiago
 */
public class TestarData {
    String Data = "";
    String Retira = "";
    String DataInv = "";
    
    String Ano = "";
    String Mes = "";
    String Dia = "";
    int    DataInvertida = 0;
    
    public int Testa(String data){
        Data = data;
        Data = Data.replace("-", "");
        Data = Data.replace("/", "");
        if(Data.equals("")){
            return DataInvertida;
        }
        
        Retira = Data.replace("/", "");
        Retira = Retira.replace("-", "");
        
        if(Retira.length() >= 8){
            Dia = Retira.substring(0, 2);
            Mes = Retira.substring(2, 4);
            Ano = Retira.substring(4, 8);
        }else{
            Mes = Retira.substring(0, 2);
            Ano = Retira.substring(2, 6);
        }
        
        DataInv = Ano + Mes + Dia;
        DataInvertida = Integer.parseInt(DataInv);
        
        return DataInvertida;
    }
    
}