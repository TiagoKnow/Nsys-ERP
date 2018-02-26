package Beans;

import FuncoesInternas.FormataCampo;

/*
 @author Tiago e Paulo
 */
public class BeanPlanoReferencial {
    
    FormataCampo        fc      = new FormataCampo();
    
    public int    idPlanoReferencial                    = 0;    //0
    public int    codigoGrupo                           = 0;    //1
    public String codigoPlanoReferencial                = "";   //2
        public String codigoPlanoReferencial1           = "";
        public String codigoPlanoReferencial2           = "";
        public String codigoPlanoReferencial3           = "";
        public String codigoPlanoReferencial4           = "";
        public String codigoPlanoReferencial5           = "";
        public String codigoPlanoReferencial6           = "";
    public String descricaoPlanoReferencial             = "";   //3
    public String dataInicial                           = "";   //4
    public String dataFinal                             = "";   //5
    public String tipoPlanoReferencial                  = "";   //6
    public String codigoPlanoReferencialSuperior        = "";   //7
        public String codigoPlanoReferencialSuperior1   = "";
        public String codigoPlanoReferencialSuperior2   = "";
        public String codigoPlanoReferencialSuperior3   = "";
        public String codigoPlanoReferencialSuperior4   = "";
        public String codigoPlanoReferencialSuperior5   = "";
    public int    nivel                                 = 0;    //8
    public int    natureza                              = 0;    //9
    public String orientacoes                           = "";   //10
    
    public void RecarregaPlanoReferencial(){
        codigoPlanoReferencial          = codigoPlanoReferencial1;
        if(nivel < 2)return;
        codigoPlanoReferencial         += "." + fc.FormataCampo(codigoPlanoReferencial2, 2, 0);
        if(nivel < 3)return;
        codigoPlanoReferencial         += "." + fc.FormataCampo(codigoPlanoReferencial3, 2, 0);
        if(nivel < 4)return;
        codigoPlanoReferencial         += "." + fc.FormataCampo(codigoPlanoReferencial4, 2, 0);
        if(nivel < 5)return;
        codigoPlanoReferencial         += "." + fc.FormataCampo(codigoPlanoReferencial5, 2, 0);
        if(nivel < 6)return;
        codigoPlanoReferencial         += "." + fc.FormataCampo(codigoPlanoReferencial6, 2, 0);
    }
    
    public void RecarregaCodigosPlanoReferencial(){
        if(codigoPlanoReferencial.equals(""))return;
        codigoPlanoReferencial          = codigoPlanoReferencial        .replace(".", "");
        nivel = 6;
        if(codigoPlanoReferencial.length() <11)nivel = 5;
        if(codigoPlanoReferencial.length() < 9)nivel = 4;
        if(codigoPlanoReferencial.length() < 7)nivel = 3;
        if(codigoPlanoReferencial.length() < 5)nivel = 2;
        if(codigoPlanoReferencial.length() < 3)nivel = 1;
        codigoPlanoReferencial1         = codigoPlanoReferencial        .substring(0 , 1);
        if(nivel < 2)return;
        codigoPlanoReferencial2         = codigoPlanoReferencial        .substring(1 , 3);
        if(nivel < 3)return;
        codigoPlanoReferencial3         = codigoPlanoReferencial        .substring(3 , 5);
        if(nivel < 4)return;
        codigoPlanoReferencial4         = codigoPlanoReferencial        .substring(5 , 7);
        if(nivel < 5)return;
        codigoPlanoReferencial5         = codigoPlanoReferencial        .substring(7 , 9);
        if(nivel < 6)return;
        codigoPlanoReferencial6         = codigoPlanoReferencial        .substring(9 ,11);
    }
    
    public void RecarregaPlanoReferencialSuperior(){
        if(codigoPlanoReferencialSuperior1.equals(""))return;
        if(nivel < 2)return;
        codigoPlanoReferencialSuperior  = codigoPlanoReferencialSuperior1;
        if(nivel < 3)return;
        codigoPlanoReferencialSuperior += "." + fc.FormataCampo(codigoPlanoReferencialSuperior2, 2, 0);
        if(nivel < 4)return;
        codigoPlanoReferencialSuperior += "." + fc.FormataCampo(codigoPlanoReferencialSuperior3, 2, 0);
        if(nivel < 5)return;
        codigoPlanoReferencialSuperior += "." + fc.FormataCampo(codigoPlanoReferencialSuperior4, 2, 0);
        if(nivel < 6)return;
        codigoPlanoReferencialSuperior += "." + fc.FormataCampo(codigoPlanoReferencialSuperior5, 2, 0);
    }
    
    public void RecarregaCodigosPlanoReferencialSuperior(){
        if(codigoPlanoReferencialSuperior.equals(""))return;
        codigoPlanoReferencialSuperior  = codigoPlanoReferencialSuperior.replace(".", "");
        if(nivel < 2)return;
        codigoPlanoReferencialSuperior1 = codigoPlanoReferencialSuperior.substring(0 , 1);
        if(nivel < 3)return;
        codigoPlanoReferencialSuperior2 = codigoPlanoReferencialSuperior.substring(1 , 3);
        if(nivel < 4)return;
        codigoPlanoReferencialSuperior3 = codigoPlanoReferencialSuperior.substring(3 , 5);
        if(nivel < 5)return;
        codigoPlanoReferencialSuperior4 = codigoPlanoReferencialSuperior.substring(5 , 7);
        if(nivel < 6)return;
        codigoPlanoReferencialSuperior5 = codigoPlanoReferencialSuperior.substring(7 , 9);
    }
    
}
