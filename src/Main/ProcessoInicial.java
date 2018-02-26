package Main;

/*
 @author Tiago e Paulo
 */
public class ProcessoInicial {
    BarraInicial Bar;
    
    public ProcessoInicial(BarraInicial bar){
        Bar = bar;
        int i=10;
        for(int j = 1; j <= 1000; j++) {
            if(j==(1000/i)){
                //System.out.println(i + " - " + j);
                i--;
                try{
                    Thread.sleep(10);
                }catch(Exception e){

                }
            }
        }
        Bar.lg.setVisible(true);
        Bar.dispose();
    }
    
}