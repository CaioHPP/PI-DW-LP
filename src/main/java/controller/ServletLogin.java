/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidades.Pessoa;
import br.com.utfpr.mavenproject.DAOPessoa;
import java.io.IOException;
import java.util.ArrayList;
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
 * @author Caio Henrique
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    List<Pessoa> clientes = new ArrayList();
    DAOPessoa controle = new DAOPessoa();
    Pessoa cliente = new Pessoa();

    List<Pessoa> lista = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        lista = controle.list();
        String aux[];
        String x = "Dados não conferem.";
        String login = null;
        String senha = null;
        for (Pessoa linha : lista) {
            aux = String.valueOf(linha).split(";");
            login = request.getParameter("login");
            senha = request.getParameter("senha");
            if (login.isEmpty()) {
                x = "Login Vazio."; //login n digitado   
            }
            else if (senha.isEmpty()) {
                x = "Senha Vazia.";   //senha n digitado
            }
            else if (!login.matches("^[a-zA-Z0-9]+$") & login != null & senha != null) {

                x = "Digite somente letras.";
            }

            if (aux[9].equals(login) && aux[10].equals(senha)) {
                login = request.getParameter("login");
                senha = request.getParameter("senha");
                x = "ok";
                break;
            }
            

        }

        if (x == "ok") {
            HttpSession session = request.getSession();
            session.setAttribute("session", login);
            session.setMaxInactiveInterval(30 * 60);
            response.sendRedirect("aluno.jsp");
        } else {//Se o login deu certo
            RequestDispatcher rd = request.getRequestDispatcher("/Login-Futuro.jsp");
            request.setAttribute("x", x);
            rd.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. +
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
