package lms;

import java.util.Date;
//sah
public class BookRecord {
    User issuer;
    Book book;
    Date issueDate;
    Date returnDate;
    int id;

    public BookRecord(User issuer, Book book, Date issueDate, Date returnDate, int id) {
        this.issuer = issuer;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.id = id;
    }
    
}
