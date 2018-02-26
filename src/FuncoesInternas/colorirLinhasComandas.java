package FuncoesInternas;
/*
 @author Paulo e Tiago
 */


import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class colorirLinhasComandas  extends JLabel implements TableCellRenderer{
    String STATUS  = "";
    int Numero     = 0;
    
    public colorirLinhasComandas(int numeroDaColuna){
        setOpaque(true);
        Numero = numeroDaColuna;
    }
        
        @Override
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column){
        STATUS = ((String) table.getModel().getValueAt(row, Numero));
        
        if(STATUS.equals("FECHADA")){
            setBackground(new Color(153,255,153));// VERDE
        }else if(STATUS.equals("EM USO")){
            setBackground(new Color(255,51,51));// VERMELHO
        }

        setForeground(Color.black);
        
        setText(value.toString());
        
        return this;
    }

    public void validate() {}

    public void revalidate() {}

    protected void firePropertyChange(String propertyName,Object oldValue, Object newValue) {}

    public void firePropertyChange(String propertyName,boolean oldValue, boolean newValue) {}
}
