package FuncoesInternas;

import org.jasypt.util.text.BasicTextEncryptor;
/*
 @author Paulo e Tiago
 */
public class Criptografia {
    //Novos
    BasicTextEncryptor encrypt;
    
    //String
    String TextoRetorno     = "";
    String CaracterSenha    = "";
    String ResultadoSenha   = "";
    String ValorSenha       = "";
    
    //int
    int    Length        = 0;
    
    public String Criptografa(String Texto, String tipo){
        if(Texto.equals("null") && Texto.equals("")){
            return "";
        }
        encrypt = new BasicTextEncryptor();
        encrypt.setPassword("12345678910");
        if(tipo.equals("Criptografar")){
            TextoRetorno = encrypt.encrypt(Texto);
        }else{
            TextoRetorno = encrypt.decrypt(Texto);
        }
        return TextoRetorno;
    }
    
    public String CriptografaManualmente(String Senha){
        Length = Senha.replace(" ", "").length();
        ResultadoSenha = "";
        //System.out.println(Senha);
        for(int i = 0; i < Length; i++){
            CaracterSenha = "";
            CaracterSenha = Senha.substring(i, i + 1);
            
            SubstituicaoDeSenha();
            //System.out.println(CaracterSenha);
            
            ResultadoSenha = ResultadoSenha + CaracterSenha;
        }
        return ResultadoSenha;
    }
    
