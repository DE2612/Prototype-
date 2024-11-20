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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.BufferedReader;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;

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

/**************************
  //FOR TESTING START
  private TableView<Book> table = new TableView();
  Set<Book> hashSet = new HashSet();   
  private ObservableList<Book> data;
  //FOR TESTING END
****************************/
  
  public static Label pageTitle = new Label();
  public static Label title = new Label();
  public static Rectangle titleRect = new Rectangle();


  public static Button log_out_btn = new Button();
  public static Button back_btn = new Button();
  public static Button cart_btn = new Button();
  
  public static Button search_btn = new Button();

  //public static InputStream booksFile = new FileInputStream("booksTests.txt");
  //public static Image booksAvailable = new Image(booksFile);
  public static ImageView booksDisplay = new ImageView();
  public static ScrollPane bookScroll = new ScrollPane();

  @Override
    void createGUI() {

//*********************************//
//*******FOR TESTING START*********//
/*      
      //Book(String title, String condition, String category, String author, String price)

      hashSet.add(new Book("Title1","Used Like New", "Fiction", "Author1", "10.00"));
      hashSet.add(new Book("Title2","Moderately Used", "Non-Fiction", "Author2", "30.00"));
      hashSet.add(new Book("Title3","Used Like New", "Educational", "Author3", "50.00"));

      data = FXCollections.observableArrayList(hashSet);

      final Label label = new Label("Search Results");
      label.setFont(new Font("Arial", 20));

      table.setEditable(true);

      TableColumn titleCol = new TableColumn("Title");
      titleCol.setMinWidth(100);
      titleCol.setCellValueFactory(
              new PropertyValueFactory<Book, String>("bookTitle"));

      TableColumn conditionCol = new TableColumn("Condition");
      conditionCol.setMinWidth(100);
      conditionCol.setCellValueFactory(
              new PropertyValueFactory<Book, String>("bookCondition"));

      TableColumn categoryCol = new TableColumn("Category");
      categoryCol.setMinWidth(200);
      categoryCol.setCellValueFactory(
              new PropertyValueFactory<Book, String>("bookCategory"));

      TableColumn authorCol = new TableColumn("Author");
      authorCol.setMinWidth(200);
      authorCol.setCellValueFactory(
              new PropertyValueFactory<Book, String>("bookAuthor"));

      TableColumn priceCol = new TableColumn("Price");
      priceCol.setMinWidth(200);
      priceCol.setCellValueFactory(
              new PropertyValueFactory<Book, String>("bookPrice"));

      FilteredList<Book> filteredBooks = new FilteredList(data, p -> true);//Pass the data to a filtered list
      table.setItems(filteredBooks);//Set the table's items using the filtered list
      table.getColumns().addAll(titleCol, conditionCol, categoryCol, authorCol, priceCol);

      ChoiceBox<String> choiceBox = new ChoiceBox();
      choiceBox.getItems().addAll("Title", "Condition", "Category", "Author", "Price");
      choiceBox.setValue("Title");

      TextField textField = new TextField();
      textField.setPromptText("Enter search criteria");
*/
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
      
      //****** Category Tile Formatting ******//
      Rectangle categoryRect = new Rectangle(1075,490,250,220);// right, down, width, height
      categoryRect.setFill(Color.WHITE);
      categoryRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");

      //****** Results Tile Formatting ******//
      Rectangle resultsRect = new Rectangle(50,260,1000,450);// right, down, width, height
      resultsRect.setFill(Color.WHITE);
      resultsRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");
      
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
 

      getChildren().addAll(title, pageTitle, log_out_btn, back_btn, cart_btn, conditionsRect, categoryRect, resultsRect, search_btn, search_field);

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



    search_btn.setOnAction((ActionEvent e) -> {
      // TODO: add code to read text from search_field
      //callNext1();
    

      //***********TESTING************************//
      /*textField.setOnKeyReleased(keyEvent ->
      {
        //TODO: code for book search needed @payton
        if(!textField.getText().equals("")) {
          filteredBooks.setPredicate(p -> p.getTitle().toLowerCase().contains(textField.getText().toLowerCase().trim()));
        }

      });*/
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
      });
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
