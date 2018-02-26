//package funcoesInternas;
//
////import Beans.beanArquivoRemessaBradesco;;
////import Beans.BeanConcessionarios;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.util.Vector;
//import javax.swing.JOptionPane;
//
//
//public class gerarArquivoBradesco {
//
//    public boolean gerarArquivo(beanArquivoRemessaBradesco b, Vector dadosC, String empresa){
//        try{
//            Vector linhasArquivo = new Vector();
//            int y = 1;
//            //cabeçalho ASSOC MITRA CEMITERIO GETHSEMANI
//                String dataEmissaoBoleto = b.getDataEmissao();
//                String mesEm, diaEm, anoEm = null;
//
//                mesEm = dataEmissaoBoleto.substring(3, 5);
//                diaEm = dataEmissaoBoleto.substring(0, 2);
//                anoEm = dataEmissaoBoleto.substring(8, 10);
//
//                dataEmissaoBoleto = diaEm + mesEm + anoEm;
//
//           if(empresa.equals("mitra-54320-9")){
//                //Cemitério Gethsemani
//                String identificacaoDoRegistro = "0";
//                String identificacoDoArquivoRemessa = "1";
//                String literalRemessa = "REMESSA";
//                String codigoDeServico = "01";
//                String literalServico = "COBRANCA       ";
//              //String codigoDaEmpresa = "00000000000004086900";
//                String codigoDaEmpresa = "00000000000004425671";
//              //String nomeDaEmpresa = "ASSOC MITRA CEMITERIO GETHSEMA";
//                String nomeDaEmpresa = "CEMITERIO GETHSEMANI          ";
//                String numeroDoBradesco = "237";
//                String nomeDoBancoPorExtenso = "BRADESCO       ";
//                String dataGravacaoArquivo = dataEmissaoBoleto;
//                String branco = "        ";
//                String identificacaoDoSistema = "  ";
//                String numeroSequencialArquivo = inverterString.inverter("" + b.getCodigoArquivo(), 7, "0");
//                //String numeroSequencialArquivo = "0000002"; //criar procedimento para ir rodando conforme forem sendo criados novos arquivos
//                String branco2 = "                                                                                                                                                                                                                                                                                     ";
//                String nSequencialDeRegistro = "000001";
//
//
//                linhasArquivo.add(identificacaoDoRegistro + identificacoDoArquivoRemessa + literalRemessa +
//                        codigoDeServico + literalServico + codigoDaEmpresa + nomeDaEmpresa + numeroDoBradesco +
//                        nomeDoBancoPorExtenso + dataGravacaoArquivo + branco + identificacaoDoSistema + numeroSequencialArquivo +
//                        branco2 + nSequencialDeRegistro);
//            }
//            if(empresa.equals("mitra-40220")){
//                //Mitra Diocesana de Campo Limpo
//                String identificacaoDoRegistro = "0";
//                String identificacoDoArquivoRemessa = "1";
//                String literalRemessa = "REMESSA";
//                String codigoDeServico = "01";
//                String literalServico = "COBRANCA       ";
//                String codigoDaEmpresa = "00000000000000309724";
//                String nomeDaEmpresa = "MITRA DIOCESANA CAMPO LIMPO   ";
//                String numeroDoBradesco = "237";
//                String nomeDoBancoPorExtenso = "BRADESCO       ";
//                String dataGravacaoArquivo = dataEmissaoBoleto;
//                String branco = "        ";
//                String identificacaoDoSistema = "  ";
//                String numeroSequencialArquivo = inverterString.inverter("" + b.getCodigoArquivo(), 7, "0");
//                String branco2 = "                                                                                                                                                                                                                                                                                     ";
//                String nSequencialDeRegistro = "000001";
//
//
//                linhasArquivo.add(identificacaoDoRegistro + identificacoDoArquivoRemessa + literalRemessa +
//                        codigoDeServico + literalServico + codigoDaEmpresa + nomeDaEmpresa + numeroDoBradesco +
//                        nomeDoBancoPorExtenso + dataGravacaoArquivo + branco + identificacaoDoSistema + numeroSequencialArquivo +
//                        branco2 + nSequencialDeRegistro);
//            }
//
//            for(int i = 0; i < dadosC.size(); i++){
//            //for(int i = 2800; i < dadosC.size(); i++){
//                String identificacaoRegistro = "1";
//                String agenciaDebito = "00000";
//                String digitoAgenciaDebito = "0";
//                String razaoContaCorrente = "00000";//12
//                String contaCorrente = "0000000";//19
//                String digitoContaCorrente = "0";//20
//
//                String carteira = null;
//                String agencia = null;
//                String conta = null;
//                
//                if(empresa.equals("mitra-40220")){
//                    carteira = "0009";//21 - 24
//                    agencia = "01449";//25 - 29
//                    conta = "00402206";//30 37
//                }
//                if(empresa.equals("mitra-54320-9")){
//                    carteira = "0009";//21 - 24
//                    agencia = "01449";//25 - 29
//                    conta = "00543209";//30 37
//                    //conta = "00000035";//30 37
//                }
//
//                String identificacaoEmpresaCedente = carteira + agencia + conta;
//                
//                String nControleParticipante = "                         ";
//                String codigoBancoASerDebitado = "000";//sinal de débito automático
//                String zeros = "00000";
//                String identificacaoDoTituloBanco = "000000000000";
//                String descontoBonificacaoPorDia = "0000000000";
//                String condicaoParaEmissaodaPapeleta = "1";
//                String identSeEmitePapeletaDebitoAutomatico = "N";
//                String identificacaoParaOperacaodoBanco = "          ";
//                String indicadorRateioCredito = " ";
//                String enderecamentoParaAvisodoDebito = "1";
//                String branco = "  ";
//                String identificacaoOcorrencia = "01";  //01 = remessa
//
//                //numero do documento é o numero que futuramente será utilizado para dar baixa no kge
//                //Neste primeiro momento estamos usando o número do contrato, porem futuramente
//                //Obrigatóriamente será a CI - código interno
//                String nDocumento = ((String)((BeanConcessionarios)dadosC.get(i)).getNCONTRATO());
//                int t_nDocumento = nDocumento.length();
//                if(t_nDocumento < 6){
//                    nDocumento = inverterString.inverter(nDocumento, 6, "0");
//                }else{
//                //Caso a string seja maior do que cabe no campo, temos que truncar ela
//                //temos que pegar no máximo xx caracteres.
//                nDocumento = nDocumento.substring(0, 6);
//                    nDocumento = inverterString.inverter(nDocumento, 6, "0");
//                }
//
//                //CÓDIGO DE MANUTENÇÃO
//                String codManut = b.getCodigoManutencao(); //2 posições
//                if(codManut.length() < 2){
//                    codManut = inverterString.inverter(codManut, 2, "0");
//                }else{
//                codManut = codManut.substring(0, 2);
//                    codManut = inverterString.inverter(codManut, 2, "0");
//                }
//
//
//
//                //MÊS DE REFERENCIA
//                String mesReferencia = b.getMesRef(); //2 posições
//                if(mesReferencia.length() < 2){
//                    mesReferencia = inverterString.inverter(mesReferencia, 2, "0");
//                }else{
//                mesReferencia = mesReferencia.substring(0, 2);
//                    mesReferencia = inverterString.inverter(mesReferencia, 2, "0");
//                }
//
//
//                
//
//
//                //tratar este campo
//                String dtVencimentoDoTitulo = b.getDataDeVencimento();
//                String mesV, diaV, anoV = null;
//
//                mesV = dtVencimentoDoTitulo.substring(3, 5);
//                diaV = dtVencimentoDoTitulo.substring(0, 2);
//                anoV = dtVencimentoDoTitulo.substring(8, 10);
//
//                dtVencimentoDoTitulo = diaV + mesV + anoV;
//
//
//                //tratar este campo
//                String valorTitulo = "" + b.getValorDocumento();
//                valorTitulo = valorTitulo.replace(".", "");
//                valorTitulo = valorTitulo.replace(",", "");
//
//                valorTitulo = inverterString.inverter(valorTitulo, 13, "0");
//                
//                String bancoEncarregadoCobranca = "000";
//                String agenciaDepositaria = "00000";
//                String especieDeTitulo = "01";
//                String identificacao = "N";
//
//                //tratar este campo
//                String dataEmissaoTitulo = b.getDataEmissao();
//                String mesE, diaE, anoE = null;
//
//                mesE = dataEmissaoTitulo.substring(3, 5);
//                diaE = dataEmissaoTitulo.substring(0, 2);
//                anoE = dataEmissaoTitulo.substring(8, 10);
//
//                dataEmissaoTitulo = diaE + mesE + anoE;
//
//                String instrucao1 = "00";
//                String instrucao2 = "00";
//                String valorASerCobradoPorDiaDeAtrazo = "0000000000000";
//                String dtLimiteParaConcessaoDesconto = "000000";
//                String valorDesconto = "0000000000000";
//                String valorIOF = "0000000000000";
//                String valorAbatimentoASerConcedidoOuCancelado = "0000000000000";
//                String identificacaoTipoSacado = "98";
//                String nInscricaoSacado = "00000000000000";
//
//
////=================NOME SACADO=========================================================================
//                //tratar este campo
//                String nomeSacado = ((String)((BeanConcessionarios)dadosC.get(i)).getRESP());
//                nomeSacado = a.avaliar(nomeSacado, 40);
//
//
//
////=================ENDEREÇO COMPLETO=========================================================================
//                String end = ((String)((BeanConcessionarios)(dadosC.get(i))).getENDRES());
//                String bai = ((String)((BeanConcessionarios)(dadosC.get(i))).getBAIRES());
//                String cid = ((String)((BeanConcessionarios)(dadosC.get(i))).getCIDRES());
//                String uf = ((String)((BeanConcessionarios)(dadosC.get(i))).getUFRES());
//
//                //tratar este campo
//                String enderecoCompleto = end + "-" + bai + "-" + cid + "-" + uf;
//
//                enderecoCompleto = a.avaliar(enderecoCompleto, 40);
//
//                //String menssagem1 = "            ";
//                  String menssagem1 = "            ";
//
//
//                //tratar este campo
//                String var_cep = ((String)((BeanConcessionarios)(dadosC.get(i))).getCEPRES());
//                var_cep = var_cep.replace("-", "");
//
//                var_cep = inverterString.inverter(var_cep, 8, "0");
//
//                String cep = var_cep;
//                cep = cep.substring(0, 5);
//
//                //tratar este campo
//                String sulfisoCep = var_cep;
//                sulfisoCep = sulfisoCep.substring(5, 8);
//
//
//                String sacadorAvalistaOuMenssagem2 = a.avaliar(b.getMenssagem1(), 60);
//
//              //"CEMITERIO GETHSEMANI - MORUMBI                              ";
//              //String sacadorAvalistaOuMenssagem2 = "                                                            ";
//                
//
//                int ns = y + 1;
//                String nSequencial = "" + ns;
//                nSequencial = inverterString.inverter(nSequencial, 6, "0");
//                y = y + 1; //incrementar a variavel para ela dar o número sequencial do arquivo nas últimas posições
//
//                linhasArquivo.add(identificacaoRegistro +
//                        agenciaDebito + digitoAgenciaDebito +
//                        razaoContaCorrente + contaCorrente +
//                        digitoContaCorrente + identificacaoEmpresaCedente +
//                        nControleParticipante + codigoBancoASerDebitado + zeros + identificacaoDoTituloBanco +
//                        descontoBonificacaoPorDia + condicaoParaEmissaodaPapeleta +
//                        identSeEmitePapeletaDebitoAutomatico + identificacaoParaOperacaodoBanco +
//                        indicadorRateioCredito + enderecamentoParaAvisodoDebito +
//                        branco + identificacaoOcorrencia + codManut + mesReferencia +nDocumento + dtVencimentoDoTitulo + valorTitulo + bancoEncarregadoCobranca +
//                        agenciaDepositaria + especieDeTitulo + identificacao + dataEmissaoTitulo + instrucao1 +
//                        instrucao2 + valorASerCobradoPorDiaDeAtrazo + dtLimiteParaConcessaoDesconto +
//                        valorDesconto + valorIOF + valorAbatimentoASerConcedidoOuCancelado +
//                        identificacaoTipoSacado + nInscricaoSacado + nomeSacado + enderecoCompleto +
//                        menssagem1 + cep + sulfisoCep + sacadorAvalistaOuMenssagem2 +
//                        nSequencial);
//
//                //processo de criação da 2a Linha dentro do mesmo registro
//                String tipoRegistro2 = "2";
//
//                String var_menssagem2 = a.avaliar(b.getMenssagem2(), 79);
//                var_menssagem2 = var_menssagem2 + ".";
//                String var_menssagem3 = a.avaliar(b.getMenssagem3(), 79);
//                var_menssagem3 = var_menssagem3 + ".";
//                String var_menssagem4 = a.avaliar(b.getMenssagem4(), 79);
//                var_menssagem4 = var_menssagem4 + ".";
//                String var_menssagem5 = a.avaliar(b.getMenssagem5(), 79);
//                var_menssagem5 = var_menssagem5 + ".";
//                String reserva = "                                             ";
//                String var_carteira = "009";
//                String var_agencia = agencia;
//                String var_nconta = conta;
//                //String var_nossoNumero = "           ";
//                String var_nossoNumero = "00000000000";
//                String dacNossoNumero = "0";
//
//                int ns2 = y + 1;
//                String nSequencial2 = "" + ns2;
//                nSequencial2 = inverterString.inverter(nSequencial2, 6, "0");
//                y = y + 1; //incrementar a variavel para ela dar o número sequencial do arquivo nas últimas posições
//
//                linhasArquivo.add(tipoRegistro2 + var_menssagem2 + var_menssagem3 + var_menssagem4
//                        + var_menssagem5 + reserva + var_carteira + var_agencia + var_nconta
//                        + var_nossoNumero + dacNossoNumero + nSequencial2);
//
//            }//final do for
//
//            //RODAPÉ
//            int ultimo = y + 1;
//            String ultimoNumero = inverterString.inverter("" + ultimo, 6, "0");
//            linhasArquivo.add("9                                                                                                                                                                                                                                                                                                                                                                                                         " + ultimoNumero);
//
//            inserirLinha(linhasArquivo, b.getNomeArquivo());
//            
//            return true;
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "O erro foi na função gerarArquivoBradesco: " + e.getMessage());
//            return false;
//        }
//        
//    }
//
//    public boolean inserirLinha(Vector linhas, String nomeDoArquivo){
//        //String nomeDoArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo:");
//
//        File novoArquivo = new File("C:\\boletos\\" + nomeDoArquivo + ".REM");
//        try {
//            boolean existe = novoArquivo.exists();
//
//            if(existe == false){
//                novoArquivo.createNewFile();
//                FileWriter a = new FileWriter(novoArquivo,true);
//
//                PrintWriter detalhes = new PrintWriter(a, true);
//
//                for(int i = 0; i < linhas.size(); i++){
//                    detalhes.println((String)(linhas.get(i)));
//                }
//
//                JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
//            }
//            if(existe == true){
//                JOptionPane.showMessageDialog(null, "O arquivo já existe!");
//            } 
//
//        } catch (Exception e) {
//            System.out.println("O erro foi: " + e);
//        }
//        return true;
//    }//fecha o método
//    adicionarEspacosVaziosDireita a = new adicionarEspacosVaziosDireita();
//    inverterString inverterString = new inverterString();
//}
