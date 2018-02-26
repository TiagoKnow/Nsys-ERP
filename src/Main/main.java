package Main;

/*
 @author Tiago e Paulo
 */
public class main {
    //Telas
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tela de progresso em inicialização .. carrega as variáveis antes da tela de login - Tiago.        
        BarraInicial    bar     = new BarraInicial();
        ProcessoInicial ProIni  = new ProcessoInicial(bar);
    }
    
}
