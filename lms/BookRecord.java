package lms;

import java.util.Date;
public class BookRecord {
    User issuer;
    User issuedTo;
    Book book;
    Date issueDate;
    Date returnDate;
    Date dueDate;
    int fine = 0;

    public BookRecord(User issuer, Book book, Date issueDate, Date returnDate, Date dueDate) {
        this.issuer = issuer;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
    }
    
}
