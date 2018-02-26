package FuncoesInternas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.read.biff.PasswordException;

/*
 @author Tiago e Paulo
 */
public class LerArquivoExcel {
    //Workbook's
    public Workbook Planilha    = new Workbook() {
        @Override
        public Sheet[] getSheets() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String[] getSheetNames() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet getSheet(int i) throws IndexOutOfBoundsException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet getSheet(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getNumberOfSheets() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Cell findCellByName(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Cell getCell(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Range[] findByName(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String[] getRangeNames() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isProtected() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void parse() throws BiffException, PasswordException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    //Sheet's
    public Sheet[]  Sh;
    
    //File's
    public File     NomeArquivo;
    
    //String's
    public String   Pasta;
    public String   Mensagem;
    public String   Texto;
    
    //Vetores
    ArrayList dadosPlanilha                         = new ArrayList();
    
    //Especiais
    FormataCampoComEspacos                  fccc    = new FormataCampoComEspacos();
    InverterData                            invdata = new InverterData();
    
    public ArrayList LerArquivoExcel(String pasta){
        Pasta = pasta;
        if(!Pasta.substring(Pasta.length() - 3, Pasta.length()).equalsIgnoreCase("xls")){
            Mensagem = "Extensão do Arquivo inválida!\nExtensão do arquivo deve ser xls!";
            new MostraMensagem(Mensagem);
            return null;
        }
        try{
            Planilha    = Workbook.getWorkbook(new File(Pasta));
            
            Sh = Planilha.getSheets();
            for(Sheet Sh1 : Sh) {
                for(int i = 3; i < Sh1.getRows(); i++){
                    Texto = "";
                    Texto  = fccc.FormatarCampoComEspacos   (Sh1.getCell(1, i).getContents(), 16, 0);   //Código Plano Referencial
                    if(Texto.replace(" ", "").equals(""))continue;
                    Texto += fccc.FormatarCampoComEspacos   (Sh1.getCell(2, i).getContents(),800, 0);   //Descricao Plano Referencial
                    if(!Sh1.getCell(3, i).getContents().replace(" ", "").equals("")){//Data Inicial
                        Texto += invdata.inverterData       (Sh1.getCell(3, i).getContents(), 2);
                    }else{
                        Texto += fccc.FormatarCampoComEspacos("", 10, 0);
                    }
                    Texto += fccc.FormatarCampoComEspacos   (Sh1.getCell(4, i).getContents(), 10, 0);   //Data Final
                    Texto +=                                 Sh1.getCell(6, i).getContents();           //Tipo Plano Referencial
                    Texto += fccc.FormatarCampoComEspacos   (Sh1.getCell(7, i).getContents(), 13, 0);   //Codigo Plano Referencial Superior
                    Texto += fccc.FormatarCampoComEspacos   (Sh1.getCell(8, i).getContents(),  1, 0);   //Nível
                    Texto += fccc.FormatarCampoComEspacos   (Sh1.getCell(9, i).getContents(),  1, 0);   //Natureza
                    Texto +=                                 Sh1.getCell(10, i).getContents();          //Orientações
                    dadosPlanilha.add(Texto);
                }
            }
        }catch(Exception erro){
            Mensagem = "Erro: arquivo excel deve estar no formato 97-2003";
            new MostraMensagem(Mensagem);
            dadosPlanilha.clear();
        }
        return dadosPlanilha;
    }
}