    public void SubstituicaoDeSenha(){
        if(CaracterSenha.equals("a")){CaracterSenha = CaracterSenha.replace("a", "/");return;}
        if(CaracterSenha.equals("A")){CaracterSenha = CaracterSenha.replace("A", "/");return;}
        if(CaracterSenha.equals("b")){CaracterSenha = CaracterSenha.replace("b", "*");return;}
        if(CaracterSenha.equals("B")){CaracterSenha = CaracterSenha.replace("B", "*");return;}
        if(CaracterSenha.equals("c")){CaracterSenha = CaracterSenha.replace("c", "+");return;}
        if(CaracterSenha.equals("C")){CaracterSenha = CaracterSenha.replace("C", "+");return;}
        if(CaracterSenha.equals("d")){CaracterSenha = CaracterSenha.replace("d", ".");return;}
        if(CaracterSenha.equals("D")){CaracterSenha = CaracterSenha.replace("D", ".");return;}
        if(CaracterSenha.equals("e")){CaracterSenha = CaracterSenha.replace("e", ",");return;}
        if(CaracterSenha.equals("E")){CaracterSenha = CaracterSenha.replace("E", ",");return;}
        if(CaracterSenha.equals("f")){CaracterSenha = CaracterSenha.replace("f", "!");return;}
        if(CaracterSenha.equals("F")){CaracterSenha = CaracterSenha.replace("F", "!");return;}
        if(CaracterSenha.equals("g")){CaracterSenha = CaracterSenha.replace("g", "@");return;}
        if(CaracterSenha.equals("G")){CaracterSenha = CaracterSenha.replace("G", "@");return;}
        if(CaracterSenha.equals("h")){CaracterSenha = CaracterSenha.replace("h", "#");return;}
        if(CaracterSenha.equals("H")){CaracterSenha = CaracterSenha.replace("H", "#");return;}
        if(CaracterSenha.equals("i")){CaracterSenha = CaracterSenha.replace("i", "$");return;}
        if(CaracterSenha.equals("I")){CaracterSenha = CaracterSenha.replace("I", "$");return;}
        if(CaracterSenha.equals("j")){CaracterSenha = CaracterSenha.replace("j", "%");return;}
        if(CaracterSenha.equals("J")){CaracterSenha = CaracterSenha.replace("J", "%");return;}
        if(CaracterSenha.equals("k")){CaracterSenha = CaracterSenha.replace("k", "¨");return;}
        if(CaracterSenha.equals("K")){CaracterSenha = CaracterSenha.replace("K", "¨");return;}
        if(CaracterSenha.equals("l")){CaracterSenha = CaracterSenha.replace("l", "&");return;}
        if(CaracterSenha.equals("L")){CaracterSenha = CaracterSenha.replace("L", "&");return;}
        if(CaracterSenha.equals("m")){CaracterSenha = CaracterSenha.replace("m", "¢");return;}
        if(CaracterSenha.equals("M")){CaracterSenha = CaracterSenha.replace("M", "¢");return;}
        if(CaracterSenha.equals("n")){CaracterSenha = CaracterSenha.replace("n", "¬");return;}
        if(CaracterSenha.equals("N")){CaracterSenha = CaracterSenha.replace("N", "¬");return;}
        if(CaracterSenha.equals("o")){CaracterSenha = CaracterSenha.replace("o", "_");return;}
        if(CaracterSenha.equals("O")){CaracterSenha = CaracterSenha.replace("O", "_");return;}
        if(CaracterSenha.equals("p")){CaracterSenha = CaracterSenha.replace("p", "-");return;}
        if(CaracterSenha.equals("P")){CaracterSenha = CaracterSenha.replace("P", "-");return;}
        if(CaracterSenha.equals("q")){CaracterSenha = CaracterSenha.replace("q", "=");return;}
        if(CaracterSenha.equals("Q")){CaracterSenha = CaracterSenha.replace("Q", "=");return;}
        if(CaracterSenha.equals("r")){CaracterSenha = CaracterSenha.replace("r", "§");return;}
        if(CaracterSenha.equals("R")){CaracterSenha = CaracterSenha.replace("R", "§");return;}
        if(CaracterSenha.equals("s")){CaracterSenha = CaracterSenha.replace("s", "`");return;}
        if(CaracterSenha.equals("S")){CaracterSenha = CaracterSenha.replace("S", "`");return;}
        if(CaracterSenha.equals("t")){CaracterSenha = CaracterSenha.replace("t", "´");return;}
        if(CaracterSenha.equals("T")){CaracterSenha = CaracterSenha.replace("T", "´");return;}
        if(CaracterSenha.equals("u")){CaracterSenha = CaracterSenha.replace("u", "~");return;}
        if(CaracterSenha.equals("U")){CaracterSenha = CaracterSenha.replace("U", "~");return;}
        if(CaracterSenha.equals("w")){CaracterSenha = CaracterSenha.replace("w", "^");return;}
        if(CaracterSenha.equals("W")){CaracterSenha = CaracterSenha.replace("W", "^");return;}
        if(CaracterSenha.equals("v")){CaracterSenha = CaracterSenha.replace("v", "{");return;}
        if(CaracterSenha.equals("V")){CaracterSenha = CaracterSenha.replace("V", "{");return;}
        if(CaracterSenha.equals("y")){CaracterSenha = CaracterSenha.replace("y", "}");return;}
        if(CaracterSenha.equals("Y")){CaracterSenha = CaracterSenha.replace("Y", "}");return;}
        if(CaracterSenha.equals("x")){CaracterSenha = CaracterSenha.replace("x", "[");return;}
        if(CaracterSenha.equals("X")){CaracterSenha = CaracterSenha.replace("X", "[");return;}
        if(CaracterSenha.equals("z")){CaracterSenha = CaracterSenha.replace("z", "]");return;}
        if(CaracterSenha.equals("Z")){CaracterSenha = CaracterSenha.replace("Z", "]");return;}
        if(CaracterSenha.equals("0")){CaracterSenha = CaracterSenha.replace("0", "ª");return;}
        if(CaracterSenha.equals("1")){CaracterSenha = CaracterSenha.replace("1", "º");return;}
        if(CaracterSenha.equals("2")){CaracterSenha = CaracterSenha.replace("2", "<");return;}
        if(CaracterSenha.equals("3")){CaracterSenha = CaracterSenha.replace("3", ">");return;}
        if(CaracterSenha.equals("4")){CaracterSenha = CaracterSenha.replace("4", ";");return;}
        if(CaracterSenha.equals("5")){CaracterSenha = CaracterSenha.replace("5", ":");return;}
        if(CaracterSenha.equals("6")){CaracterSenha = CaracterSenha.replace("6", "?");return;}
        if(CaracterSenha.equals("7")){CaracterSenha = CaracterSenha.replace("7", "°");return;}
        if(CaracterSenha.equals("8")){CaracterSenha = CaracterSenha.replace("8", "|");return;}
        if(CaracterSenha.equals("9")){CaracterSenha = CaracterSenha.replace("9", "£");return;}
        
        if(CaracterSenha.equals("/")){CaracterSenha = CaracterSenha.replace("/" ,"A");return;}
        if(CaracterSenha.equals("*")){CaracterSenha = CaracterSenha.replace("*" ,"B");return;}
        if(CaracterSenha.equals("+")){CaracterSenha = CaracterSenha.replace("+" ,"C");return;}
        if(CaracterSenha.equals(".")){CaracterSenha = CaracterSenha.replace("." ,"D");return;}
        if(CaracterSenha.equals(",")){CaracterSenha = CaracterSenha.replace("," ,"E");return;}
        if(CaracterSenha.equals("!")){CaracterSenha = CaracterSenha.replace("!" ,"F");return;}
        if(CaracterSenha.equals("@")){CaracterSenha = CaracterSenha.replace("@" ,"G");return;}
        if(CaracterSenha.equals("#")){CaracterSenha = CaracterSenha.replace("#" ,"H");return;}
        if(CaracterSenha.equals("$")){CaracterSenha = CaracterSenha.replace("$" ,"I");return;}
        if(CaracterSenha.equals("%")){CaracterSenha = CaracterSenha.replace("%" ,"J");return;}
        if(CaracterSenha.equals("¨")){CaracterSenha = CaracterSenha.replace("¨" ,"K");return;}
        if(CaracterSenha.equals("&")){CaracterSenha = CaracterSenha.replace("&" ,"L");return;}
        if(CaracterSenha.equals("¢")){CaracterSenha = CaracterSenha.replace("¢" ,"M");return;}
        if(CaracterSenha.equals("¬")){CaracterSenha = CaracterSenha.replace("¬" ,"N");return;}
        if(CaracterSenha.equals("_")){CaracterSenha = CaracterSenha.replace("_" ,"O");return;}
        if(CaracterSenha.equals("-")){CaracterSenha = CaracterSenha.replace("-" ,"P");return;}
        if(CaracterSenha.equals("=")){CaracterSenha = CaracterSenha.replace("=" ,"Q");return;}
        if(CaracterSenha.equals("§")){CaracterSenha = CaracterSenha.replace("§" ,"R");return;}
        if(CaracterSenha.equals("`")){CaracterSenha = CaracterSenha.replace("`" ,"S");return;}
        if(CaracterSenha.equals("´")){CaracterSenha = CaracterSenha.replace("´" ,"Y");return;}
        if(CaracterSenha.equals("~")){CaracterSenha = CaracterSenha.replace("~" ,"U");return;}
        if(CaracterSenha.equals("^")){CaracterSenha = CaracterSenha.replace("^" ,"W");return;}
        if(CaracterSenha.equals("{")){CaracterSenha = CaracterSenha.replace("{" ,"V");return;}
        if(CaracterSenha.equals("}")){CaracterSenha = CaracterSenha.replace("}" ,"Y");return;}
        if(CaracterSenha.equals("[")){CaracterSenha = CaracterSenha.replace("[" ,"X");return;}
        if(CaracterSenha.equals("]")){CaracterSenha = CaracterSenha.replace("]" ,"Z");return;}
        if(CaracterSenha.equals("ª")){CaracterSenha = CaracterSenha.replace("ª" ,"0");return;}
        if(CaracterSenha.equals("º")){CaracterSenha = CaracterSenha.replace("º" ,"1");return;}
        if(CaracterSenha.equals("<")){CaracterSenha = CaracterSenha.replace("<" ,"2");return;}
        if(CaracterSenha.equals(">")){CaracterSenha = CaracterSenha.replace(">" ,"3");return;}
        if(CaracterSenha.equals(";")){CaracterSenha = CaracterSenha.replace(";" ,"4");return;}
        if(CaracterSenha.equals(":")){CaracterSenha = CaracterSenha.replace(":" ,"5");return;}
        if(CaracterSenha.equals("?")){CaracterSenha = CaracterSenha.replace("?" ,"6");return;}
        if(CaracterSenha.equals("°")){CaracterSenha = CaracterSenha.replace("°" ,"7");return;}
        if(CaracterSenha.equals("|")){CaracterSenha = CaracterSenha.replace("|" ,"8");return;}
        if(CaracterSenha.equals("£")){CaracterSenha = CaracterSenha.replace("£" ,"9");return;}
    }
}
