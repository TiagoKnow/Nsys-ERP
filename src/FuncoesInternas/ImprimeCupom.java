package FuncoesInternas;

import BeansNS.BeanEmpresas;
import Beans.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import Dao.*;
import TelasDeConfiguracoes.*;
import Parametros.parametrosNS;
import java.text.SimpleDateFormat;

/**
 * @author Tiago
 */
public class ImprimeCupom {
    //String
    String dataLancamento  = "";
    String nomeArquivo     = "";
    String Mensagem        = "";
    
    //int
    int codigoRecibo    = 0;
    int qtdItens        = 0;
    
    //floats
    double valorTotalCredito    = 0;
    double valorTotalDebito     = 0;
    
    //Vetores
    ArrayList linhasArquivo                 = new ArrayList();
    ArrayList dadosCupom                    = new ArrayList();
    ArrayList dadosOrdemServicoItens        = new ArrayList();
    
    //Bean's
    BeanEmpresas                be          = new BeanEmpresas();
    BeanUsuarios                bu          = new BeanUsuarios();
    BeanClientes                bc          = new BeanClientes();
    BeanProdutos                bp          = new BeanProdutos();
    BeanServicos                bser        = new BeanServicos();
    BeanCupom                   bcu         = new BeanCupom();
    BeanFormasPagamentos        bfp         = new BeanFormasPagamentos();
    BeanOrdemServico            bos         = new BeanOrdemServico();
    BeanOrdemServicoItens       bosi        = new BeanOrdemServicoItens();
    BeanOrdemServicoPagamentos  bosp        = new BeanOrdemServicoPagamentos();

    //Outros
    SimpleDateFormat sdfDia = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat sdfHoraMinuto = new SimpleDateFormat("HH:mm");
    
    //Especiais
    FormataCPFCNPJ              FCpfCnpj    = new FormataCPFCNPJ();
    InverterData                invdata     = new InverterData();
    
    //Telas
    
