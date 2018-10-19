
package lms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
public class dbConnectivity {
    Connection con;
    Statement stmt;
    dbConnectivity(){
        try{
            String s  = "jdbc:sqlserver://localhost:1433;databaseName=lms";
            con=DriverManager.getConnection(s,"mohsin","mohsinhayat007");
            stmt = con.createStatement(); 
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void loadUsers(){
        try
        {
            ResultSet rs=stmt.executeQuery("select * from librarian");
            LMS.Users.clear();
            while(rs.next())
            {                 
               LMS.Users.add(new Librarian(rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            
            rs=stmt.executeQuery("select * from Clerk");
            while(rs.next())
            {                 
               LMS.Users.add(new Clerk(rs.getString(4), rs.getString(5), rs.getString(2), rs.getString(6), rs.getInt(3)));
            }
            
            rs=stmt.executeQuery("select * from Student");
            while(rs.next())
            {                 
               LMS.Users.add(new Borrower(rs.getString(6), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(8), rs.getString(2), rs.getString(9), rs.getInt(3)));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void loadBooks()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from book");
            LMS.Books.clear();
            while(rs.next())
            {                 

               LMS.Books.add(new Book(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void insertBook(String Name, String Author, String ISBN, int quantity){
        try
        {
            PreparedStatement addedBook = con.prepareStatement("INSERT INTO Book values(?, ?, ?, ?, ?)");
            addedBook.setInt(1, LMS.Books.size());
            addedBook.setString(2, Name);
            addedBook.setString(3, Author);
            addedBook.setString(4, ISBN);
            addedBook.setInt(5, quantity);
            addedBook.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
