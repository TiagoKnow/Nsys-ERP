/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FuncoesInternas;

import java.text.DecimalFormat;

/**
 *
 * @author tiago 2008
 */
public class mascaras {

    /**
     * converte a virgula de uma string para ponto
     * @param pString
     * @return String
     */
    public String converterVirgulaParaPonto(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for(int i = 0; i < tamanhoString; i++){
            if(pString.charAt(i) == ','){
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }
    
   /**
     * converte a virgula de uma string para ponto
     * @param pString
     * @return String
     */
    public String converterPontoPraVirgula(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for(int i = 0; i < tamanhoString; i++){
            if(pString.charAt(i) == '.'){
                retorno += ',';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }
    
    /**
     * converte a virgula de uma string para ponto
     * @param pString
     * @return float
     */
    public float converterVirgulaParaPontoReturnFloat(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for(int i = 0; i < tamanhoString; i++){
            if(pString.charAt(i) == ','){
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            }
        }
        return Float.parseFloat(retorno);
    }
    
    /**
     * retira os pontos do valor
     * @param pString
     * @return 
     */
    public String removerPontos(String pString){
        String retorno = new String();
        int tamanhoString = pString.length();
        for(int i = 0; i < tamanhoString; i++){
            if(pString.charAt(i) == '.'){
                retorno += "";
            } else {
                retorno += pString.charAt(i);
            }
        }
        return retorno;
    }
    
    /**
     * adiciona um ponto a string
     * @param pString
     * @return String
     */
    public String addPonto(String pString){
        int pontoConter = 0;
        for(int i = 0; i < pString.length(); i++){
            if(pString.charAt(i) == '.'){
                pontoConter++;
            }
        }
        if(pontoConter == 0){
            pString += ".0";
        }
        return pString;
    }
    
    /**
     * truca o valor com 3 casas decimais
     * @param pValor
     * @return double
     */
    public double truncar3Casas(double pValor){
        
        return Math.round(pValor * 100)/100d;
    }
    
    
    public int converteInteiro(int pString){
        DecimalFormat df = new DecimalFormat("#.0");
        pString = Integer.parseInt(df.format(pString));
        return pString;
    }
    
    /**
     * Arredonda com 2 casas decimais.
     */
    public double converteArredondar2Casas(double pDouble){
        DecimalFormat df = new DecimalFormat("#,00");
        pDouble = Double.parseDouble(df.format(pDouble));
        return pDouble;
    }
    
    /**
     * arredonda um valor com ponto
     * @param pValor
     * @return 
     */
    public float arredondamentoComPontoDuasCasas(float pValor){
        DecimalFormat df = new DecimalFormat("#.00");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }
    
    /**
     * arredonda um valor com ponto string formatada
     * @param pValor
     * @return 
     */
    public String arredondamentoComPontoDuasCasasString(float pValor){
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }
    
        /**
     * arredonda um valor com ponto
     * @param pValor
     * @return 
     */
    public float arredondamentoComPontoTresCasas(float pValor){
        DecimalFormat df = new DecimalFormat("#.000");
        return Float.parseFloat(this.converterVirgulaParaPonto(df.format(pValor)));
    }

    /**
     * arredonda um valor com ponto
     * @param pValor
     * @return 
     */
    public String arredondamentoDoubleComPontoDuasCasasString(Double pValor){
        DecimalFormat df = new DecimalFormat("#.00");
        return this.converterVirgulaParaPonto(df.format(pValor));
    }
    
}


