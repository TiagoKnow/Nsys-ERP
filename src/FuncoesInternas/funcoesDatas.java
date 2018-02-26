/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FuncoesInternas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author  Tiago
 * www.ns3info.com.br
 */
public class funcoesDatas {

    /**
     * retorna uma String quando o parametro recebido é uma
     * string no formato yyyy-MM-dd
     * @param pString
     * @return String
     */
    public String addBarras(String pString){
        String dataRetorno = new String();
        //substitui o '-' por '\'
        if(pString != null){
            dataRetorno += pString.charAt(8);
            dataRetorno += pString.charAt(9);
            dataRetorno += '/';
            dataRetorno += pString.charAt(5);
            dataRetorno += pString.charAt(6);
            dataRetorno += '/';
            dataRetorno += pString.charAt(0);
            dataRetorno += pString.charAt(1);
            dataRetorno += pString.charAt(2);
            dataRetorno += pString.charAt(3);
        }
        return dataRetorno;
    }

    public String trocarTracos(String pString){
        String retorno = new String();
        if(pString != null){
            for(int i = 0; i < pString.length(); i++){
                if(pString.charAt(i) == '-'){
                    retorno += '/';
                } else {
                    retorno += pString.charAt(i);
                }
            }
        }
        return retorno;
    }
    
        /**
     * adiciona uma quantidade de dias a data
     * @param pQteDias
     * @return Date
     */
    public Date addDias(int pQteDias, Date pDate){
        Calendar c = Calendar.getInstance();

        c.setTime(pDate);
        c.add(Calendar.DATE, pQteDias);

        return c.getTime();
    }
    
   /**
    * adicionar mês a data
    * @param totalParcelas
    * @return 
    */
   public Date adddMes(Date dataAtual, int quantidadeMes){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.MONTH, quantidadeMes);
        return c.getTime();
   }
    
    public int diasEntreDatas(Date pDataInicio, Date pDataFim){
        GregorianCalendar ini = new GregorianCalendar();  
        GregorianCalendar fim = new GregorianCalendar();  
        ini.setTime(pDataInicio);  
        fim.setTime(pDataFim);  
        long dt1 = ini.getTimeInMillis();  
        long dt2 = fim.getTimeInMillis();  
        return (int) (((dt2 - dt1) / 86400000)+1); 
    }

    /**
     *retornar data e hora tempo real
     * @return 
     */
    public String retornarDataHora(){
        Date date = new Date(); 
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm");	
        return teste.format(date);
    }	

    
/** 
     * Converte uma String para um objeto Date. Caso a String seja vazia ou nula,  
     * retorna null - para facilitar em casos onde formulários podem ter campos 
     * de datas vazios. 
     * @param data String no formato dd/MM/yyyy a ser formatada 
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula 
     * @throws Exception Caso a String esteja no formato errado 
     */  
    public java.sql.Date converterDataStringParaDate(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }  
   
    /**
     * Converte data tipo string para o formato americano yyyy/MM/dd no tipo date
     * String para Date
     * @param data
     * @return
     * @throws Exception 
     */
     public java.sql.Date converterDataStringParaDateUS(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }   
    
    /**
     * Converte data tipo date para o formato americano yyyy/MM/dd também tipo date
     * Date para Date
     * @param pData
     * @return
     * @throws Exception 
     */
     public java.sql.Date converterDataParaDateUS(Date pData) throws Exception {   
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
         if (pData == null || pData.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(dataString)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }   
     
    /**
     * Recebe qualquer data em tipo date e retorna a data
     * formatada no tipo string ex. dd/MM/yyyy
     * Date para String
     * @param pData
     * @return String
     */
    public String formatarData(Date pData){ 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");    
        return formatarDate.format(pData);
    }
    
    public void formatarDataT(){
    
    }
}
