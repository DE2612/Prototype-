package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class BookSearchUtilities {
	
	public BookSearchUtilities() {
	
	}
	
	public ArrayList<Book> BookList = new ArrayList<Book>();
    
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
