package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.concurrent.locks.Condition;

public class Book {
    public String ID;
    public String Title;
    public String author;
    public String ISBN;
    public String description;
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
        writer.write(Integer.toString(AvailableCount));
        for(int i = 0; i < AvailableCount; i++) {
            writer.write(Double.toString(Prices.get(i)));
            writer.write(Conditions.get(i));
            if(Conditions.get(i).equals("LikeNew")) HasLikeNew = true;
            else if(Conditions.get(i).equals("ModeratelyUsed")) HasModeratelyUsed = true;
            else if(Conditions.get(i).equals("HeavilyUsed")) HasHeavilyUsed = true;
        }
        writer.write(Boolean.toString(HasLikeNew));
        writer.write(Boolean.toString(HasModeratelyUsed));
        writer.write(Boolean.toString(HasHeavilyUsed));
        writer.write(Boolean.toString(AvailableCount != 0));
    }
    public void Book() {
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

