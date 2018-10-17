package lms;

import java.util.ArrayList;

public class Clerk extends User{

    public Clerk(String username, String password, String Name, String Gender, int Age) {
        super(username, password, Name, Gender, Age);
    }
    public ArrayList<Book> searchBook(String query){
        ArrayList<Book> result = new ArrayList<>();
        for(int k=0; k<LMS.bookCount; k++){
            Book bn = LMS.Books.get(k);
            if(bn.getName().contains(query) || bn.getAuthor().contains(query) || bn.getISBN().contains(query)){
                result.add(LMS.Books.get(k));
            }
        }
        return result;
    }
    public String[] getInfo(){
        String[] profile = new String[4];
        profile[0] = username;
        profile[1] = Name;
        profile[2] = Gender;
        profile[3] = String.valueOf(Age);
        return profile;
    }
    
    public boolean addBorrower(String username, String password, String Name, String Gender, int Age){
        LMS.Users.add(new Borrower(username, password, Name, Gender, Age));
        return true;
    }
    
    
}
