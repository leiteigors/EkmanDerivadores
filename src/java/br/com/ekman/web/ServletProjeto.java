/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Servlet;

/**
 *
 * @author Igor
 */

import br.com.ekman.timer.TimerTaskProjeto;
import br.com.ekman.util.ConexaoCaixaGmail;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ServletProjeto implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Timer timer = new Timer();
        //TimerTask myTimerTask = new TimerTaskProjeto();
        //Long period = new Long("1800000"); //meia hora
        //Long period = new Long("900000");    //15 min
        //Long period = new Long("60000");
        //timer.schedule(myTimerTask, new Date(), period.longValue());
            try {
            SimpleDateFormat myDateFormat = new SimpleDateFormat("hh:mm:ss");
            //descreve inicio da rotina;
            System.out.println("\n" + myDateFormat.format(new Date()) + " = Task Running");
            
//            //instancia objeto que entra no servidor de email;
            ConexaoCaixaGmail myCaixaGmail = new ConexaoCaixaGmail();            
//        
        }catch (Exception e) {
            e.printStackTrace();        
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        
    }
    
    
}