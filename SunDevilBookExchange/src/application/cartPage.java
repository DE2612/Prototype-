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
import java.nio.file.Paths;
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

public class cartPage extends CycledView {

	cartPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
    super(next1, next2, next3, next4, next5);
  }
	
  public static ArrayList<Integer> cartArray = new ArrayList<Integer>();
  public static Label pageTitle = new Label();
  public static Label title = new Label();
  
  Double subtotal = (double) 0;
  Double Shipping = (double) 0;
  Double Taxes = (double) 0;
  Double total = (double) 0;
  
  static ArrayList<Integer> choseBookindex = new ArrayList<Integer>();
	  
  public static Pane resultsPane;
  
  @Override
  void createGUI() {
	  
	  Label Warning1 = new Label("Error: Please choose at least 1 item!");
	  Warning1.setLayoutX(1366/2 - 200); 
		Warning1.setLayoutY(730);
		Warning1.setTextFill(Color.RED);
		Warning1.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		
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
      pageTitle.setText("Checkout Cart");
      pageTitle.setStyle(" -fx-pref-width: 312px;\n"
      		+ "    -fx-pref-height: 79px;\n"
      		+ "    -fx-text-fill: #444444;\n"
      		+ "    -fx-font-family: \"Alumni Sans\";\n"
      		+ "    -fx-font-weight: bold;\n"
      		+ "    -fx-font-size: 35px;\n"
      		+ "    -fx-alignment: baseline-left;");
      pageTitle.setLayoutX(95);
      pageTitle.setLayoutY(114);
      
      Rectangle cartHeader = new Rectangle();
      cartHeader.setWidth(741);
      cartHeader.setHeight(55);
      cartHeader.setX(82);
      cartHeader.setY(187);
      cartHeader.setFill(Color.web("#E36986"));
      cartHeader.setStyle("-fx-pref-width: 741px;\r\n"
      		+ "    -fx-pref-height: 55px;\r\n"
      		+ "    -fx-padding: 8px;\r\n"
      		+ "    -fx-background-color: #E36986;\r\n"
      		+ "    -fx-border-color: #D9BD82;\r\n"
      		+ "    -fx-border-width: 1px;\r\n"
      		+ "    -fx-border-style: solid;\r\n"
      		+ "    -fx-border-radius: 3px 3px 0px 0px;\r\n"
      		+ "    -fx-background-radius: 3px 3px 0px 0px;");
      
      Label Item = new Label("Item");
      Item.setStyle("-fx-pref-width: 46px;\r\n"
      		+ "    -fx-pref-height: 38px;\r\n"
      		+ "    -fx-text-fill: #F6F6F6;\r\n"
      		+ "    -fx-font-family: \"Arial\";\r\n"
      		+ "    -fx-font-weight: bold; /* 700 corresponds to bold */\r\n"
      		+ "    -fx-font-size: 13px;\r\n"
      		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
      Item.setLayoutX(102);
      Item.setLayoutY(196);
      
      Label Price = new Label("Price");
      Price.setStyle("-fx-pref-width: 46px;\r\n"
      		+ "    -fx-pref-height: 38px;\r\n"
      		+ "    -fx-text-fill: #F6F6F6;\r\n"
      		+ "    -fx-font-family: \"Arial\";\r\n"
      		+ "    -fx-font-weight: bold; /* 700 corresponds to bold */\r\n"
      		+ "    -fx-font-size: 13px;\r\n"
      		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
      Price.setLayoutX(729);
      Price.setLayoutY(196);
      
		
	  Button log_out_btn = new Button();
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
		log_out_btn.setLayoutX(1145);
		log_out_btn.setLayoutY(57);
		
		
		Button back_btn = new Button();
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
		back_btn.setLayoutX(1145);
		back_btn.setLayoutY(17);
		
		Label totalOrder = new Label();
	    Label youPay = new Label();
		
		Rectangle orderRect = new Rectangle();
		orderRect.setX(883);
		orderRect.setY(187);
		orderRect.setWidth(402);
		orderRect.setHeight(394);
		orderRect.setFill(Color.web("#FAFAFA"));
		orderRect.setStyle(" -fx-pref-width: 402px;\r\n"
				+ "    -fx-pref-height: 394px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FAFAFA;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;");
		
		Label orderSummary = new Label("Order Summary");
		orderSummary.setStyle("    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 20px;\r\n"
				+ "    -fx-line-spacing: 1.3em; /* Adjusts line height */\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		orderSummary.setLayoutX(1010);
		orderSummary.setLayoutY(209);
		
		Line orderLine1 = new Line();
		orderLine1.setStartX(891);
		orderLine1.setEndX(891 + 387);
		orderLine1.setStartY(249);
		orderLine1.setEndY(249);
		
		Line orderLine2 = new Line();
		orderLine2.setStartX(891);
		orderLine2.setEndX(891 + 387);
		orderLine2.setStartY(423);
		orderLine2.setEndY(423);
		
		Button placeOrder = new Button("Place Order");
		placeOrder.setLayoutX(1099);
		placeOrder.setLayoutY(511);
		placeOrder.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;");
		placeOrder.setOnMouseEntered(e -> placeOrder.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;")); 
		placeOrder.setOnMouseExited(e -> placeOrder.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;"));
		
		Button update_btn = new Button("Update");
		update_btn.setLayoutX(954);
		update_btn.setLayoutY(511);
		update_btn.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;");
		update_btn.setOnMouseEntered(e -> update_btn.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;")); 
		update_btn.setOnMouseExited(e -> update_btn.setStyle("-fx-pref-width: 130px;\r\n"
				+ "    -fx-pref-height: 55px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 9px;\r\n"
				+ "    -fx-background-radius: 9px;\r\n"
				+ "    -fx-font-family: \"Inter\";\r\n"
				+ "    -fx-font-weight: 600; /* Semi-bold weight */\r\n"
				+ "    -fx-font-size: 16px;\r\n"
				+ "    -fx-alignment: center;"));
		
		
		Button selectAll = new Button("Select All");
		selectAll.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3D8AF7;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;");
		selectAll.setOnMouseEntered(e -> selectAll.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3373D3;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;")); 
		selectAll.setOnMouseExited(e -> selectAll.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3D8AF7;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;"));
		selectAll.setLayoutX(87);
		selectAll.setLayoutY(654);
		
		Button removeFromCart = new Button("Remove From Cart");
		removeFromCart.setStyle(" -fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #E93578;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;");
		removeFromCart.setOnMouseEntered(e -> removeFromCart.setStyle(" -fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;")); 
		removeFromCart.setOnMouseExited(e -> removeFromCart.setStyle(" -fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #E93578;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;"));
		removeFromCart.setLayoutX(287);
		removeFromCart.setLayoutY(654);
		
		Button showCart = new Button("Show Cart");
		showCart.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3D8AF7;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;");
		showCart.setOnMouseEntered(e -> showCart.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3373D3;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;")); 
		showCart.setOnMouseExited(e -> showCart.setStyle("-fx-pref-width: 190px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #3D8AF7;\r\n"
				+ "    -fx-text-fill: #FAFAFA;\r\n"
				+ "    -fx-border-color: #231F20;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n"
				+ "    -fx-alignment: center;"));
		showCart.setLayoutX(487);
		showCart.setLayoutY(654);
		
		Image ASU_logo = new Image("ASU_logo.png");
	    ImageView ASU = new ImageView(ASU_logo);
	    ASU.setFitWidth(216);
	    ASU.setFitHeight(105);
	    ASU.setLayoutX(1130);
	    ASU.setLayoutY(691);
		
   // Pane to hold the search results
      resultsPane = new Pane();
      resultsPane.setPrefSize(741, 383);
      resultsPane.setStyle("-fx-background-color: #FFFFFF;");

      // Wrap the resultsPane inside a ScrollPane
      ScrollPane scrollPane = new ScrollPane(resultsPane);
      scrollPane.setLayoutX(82);
      scrollPane.setLayoutY(242);
      scrollPane.setPrefSize(741, 383);
      scrollPane.setFitToWidth(true); // Adjust the content width to match the scroll area
     
   
      getChildren().addAll(title, pageTitle, showCart, orderRect, orderSummary, orderLine1, orderLine2, update_btn, placeOrder, selectAll, removeFromCart, cartHeader, 
    		  Item, ASU, Price, log_out_btn, back_btn,scrollPane);

      log_out_btn.setOnAction((ActionEvent e) -> {
    	  totalOrder.setText("");
    	  youPay.setText("");
    	  resultsPane.getChildren().clear();
    	  getChildren().remove(Warning1);
          callNext1();
        });
      
      back_btn.setOnAction((ActionEvent e) -> {
    	  getChildren().remove(Warning1);
    	  callNext2();
      });
     
  
      ArrayList<CheckBox> CheckBoxArray = new ArrayList<CheckBox>();
  
      showCart.setOnAction(event -> {
    	  
    	  ArrayList<String> cartArrayString = new ArrayList<String>();
          cartArrayString = BookSearchUtilities.readCart(mainMenuPage.welcomeName.getText().substring(8));
          
    	  resultsPane.getChildren().clear();
    	  ArrayList<Book> booksInCart = null;
	try {
		booksInCart = BookSearchUtilities.readCertainBooks(cartArrayString);
	} catch (NumberFormatException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      int yOffset = 30; // Start vertical offset for results
      for (int i = 0; i < cartArrayString.size(); i++) { // Create many results to demonstrate scrolling
    	  
    	  Label description = new Label("Title: " + booksInCart.get(i).Title + "\nAuthor(s): " + booksInCart.get(i).Author + "\nSeller: " + booksInCart.get(i).seller);
    	  description.setStyle("-fx-pref-width: 409px;\r\n"
    	  		+ "    -fx-pref-height: 84px;\r\n"
    	  		+ "    -fx-text-fill: #444444;\r\n"
    	  		+ "    -fx-font-family: \"Arial\";\r\n"
    	  		+ "    -fx-font-weight: bold;\r\n"
    	  		+ "    -fx-font-size: 20px;\r\n"
    	  		+ "    -fx-line-spacing: 1.8em; /* Sets the line height */\r\n"
    	  		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
    	  description.setLayoutX(30);
          description.setLayoutY(yOffset);
          
          Label price = new Label(String.format("$%.2f", booksInCart.get(i).price));
          price.setStyle("-fx-pref-width: 84px;\r\n"
          		+ "    -fx-pref-height: 33px;\r\n"
          		+ "    -fx-text-fill: #444444;\r\n"
          		+ "    -fx-font-family: \"Arial\";\r\n"
          		+ "    -fx-font-weight: bold;\r\n"
          		+ "    -fx-font-size: 12px;\r\n"
          		+ "    -fx-line-spacing: 2.3em; /* Adjusts line height */\r\n"
          		+ "    -fx-alignment: center; /* Aligns text to the right */");
          price.setLayoutX(634);
          price.setLayoutY(yOffset + 10);
          
          CheckBoxArray.add(new CheckBox());
          CheckBoxArray.get(i).setLayoutX(666);
          CheckBoxArray.get(i).setLayoutY(yOffset + 40);
          
          Line line1 = new Line();
          line1.setStartX(30);
          line1.setEndX(30 + 697 - 20);
          line1.setStartY(yOffset + 90);
          line1.setEndY(yOffset + 90);

          // Add the result to the pane
          resultsPane.getChildren().addAll(description, price, CheckBoxArray.get(i), line1);

          // Increment vertical offset for the next result
          yOffset += 100; // Space between results
      }
      // Adjust the resultsPane height to fit the content
      resultsPane.setPrefHeight(yOffset);
      });
      
      
      
      update_btn.setOnAction(event -> {
    	  ArrayList<String> cartArrayString = new ArrayList<String>();
          cartArrayString = BookSearchUtilities.readCart(mainMenuPage.welcomeName.getText().substring(8));
    	  ArrayList<Book> booksInCart = null;
    	  try {
    		  booksInCart = BookSearchUtilities.readCertainBooks(cartArrayString);
    	  } catch (NumberFormatException | IOException e1) {
    		  // 	TODO Auto-generated catch block
    		  e1.printStackTrace();
    	  }
			for (int i = 0; i < CheckBoxArray.size(); i++) {
				if (CheckBoxArray.get(i).isSelected()) {
					subtotal += booksInCart.get(i).price;
				}
			}
			Shipping = subtotal * 5 / 100;
			Taxes = subtotal * 8 / 100;
			total = subtotal + Shipping + Taxes;
			if (total == 0) {
				getChildren().remove(Warning1);
				getChildren().add(Warning1);
				return;
			}
			totalOrder.setText((String.format("Subtotal: $%.2f\nShipping: $%.2f\nTaxes: $%.2f\n", subtotal, Shipping, Taxes)));
			totalOrder.setStyle("    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 22px;\r\n"
				+ "    -fx-line-spacing: 1.3em; /* Adjusts line height */\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
			totalOrder.setLayoutX(891);
			totalOrder.setLayoutY(267);
			
			youPay.setText((String.format("You Pay: $%.2f\n", total)));
			youPay.setStyle("    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 22px;\r\n"
				+ "    -fx-line-spacing: 1.3em; /* Adjusts line height */\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
			youPay.setLayoutX(891);
			youPay.setLayoutY(423 + 267 - 249);
			
			subtotal = 0.0;
			Shipping = 0.0;
			Taxes = 0.0;
			total = 0.0;
			
			getChildren().remove(totalOrder);
			getChildren().remove(youPay);
			getChildren().addAll(totalOrder, youPay);
			
		});
      
      selectAll.setOnAction(event -> {
    	  for (int i = 0; i < CheckBoxArray.size(); i++) {
				CheckBoxArray.get(i).setSelected(true);
			}
      });
      
      
      
      removeFromCart.setOnAction(event -> {
    	  
    	  ArrayList<String> cartArrayString = new ArrayList<String>();
          cartArrayString = BookSearchUtilities.readCart(mainMenuPage.welcomeName.getText().substring(8));
          
    	  resultsPane.getChildren().clear();
    	  
	ArrayList<Integer> toBeRemoved = new ArrayList<Integer>();
	for (int i = 0; i < CheckBoxArray.size(); i++) {
		if (CheckBoxArray.get(i).isSelected()) {
			toBeRemoved.add(i);
		}
	}
	for (int i = toBeRemoved.size() - 1; i>=0; i--) {
		cartArrayString.remove(i);
	}
	try {
		Files.delete(Paths.get("Carts/" + mainMenuPage.welcomeName.getText().substring(8) + "Cart.txt"));
		System.out.println("file deleted successfully");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (int i = 0; i < cartArrayString.size(); i++) {
		BookSearchUtilities.addToCart(mainMenuPage.welcomeName.getText().substring(8), Integer.parseInt(cartArrayString.get(i)));
	}
	CheckBoxArray.clear();
	ArrayList<Book> booksInCart = null;
	try {
		booksInCart = BookSearchUtilities.readCertainBooks(cartArrayString);
	} catch (NumberFormatException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
      int yOffset = 30; // Start vertical offset for results
      for (int i = 0; i < cartArrayString.size(); i++) { // Create many results to demonstrate scrolling
    	  
    	  Label description = new Label("Title: " + booksInCart.get(i).Title + "\nAuthor(s): " + booksInCart.get(i).Author + "\nSeller: " + booksInCart.get(i).seller);
    	  description.setStyle("-fx-pref-width: 409px;\r\n"
    	  		+ "    -fx-pref-height: 84px;\r\n"
    	  		+ "    -fx-text-fill: #444444;\r\n"
    	  		+ "    -fx-font-family: \"Arial\";\r\n"
    	  		+ "    -fx-font-weight: bold;\r\n"
    	  		+ "    -fx-font-size: 20px;\r\n"
    	  		+ "    -fx-line-spacing: 1.8em; /* Sets the line height */\r\n"
    	  		+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
    	  description.setLayoutX(30);
          description.setLayoutY(yOffset);
          
          Label price = new Label(String.format("$%.2f", booksInCart.get(i).price));
          price.setStyle("-fx-pref-width: 84px;\r\n"
          		+ "    -fx-pref-height: 33px;\r\n"
          		+ "    -fx-text-fill: #444444;\r\n"
          		+ "    -fx-font-family: \"Arial\";\r\n"
          		+ "    -fx-font-weight: bold;\r\n"
          		+ "    -fx-font-size: 12px;\r\n"
          		+ "    -fx-line-spacing: 2.3em; /* Adjusts line height */\r\n"
          		+ "    -fx-alignment: center; /* Aligns text to the right */");
          price.setLayoutX(634);
          price.setLayoutY(yOffset + 10);
          
          CheckBoxArray.add(new CheckBox());
          CheckBoxArray.get(i).setLayoutX(666);
          CheckBoxArray.get(i).setLayoutY(yOffset + 40);
          
          Line line1 = new Line();
          line1.setStartX(30);
          line1.setEndX(30 + 697 - 20);
          line1.setStartY(yOffset + 90);
          line1.setEndY(yOffset + 90);

          // Add the result to the pane
          resultsPane.getChildren().addAll(description, price, CheckBoxArray.get(i), line1);

          // Increment vertical offset for the next result
          yOffset += 100; // Space between results
      }
      // Adjust the resultsPane height to fit the content
      resultsPane.setPrefHeight(yOffset);
      });
      
      
      placeOrder.setOnAction(event -> {
    	  ArrayList<String> cartArrayString = new ArrayList<String>();
          cartArrayString = BookSearchUtilities.readCart(mainMenuPage.welcomeName.getText().substring(8));
          
    	  resultsPane.getChildren().clear();
    	  
	ArrayList<Integer> toBeRemoved = new ArrayList<Integer>();
	for (int i = 0; i < CheckBoxArray.size(); i++) {
		if (CheckBoxArray.get(i).isSelected()) {
			try {
				BookSearchUtilities.setAvailability(Integer.parseInt(cartArrayString.get(i)), 0);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			toBeRemoved.add(i);
		}
	}
	if (toBeRemoved.size() == 0) {
    	  getChildren().remove(Warning1);
			getChildren().add(Warning1);
			return;
      }
	for (int i = toBeRemoved.size() - 1; i>=0; i--) {
		cartArrayString.remove(i);
	}
	try {
		Files.delete(Paths.get("Carts/" + mainMenuPage.welcomeName.getText().substring(8) + "Cart.txt"));
		System.out.println("file deleted successfully");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (int i = 0; i < cartArrayString.size(); i++) {
		BookSearchUtilities.addToCart(mainMenuPage.welcomeName.getText().substring(8), Integer.parseInt(cartArrayString.get(i)));
	}
	CheckBoxArray.clear();
		  
	totalOrder.setText("");
	  youPay.setText("");
	  resultsPane.getChildren().clear();
	  getChildren().remove(Warning1);
    	  callNext3();
    	  
      });
		
  }
}
