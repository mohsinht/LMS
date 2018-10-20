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

    public BookRecord(User issuer, User issuedTo, Book book, Date issueDate, Date dueDate) {
        this.issuer = issuer;
        this.issuedTo = issuedTo;
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public BookRecord(User issuer, User issuedTo, Book book, Date issueDate, Date returnDate, Date dueDate) {
        this.issuer = issuer;
        this.issuedTo = issuedTo;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
    }

    public User getIssuer() {
        return issuer;
    }

    public User getIssuedTo() {
        return issuedTo;
    }

    public Book getBook() {
        return book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getFine() {
        return fine;
    }


    
}
