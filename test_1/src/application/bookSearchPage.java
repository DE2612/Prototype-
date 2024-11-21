package application;

//TODO: 
// add search functionality
// add filter by condition functionality
// add filter by category functionality
// import text file with books
// determine how to best display books and import their images
// determine how to display books with buttons to add to cart

import javafx.event.ActionEvent;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

//**************FOR TESTING START*****************//
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//**********FOR TESTING END************************//

public class bookSearchPage extends CycledView {

  bookSearchPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
    super(next1, next2, next3, next4, next5);
  }

  private ArrayList<String> searchArray = new ArrayList<String>();


  private ObservableList<Book> data;
  
  BookSearchUtilities SearchUtils;// = new BookSearchUtilities();
  ArrayList<Book> WorkingSet = new ArrayList<Book>();
  public static Label pageTitle = new Label();
  public static Label title = new Label();
  public static Label emptyInput = new Label();
  public static Label underConstruction = new Label();
  public static Rectangle titleRect = new Rectangle();

  public static CheckBox LikeNewCheckBox = new CheckBox();
  public static CheckBox HeavilyUsedCheckBox = new CheckBox();
  public static CheckBox ModeratelyUsedCheckBox = new CheckBox();

  public static Button log_out_btn = new Button();
  public static Button back_btn = new Button();
  public static Button cart_btn = new Button();
  
  public static Button search_btn = new Button();

  //public static InputStream booksFile = new FileInputStream("booksTests.txt");
  //public static Image booksAvailable = new Image(booksFile);
  public static ImageView booksDisplay = new ImageView();
  public static ScrollPane bookScroll = new ScrollPane();
  FilteredList<Book> filteredBooks;
  public static ObservableList<String> categories_list =
          FXCollections.observableArrayList(
        		  "Any",
                  "Education",
                  "Non-fiction",
                  "Fiction",
                  "Mathematics",
                  "Biology",
                  "Computer Science",
                  "Music",
                  "History"
          );
  
  public static ObservableList<String> SearchByList =
          FXCollections.observableArrayList(
        		  "None",
        		  "Title",
        		  "Author",
        		  "ISBN"
          );
  
  @Override
    void createGUI() {
//*********************************//
//*******FOR TESTING START*********//
	    final ComboBox<String> categories_box = new ComboBox<String>(categories_list);
	    final ComboBox<String> SearchByBox = new ComboBox<String>(SearchByList);

      //Book(String title, String condition, String category, String author, String price)
	  SearchUtils = new BookSearchUtilities();

	  
//TESTING TEMP ADDING BOOKS START	  
/*
	  Book ThisBook = new Book();
	  ThisBook.Title = "Title1";
	  ThisBook.Author = "Author 1";
	  ThisBook.Catagory = "Education";
	  ThisBook.AddBook(10.00, "Used Like New");
	  ThisBook.AddBook(30.00, "Heavily Used");
	  ThisBook.AddBook(15.00, "Used Like New");
	  SearchUtils.AddBook(ThisBook);
	  ThisBook = new Book();
	  ThisBook.Title = "Title2";
	  ThisBook.Author = "Author 2";
	  ThisBook.Catagory = "Education";
	  ThisBook.AddBook(30.00, "Moderately Used");
	  SearchUtils.AddBook(ThisBook);
	  ThisBook = new Book();
	  ThisBook.Title = "Title3";
	  ThisBook.Author = "Author 3";
	  ThisBook.Catagory = "Biology";
	  ThisBook.AddBook(50.00, "Used Like New");
	  SearchUtils.AddBook(ThisBook);
	  try{SearchUtils.WriteBooks();} catch(IOException E) {E.printStackTrace();}
	*/  
//TESTING TEMP ADDING BOOKS END
	  
	  try{SearchUtils.ReadBooks();} catch(IOException E) {E.printStackTrace();}
	  WorkingSet = SearchUtils.GetUpdatedList();

	  

      data = FXCollections.observableArrayList(WorkingSet);

      final Label label = new Label("Search Results");
      label.setFont(new Font("Arial", 20));




      filteredBooks = new FilteredList(data);//Pass the data to a filtered list

      TextField textField = new TextField();
      textField.setPromptText("Enter search criteria");

//**********FOR TESTING END*************//
//*************************************//

      //***** Site Title Formatting ******//
      title.setText("Sun Devil Book Exchange");
      title.setStyle("-fx-pref-width: 455px;          /* Preferred width */\r\n"
          + "    -fx-pref-height: 130px;         /* Preferred height */\r\n"
          + "    -fx-text-fill: #bf0045;         /* Text color */\r\n"
          + "    -fx-font-family: \"Alumni Sans\"; /* Font family */\r\n"
          + "    -fx-font-weight: bold;          /* Font weight */\r\n"
          + "    -fx-font-size: 30px;            /* Font size */\r\n"
          + "    -fx-line-spacing: 0;            /* Line height adjustment */\r\n"
          + "    -fx-text-alignment: center;     /* Text alignment */");
      title.setLayoutX(455);
      title.setLayoutY(-18);
      
      //****** Page Title Formatting ******//
      pageTitle.setText("Book Search");
      pageTitle.setStyle("-fx-pref-width: 900px;          /* Preferred width */\r\n"
          + "    -fx-pref-height: 60px;          /* Preferred height */\r\n"
          + "    -fx-text-fill: #464544;         /* Text color */\r\n"
          + "    -fx-font-family: \"Alumni Sans\"; /* Font family */\r\n"
          + "    -fx-font-weight: bold;          /* Font weight */\r\n"
          + "    -fx-font-size: 40px;            /* Font size */\r\n"
          + "    -fx-line-spacing: 0;            /* Line height adjustment */\r\n"
          + "    -fx-text-alignment: left;       /* Text alignment */");
      pageTitle.setLayoutX(50);
      pageTitle.setLayoutY(146);
      
      //****** Conditions Tile Formatting ******//
      Rectangle conditionsRect = new Rectangle(1075,260,250,220);// right, down, width, height
      conditionsRect.setFill(Color.WHITE);
      conditionsRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");
      
      LikeNewCheckBox = new CheckBox("Like New");
      LikeNewCheckBox.setLayoutX(1075);
      LikeNewCheckBox.setLayoutY(260);
      LikeNewCheckBox.setSelected(true);
      
      ModeratelyUsedCheckBox = new CheckBox("ModeratelyUsed");
      ModeratelyUsedCheckBox.setLayoutX(1075);
      ModeratelyUsedCheckBox.setLayoutY(280);
      ModeratelyUsedCheckBox.setSelected(true);
      
      HeavilyUsedCheckBox = new CheckBox("Heavily Used");
      HeavilyUsedCheckBox.setLayoutX(1075);
      HeavilyUsedCheckBox.setLayoutY(300);
      HeavilyUsedCheckBox.setSelected(true);
      
      //****** Category Tile Formatting ******//
      
      SearchByBox.setPrefWidth(250);
      SearchByBox.setLayoutX(700);
      SearchByBox.setLayoutY(200);
      SearchByBox.setVisibleRowCount(5);
      SearchByBox.setPromptText("Search By");
      
      categories_box.setPrefWidth(250);
      categories_box.setLayoutX(1075);
      categories_box.setLayoutY(500);
      categories_box.setVisibleRowCount(5);
      categories_box.setPromptText("Category");
      
      //****** Results Tile Formatting ******//
      Rectangle resultsRect = new Rectangle(50,260,1000,450);// right, down, width, height
      resultsRect.setFill(Color.WHITE);
      resultsRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");
      
      bookScroll.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");
      bookScroll.setPrefWidth(1000);
      bookScroll.setPrefHeight(450);
      bookScroll.setLayoutX(50);
      bookScroll.setLayoutY(260);
      
      //****** Search Bar Formatting ******//
      TextField search_field = new TextField("Title, Author, Keyword, or ISBN");
      search_field.setStyle("-fx-spacing: 15;"
        + "    -fx-pref-width: 600px;"
        + "    -fx-pref-height: 50px;"
        + "    -fx-padding: 0 10 0 48;"
        + "    -fx-background-color: #FFFFFF;"
        + "    -fx-text-fill: #444444;"
        + "    -fx-border-color: #e05f7e;"
        + "    -fx-border-width: 5px;"
        + "    -fx-border-style: solid;"
        + "    -fx-background-radius: 6px;"
        + "    -fx-font-family: \"Inter\";"
        + "    -fx-font-weight: 500;"
        + "    -fx-font-size: 14px;"
        + "	   -fx-line-spacing: 1.2em;"
        + "    -fx-alignment: CENTER_LEFT;");
      search_field.setLayoutX(50);
      search_field.setLayoutY(200);
      
      //****** Search Button Formatting ******//
      search_btn.setText("Search");
      search_btn.setStyle("-fx-spacing: 15;\r\n"
          + "    -fx-pref-width: 100px;"
          + "    -fx-pref-height: 50px;"
          + "    -fx-padding: 0 10 0 10;"
          + "    -fx-background-color: #e05f7e;"
          + "    -fx-text-fill: #FFFFFF;"
          + "    -fx-border-color: #e05f7e;"
          + "    -fx-border-width: 5px;"
          + "    -fx-border-style: solid;"
          + "    -fx-background-radius: 9px;"
          + "    -fx-font-family: \"Inter\";"
          + "    -fx-font-weight: 600;"
          + "    -fx-font-size: 16px;"
          + "    -fx-alignment: center;");
      search_btn.setLayoutX(650);
      search_btn.setLayoutY(200);

      //***** Log Out Button Formatting ******//
      log_out_btn.setText("Log Out");  // TODO: add username
      log_out_btn.setStyle("-fx-spacing: 15;"
           + "    -fx-pref-width: 150px;"
           + "    -fx-pref-height: 30px;"
           + "    -fx-padding: 0 10 0 10;"
           + "    -fx-background-color: transparent;"
           + "    -fx-text-fill: #BF0046;"
           + "    -fx-background-radius: 9px;"
           + "    -fx-font-family: \"Inter\";"
           + "    -fx-font-weight: 600;"
           + "    -fx-font-size: 16px;"
           + "    -fx-alignment: center;");
      log_out_btn.setLayoutX(1225);
      log_out_btn.setLayoutY(20);

      //***** Back Button Formatting ******//
      back_btn.setText("<< Back");
      back_btn.setStyle("-fx-spacing: 15;"
          + "    -fx-pref-width: 150px;"
          + "    -fx-pref-height: 30px;"
          + "    -fx-padding: 0 10 0 10;"
          + "    -fx-background-color: transparent;"
          + "    -fx-text-fill: #BF0046;"
          + "    -fx-background-radius: 9px;"
          + "    -fx-font-family: \"Inter\";"
          + "    -fx-font-weight: 600;"
          + "    -fx-font-size: 16px;"
          + "    -fx-alignment: center;");
      back_btn.setLayoutX(10);
      back_btn.setLayoutY(20);

      //***** Cart Button Formatting ******//
      cart_btn.setText("Cart"); // TODO: Change to Cart image
      cart_btn.setStyle("-fx-spacing: 15;"
          + "    -fx-pref-width: 150px;"
          + "    -fx-pref-height: 30px;"
          + "    -fx-padding: 0 10 0 10;"
          + "    -fx-background-color: transparent;"
          + "    -fx-text-fill: #BF0046;"
          + "    -fx-background-radius: 9px;"
          + "    -fx-font-family: \"Inter\";"
          + "    -fx-font-weight: 600;"
          + "    -fx-font-size: 16px;"
          + "    -fx-alignment: center;");
      cart_btn.setLayoutX(1230);
      cart_btn.setLayoutY(50);
 

      //***********Message Displayed when search is pressed but textbox is empty*****//
      emptyInput.setText("Empty input. Please enter search criteria.");
      emptyInput.setStyle("-fx-pref-width: 900px;"
              + "    -fx-pref-height: 60px;"
              + "    -fx-text-fill: #464544;"
              + "    -fx-font-family: \"Inter\";"
              + "    -fx-font-size: 30px;"
              + "    -fx-text-alignment: left;");
      emptyInput.setVisible(false);
      emptyInput.setLayoutX(300);
      emptyInput.setLayoutY(350);

    //***********Temporary Message Displayed while search function is under construction**********//
    underConstruction.setText("This function is underconstruction.");
    underConstruction.setStyle("-fx-pref-width: 900px;"
            + "    -fx-pref-height: 60px;"
            + "    -fx-text-fill: RED;"
            + "    -fx-font-family: \"Inter\";"
            + "    -fx-font-size: 30px;"
            + "    -fx-text-alignment: left;");
    underConstruction.setLayoutX(300);
    underConstruction.setLayoutY(350);
    underConstruction.setVisible(false);

      
      
    getChildren().addAll(
            /*labels*/    title, pageTitle, 
            /*buttons*/   log_out_btn, back_btn, cart_btn, search_btn,
            /*shapes*/    conditionsRect, resultsRect,
            /*txt field*/ search_field,
            /*menus*/     categories_box,
            emptyInput, underConstruction, SearchByBox,
            LikeNewCheckBox, ModeratelyUsedCheckBox, HeavilyUsedCheckBox);

      log_out_btn.setOnAction((ActionEvent e) -> {
          callNext1();
        });
      
      back_btn.setOnAction((ActionEvent e) -> {
        // TODO: Figure out why this button isn't working
        callNext2();
      });

      back_btn.setOnAction((ActionEvent e) -> {
        //callNext3();  // TODO: uncomment when cart scene is created
      });

		getChildren().add(bookScroll);

      search_btn.setOnAction((ActionEvent e) -> {
          // TODO: add code to read text from search_field
            String search_criteria = "";
            search_criteria = search_field.getText();

            emptyInput.setVisible(false);
            underConstruction.setVisible(false);
            if (search_criteria.isEmpty()) {
              emptyInput.setVisible(true);
            } else {
              underConstruction.setVisible(true);
            }
            System.out.println(categories_box.getValue());
            filteredBooks = new FilteredList(FXCollections.observableArrayList(SearchUtils.GetUpdatedList()));//Pass the data to a filtered list  
        	if(!LikeNewCheckBox.isSelected())filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, "RemoveLikeNew", "", 0);
        	if(!ModeratelyUsedCheckBox.isSelected())filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, "RemoveModeratelyUsed", "", 0);
        	if(!HeavilyUsedCheckBox.isSelected())filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, "RemoveHeavilyUsed", "", 0);
            if(categories_box.getValue() != null && !categories_box.getValue().equals("Any")) filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, "Catagory", categories_box.getValue(), 0);
            if(SearchByBox.getValue() != null && !SearchByBox.getValue().equals("None")) filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, SearchByBox.getValue(), search_criteria, 2);
        	

    		VBox box = new VBox();

    		for(int i = 0; i < filteredBooks.size(); i++) {
        		HBox SelectedBook = new HBox();
        			Book TempBook = filteredBooks.get(i);
        			Label TempLabel = new Label(filteredBooks.get(i).Title + "    " + filteredBooks.get(i).Author + "    " + filteredBooks.get(i).Catagory);
        			ArrayList<String> AvailableBooks = new ArrayList<String>();
        			for(int j = 0; j < filteredBooks.get(i).AvailableCount; j++) {
        				AvailableBooks.add(filteredBooks.get(i).Conditions.get(j) + ": $" + Double.toString(filteredBooks.get(i).Prices.get(j)));
        			}
        		    final ComboBox<String> AvailableBox = new ComboBox<String>(FXCollections.observableArrayList(AvailableBooks));        			
        		    AvailableBox.setPromptText("Select Your Book");
        		    
        		    Button AddToCartButton = new Button();
        		    AddToCartButton.setText("Add to Cart");
        		    
        		    AddToCartButton.setOnAction((ActionEvent e2) -> {
    		    		System.out.println(AvailableBox.getSelectionModel().getSelectedIndex());
        		    	int BookIndex = TempBook.GetIndex();//This is the index into the book TEXT file, so you can read the file again somewhere and just pass in this index
		    			int BookInstanceIndex = AvailableBox.getSelectionModel().getSelectedIndex();//Since each "Book" instance stores every identitcal book(with varying price/conditions), this is the index into the price/condition list to retrieve a specific book
        		    });
        		    
        			SelectedBook.getChildren().addAll(TempLabel, AvailableBox, AddToCartButton);
        		box.getChildren().add(SelectedBook);
    		}
    		bookScroll.setContent(box);
