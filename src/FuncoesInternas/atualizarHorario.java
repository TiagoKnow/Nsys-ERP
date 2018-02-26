/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FuncoesInternas;

/**
 *
 * @author Tiago
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
/**
 *
 * @author Tiago e Paulo
 */
public class atualizarHorario extends Thread {

    private JLabel hr;
    private boolean mostrarData;

    public atualizarHorario(JLabel hora) {
        this.hr = hora;
    }

    public void mostrarData(boolean mostrar) {
        if (mostrar) {
            this.mostrarData = true;
        } else {
            this.mostrarData = false;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Date d = new Date();
                StringBuffer data = new StringBuffer();
                if (mostrarData) {
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
                    data.append(sdfData.format(d));
                    data.append(" - ");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                this.hr.setText(data.toString() + sdf.format(d));
                Thread.sleep(1000);
                this.hr.revalidate();
            }
        } catch (InterruptedException ex) {
            System.out.println("Problema na atualização da data/hora");
            ex.printStackTrace();
        }
    }
}