    public boolean gerarArquivo(ArrayList DadosCupom, ArrayList DadosOrdemServicoItens, String NomeArquivo){
        dadosCupom                  = DadosCupom;
        dadosOrdemServicoItens      = DadosOrdemServicoItens;
        nomeArquivo                 = NomeArquivo;
        
        PegaDadosCupom();
        SetaValores();
        try{
            linhasArquivo.add(be.nomeEmpresa);
            linhasArquivo.add(be.enderecoEmpresa);
            linhasArquivo.add(be.cidadeEmpresa);
            linhasArquivo.add(be.cnpjEmpresa);
            linhasArquivo.add("================================================================================================" );
            linhasArquivo.add(bcu.dataGerado + " " + bcu.horaGerado);
            linhasArquivo.add("CPF/CNPJ consumidor: " + bcu.cpfCnpj);
            
            for(int i = 0; i < dadosOrdemServicoItens.size(); i++){
                bosi = new BeanOrdemServicoItens();
                bosi.idOrdemServicoItem     = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).idOrdemServicoItem;
                bosi.idEmpresa              = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).idEmpresa;
                bosi.codigoGrupo            = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoGrupo;
                bosi.codigoEmpresa          = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoEmpresa;
                bosi.codigoOrdemServico     = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoOrdemServico;
                bosi.codigoOrdemServicoItem = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoOrdemServicoItem;
                bosi.codigoServicoProduto   = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoServicoProduto;
                bosi.codigoUsuario          = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).codigoUsuario;
                bosi.dataCadastro           = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).dataCadastro;
                bosi.horaCadastro           = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).horaCadastro;
                bosi.tipo                   = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).tipo;
                bosi.valorUnitario          = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).valorUnitario;
                bosi.quantidade             = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).quantidade;
                bosi.valorTotal             = ((BeanOrdemServicoItens)(dadosOrdemServicoItens.get(i))).valorTotal;
                
                qtdItens = i + 1;
                
                linhasArquivo.add("T: " + bosi.tipo + "   " + bosi.idOrdemServicoItem + "   " + "descrição do item" + "   " + bosi.valorUnitario + "   " + bosi.quantidade + "   " + bosi.valorTotal);
            }
            
            linhasArquivo.add("================================================================================================");
            linhasArquivo.add("FB55C4272F549AT22545C001" );
            linhasArquivo.add("================================================================================================");
            linhasArquivo.add("                                                                  Qtd itens:    " + qtdItens + "");
            linhasArquivo.add("                                                                   Subtotal: " + "vrtotal00" + "");
            linhasArquivo.add("                                                                   Desconto: " + "vrtotal00" + "");
            linhasArquivo.add("Nota" + " " + "Data: " + " " + "Hora: " + " ");
            linhasArquivo.add("                                                                                              BR");
            
            boolean incluiuLinhas = inserirLinha(linhasArquivo); 
            
            return incluiuLinhas;
        }catch(Exception e){
            Mensagem = "O erro foi na função gerar arquivo de exportação do tef: " + e.getMessage();
            new MostraMensagem(Mensagem);
            return false;
        }
    }

    public boolean inserirLinha(ArrayList linhas){
        File novoArquivo = new File("C:\\recibos\\" + nomeArquivo + ".nsc");
        try {

            if(novoArquivo.exists() == true){
                Mensagem = "O arquivo já existe!";
                new MostraMensagem(Mensagem);
                return true;
            }
            novoArquivo.createNewFile();
            FileWriter a = new FileWriter(novoArquivo,true);

            PrintWriter detalhes = new PrintWriter(a, true);

            for(int i = 0; i < linhas.size(); i++){
                detalhes.println((String)(linhas.get(i)));
            }
            Mensagem = "Recibo gerado ao tef com sucesso!";
            new MostraMensagem(Mensagem);
        }catch (Exception erro){
            Mensagem = "O erro foi ao criar fisicamente o arquivo: " + erro;
            new MostraMensagem(Mensagem);
        }
        return true;
    }

    private void PegaDadosCupom(){
        bcu.Tipo                = (String)      dadosCupom.get(0);
        bcu.codigoOrdemVenda    = (int)         dadosCupom.get(1);
        bcu.dataGerado          = (String)      dadosCupom.get(2);
        bcu.dataGerado          = invdata.inverterData(bcu.dataGerado, 2);
        bcu.dataGerado          = invdata.inverterData(bcu.dataGerado, 1);
        bcu.horaGerado          = (String)      dadosCupom.get(3);
        bcu.horaGerado          = bcu.horaGerado.substring(0, 2) + ":" + bcu.horaGerado.substring(2, 4) + ":" + bcu.horaGerado.substring(4, 6);
        bcu.cpfCnpj             = (String)      dadosCupom.get(4);
    }
    
    private void SetaValores(){
        be.nomeEmpresa          = FormataValores(parametrosNS.be.nomeEmpresa);
        be.enderecoEmpresa      = parametrosNS.be.enderecoEmpresa + ", " + parametrosNS.be.numeroEmpresa + " - " + parametrosNS.be.bairroEmpresa;
        be.enderecoEmpresa      = FormataValores(parametrosNS.be.enderecoEmpresa);
        be.cidadeEmpresa        = parametrosNS.be.cidadeEmpresa + " - " + parametrosNS.be.ufEmpresa + " CEP: " + parametrosNS.be.cepEmpresa;
        be.cidadeEmpresa        = FormataValores(parametrosNS.be.cidadeEmpresa);
        be.cnpjEmpresa          = FCpfCnpj.FormataCPFCNPJ(parametrosNS.be.cnpjEmpresa);
        be.cnpjEmpresa          = "CNPJ: " + parametrosNS.be.cnpjEmpresa;
    }
    
    private String FormataValores(String Valor){
        int Tamanho = 96 - Valor.length();
        if(Tamanho % 2 == 1){
            Tamanho = Tamanho - 1;
            Valor   = Valor + " ";
        }
        Tamanho = Tamanho / 2;
        for(int i = 0; i < Tamanho; i++){
            Valor           = " " + Valor + " ";
        }
        return Valor;
    }
    
}
