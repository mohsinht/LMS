package lms;

import java.util.Date;
public class BookRecord {
    User issuer;
    Book book;
    Date issueDate;
    Date returnDate;
    int id;
	Date dueDate;
	int fine = 0;

    public BookRecord(User issuer, Book book, Date issueDate, Date returnDate, int id) {
        this.issuer = issuer;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.id = id;
    }
    
}
