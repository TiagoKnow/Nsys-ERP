package FuncoesInternas;

import java.util.Vector;
import javax.swing.JOptionPane;


public class ajustarData {

    /**
      * Ajusta a data para determinada finalidade, como a seguir:<br>
      * o tipo 1 converte do padrão sql para o padrão que utilizamos;<br>
      * o tipo 2 converte do padrão que utilizamos para o padrão sql.<br>
      * o tipo 3 converte do padrao que utilizamos para o padrão que o access utiliza
      * @author            Leonardo Loures
      */
    public String inverterData(String d, int tipo){
        //o tipo 1 converte do padrão sql para o padrão que utilizamos;
        //o tipo 2 converte do padrão que utilizamos para o padrão sql.
        //o tipo 3 converte do padrao que utilizamos para o padrão que o access utiliza
        try{
            String data = null;
            
            //if(d.isEmpty() == false){
                //passa do formato YYYY/MM/DD para o formato DD/MM/YYYY,
                //ou seja do      padrão mysql        para   o que utilizamos
                if(tipo == 1){
                    String dia, mes, ano = null;
                    data = d;

                    ano = d.substring(0, 4);
                    mes = d.substring(5, 7);
                    dia = d.substring(8, 10);

                    data = dia + "/" + mes + "/" + ano;
                }

                //passa do formato DD/MM/YYYY para o formato YYYY/MM/DD,
                //ou seja do      o que utilizamos    ara   padrão mysql

                if(tipo == 2){
                    String dia, mes, ano = null;

                    dia = d.substring(0, 2);
                    mes = d.substring(3,5);
                    ano = d.substring(6, 10);

                    data = ano + "/" + mes + "/" + dia;
                }

                if(tipo == 3){
                    String dia, mes, ano = null;

                    dia = d.substring(0, 2);
                    mes = d.substring(3,5);
                    ano = d.substring(6, 10);

                    data = mes + "/" + dia + "/" + ano;
                }
            //}else{
            //    data = "0000/00/00";
            //}

            return data;
            
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Erro ao ajustar Data: " + e.getMessage());
            return "-----";
        }
        
    }
    
    /**
     * O Marcinho que fez
     * @param d
     * @return 
     */
    public Vector devolverDiaMesAno(String d){
        Vector data = new Vector();
        try{
            String dia, mes, ano = null;

            dia = d.substring(0, 2);
            mes = d.substring(3,5);
            ano = d.substring(6, 10);
            
            data.add(dia);
            data.add(mes);
            data.add(ano);

            return data;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "O erro foi ao devolver dia mes e ano");
            return null;
        }
    }
}
