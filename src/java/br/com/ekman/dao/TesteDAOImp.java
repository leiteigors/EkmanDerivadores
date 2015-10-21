/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.dao;

import br.com.ekman.modelo.Teste;
import br.com.ekman.util.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Igor
 */
public class TesteDAOImp implements DAO {
    
    private Connection connection;
    
    public TesteDAOImp() throws Exception{
        try{
            this.connection = ConexaoMySQL.getConnection();
        }
        catch(Exception e) {
            throw new Exception("Erro: " + "\n" + e.getMessage());
        }
    }
    
    @Override
    public void salvarTeste(Teste myTeste) throws Exception{
        PreparedStatement myPreparedStatement = null;
        Connection connection = null;
        if(myTeste==null)
            throw new 
                    Exception("O valor passado não pode ser nulo!");
        
        try {
            String sql = "INSERT INTO Teste (CORPOEMAIL,DATADATE)" + "VALUES(?,?)";
            connection = this.connection;
            myPreparedStatement = connection.prepareStatement(sql);
            myPreparedStatement.setString(1, myTeste.getCorpoEmail());
            SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
            myPreparedStatement.setString(2, myDateFormat.format(myTeste.getDataDate().toString()));
            myPreparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new Exception("Erro ao inserir dados" + e);
        } finally {
            ConexaoMySQL.closeConnection(connection, myPreparedStatement);
        }
    }
    
}
