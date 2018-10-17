
package lms;
import java.util.*;
import java.util.Queue;

public class LMS {
    
    protected static ArrayList<Book> Books;
    protected static ArrayList<User> Users;
    protected static int bookCount = 0;
    protected static int userCount = 0;
    LMS(){
        Books = new ArrayList<>();
        Users = new ArrayList<>();
    }
    protected Boolean addBook(Book b){
        Books.add(bookCount++, b);
        return true;
    }
    protected Boolean addUser(User u){
        Users.add(userCount++, u);
        return true;
    }
}
