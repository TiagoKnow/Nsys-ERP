package FuncoesInternas;
/*
 @author Paulo
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
public class TabelaZebra extends DefaultTableCellRenderer {
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            Component myself = super.getTableCellRendererComponent(table,value, isSelected, hasFocus, row, column);
            if (isSelected) {
                setBackground(new Color(0  ,0  ,0  ));
                setForeground(new Color(255,255,255));
            }else{
                setForeground(new Color(0  ,0  ,0  ));
                if(row % 2 == 0)
                    setBackground(new Color(225, 225, 225));
                else
                    setBackground(Color.WHITE);
            }
           return myself;
    }
}
