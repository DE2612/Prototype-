package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class bookViewPage extends CycledView{
	
	public static int bookIndex;
	public static Label TitleOfBook;
	public static Label BookDetails;
	public static TextArea Synopsis;
	public static Label Price;
	public static FileInputStream Path = null;
	public static ImageView imgView;
	public static boolean imageSet = false;
	
	public static Button AddToCart = new Button();

	bookViewPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
		super(next1, next2, next3, next4, next5);
		// TODO Auto-generated constructor stub
	}

	@Override
	void createGUI() {
		// TODO Auto-generated method stub
		Label Warning1 = new Label("Error: Book is already in cart!");
		Warning1.setLayoutX(1366/2 - 200); 
		Warning1.setLayoutY(730);
		Warning1.setTextFill(Color.RED);
		Warning1.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		try {
			Path = new FileInputStream("src/placeholder.png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image tmpImage = new Image(Path);
		imgView = new ImageView(tmpImage);
		imgView.setFitWidth(409);
		imgView.setFitHeight(456);
		imgView.setX(78);
		imgView.setY(142);
		
		TitleOfBook = new Label("Title of Book");
		TitleOfBook.setStyle("-fx-pref-width: 450px;\r\n"
				+ "    -fx-pref-height: 64px;\r\n"
				+ "    -fx-text-fill: #232323;\r\n"
				+ "    -fx-font-family: \"Alumni Sans\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 55px;\r\n"
				+ "    -fx-underline: true; /* Applies underline to the text */\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		TitleOfBook.setLayoutX(510);
		TitleOfBook.setLayoutY(123);
		
		BookDetails = new Label("Author(s): John Doe" + "\n\nCondition: Used Like New" + "\nCategories: Fiction, Fantasy" + "\n\nSynopsis");
		BookDetails.setStyle(" -fx-pref-width: 800px;\r\n"
				+ "    -fx-pref-height: 162px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold; /* 400 corresponds to normal weight */\r\n"
				+ "    -fx-font-size: 17px;\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		BookDetails.setLayoutX(515);
		BookDetails.setLayoutY(196);
		
		Synopsis = new TextArea();
		Synopsis.setText("The story takes place in a vibrant fantasy world known as Eldoria, filled with sprawling forests, towering mountains, and ancient ruins. Eldoria is home to various magical creatures, including dragons, elves, and mystical beings. The kingdom is divided into several regions, each with its own unique cultures and landscapes. A powerful artifact, the Heart of Eldoria, lies hidden in the mythical city of Valoria, which is said to grant unimaginable power to its wielder.");
		Synopsis.setStyle("-fx-pref-width: 684px;\r\n"
				+ "    -fx-pref-height: 240px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: rgba(255, 255, 255, 0.66); /* #FFFFFFA8 in RGBA */\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 2px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 5px;\r\n"
				+ "    -fx-background-radius: 5px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 18px;\r\n"
				+ "    -fx-line-spacing: 1.3em; /* Adjusts line height */\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		Synopsis.setEditable(false);
		Synopsis.setWrapText(true);
		Synopsis.setLayoutX(510);
		Synopsis.setLayoutY(358);
		
		AddToCart.setText("Add to cart");
		AddToCart.setStyle("-fx-pref-width: 169px;\r\n"
				+ "    -fx-pref-height: 43px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 20px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */");
		AddToCart.setOnMouseEntered(e -> AddToCart.setStyle("-fx-pref-width: 169px;\r\n"
				+ "    -fx-pref-height: 43px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 20px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */")); 
		AddToCart.setOnMouseExited(e -> AddToCart.setStyle("-fx-pref-width: 169px;\r\n"
				+ "    -fx-pref-height: 43px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #D9BD82;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 20px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */"));
		AddToCart.setLayoutX(1025);
		AddToCart.setLayoutY(201);
		
		
		Price = new Label("Price: $99.99");
		Price.setStyle("-fx-pref-width:400px;\r\n"
				+ "    -fx-pref-height: 63px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Alumni Sans\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 25px;\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		Price.setLayoutX(1025);
		Price.setLayoutY(138);
		
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
		back_btn.setLayoutX(14);
		back_btn.setLayoutY(689);
		
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
		log_out_btn.setLayoutX(14);
		log_out_btn.setLayoutY(729);
		
		Image ASU_logo = new Image("ASU_logo.png");
	    ImageView ASU = new ImageView(ASU_logo);
	    ASU.setFitWidth(216);
	    ASU.setFitHeight(105);
	    ASU.setLayoutX(1130);
	    ASU.setLayoutY(691);
		
		log_out_btn.setOnAction(actionEvent -> {
			getChildren().remove(Warning1);
			bookSearchPage.resultsPane.getChildren().clear();
			callNext2();
		});
		
		back_btn.setOnAction(actionEvent -> {
			getChildren().remove(Warning1);
			callNext1();
		});
		
		
		AddToCart.setOnAction(actionEvent-> {
			ArrayList<String> currenctCart = BookSearchUtilities.readCart(mainMenuPage.welcomeName.getText().substring(8));
			if (currenctCart.contains(Integer.toString(bookIndex)) ) {
				getChildren().remove(Warning1);
				getChildren().add(Warning1);
				return;
			}
			BookSearchUtilities.addToCart(mainMenuPage.welcomeName.getText().substring(8), bookIndex);
			callNext1();
		});
		
		getChildren().addAll(ASU, TitleOfBook, imgView, BookDetails, Synopsis, Price, AddToCart, back_btn, log_out_btn);
		
	}
	
}
