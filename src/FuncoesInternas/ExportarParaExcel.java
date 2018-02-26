package FuncoesInternas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/*
 @author Tiago e Paulo
 */
public class ExportarParaExcel {
    JTable              Table;
    File                File;
    FileWriter          Excel;
    String              ValorAGravar    = "";
    int                 QtdLinhas       = 0;
    int                 QtdColunas      = 0;
    
    public ExportarParaExcel(JTable table, File file, int coluna1, int coluna2, int coluna3) throws IOException {
        Table       = table;
        File        = file;
        QtdLinhas   = Table.getRowCount();
        QtdColunas  = Table.getColumnCount();
        
        Excel = new FileWriter(File);
        for (int i = 0; i < QtdColunas; i++) {
            if(coluna1 != 0){if(i == coluna1)continue;}
            if(coluna2 != 0){if(i == coluna2)continue;}
            if(coluna3 != 0){if(i == coluna3)continue;}
            ValorAGravar = Table.getColumnName(i) + "\t";
            Excel.write(ValorAGravar);
        }
        Excel.write("\n");
        for (int i = 0; i < QtdLinhas; i++) {
            for (int j = 0; j < QtdColunas; j++){
                if(coluna1 != 0){if(j == coluna1)continue;}
                if(coluna2 != 0){if(j == coluna2)continue;}
                if(coluna3 != 0){if(j == coluna3)continue;}
                ValorAGravar = Table.getValueAt(i, j) + "\t";
                if(ValorAGravar == null)continue;
                Excel.write(ValorAGravar);
            }
            Excel.write("\n");
        }
        Excel.close();
    }
    
}
