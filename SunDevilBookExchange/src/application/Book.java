package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.concurrent.locks.Condition;

public class Book {
	public int available;		//1 = yes, 0 = no
    public String Title;
    public String Author;
    public String ISBN;
    public String description;
    public ArrayList<Integer> Catagory; //1 = Education, 2 = Non-fiction, 3 = Fiction, 4 = Mathematics, 5 = Biology, 6 = Computer Science, 7 = Music, 8 = History
    public double price;		// original price
    public int Condition; 		//1 = like new, 2 = moderately used, 3 = heavily used
    public String seller;
    
    public Book() {
    	
    }
    
    public Book(int available, String Title, String Author, String ISBN, String description, ArrayList<Integer> Category, double price, int Condition) {
        this.Title = Title;
        this.Author = Author;
        this.ISBN = ISBN;
        this.description = description;
        this.Catagory = Category;
        this.price = price;
        this.Condition = Condition;
        this.available = available;
        
    }
    
}

