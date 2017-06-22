/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.utfpr.mavenproject.DAOPessoa;
import br.com.utfpr.mavenproject.DAOGenerico;
import Entidades.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EscolaDeMusica", urlPatterns = {"/EscolaDeMusica", "/DomZelitus", "/gerenciamento"})
public class ServeletAnotation extends HttpServlet {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    List<Pessoa> lista = new ArrayList<>();
    DAOPessoa controle = new DAOPessoa();

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gerenciamento</title>");

            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + " <a href= \"index.jsp\">  Voltar  </a></h1>");
            out.println("<table border=\"1\">\n"
                    + "<tr>\n"
                    + "<th>IdPessoa</th>\n"
                    + "<th>Nome</th>\n"
                    + "<th>Telefone</th>\n"
                    + "<th>Sexo</th>\n"
                    + "<th>Cpf</th>\n"
                    + "<th>Email</th>\n"
                    + "<th>Data de Nascimento</th>\n"
                    + "<th>Endereço</th>\n"
                    + "<th>Instrumento</th>\n"
                    + "</tr>\n");

            lista = controle.list();
            String aux[];
            String sexo = null;
            for (Pessoa linha : lista) {
                aux = String.valueOf(linha).split(";");
                
                if (Objects.equals(Short.valueOf(aux[3]), Short.valueOf("0"))){
                    sexo = "Masculino";}
                if (Objects.equals(Short.valueOf(aux[3]), Short.valueOf("1"))){
                    sexo = "Feminino";
                
                }
                out.println(
                        "<tr>"
                        + "<td><center>" + Integer.valueOf(aux[0]) + "</center></td>"
                        + "\n"
                        + "<td><center>"
                        + aux[1] + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[2] + "</center></td>"
                        + "\n"
                        + "<td><center>" + sexo + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[4] + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[5] + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[6] + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[7] + "</center></td>"
                        + "\n"
                        + "<td><center>" + aux[8] + "</center></td>"
                        + "</tr>"
                        + "<br/>"
                );
            }

            out.println("</table>");
            

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("SolicitaCadastro.jsp");
        dispatcher.forward(req, resp);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String tel = req.getParameter("tel");
        String sexo = (req.getParameter("genero"));
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String dataN = req.getParameter("dataN");
        String endereco = req.getParameter("endereço");
        String instrumento = req.getParameter("instrumento");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Pessoa cliente = new Pessoa();
        cliente.setIdCliente(controle.autoIdPessoa());

        if (nome != null) {
            cliente.setNome(nome);
        }
        if (tel != null) {
            cliente.setTelefone(tel);
        }
        if (sexo != null) {
            if ("Masculino".equals(sexo)) {
                cliente.setSexo(Short.valueOf("0"));
            } else if ("Feminino".equals(sexo)) {
                cliente.setSexo(Short.valueOf("1"));

            }
        }
        if (cpf != null) {
            cliente.setCpf(cpf);
        }
        if (email != null) {
            cliente.setEmail(email);
        }
        if (dataN != null) {
            cliente.setDataN(Date.valueOf(dataN));
        }
        if (endereco != null) {
            cliente.setEndereco(endereco);
        }if (login != null) {
            cliente.setLogin(login);
        }if (senha != null) {
            cliente.setSenha(senha);
        }
        cliente.setInstrumento(instrumento);
       cliente.setTipo("Aluno");
        
        controle.inserir(cliente);
        //controle.RemoveIguais();
        System.out.println("DEU CERTO!");
        
        processRequest(req, resp);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

