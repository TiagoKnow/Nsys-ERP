package FuncoesInternas;

import Parametros.parametrosNS;
import java.util.ArrayList;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/*
 @author Tiago e Paulo 13/02/2017 15:10
 */
public class EmailAnexoEnviar {
    //Email's
    String destinatarioEmail                = "";
    String assuntoEmail                     = "";
    String mensagemEmail                    = "";
    String descriptionEmail                 = "";
    String nameEmail                        = "";
    String Mensagem                         = "";
    
    //Vetores
    ArrayList dadosEmail                    = new ArrayList<Object>();
    ArrayList dadosAnexo                    = new ArrayList<Object>();
    
    //Especiais
    MultiPartEmail  MulPartEmail;
    SimpleEmail     SimpEmail       = new SimpleEmail();
    EmailAttachment Attachment;
    
    public void EnviarEmailAnexo(ArrayList DadosEmail, ArrayList DadosAnexo){
        dadosEmail          = DadosEmail;
        dadosAnexo          = DadosAnexo;
        
        destinatarioEmail   = (String)  dadosEmail.get(0);
        assuntoEmail        = (String)  dadosEmail.get(1);
        mensagemEmail       = (String)  dadosEmail.get(2);
        
        if(!dadosAnexo.isEmpty())
            CriaAnexoEmail();
        else
            CriaMensagemDeEmail();
    }
    
    private void CriaAnexoEmail(){
        Attachment          = new EmailAttachment();
        Attachment.setDisposition(EmailAttachment.ATTACHMENT);
        CriaMensagemDeEmail();
    }
    
    private void CriaMensagemDeEmail(){
        MulPartEmail        = new MultiPartEmail();
        try{
            MulPartEmail.setHostName(parametrosNS.bue.servidorEmail);
            MulPartEmail.addTo      (destinatarioEmail.replace(" ", "").replace(";", ""));
            MulPartEmail.setFrom    (parametrosNS.bue.email, parametrosNS.bu.nome);
            MulPartEmail.setSubject (assuntoEmail);
            MulPartEmail.setMsg     (mensagemEmail);
            MulPartEmail.setAuthentication(parametrosNS.bue.usuarioServidorEmail, parametrosNS.bue.senhaServidorEmail);
            if(!dadosAnexo.isEmpty()){
                for(int i = 0; i < dadosAnexo.size(); i++){
                    Attachment.setPath(String.valueOf(dadosAnexo.get(i)));
                    MulPartEmail.attach     (Attachment);
                }
            }
            MulPartEmail.setSSL(true);
            MulPartEmail.setTLS(true);
            MulPartEmail.setSmtpPort(parametrosNS.bue.portaEmail);
            MulPartEmail.send();
            
            Mensagem = "Email enviado com sucesso!";
            new MostraMensagem(Mensagem);
        }catch(EmailException erro){
            Mensagem = "Erro ao enviar email: " + erro.getMessage();
            new MostraMensagem(Mensagem);
        }
    }
    
}
