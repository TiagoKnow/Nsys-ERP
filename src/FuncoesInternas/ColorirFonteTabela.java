package FuncoesInternas;

import java.awt.*;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 @author Tiago e Paulo
 */
public class ColorirFonteTabela extends JLabel implements TableCellRenderer {
    //int's
    int    numeroDaColuna   = 0;
    
    //String's
    String status           = "";
    
    public ColorirFonteTabela(int NumeroDaColuna){
        setOpaque(true);
        numeroDaColuna = NumeroDaColuna;
    }
        
        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column){
        status = ((String) table.getModel().getValueAt(row, numeroDaColuna));
        
        switch(status){
            case "TOTAIS DA GRUPO"      :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DA EMPRESA"    :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DA CLASSE"     :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DO GRUPO"      :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DO SUBGRUPO"   :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DA CONTA"      :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            case "TOTAIS DA SUBCONTA"   :   setFont(new java.awt.Font("Tahoma", 1, 11));    break;
            default:                        setFont(new java.awt.Font("Tahoma", 0, 11));
        }
        
        if(value != null){
            setText(value.toString());
        }else{
            setText("");
        }
        
        return this;
    }
}
