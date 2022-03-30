/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Usuario;
import connection.ConnectionFactory;
import dao.UsuarioDAO;
import exception.DAOException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/*
* @author laboratorio
*/
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher portalRD = getServletContext().getRequestDispatcher("/PortalServlet");
        
        HttpSession session = request.getSession();
        RequestDispatcher erroRD = getServletContext().getRequestDispatcher("/index.jsp");
        if(session == null){
            request.setAttribute("msg", "Usuário não logado");
            erroRD.forward(request, response);
        }
    
        
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
            
        Usuario newUser = new Usuario(name,login,password);
        
        insertUser(newUser);
           
            
    }
    
    private void insertUser(Usuario user){
        try(ConnectionFactory factory = new ConnectionFactory()){
            UsuarioDAO u = new UsuarioDAO(factory.getConnection());
            
            u.insert(user);
        } catch (DAOException e){
            System.out.println("Erro ao buscar usuario");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("erro");
            e.printStackTrace();
        }
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
