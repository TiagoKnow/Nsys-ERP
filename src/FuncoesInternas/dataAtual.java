
package FuncoesInternas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Tiago 13-06-2016 as 13-36
 */
public class dataAtual {
    
    //Funções
    SimpleDateFormat sdfDiaBRA = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfDiaUS  = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat sdfDiaItau = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat sdf       = new SimpleDateFormat("HH:mm:ss");
    
    //String
    String dataAtual = "";
    String horaAtual = "";
    
    public String pegarDataAtualBRA(){
        try{
            dataAtual = sdfDiaBRA.format(new Date());  // data do sistema
            return dataAtual;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi ao pegar a data Atual: " + e);
            return null;
        }
    }
    public String pegarDataAtualUS(){
        try{
            dataAtual = sdfDiaUS.format(new Date());  // data do sistema
            return dataAtual;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi ao pegar a data Atual: " + e);
            return null;
        }
    }
    
    public String pegarDataAtualItau(){
        try{
            dataAtual = sdfDiaUS.format(new Date());  // data do sistema
            return dataAtual;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O erro foi ao pegar a data Atual: " + e);
            return null;
        }
    }
    
    public String pegarHoraAtual(){
        Date hora = Calendar.getInstance().getTime(); 
        String horaAtual = sdf.format(hora);
        return horaAtual;
    }
}
