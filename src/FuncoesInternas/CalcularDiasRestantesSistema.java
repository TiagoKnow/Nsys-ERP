package FuncoesInternas;

import java.text.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago e Paulo Gostoso
 */
public class CalcularDiasRestantesSistema {
    DateFormat  df          = new SimpleDateFormat ("dd/MM/yyyy");
    Date        DataInicial;
    Date        DataFinal;
    String      Mensagem    = "";
    
    public long RetornaDias(String DataIni, String DataFim){
        try{
            DataInicial = df.parse(DataIni);  
            DataFinal   = df.parse(DataFim);
            long dias = (DataFinal.getTime() - DataInicial.getTime()) + 3600000; // 1 hora para compensar horário de verão  
            dias = dias / 86400000L; // passaram-se 67111 dias  
            return dias;
        }catch(Exception erro){
            Mensagem = "Erro ao calcular Dias Restantes: " + erro.getMessage();
            new MostraMensagem(Mensagem);
            return 0;
        }
    }
    
}
