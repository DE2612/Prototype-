package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class BookSearchUtilities {
    private ArrayList<Book> BookList;
    public ArrayList<Book> GetUpdatedList() {
        return BookList;
    }
    BookSearchUtilities() {
    	 BookList = new ArrayList<Book>();
//    	try{
//    		ReadBooks();
//    	} catch(IOException E) {
//    		E.printStackTrace();
//    	}
    }
    public void ReadBooks() throws IOException {
        BookList = new ArrayList<Book>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("BookList.txt"));
            int NumBooks = Integer.parseInt(reader.readLine());
            for(int i = 0; i < NumBooks; i++) {
                Book TempBook = new Book();
                TempBook.SetIndex(i);
                TempBook.ID = reader.readLine();
                TempBook.Title = reader.readLine();
                TempBook.Author = reader.readLine();
                TempBook.ISBN = reader.readLine();
                TempBook.description = reader.readLine();
                TempBook.Catagory = reader.readLine();
                int AvailableCount = Integer.parseInt(reader.readLine());
                for(int i2 = 0; i2 < AvailableCount; i2++) {
                    TempBook.AddBook(Double.parseDouble(reader.readLine()), reader.readLine());
                }
                TempBook.HasLikeNew = Boolean.parseBoolean(reader.readLine());
                TempBook.HasModeratelyUsed = Boolean.parseBoolean(reader.readLine());
                TempBook.HasHeavilyUsed = Boolean.parseBoolean(reader.readLine());
                TempBook.available = Boolean.parseBoolean(reader.readLine());
                BookList.add(TempBook);
            }
            reader.close();

        } catch(IOException E) {
            E.printStackTrace();
        }

    }
    public void WriteBooks() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("BookList.txt"));
            int NumBooks = BookList.size();
            writer.write(Integer.toString(NumBooks) + "\n");
            for(int i = 0; i < NumBooks; i++) {
                Book TempBook = BookList.get(i);
                TempBook.SetIndex(i);
                writer.write(TempBook.ID + "\n");
                writer.write(TempBook.Title + "\n");
                writer.write(TempBook.Author + "\n");
                writer.write(TempBook.ISBN + "\n");
                writer.write(TempBook.description + "\n");
                writer.write(TempBook.Catagory + "\n");
                TempBook.SerializeBook(writer);
            }
            writer.close();
        } catch(IOException E) {
            E.printStackTrace();
        }
    }
    public boolean RemoveBook(Book TargetBook) {//returns bool indicating if a specific book was successfully removed
        return BookList.remove(TargetBook);
    }
    public void AddBook(Book TargetBook) {
        boolean FoundDuplicate = false;
        for(int i = 0; i < BookList.size(); i++) {
            if(BookList.get(i).Title == TargetBook.Title) {
                FoundDuplicate = true;
                BookList.get(i).HasLikeNew |= TargetBook.HasLikeNew;
                BookList.get(i).HasModeratelyUsed |= TargetBook.HasModeratelyUsed;
                BookList.get(i).HasHeavilyUsed |= TargetBook.HasHeavilyUsed;
                for(int j = 0; j < TargetBook.AvailableCount; j++) {
                    BookList.get(i).AddBook(TargetBook.Prices.get(j), TargetBook.Conditions.get(j));
                }
                return;
            };
        }
        if(!FoundDuplicate) {
        	TargetBook.SetIndex(BookList.size());
            BookList.add(TargetBook);
        }
    }
    private int CalcLevenshteinDistance(String InputVal, String ComparativeVal) {
        if(InputVal.equals(ComparativeVal)) return 0;
        int InputLength = InputVal.length();
        int ComparativeLength = ComparativeVal.length();
        if(InputLength == 0) return ComparativeLength;
        if(ComparativeLength == 0) return InputLength;
        if(ComparativeVal.contains(InputVal)) return 0;

        int[] Distances = new int[(InputLength + 1) * (ComparativeLength + 1)];
        for (int i = 0; i <= InputLength; i++) Distances[i] = i;
        for (int j = 0; j <= ComparativeLength; j++) Distances[j * (InputLength + 1)] = j;
        for (int i = 1; i <= InputLength; i++) {
            for (int j = 1; j <= ComparativeLength; j++) {
                int cost = (InputVal.charAt(i - 1) == ComparativeVal.charAt(j - 1)) ? 0 : 1;
                Distances[i + j * (InputLength + 1)] = Math.min(Math.min(Distances[i + j * (InputLength + 1) - 1] + 1, Distances[i + (j - 1) * (InputLength + 1)] + 1), Distances[i + (j - 1) * (InputLength + 1) - 1] + cost);
            }
        }
        return Distances[InputLength + ComparativeLength * (InputLength + 1)];
    }
    public FilteredList<Book> GetSortedBooks(FilteredList<Book> WorkingBookListA, String SearchBy, String SearchTerm, int SimilarityLevel) {//You can use this to progressively refine your search by calling it multiple times on the same "working set"
        ArrayList<Book> WorkingBookList = new ArrayList<Book>(WorkingBookListA);
    	int WorkingSetSize = WorkingBookList.size();
        for (int i = WorkingSetSize - 1; i >= 0; i--) {
            boolean RemoveCurrent = false;
            switch (SearchBy) {
                case "Author":
                    if (CalcLevenshteinDistance(SearchTerm, WorkingBookList.get(i).Author) > SimilarityLevel) RemoveCurrent = true;
                break;
                case "Title":
                    if (CalcLevenshteinDistance(SearchTerm, WorkingBookList.get(i).Title) > SimilarityLevel) RemoveCurrent = true;
                break;
                case "ISBN":
                    if (!WorkingBookList.get(i).ISBN.equals(SearchTerm)) RemoveCurrent = true;
                break;
                case "RemoveHeavilyUsed":
                    if (WorkingBookList.get(i).HasHeavilyUsed) RemoveCurrent = true;
                break;
                case "RemoveModeratelyUsed":
                    if (WorkingBookList.get(i).HasModeratelyUsed) RemoveCurrent = true;
                break;
                case "RemoveLikeNew":
                    if (WorkingBookList.get(i).HasLikeNew) RemoveCurrent = true;
                break;
                case "Catagory":
                    if (!WorkingBookList.get(i).Catagory.equals(SearchTerm)) RemoveCurrent = true;
                break;
            }
            if(RemoveCurrent) WorkingBookList.remove(i);
        }
        WorkingBookList.sort((a, b) -> {return a.Title.compareToIgnoreCase(b.Title);});
        return new FilteredList<Book>(FXCollections.observableArrayList(WorkingBookList));
    }


    /*
        WorkingBookList needs to be created and exist on the UI-side, created/updated by the GetUpdatedList function.
        WorkingBookList is the working list that represents the resulting sorted/filtered books to be displayed by the UI.
        To intiailize: Call ReadBooks.  This will populate the internal total list from the text file.
        Having a private internal list means we dont need to read from the file every time we want to get the unsorted list of books back.
        Calling GetUpdatedList will return a new array that is a copy of the internal one that you can then sort or do whatever with.

        Calling AddBook or RemoveBook will operate on the INTERNAL array, so you should call GetUpdatedList after.

        Sorting example:
        (Say I want to get only the books by the EXACT author(Payton), but I ONLY want "Heavily Used" books... for some reason.)

        *GLOBALS*
            ArrayList<Book> WorkingSet;
            BookSearchUtilities SearchUtils;
        *

        *INSIDE FUNCTION*
            WorkingSet = SearchUtils.GetUpdatedList();
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "Author", "Payton", 6);
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "RemoveModeratelyUsed", "", 0);
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "RemoveLikeNew", "", 0);
        *
        This will return all books with the exact author "Payton" that have "Heavily Used" versions available


        (Say I want to get only the books with titles that contain the phrase "The Apple" but I ONLY want "Moderately Used" or "Like New" books)
        *GLOBALS*
            ArrayList<Book> WorkingSet;
            BookSearchUtilities SearchUtils;
        *

        *INSIDE FUNCTION*
            WorkingSet = SearchUtils.GetUpdatedList();
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "Title", "The Apple", 6);
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "RemoveHeavilyUsed", "", 0);
        *


        (Say I want to get only the books with the title "Hello World" or similar(in case the user Misspells), but I ONLY want "Like New" books)
        *GLOBALS*
            ArrayList<Book> WorkingSet;
            BookSearchUtilities SearchUtils;
        *

        *INSIDE FUNCTION*
            WorkingSet = SearchUtils.GetUpdatedList();
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "Title", "Hellow Wrldd", 6);
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "RemoveHeavilyUsed", "", 0);
            WorkingSet = SearchUtils.GetSortedBooks(WorkingSet, "RemoveModeratelyUsed", "", 0);
        *
        (This will return books whos title is no more than 6 characters different than the query)



        *IDEAS*
            Should I also add an option to sort by the Levenshtein Distance itself, instead of only sorting alphabetically? so results that are closer to the desired one show up first?
            We may want some kind of heuristic for sufficiently related matches/"Similarity" to the search query
        *
     */



}
