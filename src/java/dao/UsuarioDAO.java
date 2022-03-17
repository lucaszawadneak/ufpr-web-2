/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Usuario;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class UsuarioDAO implements DAO<Usuario>{
    private static final String INSERT_QUERY = "INSERT INTO usuario (nome,login,senha) values (?,?,?)";
    private static final String FIND_ALL_QUERY = "SELECT * from usuario;";
    private static final String FIND_ONE = "SELECT * FROM usuario WHERE login = ?";
    private static final String UPDATE = "UPDATE user SET name = ?, login = ?, senha = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM user WHERE id = ?";
    private Connection con = null;
    
    public UsuarioDAO(Connection con) throws DAOException{
        if(con == null){
            throw new DAOException("Conn null");
        }
        this.con = con;
    }
    

    @Override
    public Usuario find(String login) throws DAOException {
        try(PreparedStatement ps = con.prepareStatement(FIND_ONE)){
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("password"));
                u.setId(rs.getInt("id"));
               
                return u;
            }
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(FIND_ALL_QUERY)){
            List<Usuario> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("password"));
                u.setId(rs.getInt("id"));
               
                list.add(u);
            }
            return list;
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    @Override
    public void insert(Usuario user) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(INSERT_QUERY)){
           ps.setString(1, user.getNome());
           ps.setString(2, user.getLogin());
           ps.setString(3, user.getSenha());
           ps.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    @Override
    public void update(Usuario user) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(UPDATE)){
           ps.setString(1, user.getNome());
           ps.setString(2, user.getLogin());
           ps.setString(3, user.getSenha());
           ps.setInt(4,user.getId());
           ps.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }

    @Override
    public void delete(Usuario user) throws DAOException {
       try(PreparedStatement ps = con.prepareStatement(DELETE)){
           ps.setInt(1, user.getId());
           ps.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("Erro sql",e);
        }
    }
    
}
