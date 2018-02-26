package FuncoesInternas;

import java.awt.*;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/*
 @author Tiago e Paulo
 */
public class ColorirTabelaOSeVendaseBoletos extends DefaultTableCellRenderer {
    //int's
    public int    numeroDaColuna   = 0;
    
    //String's
    String status           = "";
    String Mensagem         = "";
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column){
        status = ((String) table.getModel().getValueAt(row, numeroDaColuna));
        if(table.getRowCount() - 1 == row)
            status = "";
        if(isSelected){
            setBackground(new Color(0  ,0  ,0  ));
            setForeground(new Color(255,255,255));
        }else{
//            System.out.println(status);
            setForeground(new Color(0,0,0));
            if(status != null)
                if(!status.equals("null")){
                    switch(status){
                        case "Pendente"         :   setBackground(new Color(255,255,153))   ; break;//Menos gritante que Amalero
                        case "À Vencer"         :   setBackground(new Color(255,204,153))   ; break;//Amalero Alaranjado
                        case "Cancelada"        :   setBackground(new Color(255,114,86 ))   ; break;//Vermelho
                        case "Vencido"          :   setBackground(new Color(255,114,86 ))   ; break;//Vermelho
                        case "Finalizada"       :   setBackground(new Color(153,255,153))   ; break;//Verde
                        case "Pago"             :   setBackground(new Color(153,255,153))   ; break;//Verde
                        case "Sem Solução"      :   setBackground(new Color(153,255,255))   ; break;//Verde
                        case "Pagamento Parcial":   setBackground(new Color(204,255,204))   ; break;//Verde claro
                        case "Faturada"         :   setBackground(new Color(153,153,255))   ; break;//Roxo
                        case "Baixado"          :   setBackground(new Color(204,204,204))   ; break;//Roxo
                        case ""                 :   setBackground(new Color(255,255,255))   ; break;
                        default:                    setBackground(new Color(255,255,255))   ;
                    }
                }
        }
//        try{
//            System.out.println(value);
            if(value != null)
                if(!value.equals("null"))
                    setText(value.toString());
                else
                    setText("");    
            else
                setText("");
//        }catch(Exception erro){
//            Mensagem = "Erro: " + erro.getMessage();
//            new MostraMensagem(Mensagem);
//        }
        
        return this;
    }
}
