package FuncoesInternas;
/*
 @author Tiago e Paulo
 */
public class Ok {
    static int     i;
    
    public static void main (String[] args){
        for(i = 5; i > 0; i--){
            System.out.println(i + " patinhos");
            System.out.println("Foram passear");
            System.out.println("Além das montanhas");
            System.out.println("Para brincar");
            System.out.println("A mamãe gritou");
            System.out.println("Quack, Quack, Quack, Quack");
            if(i == 1){
                System.out.println("Mas nenhum patinho");
                System.out.println("Voltou de lá");
                System.out.println("");
            }else{
                System.out.println("Mas só " + (i - 1) + " patinhos");
                System.out.println("voltaram de lá");
                System.out.println("");
            }
        }
        i = 5;
        System.out.println("Puxa, a mamãe patinha ficou tão triste naquele dia");
        System.out.println("Aonde será que estavam os filhotes?");
        System.out.println("Mas essa história vai ter um final feliz, sabê por quê?");
        
        System.out.println("");
        
        System.out.println("A mamãe patinha");
        System.out.println("Foi procurar");
        System.out.println("Além das montanhas");
        System.out.println("Na beira do mar");
        System.out.println("A mamãe gritou");
        System.out.println("Quack, Quack, Quack, Quack");
        System.out.println("E os " + i + " patinhos");
        System.out.println("Voltaram de lá");
    }
    
}
