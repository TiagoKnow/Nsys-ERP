package TelasContasCorrente;

import FuncoesInternas.CalcularDAC;
import javax.swing.JOptionPane;

/**
 * @author Paulo
 */
  
public class TestaCodigoDeBarras {
    
    public static void main(String args []){
        String Cod  = JOptionPane.showInputDialog("Codigo de Barras: ");
        String i = new CalcularDAC().CalcularDACCodigoDeBarras(Cod);
        System.out.println(i);
    }
}
