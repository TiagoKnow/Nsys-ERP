package FuncoesInternas;

import Parametros.parametrosNS;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 @author Tiago e Paulo 03/10/2017 12:30
 */
public class PesquisaAvancada {
    //String
    String sql          = "";
    String sql1         = "";
    String sql2         = "";
    String nomeTabela   = "";
    String mensagem     = "";
    String nomeColuna   = "";
    
    //Vetores
    ArrayList<ArrayList> dadosArray    = new ArrayList();
    ArrayList<ArrayList> dadosValores  = new ArrayList();
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public ArrayList PesquisaAvancada(String Sql1, String Sql2, String NomeTabela){
        sql1        = Sql1;
        sql2        = Sql2;
        nomeTabela  = NomeTabela;
        sql = "select column_name from information_schema.columns where table_schema = '" + parametrosNS.bbd.nomeBanco + "' and table_name = '" + nomeTabela + "';";
        dadosArray.clear();
        dadosArray = parametrosNS.dao.Consulta(sql);
        if(dadosArray.isEmpty()){
            mensagem = "Não foram encontrados registros!";
            mostraMensagem();
            return dadosArray;
        }
        PegaDados();
        return dadosValores;
    }
    
    private void PegaDados(){
        sql         = "";
        nomeColuna  = "";
        dadosValores.clear();
        for(int i = 0; i < dadosArray.size(); i++){
            nomeColuna = String.valueOf(dadosArray.get(i).get(0));
            sql = sql1 + nomeColuna + sql2;
            
            dadosValores = parametrosNS.dao.Consulta(sql);
            if(!dadosValores.isEmpty()){
                return;
            }
        }
    }
    
}
