/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.util;

import br.com.ekman.dao.DAO;
import br.com.ekman.dao.DAODerivadores;
import br.com.ekman.dao.DerivadoresDAOImp;
import br.com.ekman.dao.TesteDAOImp;
import br.com.ekman.modelo.Derivadores;
import br.com.ekman.modelo.Teste;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

/**
 *
 * @author Igor
 */
public class ConexaoCaixaGmail {
    
    private String reposta;
    
    public ConexaoCaixaGmail() throws MessagingException, IOException {
        Properties myProperties = System.getProperties();
        //myProperties.put("mail.pop.host", "mail.gmail.com");
        myProperties.setProperty("mail.store.protocol", "imaps");
        
        try 
        {
            //PropertiesMail myPropertiesMail = new PropertiesMail();
            //Properties myProperties = System.getProperties();
            //myProperties.put("mail.pop.host", myPropertiesMail.getHost());
            //myProperties.setProperty("mail.store.protocol", "imaps");
            
            //Authenticator auth = new br.com.Util.PopAuthentication();
            //Session mySession    = Session.getDefaultInstance(myProperties, auth);
           
            Session mySession = Session.getDefaultInstance(myProperties,null); 
         
            //Store myStore = mySession.getStore("pop3");
            Store myStore = mySession.getStore("imaps");
         
            //myStore.connect(myPropertiesMail.getHost(), myPropertiesMail.getUser(), myPropertiesMail.getPassword());
            //myStore.connect("imap.gmail.com","leiteigors@gmail.com","@blackdiamond");
            myStore.connect("imap.gmail.com","drifters.karoon@gmail.com","drifterskaroon2012!");
        
            Folder myFolder = myStore.getFolder("INBOX");
            myFolder.open(Folder.READ_WRITE);
                    
            //SearchTerm olderThan = new ReceivedDateTerm(ComparisonTerm.LT, new Date());
            //SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, new Date());
            //SearchTerm andThan = new AndTerm(olderThan, newerThan);
            
            // search for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);

            Message myMessage[] = myFolder.search(unseenFlagTerm);

            // Message myMessage[] = myFolder.getMessages();
            //Message myMessage[] = myFolder.search(andThan);
            
            //tentativa ler email
            
            for (int i = 0; i < myMessage.length; i++)  
            //for (int i = 0; i < 2; i++)
            {       
                myMessage[i].setFlag(Flags.Flag.SEEN, true);
                ContentType ct = new ContentType(myMessage[i].getContentType());
                System.out.println( i + ": " + myMessage[i].getFrom()[0] +
                        "\t" + ct.getPrimaryType() + "/" + ct.getSubType() +
                        "\t" + myMessage[i].getSubject());
                String verType = ct.getPrimaryType();
                String verSubj = myMessage[i].getSubject();
                
                if (ct.getPrimaryType().equals("TEXT") && (myMessage[i].getFrom()[0].toString().equals("data@ams.joubeh.com")) == true);
                {
                    showMultiPart(myMessage[i]);
                }
            }
            
            //processMessage(myMessage);
            myFolder.expunge();        
            myFolder.close(true);
            myStore.close();        
        }
        catch(MessagingException e) {
            e.printStackTrace();
        }
    }
    
//    public String processeMessage(Message[] message) throws MessagingException, IOException {
//        if(message == null || message.length == 0) {
//            //System.out.println("Nenhuma mensagem encontrada");
//            setReposta("Nenhuma msg encontrada!");
//            return getReposta();            
//        } else {
//            for (int i = 0, n = message.length; i < 1; i++){
//                System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
//                
//                String content = message[i].getContent().toString();
//                System.out.print(content);
//                setReposta(content);
//                
//            }
//            return getReposta();
//        }
//    }
    
    private void processMessage( Message[] message ) throws MessagingException, IOException{
        //String content = null;
        if( message == null || message.length==0 ){
            System.out.println("Nenhuma mensagem encontrada");
        }else{
            DAO dao;
            for (int i = 0, n = message.length; i < n; i++) {
                System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
                //String content = message[i].getContent().toString();
                
    
            
                System.out.println(message[i].getContent());
                try {                    
                    dao = new TesteDAOImp();
                    dao.salvarTeste(new Teste(message[i].getContent().toString(), new Date()));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void showMultiPart(Message m) {
        try
        {
            DAODerivadores dao;
            MimeMultipart content = (MimeMultipart)m.getContent();
            //Multipart content = m.getContent();
            for( int i=0; i<content.getCount(); i++ )
            //for( int i=0; i<2; i++ )
            {
                BodyPart part = content.getBodyPart( i );
                ContentType ct = new ContentType(part.getContentType());
                if((ct.getPrimaryType().equals("TEXT")) && (ct.getSubType().equals("PLAIN"))) {
                System.out.println( "\t\tContent-type: " + ct.getPrimaryType() + "/" + ct.getSubType() );
                part.toString();
                System.out.println( "\t\tContent\n\r" + part.getContent().toString() );
                dao = new DerivadoresDAOImp(); 
                String conteudo = part.getContent().toString();
                String s[] = conteudo.split(" ");
                //System.out.println(s[1].substring(3,19));
                //System.out.println(s[2]);
                //System.out.println(s[3]);
                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                Date dataEmail = myFormat.parse(s[2].substring(5, 15) + " " + s[3].substring(0, 8));
                Date dataMaxima = dao.selecionarMaiorData();
                //if (dao.selecionarMaiorData().before(new Date()) || dao.selecionarMaiorData() == null){
                if (dataMaxima == null) {
                    dao.salvarDerivadores(
                    new Derivadores(s[1].substring(3,19),
                    s[2].substring(5, 15) + " " + s[3].substring(0, 8),
                    s[2].substring(5, 9),
                    s[2].substring(10, 12),
                    s[2].substring(13, 15),
                    s[3].substring(0, 2),
                    s[3].substring(3, 5),
                    s[8].substring(30,35),
                    s[8].substring(80,88),
                    s[8].substring(98,105),
                    s[8].substring(30,35)
                    ));             
                }else 
                if (dataMaxima.compareTo(dataEmail) == -1 && dataMaxima != dataEmail) {
                    dao.salvarDerivadores(
                    new Derivadores(s[1].substring(3,19),
                    s[2].substring(5, 15) + " " + s[3].substring(0, 8),
                    s[2].substring(5, 9),
                    s[2].substring(10, 12),
                    s[2].substring(13, 15),
                    s[3].substring(0, 2),
                    s[3].substring(3, 5),
                    s[8].substring(30,35),
                    s[8].substring(80,88),
                    s[8].substring(98,105),
                    s[8].substring(30,35)
                    ));
                }
                }
            }
        } catch( Exception e ){
                e.printStackTrace();            
        }        
    }
  
    

    /**
     * @return the reposta
     */
    public String getReposta() {
        return reposta;
    }

    /**
     * @param reposta the reposta to set
     */
    public void setReposta(String reposta) {
        this.reposta = reposta;
    }
    
}
