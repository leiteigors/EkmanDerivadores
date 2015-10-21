/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.timer;

import br.com.ekman.dao.DAO;
import br.com.ekman.dao.TesteDAOImp;
import br.com.ekman.modelo.Teste;
import br.com.ekman.util.ConexaoCaixaGmail;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.mail.MessagingException;
/**
 *
 * @author Igor
 */
public class TimerTaskProjeto extends TimerTask{
    public TimerTaskProjeto() {
        
    }
    
    public void run() {
        try {
            SimpleDateFormat myDateFormat = new SimpleDateFormat("hh:mm:ss");
            //descreve inicio da rotina;
            System.out.println("\n" + myDateFormat.format(new Date()) + " = Task Running");
            
            //instancia objeto que entra no servidor de email;
            ConexaoCaixaGmail myCaixaGmail = new ConexaoCaixaGmail();            
        
        }catch (Exception e) {
            e.printStackTrace();        
        } 
        
        }
}