//          }

        });
      
      
//    search_btn.setOnAction((ActionEvent e) -> {
//      // TODO: add code to read text from search_field
//      //callNext1();
//    
//
//      //***********TESTING************************//
//      textField.setOnKeyReleased(keyEvent ->
//      {
//        //TODO: code for book search needed @payton
//        if(!textField.getText().equals("")) {
//        	filteredBooks = SearchUtils.GetSortedBooks(filteredBooks, "Title", textField.getText(), 2);
//        	//          filteredBooks.setPredicate(p -> p.getTitle().toLowerCase().contains(textField.getText().toLowerCase().trim()));
//    		VBox box = new VBox();
//
//    		for(int i = 0; i < filteredBooks.size(); i++) {
//        		Label TempLabel = new Label(filteredBooks.get(i).Title);
//        		resultsRect.getChildren().add(TempLabel);
//        	}
//    		//bookScroll.setContent(box);
//    		//getChildren().add(bookScroll);
//        }
//
//      });
      //*********FOR TESTING END*****************//
      
/*
      try {
        read();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
        log_id = id_field.getText();
        log_pass = password_field.getText();
        if (log_id.length() <= 0 || log_pass.length() <= 0) {
          System.out.println("Please enter ID and password");
          return;
        }
        for (int i = 0; i < credentialsArray.size(); i++) {
          if (log_id.equals(credentialsArray.get(i)) && log_pass.equals(passwordArray.get(i))) {
  
              mainMenuPage.welcomeName.setText("Welcome " + log_id);
              credentialsArray.clear();
              passwordArray.clear();
              callNext3();
            return;
          }
  
        }
        System.out.println("Wrong ID or password");
*/
      //});
  }
