package lms;

import java.util.Queue;

public class Book {
    String Name;
    String Author;
    String ISBN;
    String Status;
    Queue reserve;
    int quantity;
    
    public Book(String Name, String Author, String ISBN, int quantity) {
        this.Name = Name;
        this.Author = Author;
        this.ISBN = ISBN;
        this.Status = "available";
        this.quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void updateStatus(String newStatus){
        this.Status = newStatus;
    }
    
    public void setQuantity(int qty) {
        this.quantity = qty;
    }
}
