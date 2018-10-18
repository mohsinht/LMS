package lms;

public class Librarian extends User {

    public Librarian(String username, String password, String Name, String Gender, int Age) {
        super(username, password, Name, Gender, Age);
    }
    
    public boolean addBook(Book b){
        LMS.Books.add(b);
        return true;
    }
    
}
