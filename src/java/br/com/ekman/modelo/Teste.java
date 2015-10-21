/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.modelo;

//import com.sun.msv.datatype.xsd.DateTimeType;
import java.util.Date;

/**
 *
 * @author Igor
 */
public class Teste {
    
    private String corpoEmail;    
    private Date dataDate;

    public Teste(String corpoEmail,Date dataDate) {
        this.corpoEmail = corpoEmail;
        this.dataDate = dataDate;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }
    
    public String getCorpoEmail() {
        return corpoEmail;
    }

    public void setCorpoEmail(String corpoEmail) {
        this.corpoEmail = corpoEmail;
    }

}
