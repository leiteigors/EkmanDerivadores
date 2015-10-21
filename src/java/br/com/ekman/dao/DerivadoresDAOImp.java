/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.dao;

import br.com.ekman.modelo.Derivadores;
import br.com.ekman.modelo.Teste;
import br.com.ekman.util.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Igor
 */
public class DerivadoresDAOImp implements DAODerivadores {
        private Connection connection;
    
    public DerivadoresDAOImp() throws Exception{
        try{
            this.connection = ConexaoMySQL.getConnection();
        }
        catch(Exception e) {
            throw new Exception("Erro: " + "\n" + e.getMessage());
        }
    }
    
    
    public void salvarDerivadores(Derivadores myDerivadores) throws Exception{
        PreparedStatement myPreparedStatement = null;
        Connection connection = null;
        if(myDerivadores==null)
            throw new 
                    Exception("O valor passado não pode ser nulo!");
        
        try {
            //String sql = "INSERT INTO Boias (asset_id,data_date)" + "VALUES(?,?)";
            String sql = "insert into boias (asset_id,data_date,time_year,time_month,time_day,time_hour,time_min,sst,gps_lat,gps_lon,tipo)"
                    + "values (?," + "" + "?" + ",?,?,?,?,?,?,?,?,?)";
            connection = this.connection;
            myPreparedStatement = connection.prepareStatement(sql);
            myPreparedStatement.setString(1, myDerivadores.getAssetId());
            //SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            myPreparedStatement.setString(2, myDerivadores.getDataDate());
            myPreparedStatement.setInt(3, Integer.parseInt(myDerivadores.getTimeYear()));
            myPreparedStatement.setInt(4, Integer.parseInt(myDerivadores.getTimeMonth()));
            myPreparedStatement.setInt(5, Integer.parseInt(myDerivadores.getTimeDay()));
            myPreparedStatement.setInt(6, Integer.parseInt(myDerivadores.getTimeHour()));
            myPreparedStatement.setInt(7, Integer.parseInt(myDerivadores.getTimeMin()));
            myPreparedStatement.setString(8, myDerivadores.getSst());
            myPreparedStatement.setString(9, myDerivadores.getGps_lat());
            myPreparedStatement.setString(10,myDerivadores.getGps_lon());
            myPreparedStatement.setInt(11, 1);
            myPreparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new Exception("Erro ao inserir dados" + e);
        } finally {
            ConexaoMySQL.closeConnection(connection, myPreparedStatement);
        }
    }
    
    public Date selecionarMaiorData() throws Exception {
        PreparedStatement myPreparedStatement = null;
        Connection myConnection = null;
        Date maiorData = new Date();
        //if(myDerivadores==null)
        //    throw new 
        //            Exception("O valor passado não pode ser nulo!");
        try {
            //String sql = "INSERT INTO Boias (asset_id,data_date)" + "VALUES(?,?)";
            String sql = "select max(b.data_date) as maiorData from boias b";
            connection = this.connection;
            myPreparedStatement = connection.prepareStatement(sql);
            ResultSet myResultSet = myPreparedStatement.executeQuery();
            //negar if para prd 
            //if (myResultSet.next() && myResultSet.getString(1).substring(0, 19).equals(myDerivadores.getDataDate())) {
            //return new Derivadores("", myResultSet.getString(1).substring(0, 19));
            while(myResultSet.next()){
                if (myResultSet.getString("maiorData") != null){
                    DateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                    Date data = myFormat.parse(myResultSet.getString("maiorData").substring(0, 19));
                    maiorData = myFormat.parse(myFormat.format(data));
                } else return null;
            }
            
            //else return null;
        } catch(SQLException e) {
            throw new Exception("Erro ao inserir dados" + e);
        }
        return maiorData;
    }

}
