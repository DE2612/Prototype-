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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//**********FOR TESTING END************************//

public class bookSearchPage extends CycledView {

  bookSearchPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
    super(next1, next2, next3, next4, next5);
  }
  
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
  public static ImageView booksDisplay = new ImageView();
  
  public static Pane resultsPane;
  
  @Override
  void createGUI() {
      title.setText("Sun Devil Book Exchange");
      title.setStyle("-fx-pref-width: 372px;\n"
      		+ "    -fx-pref-height: 62px;\n"
      		+ "    -fx-text-fill: #BF0045;\n"
      		+ "    -fx-font-family: \"Alumni Sans\";\n"
      		+ "    -fx-font-weight: bold;\n"
      		+ "    -fx-font-size: 30px;\n"
      		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
      title.setLayoutX(497);
      title.setLayoutY(0);
      
      //****** Page Title Formatting ******//
      pageTitle.setText("Book Search");
      pageTitle.setStyle(" -fx-pref-width: 242px;\n"
      		+ "    -fx-pref-height: 79px;\n"
      		+ "    -fx-text-fill: #444444;\n"
      		+ "    -fx-font-family: \"Alumni Sans\";\n"
      		+ "    -fx-font-weight: bold;\n"
      		+ "    -fx-font-size: 35px;\n"
      		+ "    -fx-alignment: baseline-left;");
      pageTitle.setLayoutX(87);
      pageTitle.setLayoutY(114);
      
      //****** Conditions Tile Formatting ******//
      
      Label searchFilter = new Label("Search Filters");
      searchFilter.setStyle("-fx-pref-width: 183px;\n"
      		+ "    -fx-pref-height: 34px;\n"
      		+ "    -fx-text-fill: #BF0045;\n"
      		+ "    -fx-font-family: \"Helvetica\";\n"
      		+ "    -fx-font-weight: bold;\n"
      		+ "    -fx-font-size: 24px;\n"
      		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
      searchFilter.setLayoutX(1039);
      searchFilter.setLayoutY(236);
      
      Line line1 = new Line();
      line1.setStartX(1028);
      line1.setEndX(1028+277);
      line1.setStartY(270);
      line1.setEndY(270);
      
      int checkBoxXcoor = 1039;
      int checkBoxYcoor = 278;
      LikeNewCheckBox = new CheckBox("Used Like New");
      LikeNewCheckBox.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      LikeNewCheckBox.setLayoutX(checkBoxXcoor);
      LikeNewCheckBox.setLayoutY(checkBoxYcoor);
      LikeNewCheckBox.setSelected(true);
      
      ModeratelyUsedCheckBox = new CheckBox("Moderately Used");
      ModeratelyUsedCheckBox.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      ModeratelyUsedCheckBox.setLayoutX(checkBoxXcoor);
      ModeratelyUsedCheckBox.setLayoutY(checkBoxYcoor + 35);
      ModeratelyUsedCheckBox.setSelected(true);
      
      HeavilyUsedCheckBox = new CheckBox("Heavily Used");
      HeavilyUsedCheckBox.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      HeavilyUsedCheckBox.setLayoutX(checkBoxXcoor);
      HeavilyUsedCheckBox.setLayoutY(checkBoxYcoor + 70);
      HeavilyUsedCheckBox.setSelected(true);
      
      Line line2 = new Line();
      line2.setStartX(1028);
      line2.setEndX(1028+277);
      line2.setStartY(384);
      line2.setEndY(384);
      
      int offset = 35;
      CheckBox category1 = new CheckBox("All categories");
      category1.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category1.setLayoutX(checkBoxXcoor);
      category1.setLayoutY(checkBoxYcoor + 120);
      category1.setSelected(true);
      
      CheckBox category2 = new CheckBox("Education");
      category2.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category2.setLayoutX(checkBoxXcoor);
      category2.setLayoutY(checkBoxYcoor + 120 + offset);
      category2.setSelected(true);
      
      CheckBox category3 = new CheckBox("Non-fiction");
      category3.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category3.setLayoutX(checkBoxXcoor);
      category3.setLayoutY(checkBoxYcoor + 120 + offset * 2);
      category3.setSelected(true);
      
      CheckBox category4 = new CheckBox("Fiction");
      category4.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category4.setLayoutX(checkBoxXcoor);
      category4.setLayoutY(checkBoxYcoor + 120+ offset * 3);
      category4.setSelected(true);
      
      CheckBox category5 = new CheckBox("Mathematics");
      category5.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category5.setLayoutX(checkBoxXcoor);
      category5.setLayoutY(checkBoxYcoor + 120 + offset*4);
      category5.setSelected(true);
      
      CheckBox category6 = new CheckBox("Biology");
      category6.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category6.setLayoutX(checkBoxXcoor);
      category6.setLayoutY(checkBoxYcoor + 120 + offset * 5);
      category6.setSelected(true);
      
      CheckBox category7 = new CheckBox("Computer Science");
      category7.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category7.setLayoutX(checkBoxXcoor);
      category7.setLayoutY(checkBoxYcoor + 120 + offset * 6);
      category7.setSelected(true);
      
      CheckBox category8 = new CheckBox("Music");
      category8.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category8.setLayoutX(checkBoxXcoor);
      category8.setLayoutY(checkBoxYcoor + 120 + offset*7);
      category8.setSelected(true);
      
      CheckBox category9 = new CheckBox("History");
      category9.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFEEB7;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFEEB7;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
      category9.setLayoutX(checkBoxXcoor);
      category9.setLayoutY(checkBoxYcoor + 120 + offset * 8);
      category9.setSelected(true);
      
      //****** Results Tile Formatting ******//
      
      Rectangle resultsRect = new Rectangle();
      resultsRect.setX(87);
      resultsRect.setY(238);
      resultsRect.setWidth(896);
      resultsRect.setHeight(400);
      resultsRect.setFill(Color.WHITE);
      resultsRect.setStyle("-fx-pref-width: 896px;\n"
      		+ "    -fx-pref-height: 400px;\n"
      		+ "    -fx-padding: 8px;\n"
      		+ "    -fx-background-color: rgba(255, 252, 246, 0.91); /* #FFFCF6E8 in RGBA */\n"
      		+ "    -fx-border-color: #D9BD82;\n"
      		+ "    -fx-border-width: 1px;\n"
      		+ "    -fx-border-style: solid;");
      
      //****** Search Bar Formatting ******//
      TextField search_field = new TextField("");
      search_field.setStyle(" -fx-pref-width: 358px;\n"
      		+ "    -fx-pref-height: 45px;\n"
      		+ "    -fx-padding: 8px;\n"
      		+ "    -fx-background-color: #FAFAFA;\n"
      		+ "    -fx-text-fill: #7A7A7A;\n"
      		+ "    -fx-border-color: #E05F7E;\n"
      		+ "    -fx-border-width: 1px;\n"
      		+ "    -fx-border-style: solid;\n"
      		+ "    -fx-border-radius: 3px 0px 0px 3px;\n"
      		+ "    -fx-background-radius: 3px 0px 0px 3px;\n"
      		+ "    -fx-font-family: \"Arial\";\n"
      		+ "    -fx-font-weight: normal; /* 400 corresponds to normal weight */\n"
      		+ "    -fx-font-size: 14px;\n"
      		+ "    -fx-line-spacing: 1.3em; /* Adjusts line height */\n"
      		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
      search_field.setLayoutX(87);
      search_field.setLayoutY(180);
      search_field.setPromptText("Title, Author, Keyword or ISBN");
      
      //****** Search Button Formatting ******//
      search_btn.setText("Search");
      search_btn.setStyle(" -fx-pref-width: 90px;\n"
      		+ "    -fx-pref-height: 45px;\n"
      		+ "    -fx-padding: 8px;\n"
      		+ "    -fx-background-color: #E05F7E;\n"
      		+ "    -fx-border-color: #E05F7E;\n"
      		+ "    -fx-border-width: 1px;\n"
      		+ "    -fx-border-style: solid;\n"
      		+ "    -fx-border-radius: 0px 3px 3px 0px;\n"
      		+ "    -fx-background-radius: 0px 3px 3px 0px;");
      search_btn.setLayoutX(444);
      search_btn.setLayoutY(180);
      
      Image ASU_logo = new Image("ASU_logo.png");
	    ImageView ASU = new ImageView(ASU_logo);
	    ASU.setFitWidth(216);
	    ASU.setFitHeight(105);
	    ASU.setLayoutX(1130);
	    ASU.setLayoutY(691);

      //***** Cart Button Formatting ******//
      
      ImageView temp = new ImageView(new Image("cart.png"));
      temp.setFitHeight(54);
      temp.setFitWidth(54);
      
      cart_btn.setGraphic(temp);
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
      
		
		log_out_btn.setText("Log out");
		log_out_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #BF0046;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */");
		log_out_btn.setOnMouseEntered(e -> log_out_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #A60038;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */")); 
		log_out_btn.setOnMouseExited(e -> log_out_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #BF0046;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */"));
		log_out_btn.setLayoutX(14);
		log_out_btn.setLayoutY(729);
		
		back_btn.setText("Back");
		back_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #BF0046;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */");
		back_btn.setOnMouseEntered(e -> back_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #A60038;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */")); 
		back_btn.setOnMouseExited(e -> back_btn.setStyle("-fx-spacing: 15;\r\n"
				+ "    -fx-pref-width: 150px;           /* Preferred width */\r\n"
				+ "    -fx-pref-height: 30px;           /* Preferred height */\r\n"
				+ "    -fx-padding: 0 10 0 10;          /* Padding: top right bottom left */\r\n"
				+ "    -fx-background-color: #BF0046;   /* Background color */\r\n"
				+ "    -fx-text-fill: #FFFFFF;          /* Text color */\r\n"
				+ "    -fx-border-color: transparent;       /* Border color */\r\n"
				+ "    -fx-border-width: 1px;           /* Border width */\r\n"
				+ "    -fx-border-style: solid;          /* Border style */\r\n"
				+ "    -fx-background-radius: 9px;      /* Corner radius */\r\n"
				+ "    -fx-font-family: \"Inter\";        /* Font family */\r\n"
				+ "    -fx-font-weight: 600;             /* Font weight */\r\n"
				+ "    -fx-font-size: 16px;              /* Font size */\r\n"
				+ "    -fx-alignment: center;            /* Text alignment */"));
		back_btn.setLayoutX(14);
		back_btn.setLayoutY(689);
      
   // Pane to hold the search results
      resultsPane = new Pane();
      resultsPane.setPrefSize(896, 400);
      resultsPane.setStyle("-fx-background-color: #FFFFFF;");

      // Wrap the resultsPane inside a ScrollPane
      ScrollPane scrollPane = new ScrollPane(resultsPane);
      scrollPane.setLayoutX(87);
      scrollPane.setLayoutY(238);
      scrollPane.setPrefSize(896, 400);
      scrollPane.setFitToWidth(true); // Adjust the content width to match the scroll area
      
      
      getChildren().addAll(title, pageTitle, log_out_btn, back_btn, cart_btn, search_field, search_btn, resultsRect, scrollPane,
            LikeNewCheckBox, ModeratelyUsedCheckBox, HeavilyUsedCheckBox, ASU, searchFilter, line1, line2,
            category1,category2,category3,category4,category5,category6,category7,category8,category9);

      log_out_btn.setOnAction((ActionEvent e) -> {
    	  resultsPane.getChildren().clear();
          callNext1();
        });
      
      back_btn.setOnAction((ActionEvent e) -> {
    	  callNext2();
      });
      
      cart_btn.setOnAction((ActionEvent e) -> {
    	  callNext3();
      });

      search_btn.setOnAction(event -> {
    	// Clear previous results
          resultsPane.getChildren().clear();

      
          BookSearchUtilities test = new BookSearchUtilities();
          ArrayList<Book> allBooks = null;
         try {
			allBooks = test.readBooks();
			System.out.println(allBooks.size());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
          
          String[] searchTerm = search_field.getText().split(" ");
          
          ArrayList<Integer> BookIndex = new ArrayList<Integer>();
          
          ArrayList<String> allTitle = test.getTitleList(allBooks);
          ArrayList<String> allAuthor = test.getAuthorList(allBooks);
          ArrayList<String> allISBN = test.getISBNList(allBooks);
          
              int yOffset = 20; // Start vertical offset for results
              
              for (int i = 0; i < searchTerm.length; i++) {
            	  ArrayList<Integer> result1 = test.searchList(searchTerm[i], allTitle);
            	  ArrayList<Integer> result2 = test.searchList(searchTerm[i], allAuthor);
            	  ArrayList<Integer> result3 = test.searchList(searchTerm[i], allISBN);
            	  for (int j = 0; j < result1.size(); j++) {
            		  if(!BookIndex.contains(result1.get(j)))
            			  BookIndex.add(result1.get(j));
            	  }
            	  for (int j = 0; j < result2.size(); j++) {
            		  if(!BookIndex.contains(result2.get(j)))
            			  BookIndex.add(result2.get(j));
            	  }
            	  for (int j = 0; j < result3.size(); j++) {
            		  if(!BookIndex.contains(result3.get(j)))
            			  BookIndex.add(result3.get(j));
            	  }
            	  result1.clear();
            	  result2.clear();
            	  result3.clear();
              }
              
              ImageView tmpImg = null;
        	  BufferedReader tempBookReader;
        	  String tmptitle = null;
        	  String tmpAuthor = null;
        	  String tmpISBN = null;
        	  String tmpdescription = null;
        	  String tmpcategories = null;
        	  Double tmpprice = (double) 0;
        	  int tmpcondition = 0;
        	  String tmpseller = null;
        	  
        	  ArrayList<Integer> categoriesSelected = new ArrayList<Integer>();
				if (category2.isSelected()) { categoriesSelected.add(1); }
				if (category3.isSelected()) { categoriesSelected.add(2); }
				if (category4.isSelected()) { categoriesSelected.add(3); }
				if (category5.isSelected()) { categoriesSelected.add(4); }
				if (category6.isSelected()) { categoriesSelected.add(5); }
				if (category7.isSelected()) { categoriesSelected.add(6); }
				if (category8.isSelected()) { categoriesSelected.add(7); }
				if (category9.isSelected()) { categoriesSelected.add(8); }
				if (category1.isSelected()) {
					categoriesSelected.clear();
					categoriesSelected.add(1);
					categoriesSelected.add(2);
					categoriesSelected.add(3);
					categoriesSelected.add(4);
					categoriesSelected.add(5);
					categoriesSelected.add(6);
					categoriesSelected.add(7);
					categoriesSelected.add(8);
				}
				
				ArrayList<Integer> conditionsSelected = new ArrayList<Integer>();
				if (LikeNewCheckBox.isSelected()) { conditionsSelected.add(1); }
				if (ModeratelyUsedCheckBox.isSelected()) { conditionsSelected.add(2); }
				if (HeavilyUsedCheckBox.isSelected()) { conditionsSelected.add(3); }
				
              
				System.out.println(BookIndex);
              for (int i = 0; i < BookIndex.size(); i++) {
            	  FileInputStream path = null;
            	  String availability = "";
            	  try {
            		  tempBookReader = new BufferedReader(new FileReader("Books/BookNo" + BookIndex.get(i) + ".txt"));
            		  availability = tempBookReader.readLine();
	          		 	tmptitle = tempBookReader.readLine();
	          		 	tmpAuthor = tempBookReader.readLine();
	          		 	tmpISBN = tempBookReader.readLine();
	          		 	tmpdescription = tempBookReader.readLine();
	          		 	tmpcategories = tempBookReader.readLine();
	          		 	tmpprice = Double.parseDouble(tempBookReader.readLine());
	          		 	tmpcondition = Integer.parseInt(tempBookReader.readLine());
	          		 	tmpseller = tempBookReader.readLine();
	          		 	
            	  } catch (IOException e1) {
					// 	TODO Auto-generated catch block
            		  e1.printStackTrace();
            	  }
            	  if (availability.equals("0")) {
            		  System.out.print(BookIndex.get(i) + " ");
            		  continue;
            	  }
				
            	  int not_matching_count = 0;
            	  for (int j = 0; j < categoriesSelected.size(); j++) {
            		  if (!tmpcategories.contains(Integer.toString(categoriesSelected.get(j)))) {
						//System.out.println("working");
            			  not_matching_count++;
            		  }
            	  }
            	  if (not_matching_count == categoriesSelected.size()) {
            		  continue;
            	  }
            	  
            	  not_matching_count = 0;
            	  for (int j = 0; j < conditionsSelected.size(); j++) {
            		  if (tmpcondition != conditionsSelected.get(j)) {
						//System.out.println("working");
            			  not_matching_count++;
            		  }
            	  }
            	  if (not_matching_count == conditionsSelected.size()) {
            		  continue;
            	  }
				
            	  String[] listCategories = tmpcategories.split(" ");
            	  String bookCategory = "";
            	  for (int j = 0; j < listCategories.length; j++) {
            		  if (listCategories[j].equals("1")) { bookCategory += ", Education"; }
            		  if (listCategories[j].equals("2")) { bookCategory += ", Non-fiction"; }
            		  if (listCategories[j].equals("3")) { bookCategory += ", Fiction"; }
            		  if (listCategories[j].equals("4")) { bookCategory += ", Mathematics"; }
            		  if (listCategories[j].equals("5")) { bookCategory += ", Biology"; }
            		  if (listCategories[j].equals("6")) { bookCategory += ", Computer Science"; }
            		  if (listCategories[j].equals("7")) { bookCategory += ", Music"; }
            		  if (listCategories[j].equals("8")) { bookCategory += ", History"; }
            		  
            	  }
            	  bookCategory = "Categories: " + bookCategory.substring(2);
            	  
            	  @SuppressWarnings("unused")
            	  String bookCondition = "";
				
            	  switch(tmpcondition) {
            	  case 1:
            		  bookCondition = "Condition: Used Like New";
            		  break;
            		  
            	  case 2:
            		  bookCondition = "Condition: Moderately Used";
            		  break;
            		  
            	  default:
            		  bookCondition = "Condition: Heavily Used";
            		  break;
            	  }
            	  
            	  
            	  Label details = new Label("Title: " + tmptitle + "\nAuthor: " + tmpAuthor + "\nSeller: " + tmpseller);
            	  details.setLayoutX(200);
            	  details.setLayoutY(yOffset);
            	  details.setStyle("-fx-pref-width: 500px;\n"
						+ "    -fx-pref-height: 150px;\n"
						+ "    -fx-text-fill: #232323;\n"
						+ "    -fx-font-family: \"Helvetica\";\n"
						+ "    -fx-font-weight: normal; /* 400 corresponds to normal weight */\n"
						+ "    -fx-font-size: 30px;\n"
						+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
            	  try {
            		  path = new FileInputStream("BookImages/" + BookIndex.get(i) + ".png");
            		  tmpImg = new ImageView(new Image(path));
            		  tmpImg.setFitWidth(103);
            		  tmpImg.setFitHeight(143);
            		  tmpImg.setX(30);
            		  tmpImg.setY(yOffset);
            		  
            		  String titleEnclosed = tmptitle;
            		  String detailsEnclosed = "Author(s): " + tmpAuthor + "\nISBN: " + tmpISBN + "\n" + bookCondition + "\n" + bookCategory + "\n\nSynopsis";
            		  String synopsisEnclosed = tmpdescription;
            		  Double priceEnclosed = tmpprice;
            		  int index = i;
            		  tmpImg.setOnMouseClicked(e -> {
            			  bookViewPage.TitleOfBook.setText("" + titleEnclosed);
            			  bookViewPage.BookDetails.setText("" + detailsEnclosed);
            			  bookViewPage.Synopsis.setText("" + synopsisEnclosed);
            			  bookViewPage.Price.setText(String.format("Price: $%.2f", priceEnclosed));
            			  Image tmpImage = null;
            			  try {
            				  tmpImage = new Image(new FileInputStream("BookImages/" + BookIndex.get(index) + ".png"));
            			  } catch (FileNotFoundException e1) {
							// 	TODO Auto-generated catch block
            				  e1.printStackTrace();
            			  }
            			  bookViewPage.imgView.setImage(tmpImage);
            			  bookViewPage.bookIndex = BookIndex.get(index);
            			  bookViewPage.imageSet = true;
            			  callNext4();
            		  });
            		  resultsPane.getChildren().add(tmpImg);
            	  } catch (FileNotFoundException e1) {
            		  // TODO Auto-generated catch block
            		  tmpImg = new ImageView("placeholder.png");
            		  tmpImg.setFitWidth(103);
            		  tmpImg.setFitHeight(143);
            		  tmpImg.setX(30);
            		  tmpImg.setY(yOffset);
            		  
            		  String titleEnclosed = tmptitle;
            		  String detailsEnclosed = "Author(s): " + tmpAuthor + "\n\n" + bookCondition + "\n" + bookCategory + "\n\nSynopsis";
            		  String synopsisEnclosed = tmpdescription;
            		  Double priceEnclosed = tmpprice;
            		  int index = i;
            		  tmpImg.setOnMouseClicked(e -> {
            			  bookViewPage.TitleOfBook.setText("" + titleEnclosed);
            			  bookViewPage.BookDetails.setText("" + detailsEnclosed);
            			  bookViewPage.Synopsis.setText("" + synopsisEnclosed);
            			  bookViewPage.Price.setText(String.format("Price: $%.2f", priceEnclosed));
            			  Image tmpImage = new Image("placeholder.png");
            			  bookViewPage.imgView.setImage(tmpImage);
            			  bookViewPage.bookIndex = BookIndex.get(index);
            			  bookViewPage.imageSet = true;
            			  callNext4();
            		  });
            		  resultsPane.getChildren().add(tmpImg);
            		  e1.printStackTrace();
            	  }
				
            	  resultsPane.getChildren().add(details);
				
            	  yOffset += 155;
            	  
              } 
              
              // Adjust the resultsPane height to fit the content
              resultsPane.setPrefHeight(yOffset);


      });
  }
}
