package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.concurrent.locks.Condition;

public class Book {
	private int InternalIndex;
    public String ID;
    public String Title;
    public String Author;
    public String ISBN;
    public String description;
    public String Catagory;
    public int AvailableCount;
    public ArrayList<Double> Prices;
    public ArrayList<String> Conditions;
    public boolean HasLikeNew;
    public boolean HasModeratelyUsed;
    public boolean HasHeavilyUsed;
    public boolean available;
    public void AddBook(Double price, String condition) {
        Prices.add(price);
        Conditions.add(condition);
        AvailableCount++;
    }
    public void SerializeBook(BufferedWriter writer) throws IOException {
        writer.write(Integer.toString(AvailableCount) + "\n");
        for(int i = 0; i < AvailableCount; i++) {
            writer.write(Double.toString(Prices.get(i)) + "\n");
            writer.write(Conditions.get(i) + "\n");
            if(Conditions.get(i).equals("Used Like New")) HasLikeNew = true;
            else if(Conditions.get(i).equals("Moderately Used")) HasModeratelyUsed = true;
            else if(Conditions.get(i).equals("Heavily Used")) HasHeavilyUsed = true;
        }
        writer.write(Boolean.toString(HasLikeNew) + "\n");
        writer.write(Boolean.toString(HasModeratelyUsed) + "\n");
        writer.write(Boolean.toString(HasHeavilyUsed) + "\n");
        writer.write(Boolean.toString(AvailableCount != 0) + "\n");
    }
    public void SetIndex(int Index) {
    	InternalIndex = Index;
    }
    public int GetIndex() {
    	return InternalIndex;
    }
    Book() {
    	InternalIndex = 0;
    	AvailableCount = 0;
    	ID = "A";
    	Title = "B";
    	Author = "C";
    	ISBN = "D";
    	description = "E";
    	Catagory = "F";
    	HasLikeNew = false;
    	HasModeratelyUsed = false;
    	HasHeavilyUsed = false;
    	available = false;
        Prices = new ArrayList<Double>();
        Conditions = new ArrayList<String>();
    }
        //    public void Book(BufferedReader reader) {
//        ID = reader.readLine();
//        Title = reader.readLine();
//        author = reader.readLine();
//        ISBN = reader.readLine();
//        available = Boolean.parseBoolean(reader.readLine());
//        description = reader.readLine();
//        HasLikeNew = Boolean.parseBoolean(reader.readLine());
//        HasUsed = Boolean.parseBoolean(reader.readLine());
//        HasHeavilyUsed = Boolean.parseBoolean(reader.readLine());
//        AvailableCount = Integer.parseInt(reader.readLine());
//        Prices = new ArrayList<Double>();
//        Conditions = new ArrayList<String>();
//        for(int i = 0; i < AvailableCount; i++) {
//            Prices.add(Double.parseDouble(reader.readLine()));
//            Conditions.add(reader.readLine());
//        }
//    }
}

