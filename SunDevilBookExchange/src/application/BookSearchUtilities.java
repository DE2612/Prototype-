package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class BookSearchUtilities {
	
	public BookSearchUtilities() {
	
	}
	
	public ArrayList<Book> BookList = new ArrayList<Book>();
	
	public static ArrayList<String> readCart(String userName) {
		
		BufferedReader tempCartReader;
		ArrayList<String> cartArrayString = new ArrayList<String>();
		try {
			tempCartReader = new BufferedReader(new FileReader("Carts/" + userName + "Cart.txt"));
	    	String index = tempCartReader.readLine();
	    	while(index != null) {
	    		cartArrayString.add(index);
	    		index = tempCartReader.readLine();
	    	}
	    	tempCartReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    	return cartArrayString;
    }
	
	public static ArrayList<String> addToCart(String userName, int bookIndex /* book index starts at 1 */) {
		
		BufferedReader tempCartReader;
		ArrayList<String> cartArrayString = new ArrayList<String>();
		try {
			tempCartReader = new BufferedReader(new FileReader("Carts/" + userName + "Cart.txt"));
	    	String index = tempCartReader.readLine();
	    	while(index != null) {
	    		cartArrayString.add(index);
	    		index = tempCartReader.readLine();
	    	}
	    	tempCartReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cartArrayString.add(Integer.toString(bookIndex));
		
		BufferedWriter tempCartWriter;
		try {
			tempCartWriter = new BufferedWriter(new FileWriter("Carts/" + userName + "Cart.txt"));
	    	for (int i = 0; i < cartArrayString.size(); i++) {
	    		tempCartWriter.write(cartArrayString.get(i) + "\n");
	    	}
	    	tempCartWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    	return cartArrayString;
    }
	
	public static void renameCart(String oldUserName, String newUserName) {
		File olfFile = new File("Carts/" + oldUserName + "Cart.txt");
		File newFile = new File("Carts/" + newUserName + "Cart.txt");
		
		olfFile.renameTo(newFile);
	}
	
	public static ArrayList<Book> readCertainBooks(ArrayList<String> array) throws NumberFormatException, IOException {
		ArrayList<Book> tmpBookList= new  ArrayList<Book>();
		for (String i : array) {
			Book tempBook = new Book();
    		BufferedReader tempBookReader = new BufferedReader(new FileReader("Books/BookNo" + i + ".txt"));
    		tempBook.available = Integer.parseInt(tempBookReader.readLine());
    		tempBook.Title = tempBookReader.readLine();
    		tempBook.Author = tempBookReader.readLine();
    		tempBook.ISBN = tempBookReader.readLine();
    		tempBook.description = tempBookReader.readLine();
    		
    		String[] tempCategoryString = tempBookReader.readLine().split(" ");
    		ArrayList<Integer> Categories = new ArrayList<Integer>();
    		for(int j = 0; j < tempCategoryString.length; j++) {
    			Categories.add(Integer.parseInt(tempCategoryString[j]));
    		}
    		
    		tempBook.Catagory = Categories;
    		tempBook.price = Double.parseDouble(tempBookReader.readLine());
    		tempBook.Condition = Integer.parseInt(tempBookReader.readLine());
    		tempBook.seller = tempBookReader.readLine();
    		tempBookReader.close();
    		tmpBookList.add(tempBook);
		}
		
		return tmpBookList;
		
	}
	
	public static void setAvailability(int index, int availability /* 1 = available, 0 = unavailable */ ) throws NumberFormatException, IOException {
		Book tempBook = new Book();
		BufferedReader tempBookReader = new BufferedReader(new FileReader("Books/BookNo" + index + ".txt"));
		tempBook.available = Integer.parseInt(tempBookReader.readLine());
		tempBook.Title = tempBookReader.readLine();
		tempBook.Author = tempBookReader.readLine();
		tempBook.ISBN = tempBookReader.readLine();
		tempBook.description = tempBookReader.readLine();
		
		String[] tempCategoryString = tempBookReader.readLine().split(" ");
		ArrayList<Integer> Categories = new ArrayList<Integer>();
		for(int j = 0; j < tempCategoryString.length; j++) {
			Categories.add(Integer.parseInt(tempCategoryString[j]));
		}
		
		tempBook.Catagory = Categories;
		tempBook.price = Double.parseDouble(tempBookReader.readLine());
		tempBook.Condition = Integer.parseInt(tempBookReader.readLine());
		tempBook.seller = tempBookReader.readLine();
		tempBookReader.close();
		
		BufferedWriter tempBookWriter = new BufferedWriter(new FileWriter("Books/BookNo" + index + ".txt"));
		tempBookWriter.write(availability + "\n");
		tempBookWriter.write(tempBook.Title + "\n");
		tempBookWriter.write(tempBook.Author + "\n");
		tempBookWriter.write(tempBook.ISBN + "\n");
		tempBookWriter.write(tempBook.description + "\n");
		for(int i = 0; i < tempBook.Catagory.size(); i++) {
			tempBookWriter.write(tempBook.Catagory.get(i) + " ");
		}
		tempBookWriter.write("\n");
		tempBookWriter.write(tempBook.price + "\n");
		tempBookWriter.write(tempBook.Condition + "\n");
		tempBookWriter.write(tempBook.seller + "\n");
		tempBookWriter.close();
    }
    
    public static ArrayList<Book> readBooks() throws NumberFormatException, IOException {
    	ArrayList<Book> BookList = new ArrayList<Book>();
    	int numBooks = 0;
    	
		BufferedReader numBooksReader = new BufferedReader(new FileReader("Books/numBooks.txt"));
		numBooks = Integer.parseInt(numBooksReader.readLine());
		numBooksReader.close();
		
    	
    	for (int i = 0; i < numBooks; i++) {
    		Book tempBook = new Book();
    		int nameIndex = i + 1;
    		BufferedReader tempBookReader = new BufferedReader(new FileReader("Books/BookNo" + nameIndex + ".txt"));
    		tempBook.available = Integer.parseInt(tempBookReader.readLine());
    		tempBook.Title = tempBookReader.readLine();
    		tempBook.Author = tempBookReader.readLine();
    		tempBook.ISBN = tempBookReader.readLine();
    		tempBook.description = tempBookReader.readLine();
    		
    		String[] tempCategoryString = tempBookReader.readLine().split(" ");
    		ArrayList<Integer> Categories = new ArrayList<Integer>();
    		for(int j = 0; j < tempCategoryString.length; j++) {
    			Categories.add(Integer.parseInt(tempCategoryString[j]));
    		}
    		
    		tempBook.Catagory = Categories;
    		tempBook.price = Double.parseDouble(tempBookReader.readLine());
    		tempBook.Condition = Integer.parseInt(tempBookReader.readLine());
    		tempBook.seller = tempBookReader.readLine();
    		tempBookReader.close();
    		BookList.add(tempBook);
    	}
    	
    	return BookList;
    }
    
    public static boolean checkAvailability(int index) throws NumberFormatException, IOException {	//book index starts at 1
    	BufferedReader tempBookReader = new BufferedReader(new FileReader("Books/BookNo" + index + ".txt"));
		int test = Integer.parseInt(tempBookReader.readLine());
		if (test == 0) {
			return false;
		}
		return true;
		
    }
    
    public static void addBook(Book newBook) throws NumberFormatException, IOException {
    	int numBooks = 0;
    	
		BufferedReader numBooksReader = new BufferedReader(new FileReader("Books/numBooks.txt"));
		numBooks = Integer.parseInt(numBooksReader.readLine());
		numBooksReader.close();
		
		numBooks++;
		BufferedWriter numBooksWriter = new BufferedWriter(new FileWriter("Books/numBooks.txt"));
		numBooksWriter.write("" + numBooks + "\n");
		numBooksWriter.close();
		
		BufferedWriter tempBookWriter = new BufferedWriter(new FileWriter("Books/BookNo" + numBooks + ".txt"));
		tempBookWriter.write(newBook.available + "\n");
		tempBookWriter.write(newBook.Title + "\n");
		tempBookWriter.write(newBook.Author + "\n");
		tempBookWriter.write(newBook.ISBN + "\n");
		tempBookWriter.write(newBook.description + "\n");
		for(int i = 0; i < newBook.Catagory.size(); i++) {
			tempBookWriter.write(newBook.Catagory.get(i) + " ");
		}
		tempBookWriter.write("\n");
		tempBookWriter.write(newBook.price + "\n");
		tempBookWriter.write(newBook.Condition + "\n");
		tempBookWriter.write(newBook.seller + "\n");
		tempBookWriter.close();
		
    }
    
    public static ArrayList<String> getTitleList(ArrayList<Book> BookList) {
    	ArrayList<String> TitleList = new ArrayList<String>();
    	for (int i = 0; i < BookList.size(); i++) {
    		TitleList.add(BookList.get(i).Title);
    	}
    	
		return TitleList;
    	
    }
    
    public static ArrayList<String> getISBNList(ArrayList<Book> BookList) {
    	ArrayList<String> ISBNList = new ArrayList<String>();
    	for (int i = 0; i < BookList.size(); i++) {
    		ISBNList.add(BookList.get(i).ISBN);
    	}
    	
		return ISBNList;
    	
    }
    
    public static ArrayList<String> getAuthorList(ArrayList<Book> BookList) {
    	ArrayList<String> AuthorList = new ArrayList<String>();
    	for (int i = 0; i < BookList.size(); i++) {
    		AuthorList.add(BookList.get(i).Author);
    	}
    	
		return AuthorList;
    	
    }
    
    public static ArrayList<Integer> searchList(String searchWords, ArrayList<String> listOfStrings) {

        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < listOfStrings.size(); i++) {
        	if (listOfStrings.get(i).contains(searchWords)) {
        		index.add(i+1);
        	}
        }
		return index;
        
    }
}
