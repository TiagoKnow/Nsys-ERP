package Beans;
/*
 @author Tiago e Paulo
 */
public class BeanPlanoDeContas {
    
    public int    idPlanoDeContas                   = 0;        //0
    public int    idEmpresa                         = 0;        //1
    public int    codigoGrupo                       = 0;        //2
        public double saldoGrupo01                      = 0;
        public double saldoGrupo02                      = 0;
        public double saldoGrupo03                      = 0;
        public double saldoGrupo04                      = 0;
        public double saldoGrupo05                      = 0;
        public double saldoGrupo06                      = 0;
        public double saldoGrupo07                      = 0;
        public double saldoGrupo08                      = 0;
        public double saldoGrupo09                      = 0;
        public double saldoGrupo10                      = 0;
        public double saldoGrupo11                      = 0;
        public double saldoGrupo12                      = 0;
    public int    codigoEmpresa                     = 0;        //3
        public double saldoEmpresa01                    = 0;
        public double saldoEmpresa02                    = 0;
        public double saldoEmpresa03                    = 0;
        public double saldoEmpresa04                    = 0;
        public double saldoEmpresa05                    = 0;
        public double saldoEmpresa06                    = 0;
        public double saldoEmpresa07                    = 0;
        public double saldoEmpresa08                    = 0;
        public double saldoEmpresa09                    = 0;
        public double saldoEmpresa10                    = 0;
        public double saldoEmpresa11                    = 0;
        public double saldoEmpresa12                    = 0;
    public String codigoPlanoDeContas               = "";       //4
        public String codigoPlanoDeContas1          = "";//VARCHAR(1)
        public String codigoPlanoDeContas2          = "";//VARCHAR(1)
        public String codigoPlanoDeContas3          = "";//VARCHAR(1)
        public String codigoPlanoDeContas4          = "";//VARCHAR(2)
        public String codigoPlanoDeContas5          = "";//VARCHAR(2)
        public String codigoPlanoDeContas6          = "";//VARCHAR(4)
        public String codigoPlanoDeContasrestante   = "";
    public String descricaoPlanoDeContas            = "";       //5
    public String tipoPlanoDeContas                 = "";       //6
    public double saldoDeAbertura                   = 0;        //7
        public double saldoNivel1                   = 0;
            public double saldoNivel101                 = 0;
            public double saldoNivel102                 = 0;
            public double saldoNivel103                 = 0;
            public double saldoNivel104                 = 0;
            public double saldoNivel105                 = 0;
            public double saldoNivel106                 = 0;
            public double saldoNivel107                 = 0;
            public double saldoNivel108                 = 0;
            public double saldoNivel109                 = 0;
            public double saldoNivel110                 = 0;
            public double saldoNivel111                 = 0;
            public double saldoNivel112                 = 0;
        public double saldoNivel2                   = 0;
            public double saldoNivel201                 = 0;
            public double saldoNivel202                 = 0;
            public double saldoNivel203                 = 0;
            public double saldoNivel204                 = 0;
            public double saldoNivel205                 = 0;
            public double saldoNivel206                 = 0;
            public double saldoNivel207                 = 0;
            public double saldoNivel208                 = 0;
            public double saldoNivel209                 = 0;
            public double saldoNivel210                 = 0;
            public double saldoNivel211                 = 0;
            public double saldoNivel212                 = 0;
        public double saldoNivel3                   = 0;
            public double saldoNivel301                 = 0;
            public double saldoNivel302                 = 0;
            public double saldoNivel303                 = 0;
            public double saldoNivel304                 = 0;
            public double saldoNivel305                 = 0;
            public double saldoNivel306                 = 0;
            public double saldoNivel307                 = 0;
            public double saldoNivel308                 = 0;
            public double saldoNivel309                 = 0;
            public double saldoNivel310                 = 0;
            public double saldoNivel311                 = 0;
            public double saldoNivel312                 = 0;
        public double saldoNivel4                   = 0;
            public double saldoNivel401                 = 0;
            public double saldoNivel402                 = 0;
            public double saldoNivel403                 = 0;
            public double saldoNivel404                 = 0;
            public double saldoNivel405                 = 0;
            public double saldoNivel406                 = 0;
            public double saldoNivel407                 = 0;
            public double saldoNivel408                 = 0;
            public double saldoNivel409                 = 0;
            public double saldoNivel410                 = 0;
            public double saldoNivel411                 = 0;
            public double saldoNivel412                 = 0;
        public double saldoNivel5                   = 0;
            public double saldoNivel501                 = 0;
            public double saldoNivel502                 = 0;
            public double saldoNivel503                 = 0;
            public double saldoNivel504                 = 0;
            public double saldoNivel505                 = 0;
            public double saldoNivel506                 = 0;
            public double saldoNivel507                 = 0;
            public double saldoNivel508                 = 0;
            public double saldoNivel509                 = 0;
            public double saldoNivel510                 = 0;
            public double saldoNivel511                 = 0;
            public double saldoNivel512                 = 0;
        public double saldoNivel6                   = 0;
    public String codigoPlanoDeContasSuperior       = "";       //8
        public String codigoPlanoDeContasSuperior1  = "";//VARCHAR(1)
        public String codigoPlanoDeContasSuperior2  = "";//VARCHAR(1)
        public String codigoPlanoDeContasSuperior3  = "";//VARCHAR(1)
        public String codigoPlanoDeContasSuperior4  = "";//VARCHAR(2)
        public String codigoPlanoDeContasSuperior5  = "";//VARCHAR(2)
    public int    nivelPlanoDeContas                = 0;        //9
    public int    idPlanoReferencial                = 0;        //10
    
