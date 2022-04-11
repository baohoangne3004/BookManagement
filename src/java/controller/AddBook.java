/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import util.BookDAO;

/**
 *
 * @author HoangKM
 */
public class AddBook extends HttpServlet {

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
        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = new ArrayList();
        books.add(new Book("0-2587-2888-4", "Book title 1", 1000, 10));
        books.add(new Book("0-9900-5119-6", "Book title 2", 1000, 10));
        books.add(new Book("0-8927-5687-X", "Book title 3", 1000, 10));
        books.add(new Book("0-2282-6753-6", "Book title 4", 1000, 10));
        books.add(new Book("0-1690-9739-0", "Book title 5", 1000, 10));

        for (Book book : books) {
            bookDAO.addBook(book);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AddBook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> 5 book add succsessfully :</h1>");
            out.println("<table border=\"1\">\n" +
"            <thead>\n" +
"                <tr>\n" +
"                    <th>Id</th>\n" +
"                    <th>Title</th>\n" +
"                    <th>Unit Price</th>\n" +
"                    <th>Quantity</th>\n" +
"                </tr>\n" +
"            </thead>\n" +
"            <tbody>\n");
            for (Book book : bookDAO.getBookOrderByTitle()) {
                out.println(book);
            }
out.println("</tbody>\n" +
"        </table>");
            out.println("<form action=\"index.jsp\">\n");
            out.println("<input type=\"submit\" value=\"Back\" />\n");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
