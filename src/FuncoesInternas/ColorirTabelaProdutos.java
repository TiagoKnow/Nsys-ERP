package FuncoesInternas;

import java.awt.*;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 @author Tiago e Paulo
 */
public class ColorirTabelaProdutos extends JLabel implements TableCellRenderer {
    //int's
    int    numeroDaColuna   = 0;
    
    //String's
    String status           = "";
    
    public ColorirTabelaProdutos(int NumeroDaColuna){
        setOpaque(true);
        numeroDaColuna = NumeroDaColuna;
    }
        
        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column){
        status = ((String) table.getModel().getValueAt(row, numeroDaColuna));
        
        if(status.equals("À venda")){
            setBackground(new Color(51,255,51));// VERDE
        }else if(status.equals("Bloqueado")){
            setBackground(new Color(255,51,51));// VERMELHO
        }
        
        if(!value.toString().equals("")){
            setText(value.toString());
        }else{
            setText("");
        }
        
        return this;
    }
}
