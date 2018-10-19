package lms;

import java.util.LinkedList;
import java.util.Queue;

public class Book {
    String Name;
    String Author;
    String ISBN;
    String Status;
    Queue<User> reserve = new LinkedList<>(); 
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

    public String getStatus() {
        return Status;
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
    
    protected boolean reserveBook(User u){
        if(this.Status.equals("unavailable")){
            return false;
        }
        if(this.reserve.contains(u)){
            return false;
        }
        this.reserve.add(u);

        return true;
    }
}
