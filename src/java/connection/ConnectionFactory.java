/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import exception.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author lucas
 */
public class ConnectionFactory implements AutoCloseable {
    private static String DRIVER = "org.postgresql.Driver";
    private static String URL = "jdbc:postgresql://localhost:5432/java";
    private static String LOGIN = "postgres";
    private static String PASSWORD = "postgres";
    
    private Connection con = null;
    
    public Connection getConnection() throws exception.DAOException{
        if(con == null){
            try{
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            } catch(ClassNotFoundException e){
                throw new DAOException("Driver não encontrado.",e);
            } catch(java.sql.SQLException e){
                throw new DAOException("Erro ao conectar ao DB.",e);
            }
        }
        return con;
    }

    @Override
    public void close() throws Exception {
        if(con!= null){
            try{
                con.close();
                con = null;
            } catch(Exception e){
                System.out.println("Erro fechando a conexão");
                e.printStackTrace();
            }
        }
    }
}
