package FuncoesInternas;

import FuncoesInternas.Criptografia;
import FuncoesInternas.TestarData;
import FuncoesInternas.CapturarDataHora;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo
 */
public class TransformarDataSistemaEmSenha {
    String dataAtual       = "";
    String Mensagem        = "";
    String dataDia         = "";
    String dataMes         = "";
    String dataAno         = "";
    String dataDeValidacao = "";
    String senha           = "";
    String dataValor       = "";
    String fatal           = "N";
    String tipo            = "";
    
    //int's
    int    index                     = 0;
    int    tempoDeValidade           = 0;
    int    mesesParaTerminarValidade = 0;
    int    ano                       = 0;
    int    mes                       = 0;
    int    dia                       = 0;
    int    user                      = 0;
    int    data                      = 0;
    int    senha1                    = 0;
    int    senha2                    = 0;
    int    senha3                    = 0;
    int    somaCalculo               = 0;
    int    dataHoje                  = 0;
    
    
    int    valor1                    = 0;
    int    valor2                    = 0;
    int    valor3                    = 0;
    int    valor4                    = 0;
    int    valor5                    = 0;
    int    valor6                    = 0;
    int    valor7                    = 0;
    int    valor8                    = 0;
    int    valor9                    = 0;
    
    //Telas
    CapturarDataHora cdh  = new CapturarDataHora();
    Criptografia     crpt = new Criptografia();
    TestarData       Test = new TestarData();
    
    public String GeraSenha(String data){
        dataValor = data;
        VerificaData();
        return senha;
    }
    
    public void VerificaData(){
        dataDeValidacao = dataValor;
        dataDeValidacao = dataDeValidacao.replace("/", "");
        dataDeValidacao = dataDeValidacao.replace("-", "");
        dataDeValidacao = dataDeValidacao.replace(" ", "");
        if(dataDeValidacao.equals(""))
            return;
        
        dataHoje = Test.Testa(cdh.CapturarData());
        data     = Test.Testa(dataValor);
        
        if(dataHoje > data){
            Mensagem = "Data Ultrapassada!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        CalculaValidacao();
    }
    
    public void CalculaValidacao(){
        data = data * 9;
        dataDeValidacao = String.valueOf(data);
        
        valor1 = Integer.parseInt(dataDeValidacao.substring(0, 1));
        valor2 = Integer.parseInt(dataDeValidacao.substring(1, 2));
        valor3 = Integer.parseInt(dataDeValidacao.substring(2, 3));
        valor4 = Integer.parseInt(dataDeValidacao.substring(3, 4));
        valor5 = Integer.parseInt(dataDeValidacao.substring(4, 5));
        valor6 = Integer.parseInt(dataDeValidacao.substring(5, 6));
        valor7 = Integer.parseInt(dataDeValidacao.substring(6, 7));
        valor8 = Integer.parseInt(dataDeValidacao.substring(7, 8));
        valor9 = Integer.parseInt(dataDeValidacao.substring(8, 9));
        
        PegaDigito1();
        PegaDigito2();
        PegaDigito3();
        FormaSenha();
    }
    
    public void PegaDigito1(){
        somaCalculo = 0;
        somaCalculo = somaCalculo + ((valor1 * 1) + (valor2 * 2));  //17
        somaCalculo = somaCalculo + ((valor3 * 3) + (valor4 * 4));  //36
        somaCalculo = somaCalculo + ((valor5 * 5) + (valor6 * 6));  //68
        somaCalculo = somaCalculo + ((valor7 * 7) + (valor8 * 8));  //76
        somaCalculo = somaCalculo +  (valor9 * 9);                  //130
        senha1 = Integer.parseInt(String.valueOf(somaCalculo).substring(String.valueOf(somaCalculo).length() - 1, String.valueOf(somaCalculo).length()));  //0
    }
    
    public void PegaDigito2(){
        somaCalculo = 0;
        somaCalculo = somaCalculo + ((valor1 * 9) + (valor2 * 8));  //73
        somaCalculo = somaCalculo + ((valor3 * 7) + (valor4 * 6));  //104
        somaCalculo = somaCalculo + ((valor5 * 5) + (valor6 * 4));  //132
        somaCalculo = somaCalculo + ((valor7 * 3) + (valor8 * 2));  //134
        somaCalculo = somaCalculo +  (valor9 * 1);                  //140
        senha2 = Integer.parseInt(String.valueOf(somaCalculo).substring(String.valueOf(somaCalculo).length() - 1, String.valueOf(somaCalculo).length()));  //0
    }
    
    public void PegaDigito3(){
        somaCalculo = 0;
        somaCalculo = somaCalculo + ((valor1 * 1) + (valor2 * 5));  //41
        somaCalculo = somaCalculo + ((valor3 * 2) + (valor4 * 6));  //67
        somaCalculo = somaCalculo + ((valor5 * 3) + (valor6 * 7));  //93
        somaCalculo = somaCalculo + ((valor7 * 4) + (valor8 * 8));  //101
        somaCalculo = somaCalculo +  (valor9 * 9);                  //155
        senha3 = Integer.parseInt(String.valueOf(somaCalculo).substring(String.valueOf(somaCalculo).length() - 1, String.valueOf(somaCalculo).length()));  //5
    }
    
    public void FormaSenha(){
        senha = dataDeValidacao + senha1 + senha2 + senha3;
        senha = crpt.Criptografa(senha, "Criptografar");
    }
    
}
