/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import classes.Cliente;
import connection.ConnectionFactory;
import dao.ClienteDAO;
import dao.UsuarioDAO;
import exception.DAOException;
import facades.ClientesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

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

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        
        RequestDispatcher portalRD = getServletContext().getRequestDispatcher("/portal.jsp");
        HttpSession s = request.getSession();

        if(s.getAttribute("logado") == null){
            request.setAttribute("msg","Usuário deve se autenticar para acessar o sistema");
            rd.forward(request, response);
        }
        
        String action = request.getParameter("action");
        
        if("store".equals(action)){
            Cliente c = new Cliente();
            
            
            String nome = (String) request.getAttribute("nome");
            String email = (String) request.getAttribute("email");
            String cpf = (String) request.getAttribute("cpf");
            Date date = (Date) request.getAttribute("date");
            String rua = (String) request.getAttribute("rua");
            Integer nr = (Integer) request.getAttribute("nr");
            String cep = (String) request.getAttribute("cep");
            String  cidade = (String) request.getAttribute("cidade");
            String uf = (String) request.getAttribute("uf");
            
            c.setNome(nome);
            c.setCep(cep);
            c.setCidade(cidade);
            c.setCpf(cpf);
            c.setData(date);
            c.setEmail(email);
            c.setNr(nr);
            c.setRua(rua);
            c.setUf(uf);
            
            ClientesFacade.inserir(c);
            
            portalRD.forward(request, response);  
            
            
        } else if("update".equals(action)){           
            Cliente c = new Cliente();
            
            
            String nome = (String) request.getAttribute("nome");
            String email = (String) request.getAttribute("email");
            String cpf = (String) request.getAttribute("cpf");
            Date date = (Date) request.getAttribute("date");
            String rua = (String) request.getAttribute("rua");
            Integer nr = (Integer) request.getAttribute("nr");
            String cep = (String) request.getAttribute("cep");
            String  cidade = (String) request.getAttribute("cidade");
            String uf = (String) request.getAttribute("uf");
            
            c.setNome(nome);
            c.setCep(cep);
            c.setCidade(cidade);
            c.setCpf(cpf);
            c.setData(date);
            c.setEmail(email);
            c.setNr(nr);
            c.setRua(rua);
            c.setUf(uf);
            
            ClientesFacade.alterar(c);
            
            portalRD.forward(request, response);  
        } else if("delete".equals(action)){
            String userID = request.getParameter("id");
            ClientesFacade.delete(userID);
            
            portalRD.forward(request, response);  
        } else if("index".equals(action)){
            String cpf = request.getParameter("cpf");
            
            Cliente c = ClientesFacade.buscar(cpf);
            
            RequestDispatcher clienteRD = getServletContext().getRequestDispatcher("/verCliente.jsp");
            request.setAttribute("cliente", c);
            clienteRD.forward(request, response);   
        } else {
            
            List<Cliente> cList = ClientesFacade.buscarTodos();
            
            
            RequestDispatcher listarRD = getServletContext().getRequestDispatcher("/listarClientes.jsp");

            request.setAttribute("clientes", cList);        
            listarRD.forward(request, response);
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
