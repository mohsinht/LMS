
package lms;
import java.util.*;
import java.util.Queue;

public class LMS {
    
    protected static ArrayList<Book> Books = new ArrayList<>();
    protected static ArrayList<User> Users = new ArrayList<>();
    protected static int bookCount = 0;
    protected static int userCount = 0;
    protected static boolean loggedIn=false;
    protected static int loginMode = 0; //1, 2, 3 for Borrower, Clerk and Librarian respectively
    protected static User loggedInUser;
    
    protected static ArrayList<BookRecord> records = new ArrayList<>();
    
    static {
        dbConnectivity db = new dbConnectivity();
        LMS.Users.add(new Librarian("admin", "123", "Administrator", "Male", 25)); 
        LMS.Users.add(new Clerk("clerk", "123", "Clerk", "Male", 42)); 
        LMS.Users.add(new Borrower("student", "123", "Student", "Female", 21));
        db.loadBooks();
    } 
    
    LMS(){
        Books = new ArrayList<>();
        Users = new ArrayList<>();
    }
    protected boolean addBook(Book b){
        Books.add(bookCount++, b);
        return true;
    }
    protected boolean addUser(User u){
        Users.add(userCount++, u);
        return true;
    }
    protected static boolean checkLoginInfo(String username, String password, int mode){
        
        int userMode;
        for(int i=0; i< Users.size(); i++){
            String cls = Users.get(i).getClass().getName();
            System.out.println("user: " + cls);
            switch (cls) {
                case "lms.Librarian":
                    userMode = 3;
                    break;
                case "lms.Clerk":
                    userMode = 2;
                    break;
                default:
                    userMode = 1;
                    break;
            }
            if(userMode == mode && Users.get(i).getUsername().equals(username) && Users.get(i).getPassword().equals(password)){
                loggedInUser = Users.get(i);
                return true;
            }
        }
        return false;
    }
    
    public static Book getBook(String name, String isbn){
        name = name.toLowerCase();
        for(int k=0; k<LMS.Books.size(); k++){
            Book bn = LMS.Books.get(k);
            if(bn.getName().toLowerCase().equals(name) && bn.getISBN().toLowerCase().equals(isbn)){
                return LMS.Books.get(k);
            }
        }
        return null;
    }
    
}
