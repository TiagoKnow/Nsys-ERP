package FuncoesInternas;

/**
 * @author Tiago e Paulo 10/08/2016 12:48
 */
public class NomeMes {
    //int
    int Mes = 0;
    
    //String
    String nomeMes = "";
    
    public String converterNome(int mes){  
        Mes = mes;
        switch(Mes){
            case  1: nomeMes = "Janeiro"   ; break;
            case  2: nomeMes = "Fevereiro" ; break;
            case  3: nomeMes = "Março"     ; break;
            case  4: nomeMes = "Abril"     ; break;
            case  5: nomeMes = "Maio"      ; break;
            case  6: nomeMes = "Junho"     ; break;
            case  7: nomeMes = "Julho"     ; break;
            case  8: nomeMes = "Agosto"    ; break;
            case  9: nomeMes = "Setembro"  ; break;
            case 10: nomeMes = "Outubro"   ; break;
            case 11: nomeMes = "Novembro"  ; break;
            case 12: nomeMes = "Dezembro"  ; break;
            default: nomeMes = "Não existe"; ;
        }
        return nomeMes;
    }    
}