    public void CarregaPlanoDeContas(){
        codigoPlanoDeContas             = codigoPlanoDeContas.replace(".", "");
        int index = codigoPlanoDeContas.length();
        if(index <  2)codigoPlanoDeContas += "0";
        if(index <  3)codigoPlanoDeContas += "0";
        if(index <  5)codigoPlanoDeContas += "00";
        if(index <  7)codigoPlanoDeContas += "00";
        if(index < 11)codigoPlanoDeContas += "0000";
    }
    
    public void RecarregaPlanoDeContas(String Concatena, String Verifica){
        if(codigoPlanoDeContas2.equalsIgnoreCase(""))return;
        codigoPlanoDeContas             = codigoPlanoDeContas1;
        if(Concatena.equalsIgnoreCase("S"))if(Verifica.equals("S")){if(Integer.parseInt(codigoPlanoDeContas2) != 0)codigoPlanoDeContas            += "." + codigoPlanoDeContas2;}else codigoPlanoDeContas            += "." + codigoPlanoDeContas2;
        if(Concatena.equalsIgnoreCase("S"))if(Verifica.equals("S")){if(Integer.parseInt(codigoPlanoDeContas3) != 0)codigoPlanoDeContas            += "." + codigoPlanoDeContas3;}else codigoPlanoDeContas            += "." + codigoPlanoDeContas3;
        if(Concatena.equalsIgnoreCase("S"))if(Verifica.equals("S")){if(Integer.parseInt(codigoPlanoDeContas4) != 0)codigoPlanoDeContas            += "." + codigoPlanoDeContas4;}else codigoPlanoDeContas            += "." + codigoPlanoDeContas4;
        if(Concatena.equalsIgnoreCase("S"))if(Verifica.equals("S")){if(Integer.parseInt(codigoPlanoDeContas5) != 0)codigoPlanoDeContas            += "." + codigoPlanoDeContas5;}else codigoPlanoDeContas            += "." + codigoPlanoDeContas5;
        if(Concatena.equalsIgnoreCase("S"))if(Verifica.equals("S")){if(Integer.parseInt(codigoPlanoDeContas6) != 0)codigoPlanoDeContas            += "." + codigoPlanoDeContas6;}else codigoPlanoDeContas            += "." + codigoPlanoDeContas6;
    }
    
    public void RecarregaCodigosPlanosDeContas(){
        if(codigoPlanoDeContas.equalsIgnoreCase(""))return;
        codigoPlanoDeContas             = codigoPlanoDeContas           .replace(".", "");
        codigoPlanoDeContas1            = codigoPlanoDeContas           .substring(0 , 1);
        codigoPlanoDeContas2            = codigoPlanoDeContas           .substring(1 , 2);
        codigoPlanoDeContas3            = codigoPlanoDeContas           .substring(2 , 3);
        codigoPlanoDeContas4            = codigoPlanoDeContas           .substring(3 , 5);
        codigoPlanoDeContas5            = codigoPlanoDeContas           .substring(5 , 7);
        codigoPlanoDeContas6            = codigoPlanoDeContas           .substring(7 ,11);
    }
    
    public void RecarregaPlanoDeContasSuperior(String Concatena){
        if(codigoPlanoDeContasSuperior2.equalsIgnoreCase(""))return;
        codigoPlanoDeContasSuperior     = codigoPlanoDeContasSuperior1;
        if(Concatena.equalsIgnoreCase("S"))if(Integer.parseInt(codigoPlanoDeContasSuperior2) != 0)codigoPlanoDeContasSuperior    += "." + codigoPlanoDeContasSuperior2;
        if(Concatena.equalsIgnoreCase("S"))if(Integer.parseInt(codigoPlanoDeContasSuperior3) != 0)codigoPlanoDeContasSuperior    += "." + codigoPlanoDeContasSuperior3;
        if(Concatena.equalsIgnoreCase("S"))if(Integer.parseInt(codigoPlanoDeContasSuperior4) != 0)codigoPlanoDeContasSuperior    += "." + codigoPlanoDeContasSuperior4;
        if(Concatena.equalsIgnoreCase("S"))if(Integer.parseInt(codigoPlanoDeContasSuperior5) != 0)codigoPlanoDeContasSuperior    += "." + codigoPlanoDeContasSuperior5;
    }
    
    public void RecarregaCodigosPlanosDeContasSuperior(){
        if(codigoPlanoDeContasSuperior.equalsIgnoreCase(""))return;
        codigoPlanoDeContasSuperior     = codigoPlanoDeContasSuperior.replace(".", "");
        codigoPlanoDeContasSuperior1    = codigoPlanoDeContasSuperior   .substring(0 , 1);
        codigoPlanoDeContasSuperior2    = codigoPlanoDeContasSuperior   .substring(1 , 2);
        codigoPlanoDeContasSuperior3    = codigoPlanoDeContasSuperior   .substring(2 , 3);
        codigoPlanoDeContasSuperior4    = codigoPlanoDeContasSuperior   .substring(3 , 5);
        codigoPlanoDeContasSuperior5    = codigoPlanoDeContasSuperior   .substring(5 , 7);
    }
    
}
