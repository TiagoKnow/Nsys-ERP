package FuncoesInternas;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/*
 @author Paulo
 */
public class AjustarLarguraColunas {
    //Especiais
    TableColumnModel  modeloColuna  = null;
    TableCellRenderer tableRenderer = null;
    Component         component     = null;
    
    //int
    int linha   = 0;
    int coluna  = 0;
    int tamanho = 0;
    
    public AjustarLarguraColunas(JTable jTable){
        modeloColuna = jTable.getColumnModel();
//        for(coluna = 0; coluna < jTable.getColumnCount(); coluna++) {
//            tableRenderer = jTable.getColumnName(linha)
//            jTable.getColumnModel().getColumn(coluna).getHeaderValue();
//            jTable.getTableHeader().resizeAndRepaint();
//        }
        for(coluna = 0; coluna < jTable.getColumnCount(); coluna++) {
            tamanho = 75; // Min Width
            for (linha = 0; linha < jTable.getRowCount(); linha++) {
                tableRenderer = jTable.getCellRenderer(linha, coluna);
//                System.out.println("TableRenderer:" + tableRenderer);
                component = jTable.prepareRenderer(tableRenderer, linha, coluna);
//                System.out.println("Component: " + component);
//                System.out.println("Component.size() :" + component.getPreferredSize().width);
                tamanho = Math.max(component.getPreferredSize().width + 1 , tamanho);
//                System.out.println("Tamanho: " + tamanho);
            }
            if(tamanho > 750){
                tamanho = 750;
            }
            modeloColuna.getColumn(coluna).setPreferredWidth(tamanho);
        }
    }
    
}
