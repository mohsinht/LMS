package lms;

import java.util.Date;
public class BookRecord {
    User issuer;
    User issuedTo;
    Book book;
    Date issueDate;
    Date returnDate;
    Date dueDate;
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

    public int getFine() { //fifty rupees per day after due date
        if(returnDate == null){
            return 0;
        }
        if(returnDate.before(dueDate)){
            return 0;
        }
        int totalFine;
        long timeDiff = returnDate.getTime() - dueDate.getTime();
        totalFine = (int)(timeDiff/(1000*60*60*24) * 50);
        return totalFine;
    }
}
