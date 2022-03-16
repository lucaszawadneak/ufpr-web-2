/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Usuario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


/**
 *
 * @author laboratorio
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {
    
    ArrayList<Usuario> usuarios = new ArrayList<>();

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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
        
        HttpSession s = request.getSession();
        
        if(!isLoggedIn(s)){
            request.setAttribute("msg","Por favor faça login");
            request.setAttribute("page","/index.html");
            rd.forward(request, response);
        } else {
            checkAndInsertUsers(request);
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Portal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"LogoutServlet\">Logout</a>");
            out.println("<form action=\"CadastrarUsuarioServlet\" method=\"post\">");
            out.println("<input type=\"text\" name=\"name\" placeholder=\"Nome\"/>");
            out.println("<input type=\"text\" name=\"login\" placeholder=\"Login\"/>");
            out.println("<input type=\"text\" name=\"password\" placeholder=\"Senha\"/>");
            out.println("<button type=\"submit\">Salvar</button><br/>");
            
            
            out.println("<ul>");
            for(Usuario u : usuarios){
                out.println("<li>" + u.getNome() + " | " + u.getSenha() + "</li>");
            }
            
            out.println("</ul>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private Boolean isLoggedIn(HttpSession session){
        return session.getAttribute("logado") != null;
    }
    
    private void checkAndInsertUsers(HttpServletRequest req){
        Usuario user = (Usuario) req.getAttribute("user");
        
        if(user != null){
            this.usuarios.add(user);
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
