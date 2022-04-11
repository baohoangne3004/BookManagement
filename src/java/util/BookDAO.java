/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author HoangKM
 */
public class BookDAO extends BaseDAO {
    public boolean addBook(Book book) {
        String insert = "INSERT INTO[dbo].[Books]\n"
                   + "([Id]\n"
                   + ",[Title]\n"
                   + ",[UnitPrice]\n"
                   + ",[Quantity])\n"
             + "VALUES\n"
                   + "(?\n"
                   + ",?\n"
                   + ",?\n"
                   + ",?)\n";
        int numOfUpdate = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(insert);
            stm.setString(1, book.getId());
            stm.setString(2, book.getTitle());
            stm.setDouble(3, book.getUnitPrice());
            stm.setInt(4, book.getQuantity());
            numOfUpdate = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numOfUpdate != 0;
    }
    
    private List<Book> getBookBySqlScript(String select) {
        List<Book> result = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(select);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String title = rs.getString("Title");
                double unitPrice = rs.getDouble("UnitPrice");
                int quantity = rs.getInt("Quantity");
                result.add(new Book(id, title, unitPrice, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Book> getBookOrderByTitle() {
        String script = "SELECT [Id]\n"
                + ",[Title]\n"
                + ",[UnitPrice]\n"
                + ",[Quantity]\n"
                + "FROM[dbo].[Books]\n"
                + "ORDER BY [Title]";
        return getBookBySqlScript(script);
    }

    public List<Book> getBookMaxPrice() {
        String script = "SELECT TOP 1 [Id]\n"
                + ",[Title]\n"
                + ",[UnitPrice]\n"
                + ",[Quantity]\n"
                + "FROM [dbo].[Books]\n"
                + "ORDER BY [UnitPrice]";
        return getBookBySqlScript(script);
    }

    public List<Book> getBook3MinPrice() {
        String script = "SELECT TOP 3 [Id]\n"
                + ",[Title]\n"
                + ",[UnitPrice]\n"
                + ",[Quantity]\n"
                + "FROM [dbo].[Books]\n"
                + "ORDER BY [UnitPrice] DESC";
        return getBookBySqlScript(script);
    }
}
