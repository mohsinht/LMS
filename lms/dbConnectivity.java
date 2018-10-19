
package lms;


import java.sql.Connection;
import java.sql.DriverManager;
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
}
