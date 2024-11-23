package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;


public class sellBookPage extends CycledView{
	
	public boolean isLikeNew;
	public boolean isModerate;
	public boolean isHeavily;
	public Button uploadImage;
	
	sellBookPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
		super(next1, next2, next3, next4, next5);
		// TODO Auto-generated constructor stub
	}

	void createGUI() {
		Label Title = new Label("Sun Devil Book Exchange");
		Title.setStyle("-fx-pref-width: 372px;\r\n"
				+ "    -fx-pref-height: 62px;\r\n"
				+ "    -fx-text-fill: #BF0045;\r\n"
				+ "    -fx-font-family: \"Alumni Sans\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 30px;\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		Title.setLayoutX(497);
		Title.setLayoutY(0);
		
		Label Sell = new Label("Sell");
		Sell.setStyle("-fx-pref-width: 242px;\r\n"
				+ "    -fx-pref-height: 79px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Alumni Sans\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 50px;\r\n"
				+ "    -fx-alignment: baseline-left;");
		Sell.setLayoutX(113);
		Sell.setLayoutY(114);
		
		TextField titleField = new TextField();
		titleField.setStyle(" -fx-pref-width: 570px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-border-color: #E2D1B1;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;"
				+ "    -fx-background-radius: 6px;         /* Use -fx-background-radius for border radius */\r\n"
	    		+ "    -fx-font-family: \"Inter\";           /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 500;               /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;                /* Use -fx-font-size for font size */\r\n"
	    		+ "	-fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;         /* Align text to the left */");
		titleField.setLayoutX(113);
		titleField.setLayoutY(180);
		titleField.setPromptText("Enter Book Title");
		
		TextField authorField = new TextField();
		authorField.setStyle(" -fx-pref-width: 570px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-border-color: #E2D1B1;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;"
				+ "    -fx-background-radius: 6px;         /* Use -fx-background-radius for border radius */\r\n"
	    		+ "    -fx-font-family: \"Inter\";           /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 500;               /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;                /* Use -fx-font-size for font size */\r\n"
	    		+ "	-fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;         /* Align text to the left */");
		authorField.setLayoutX(113);
		authorField.setLayoutY(180 + 40);
		authorField.setPromptText("Enter Book Author");
		
		TextField ISBNField = new TextField();
		ISBNField.setStyle(" -fx-pref-width: 570px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-border-color: #E2D1B1;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;"
				+ "    -fx-background-radius: 6px;         /* Use -fx-background-radius for border radius */\r\n"
	    		+ "    -fx-font-family: \"Inter\";           /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 500;               /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;                /* Use -fx-font-size for font size */\r\n"
	    		+ "	-fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;         /* Align text to the left */");
		ISBNField.setLayoutX(113);
		ISBNField.setLayoutY(180 + 80);
		ISBNField.setPromptText("Enter Book ISBN");
		
		//----------Condition Box----------//
		
		Rectangle ConditionRect = new Rectangle();
		ConditionRect.setFill(Color.WHITE);
		ConditionRect.setWidth(212);
		ConditionRect.setHeight(180);
		ConditionRect.setX(114);
		ConditionRect.setY(484);
		ConditionRect.setStyle(" -fx-pref-width: 212px;\r\n"
				+ "    -fx-pref-height: 180px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FFFFFF; \r\n"
				+ "    -fx-border-color: #C0C0C0;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;");
		
		Label Condition = new Label("Condition");
		Condition.setStyle("-fx-pref-width: 87px;\r\n"
				+ "    -fx-pref-height: 37px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 18px;\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		Condition.setLayoutX(173);
		Condition.setLayoutY(490);
		
		Line line = new Line();
		line.setStartX(125);
		line.setStartY(527);
		line.setEndX(125+183);
		line.setEndY(527);
		
		RadioButton likeNew = new RadioButton("Used Like New (90%)");
		likeNew.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		likeNew.setLayoutX(129);
		likeNew.setLayoutY(544);
		
		RadioButton moderatelyUsed = new RadioButton("Moderately Used (75%)");
		moderatelyUsed.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		moderatelyUsed.setLayoutX(129);
		moderatelyUsed.setLayoutY(544 + 35);
		
		RadioButton heavilyUsed = new RadioButton("Heavily Used (50%)");
		heavilyUsed.setStyle(" -fx-pref-width:195px;\r\n"
				+ "    -fx-pref-height: 27px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		heavilyUsed.setLayoutX(129);
		heavilyUsed.setLayoutY(544 +70);
		
		EventHandler<ActionEvent> likeNew_event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if (likeNew.isSelected()) {
					isLikeNew = true;
					isModerate = false;
					isHeavily = false;
			
					moderatelyUsed.setSelected(false);
					heavilyUsed.setSelected(false);
				} else {
					isLikeNew = false;
				}
			}
		};
		EventHandler<ActionEvent> moderatelyUsed_event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if (moderatelyUsed.isSelected()) {
					isLikeNew = false;
					isModerate = true;
					isHeavily = false;
			
					likeNew.setSelected(false);
					heavilyUsed.setSelected(false);
				} else {
					isModerate = false;
				}
			}
		};
		EventHandler<ActionEvent> heavilyUsed_event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if (heavilyUsed.isSelected()) {
					isLikeNew = false;
					isModerate = false;
					isHeavily = true;
			
					moderatelyUsed.setSelected(false);
					likeNew.setSelected(false);
				} else {
					isHeavily = false;
				}
			}
		};
		
		likeNew.setOnAction(likeNew_event);
		moderatelyUsed.setOnAction(moderatelyUsed_event);
		heavilyUsed.setOnAction(heavilyUsed_event);
		
		//---------Synopsis---------//
		
		TextArea synopsis = new TextArea();
		synopsis.setMaxWidth(569);
		synopsis.setMaxHeight(177);
		synopsis.setLayoutX(114);
		synopsis.setLayoutY(302);
		synopsis.setStyle("-fx-pref-width: 569px;\r\n"
				+ "    -fx-pref-height: 177px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: normal; /* 400 corresponds to normal weight in JavaFX */\r\n"
				+ "    -fx-font-size: 18px;\r\n"
				+ "    -fx-line-spacing: 1.3em; /* Adjusts line spacing */\r\n");
		synopsis.setWrapText(true);
		synopsis.setPromptText("Enter Synopsis (optional)");
		
		//----------Image Uploader---------//
		
		uploadImage = new Button("Upload Image\n(optional)");
		uploadImage.setLayoutX(1108);
		uploadImage.setLayoutY(601);
		uploadImage.setStyle("-fx-pref-width: 120px;\r\n"
				+ "    -fx-pref-height: 32px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #EBEBEB;\r\n"
				+ "    -fx-text-fill: #232323;\r\n"
				+ "    -fx-border-color: #232323;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: normal; /* 400 corresponds to normal weight in JavaFX */\r\n"
				+ "    -fx-font-size: 10px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */");
		
		Label label = new Label();
		ImageView bookImg = new ImageView();
		bookImg.setFitWidth(357);
		bookImg.setFitHeight(395);
		bookImg.setX(989);
		bookImg.setY(186);
		// FileChooser to select an image
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.bmp", "*.gif")
        );
		
		Rectangle ImagePlaceholder = new Rectangle();
		ImagePlaceholder.setWidth(357);
		ImagePlaceholder.setHeight(395);
		ImagePlaceholder.setX(989);
		ImagePlaceholder.setY(186);
		ImagePlaceholder.setFill(Color.GRAY);
        
		uploadImage.setOnAction(actionEvent -> {
			// Open the FileChooser dialog
			Window window = uploadImage.getScene().getWindow();
            if (window instanceof Stage) {
                File selectedFile = fileChooser.showOpenDialog((Stage) window);
                if (selectedFile != null) {
                    Image image = new Image(selectedFile.toURI().toString());
                    bookImg.setImage(image);
                }
            }
		});
		
		//----------Add Categories----------//
		
		Rectangle CategoryBox = new Rectangle();
		CategoryBox.setFill(Color.WHITE);
		CategoryBox.setWidth(212);
		CategoryBox.setHeight(447);
		CategoryBox.setX(716);
		CategoryBox.setY(186);
		CategoryBox.setStyle("-fx-pref-width: 212px;\r\n"
				+ "    -fx-pref-height: 447px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: rgba(255, 255, 255, 0.77); /* #FFFFFFC4 in RGBA */\r\n"
				+ "    -fx-border-color: #C0C0C0;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 8px;\r\n"
				+ "    -fx-background-radius: 8px;");
		
		Label addCategory = new Label("Add Category(s)");
		addCategory.setStyle(" -fx-pref-width: 143px;\r\n"
				+ "    -fx-pref-height: 109px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 18px;\r\n"
				+ "    -fx-alignment: baseline-left; /* Aligns text to the left */");
		addCategory.setLayoutX(747);
		addCategory.setLayoutY(186);
		
		Line Categoryline = new Line();
		Categoryline.setStartX(727);
		Categoryline.setStartY(293);
		Categoryline.setEndX(727+183);
		Categoryline.setEndY(293);
		
		//1 = Education, 2 = Non-fiction, 3 = Fiction, 4 = Mathematics, 5 = Biology, 6 = Computer Science, 7 = Music, 8 = History
		
		CheckBox category1 = new CheckBox("Education");
		category1.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category1.setLayoutX(731);
		category1.setLayoutY(300);
		
		CheckBox category2 = new CheckBox("Non-fiction");
		category2.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category2.setLayoutX(731);
		category2.setLayoutY(340);
		
		CheckBox category3 = new CheckBox("Fiction");
		category3.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category3.setLayoutX(731);
		category3.setLayoutY(380);
		
		CheckBox category4 = new CheckBox("Mathematics");
		category4.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category4.setLayoutX(731);
		category4.setLayoutY(420);
		
		CheckBox category5 = new CheckBox("Biology");
		category5.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category5.setLayoutX(731);
		category5.setLayoutY(460);
		
		CheckBox category6 = new CheckBox("Computer Science");
		category6.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category6.setLayoutX(731);
		category6.setLayoutY(500);
		
		CheckBox category7 = new CheckBox("Music");
		category7.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category7.setLayoutX(731);
		category7.setLayoutY(540);
		
		CheckBox category8 = new CheckBox("History");
		category8.setStyle(" -fx-pref-width:168px;\r\n"
				+ "    -fx-pref-height: 39px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-border-color: #FFFFFF;\r\n"
				+ "    -fx-border-width: 1.5px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 14px;\r\n");
		category8.setLayoutX(731);
		category8.setLayoutY(580);
		
		//----------Price Calculator----------//
		
		Label OriginalBookPrice = new Label("Original Book Price");
		OriginalBookPrice.setStyle("-fx-pref-width: 205px;\r\n"
				+ "    -fx-pref-height: 43px;\r\n"
				+ "    -fx-text-fill: #444444;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 20px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text horizontally and vertically */");
		OriginalBookPrice.setLayoutX(423);
		OriginalBookPrice.setLayoutY(484);
		
		TextField originalBookPriceField = new TextField();
		originalBookPriceField.setStyle("-fx-pref-width: 175px;\r\n"
				+ "    -fx-pref-height: 41px;\r\n"
				+ "    -fx-padding: 8px;\r\n"
				+ "    -fx-background-color: #FFFFFF;\r\n"
				+ "    -fx-border-color: #CCCCCC;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;");
		originalBookPriceField.setLayoutX(438);
		originalBookPriceField.setLayoutY(532);
		originalBookPriceField.setPromptText("0.00");
		
		//----------Functional Buttons---------//
		
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
		
		log_out_btn.setOnAction(actionEvent -> {
			Title.setText("");
			synopsis.setText("");
			likeNew.setSelected(false);
			moderatelyUsed.setSelected(false);
			heavilyUsed.setSelected(false);
			category1.setSelected(false);
			category2.setSelected(false);
			category3.setSelected(false);
			category4.setSelected(false);
			category5.setSelected(false);
			category6.setSelected(false);
			category7.setSelected(false);
			category8.setSelected(false);
			originalBookPriceField.setText("");
			getChildren().remove(bookImg);
			callNext1();
		});
		
		
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
		
		back_btn.setOnAction(actionEvent -> {
			callNext2();
		});
		
		
		Button list_book_btn = new Button("List My Book");
		list_book_btn.setStyle("-fx-pref-width: 212px;\r\n"
				+ "    -fx-pref-height: 53px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 2px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */");
		list_book_btn.setOnMouseEntered(e -> list_book_btn.setStyle("-fx-pref-width: 212px;\r\n"
				+ "    -fx-pref-height: 53px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 2px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */")); 
		list_book_btn.setOnMouseExited(e -> list_book_btn.setStyle("-fx-pref-width: 212px;\r\n"
				+ "    -fx-pref-height: 53px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #FEF67F;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 2px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px;\r\n"
				+ "    -fx-background-radius: 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n"
				+ "    -fx-alignment: center; /* Centers the text inside the button */"));
		list_book_btn.setLayoutX(1124);
		list_book_btn.setLayoutY(101);
		
		Label Warning1 = new Label("Error: Please Enter All Required Fields!");
		Warning1.setLayoutX(1366/2 - 200); 
		Warning1.setLayoutY(730);
		Warning1.setTextFill(Color.RED);
		Warning1.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		Label Warning2 = new Label("Error: Original Book Price Should Be Numbers!");
		Warning2.setLayoutX(1366/2 - 200); 
		Warning2.setLayoutY(730);
		Warning2.setTextFill(Color.RED);
		Warning2.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		Label Warning3 = new Label("Error: Please Choose Condition!");
		Warning3.setLayoutX(1366/2 - 200); 
		Warning3.setLayoutY(730);
		Warning3.setTextFill(Color.RED);
		Warning3.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		Label Warning4 = new Label("Error: Please Choose At Least 1 Category!");
		Warning4.setLayoutX(1366/2 - 200); 
		Warning4.setLayoutY(730);
		Warning4.setTextFill(Color.RED);
		Warning4.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n");
		
		list_book_btn.setOnAction(actionEvent -> {
			
			if (titleField.getText().length() <= 0 || authorField.getText().length() <= 0 || ISBNField.getText().length() <= 0 || originalBookPriceField.getText().length() <= 0) {
				getChildren().remove(Warning1);
				getChildren().remove(Warning2);
				getChildren().remove(Warning3);
				getChildren().remove(Warning4);
				getChildren().add(Warning1);
				return;
			}
			
			if (isLikeNew == false && isModerate == false && isHeavily == false) {
				getChildren().remove(Warning1);
				getChildren().remove(Warning2);
				getChildren().remove(Warning3);
				getChildren().remove(Warning4);
				getChildren().add(Warning3);
				return;
			}
			
			int numBooks = 0;
	    	
			BufferedReader numBooksReader = null;
			try {
				numBooksReader = new BufferedReader(new FileReader("Books/numBooks.txt"));
				numBooks = Integer.parseInt(numBooksReader.readLine());
				numBooksReader.close();
			} catch (IOException | NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numBooks++;
			
			Book newBook = new Book();
			newBook.Title = titleField.getText();
			newBook.Author = authorField.getText();
			newBook.ISBN = ISBNField.getText();
			newBook.description = synopsis.getText();
			
			try {
				newBook.price = Double.parseDouble(originalBookPriceField.getText());
			} catch (NumberFormatException E) {
				getChildren().remove(Warning1);
				getChildren().remove(Warning2);
				getChildren().remove(Warning3);
				getChildren().remove(Warning4);
				getChildren().add(Warning2);
				return;
			}
			newBook.available = 1;
			newBook.seller = mainMenuPage.welcomeName.getText().substring(8);
			
			ArrayList<Integer> newCategory = new ArrayList<Integer>();
			
			if (category1.isSelected()) { newCategory.add(1); }
			if (category2.isSelected()) { newCategory.add(2); }
			if (category3.isSelected()) { newCategory.add(3); }
			if (category4.isSelected()) { newCategory.add(4); }
			if (category5.isSelected()) { newCategory.add(5); }
			if (category6.isSelected()) { newCategory.add(6); }
			if (category7.isSelected()) { newCategory.add(7); }
			if (category8.isSelected()) { newCategory.add(8); }
			
			if (newCategory.size() == 0) {
				getChildren().remove(Warning1);
				getChildren().remove(Warning2);
				getChildren().remove(Warning3);
				getChildren().remove(Warning4);
				getChildren().add(Warning4);
				return;
			}
			
			newBook.Catagory = newCategory;
			
			if (isLikeNew == true) { newBook.Condition = 1; }
			if (isModerate == true) { newBook.Condition = 2; }
			if (isHeavily == true) { newBook.Condition = 3; }
			
			try {
				BookSearchUtilities.addBook(newBook);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (bookImg.getImage() != null) {
                try {
                    // Get the current image and convert it to a WritableImage
                    WritableImage writableImage = new WritableImage((int) bookImg.getFitWidth(), (int) bookImg.getFitHeight());
                    bookImg.snapshot(null, writableImage);

                    // Save the WritableImage to a file in the project's directory
                    File outputFile = new File("BookImages/" + numBooks + ".png");
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", outputFile);

                    System.out.println("Image saved to: " + outputFile.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
			callNext2();
		});
		
		
		getChildren().addAll(Title, Sell, titleField, ISBNField, authorField, ConditionRect, Condition, line, likeNew, moderatelyUsed, heavilyUsed, synopsis, uploadImage, ImagePlaceholder, bookImg
				, CategoryBox, addCategory, Categoryline, category1, category2, category3, category4, category5, category6, category7, category8, OriginalBookPrice, originalBookPriceField, log_out_btn
				, back_btn, list_book_btn);
	}
}
