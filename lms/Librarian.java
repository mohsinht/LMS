package lms;

import java.util.ArrayList;
import java.util.Date;

public class Librarian extends User {

    ArrayList<reservationDate> reservedBooks = new ArrayList<>();

    public Librarian(String username, String password, String Name, String Gender, int Age) {
        super(username, password, Name, Gender, Age);
    }

    @Override
    public void reserveBook(Book b, Date d) {
        reservedBooks.add(new reservationDate(b, d));
    }

    @Override
    public void reserveBook(Book b, Date d, String status) {
        reservedBooks.add(new reservationDate(b, d, status));
    }

    public boolean addBook(Book b) {
        LMS.Books.add(b);
        return true;
    }

    @Override
    public ArrayList<reservationDate> getResInfo() {
        return this.reservedBooks;
    }
}
