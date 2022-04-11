/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HoangKM
 */
public class Book {
    private String id;
    private String title;
    private double unitPrice;
    private int quantity;

    public Book(String id, String title, double unitPrice, int quantity) {
        this.id = id;
        this.title = title;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + title + "</td><td>" + unitPrice + "</td><td>" + quantity + "</td></tr>";
    }
    
}
