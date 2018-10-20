package lms;


import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
               LMS.Users.add(new Librarian(rs.getString(5).trim(), rs.getString(6).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getInt(4)));
            }
            
            rs=stmt.executeQuery("select * from Clerk");
            while(rs.next())
            {                 
               LMS.Users.add(new Clerk(rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(2).trim(), rs.getString(6).trim(), rs.getInt(3)));
            }
            
            rs=stmt.executeQuery("select * from Student");
            while(rs.next())
            {                 
               LMS.Users.add(new Borrower(rs.getString(6).trim(), rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(7).trim(), rs.getString(8).trim(), rs.getString(2).trim(), rs.getString(9).trim(), rs.getInt(3)));
            }
            System.out.println(LMS.Users.get(2).getUsername() + " " + LMS.Users.get(2).getPassword());
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
    
    void loadPendingReservations(){
        try
        {
            ResultSet rs=stmt.executeQuery("select * from reservationDate");
            while(rs.next())
            {                 
               String username = rs.getString(2);
               String isbn = rs.getString(1);
               String date = rs.getString(3);
               String status = rs.getString(4);
               LMS.getBook(isbn).reserveBook(LMS.getUser(username));
               SimpleDateFormat format=new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");  
               LMS.getUser(username).reserveBook(LMS.getBook(isbn), format.parse(date), status);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void reservationDate(String username, String isbn, String status, Date d){
        try
        {
            PreparedStatement addedBook = con.prepareStatement("INSERT INTO reservationDate values(?, ?, ?, ?)");
            addedBook.setString(1, isbn);
            addedBook.setString(2, username);
            addedBook.setString(3, d.toString());
            addedBook.setString(4, "pending");
            addedBook.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    void updateBorrower(String rollNo, String dept, String campus, String username, String password, String Name, String Gender, int Age){
        try
        {
            PreparedStatement updatedProfile = con.prepareStatement("UPDATE student SET " +
            "	name = ?," +
            "	age = ?," +
            "	department = ?," +
            "	campus = ?," +
            "	rollno = ?," +
            "	password = ?," +
            "	gender = ? " + 
            " WHERE username = ?");
            updatedProfile.setString(1, Name);
            updatedProfile.setInt(2, Age);
            updatedProfile.setString(3, dept);
            updatedProfile.setString(4, campus);
            updatedProfile.setString(5, rollNo);
            updatedProfile.setString(6, password);
            updatedProfile.setString(7, Gender);
            updatedProfile.setString(8, username);
            updatedProfile.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void updateClerk(String username, String password, String Name, String Gender, int Age){
        try
        {
            System.out.println("username: " + username);
            PreparedStatement updatedProfile = con.prepareStatement("UPDATE Clerk SET " +
            "	name = ?," +
            "	age = ?," +
            "	password = ?," +
            "	gender = ? " + 
            " WHERE username = ?");
            
            updatedProfile.setString(1, Name);
            updatedProfile.setInt(2, Age);
            updatedProfile.setString(3, password);
            updatedProfile.setString(4, Gender);
            updatedProfile.setString(5, username);
            updatedProfile.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}