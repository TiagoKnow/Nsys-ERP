package FuncoesInternas;

import Parametros.parametrosNS;
import java.util.ArrayList;

/*
 @author Paulo
 */
public class PegaProximoRegistro {
    //String's
    String NomeTabela               = "";
    String NomeColuna               = "";
    String Parametro                = "";
    String sql                      = "";
    
    //int's
    int    retorno                  = 0;
    
    //ArrayList's
    ArrayList dados                 = new ArrayList();
    
    //Telas
    
    public int PegaProximoRegistro(String nomeTabela, String nomeColuna, String parametro){
        NomeTabela  = nomeTabela;
        NomeColuna  = nomeColuna;
        Parametro   = parametro;
        PegaNumeros();
        return retorno;
    }
    
    private void PegaNumeros(){
//        sql = "select " + NomeColuna + " from " + NomeTabela + " where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " ";
        NomeColuna = "max(" + NomeColuna + ")";
        sql = "select " + NomeColuna + " from " + NomeTabela + " where codigoGrupo = " + parametrosNS.bge.codigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " ";
        if(parametrosNS.bu.codigoUsuario == 999){
            sql = "select " + NomeColuna + " from " + NomeTabela + " where codigoGrupo = " + parametrosNS.bge.CodigoGrupo + " and codigoEmpresa = " + parametrosNS.be.CodigoEmpresa + " ";
        }
        if(!Parametro.equals((""))){
            sql += Parametro;
        }
        sql += " order by " + NomeColuna + " asc";
        dados.clear();
        dados = parametrosNS.dao.ConsultaNumeros(sql, NomeColuna);
        PegaDadosNumeros();
    }
    
    private void PegaDadosNumeros(){
//        int i = 0;
//        if(dados.size() > 0){
//            for(i = 1; i < dados.size() + 1; i++){
//                if(i != Integer.parseInt(String.valueOf(dados.get(i - 1)))){
//                    retorno = i;
//                    return;
//                }
//            }
//            i = i - 1;
//        }
//        if(i == dados.size())
//            retorno = dados.size() + 1;
        retorno = Integer.parseInt(String.valueOf(dados.get(0))) + 1;
    }
    
}
