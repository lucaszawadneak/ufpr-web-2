/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Cliente;
import classes.Usuario;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ClienteDAO implements DAO<Cliente>{
    private static final String INSERT_QUERY = "INSERT INTO cliente (nome,cpf,email,data,rua,nr,cep,cidade,uf) values (?,?,?,?,?,?,?,?,?)";
    private static final String FIND_ALL_QUERY = "SELECT * from cliente;";
    private static final String FIND_ONE = "SELECT * FROM cliente WHERE cpf = ?";
    private static final String UPDATE = "UPDATE cliente SET nome=?,cpf=?,email=?,data=?,rua=?,nr=?,cep=?,cidade=?,uf=?";
    private static final String DELETE = "DELETE FROM cliente WHERE id = ?";
    private Connection con = null;
    
    
    public ClienteDAO(Connection con) throws DAOException{
        if(con == null){
            throw new DAOException("Conn null");
        }
        this.con = con;
    }
    

    @Override
    public Cliente find(String login) throws DAOException {
        System.out.println(login);
        try(PreparedStatement ps = con.prepareStatement(FIND_ONE)){
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setData(rs.getDate("data"));
                c.setRua(rs.getString("rua"));
                c.setNr(rs.getInt("nr"));
                c.setCep(rs.getString("cep"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setId(rs.getInt("id"));
               
                return c;
            }
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
        return null;
    }

    public List<Cliente> findAll() throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(FIND_ALL_QUERY)){
            List<Cliente> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setData(rs.getDate("data"));
                c.setRua(rs.getString("rua"));
                c.setNr(rs.getInt("nr"));
                c.setCep(rs.getString("cep"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setId(rs.getInt("id"));
                
               
                list.add(c);
            }
            return list;
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    public void insert(Cliente c) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(INSERT_QUERY)){
           ps.setString(1, c.getNome());
           ps.setString(2, c.getCpf());
           ps.setString(3, c.getEmail());
           ps.setDate(4, (java.sql.Date) c.getData());
           ps.setString(5, c.getRua());
           ps.setInt(6, c.getNr());
           ps.setString(7, c.getCep());
           ps.setString(8, c.getCidade());
           ps.setString(9, c.getUf());
           ps.executeUpdate();
           
           System.err.println(c.getNome());
        }

        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    @Override
    public void update(Cliente c) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(UPDATE)){
           ps.setString(1, c.getNome());
           ps.setString(2, c.getCpf());
           ps.setString(3, c.getEmail());
           ps.setDate(4, (java.sql.Date) c.getData());
           ps.setString(5, c.getRua());
           ps.setInt(6, c.getNr());
           ps.setString(7, c.getCep());
           ps.setString(8, c.getCidade());
           ps.setString(9, c.getUf());
           ps.setInt(4,c.getId());
           ps.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    @Override
    public void delete(String id) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(DELETE)){
           ps.setString(1, id);
           ps.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }
    
}
