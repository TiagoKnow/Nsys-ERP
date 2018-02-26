package FuncoesInternas;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/*
 @author Tiago e Paulo
 */
public class SelecaoDeCampo {
    JTextField          JText;
    JFormattedTextField JFormatted;
    
    public SelecaoDeCampo(JTextField jText, JFormattedTextField jFormatted){
        JText           = jText;
        JFormatted      = jFormatted;
        
        if(JText == null)if(JFormatted == null)return;
        
        if(JText == null)
            FormataCampoFormatado();
        if(JFormatted == null)
            FormataCampo();
    }
    
    private void FormataCampoFormatado(){
        JFormatted.setSelectionStart(0);
        JFormatted.setSelectionEnd(JFormatted.getText().length());
    }
    
    private void FormataCampo(){
        JText.setSelectionStart(0);
        JText.setSelectionEnd(JText.getText().length());
    }
    
}
