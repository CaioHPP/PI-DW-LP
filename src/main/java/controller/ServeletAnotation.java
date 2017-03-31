/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EscolaDeMusica", urlPatterns = {"/EscolaDeMusica", "/DomZelitus", "/gerenciamento"})
public class ServeletAnotation extends HttpServlet {

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
     
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gerenciamento</title>");            
            out.println("<link type=\"text/css\" href=\"css.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + " <a href= \"index.html\">  Voltar </a></h1>");
            
            out.println("");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
             
        RequestDispatcher dispatcher = req.getRequestDispatcher("SolicitaCadastro.html");
            dispatcher.forward(req, resp);
        processRequest(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        
        processRequest(req, resp);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
