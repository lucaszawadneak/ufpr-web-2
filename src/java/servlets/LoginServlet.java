/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.LoginBean;
import classes.Usuario;
import connection.ConnectionFactory;
import dao.UsuarioDAO;
import exception.DAOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


/**
 *
 * @author laboratorio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private Usuario usuario = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
       
        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        
        if(handleLogin(user,password)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
            HttpSession s = request.getSession();
            LoginBean lb = new LoginBean();
            
            lb.setId(usuario.getId());
            lb.setName(usuario.getNome());
            
            System.out.println(usuario.getNome());
            
            s.setAttribute("logado",lb);
            rd.forward(request,response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Erro ao logar! Verifique sua senha");
            request.setAttribute("page", "/index.jsp");
            rd.forward(request, response);
        }
        
    }
    
    private Boolean handleLogin(String email,String password){
        try(ConnectionFactory factory = new ConnectionFactory()){
            UsuarioDAO u = new UsuarioDAO(factory.getConnection());
            Usuario user = u.find(email);
            
            if(password.equals(user.getSenha())){
                this.usuario = user;
                return true;
            }
        } catch (DAOException e){
            System.out.println("Erro ao buscar usuario");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("erro");
            e.printStackTrace();
        }
        
        return false;
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