//**************************************************************************//
//**********************book object class FOR TESTING ONLY******************//
/*  
  public static class Book
    {

      private final SimpleStringProperty bookTitle;
      private final SimpleStringProperty bookCondition;
      private final SimpleStringProperty bookCategory;
      private final SimpleStringProperty bookAuthor;
      private final SimpleStringProperty bookPrice;

        private Book(String title, String condition, String category, String author, String price)
        {
          this.bookTitle = new SimpleStringProperty(title);
          this.bookCondition = new SimpleStringProperty(condition);
          this.bookCategory = new SimpleStringProperty(category);
          this.bookAuthor = new SimpleStringProperty(author);
          this.bookPrice = new SimpleStringProperty(price);
        }

        public String getTitle()
        {
            return bookTitle.get();
        }

        public String getCondition()
        {
            return bookCondition.get();
        }

        public String getCategory()
        {
            return bookCategory.get();
        }

        public String getAuthor()
        {
            return bookAuthor.get();
        }

        public String getPrice()
        {
            return bookPrice.get();
        }

        public void setTitle(String title)
        {
            bookTitle.set(title);
        }

        public void setCondition(String condition)
        {
            bookCondition.set(condition);
        }

        public void setCategory(String category)
        {
            bookCategory.set(category);
        }

        public void setAuthor(String author)
        {
            bookAuthor.set(author);
        } 

        public void setPrice(String price)
        {
            bookPrice.set(price);
        }

    }
*/
//**************************************************************************//
}
