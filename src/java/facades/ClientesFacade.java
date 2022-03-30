/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import classes.Cliente;
import connection.ConnectionFactory;
import dao.ClienteDAO;
import exception.DAOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author lucas
 */
public class ClientesFacade {
    public static void inserir(Cliente c){
        
            try(ConnectionFactory factory = new ConnectionFactory()){
                ClienteDAO cDAO = new ClienteDAO(factory.getConnection());
                    cDAO.insert(c);
            } catch (DAOException e){
                System.out.println("Erro ao inserir usuario");
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("erro");
                e.printStackTrace();
            }
 
    }
    
    public static void alterar(Cliente c){
            try(ConnectionFactory factory = new ConnectionFactory()){
                ClienteDAO cDAO = new ClienteDAO(factory.getConnection());
                
                cDAO.update(c);
            } catch (DAOException e){
                System.out.println("Erro ao inserir usuario");
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("erro");
                e.printStackTrace();
            }
    }
    
    public static Cliente buscar(String cpf){
        Cliente c = null;
        
        try(ConnectionFactory factory = new ConnectionFactory()){
            ClienteDAO cDAO = new ClienteDAO(factory.getConnection());
             
            c = cDAO.find(cpf);
        } catch (DAOException e){
            System.out.println("Erro ao inserir usuario");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("erro");
            e.printStackTrace();
        }

        return c;
    }
    
    public static List<Cliente> buscarTodos(){
            List<Cliente> c = null;

            try(ConnectionFactory factory = new ConnectionFactory()){
                ClienteDAO cDAO = new ClienteDAO(factory.getConnection());

                c = cDAO.findAll();
            } catch (DAOException e){
                System.out.println("Erro ao buscar usuario");
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("erro");
                e.printStackTrace();
            }
            return c;
    }
    
    public static void delete(String id){
            try(ConnectionFactory factory = new ConnectionFactory()){
                ClienteDAO cDAO = new ClienteDAO(factory.getConnection());
                
                cDAO.delete(id);
            } catch (DAOException e){
                System.out.println("Erro ao inserir usuario");
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("erro");
                e.printStackTrace();
            }
    }
}
