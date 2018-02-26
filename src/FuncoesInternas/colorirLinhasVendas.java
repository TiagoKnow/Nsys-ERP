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

public class colorirLinhasVendas  extends JLabel implements TableCellRenderer{
    String status  = "";
    int Numero     = 0;
        
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column){
        column = Numero;
        status = ((String) table.getModel().getValueAt(row, column));
        
        if(isSelected)
            setBackground(new Color(142,193,247));
        else{
            if(status.equals("ABERTA"))
                setBackground(new Color(255,153,51));// LARANJA
            else if(status.equals("LIQUIDADA"))
                setBackground(new Color(153,255,153));// VERDE
            else if(status.equals("CANCELADA"))
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
