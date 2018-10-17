package lms;
import javax.swing.*;
import java.util.*;
public class driver {
    public static void main(String[] args){
        LMS lms = new LMS();
        lms.addBook(new Book("Lord of the Rings", "Chris Gayle", "65659895"));
        lms.addBook(new Book("Lord of the Rings2", "Chris Gayle", "65659895"));
    }
}
