package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class loginPage extends CycledView {
	
	loginPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
		super(next1, next2, next3, next4, next5);
		// TODO Auto-generated constructor stub
	}
	
	
	private ArrayList<String> credentialsArray = new ArrayList<String>();
	private ArrayList<String> passwordArray = new ArrayList<String>();
	
	
	void read() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
			String first = reader.readLine();
			int num = Integer.parseInt(first);
			for (int i = 0; i < num; i++) {
				credentialsArray.add(reader.readLine());
				passwordArray.add(reader.readLine());
			}
		} catch(IOException E) {
			E.printStackTrace();
		}
		
	}
	
	static String log_id;
	static String log_pass;

	@Override
	void createGUI() {
		// TODO Auto-generated method stub
	    
	    Rectangle mainRect = new Rectangle();
	    mainRect.setX(836);
	    mainRect.setY(236);
	    mainRect.setWidth(420);
	    mainRect.setHeight(414);
	    mainRect.setFill(Color.WHITE);
	    mainRect.setStyle("-fx-padding: 8px;                    /* Padding (top, right, bottom, left) */\r\n"
	    		+ "	-fx-fill: #FAFAFA;              /* Fill color */\r\n"
	    		+ "	-fx-stroke: transparent;        /* Border color */\r\n"
	    		+ "	-fx-stroke-width: 0;           /* Border width */\r\n"
	    		+ "	-fx-arc-width: 30px;           /* Horizontal radius for rounding corners */\r\n"
	    		+ "	-fx-arc-height: 30px;          /* Vertical radius for rounding corners */");
	    
	    Label signIn = new Label("Sign in");
	    signIn.setStyle("-fx-min-width: 301px; /* Set minimum width */\r\n"
	    		+ "    -fx-min-height: 56px; /* Set minimum height */\r\n"
	    		+ "    -fx-text-fill: #444444; /* Text color */\r\n"
	    		+ "    -fx-font-family: \"Arial\"; /* Font family */\r\n"
	    		+ "    -fx-font-weight: 800; /* Font weight */\r\n"
	    		+ "    -fx-font-size: 30px; /* Font size */\r\n"
	    		+ "    -fx-line-spacing: 0; /* Line height, controlled by default in JavaFX */\r\n"
	    		+ "    -fx-letter-spacing: -0.2px; /* Letter spacing */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT; /* Text alignment */");
	    signIn.setLayoutX(895);
	    signIn.setLayoutY(270);
	    
	    Label Instruction = new Label("Log in by entering your ﻿ASUID \nand password.");
	    Instruction.setStyle("-fx-pref-width: 280px;            /* Use -fx-pref-width for preferred width */\r\n"
	    		+ "    -fx-pref-height: 40px;            /* Use -fx-pref-height for preferred height */\r\n"
	    		+ "    -fx-text-fill: #7A7A7A;           /* Use -fx-text-fill for text color */\r\n"
	    		+ "    -fx-font-family: \"Alumni Sans\";   /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 400;             /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 15px;              /* Use -fx-font-size for font size */\r\n"
	    		+ "    -fx-line-spacing: 0;               /* Line spacing can be set; use 0 for single line height */\r\n"
	    		+ "    -fx-alignment: TOP-LEFT;          /* Align text to the top-left */");
	    Instruction.setLayoutX(895);
	    Instruction.setLayoutY(322);
	    
	    Label ID = new Label("ID");
	    ID.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 189px;          /* Use -fx-pref-width for preferred width */\r\n"
	    		+ "    -fx-pref-height: 21px;          /* Use -fx-pref-height for preferred height */\r\n"
	    		+ "    -fx-text-fill: #7A7A7A;         /* Use -fx-text-fill for text color */\r\n"
	    		+ "    -fx-font-family: \"Arial\";       /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 400;           /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;            /* Use -fx-font-size for font size */\r\n"
	    		+ "    -fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: TOP-LEFT;        /* Align text to the top-left */");
	    ID.setLayoutX(895);
	    ID.setLayoutY(392);
	    
	    TextField id_field = new TextField();
	    id_field.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 300px;             /* Use -fx-pref-width for preferred width */\r\n"
	    		+ "    -fx-pref-height: 41px;             /* Use -fx-pref-height for preferred height */\r\n"
	    		+ "    -fx-padding: 0 10 0 48;            /* Use -fx-padding for padding (top, right, bottom, left) */\r\n"
	    		+ "    -fx-background-color: #FFFFFF;     /* Use -fx-background-color for background color */\r\n"
	    		+ "    -fx-text-fill: #444444;            /* Use -fx-text-fill for text color */\r\n"
	    		+ "    -fx-border-color: #EBEBEB;         /* Use -fx-border-color for border color */\r\n"
	    		+ "    -fx-border-width: 1px;             /* Use -fx-border-width for border width */\r\n"
	    		+ "    -fx-border-style: solid;            /* Use -fx-border-style for border style */\r\n"
	    		+ "    -fx-background-radius: 6px;         /* Use -fx-background-radius for border radius */\r\n"
	    		+ "    -fx-font-family: \"Inter\";           /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 500;               /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;                /* Use -fx-font-size for font size */\r\n"
	    		+ "	-fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;         /* Align text to the left */");
	    id_field.setLayoutX(896);
	    id_field.setLayoutY(411);
	    id_field.setPromptText("Enter ID");
	    
	    Label password = new Label("Password");
	    password.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 189px;          /* Use -fx-pref-width for preferred width */\r\n"
	    		+ "    -fx-pref-height: 21px;          /* Use -fx-pref-height for preferred height */\r\n"
	    		+ "    -fx-text-fill: #7A7A7A;         /* Use -fx-text-fill for text color */\r\n"
	    		+ "    -fx-font-family: \"Arial\";       /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 400;           /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;            /* Use -fx-font-size for font size */\r\n"
	    		+ "    -fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: TOP-LEFT;        /* Align text to the top-left */");
	    password.setLayoutX(895);
	    password.setLayoutY(461);
	    
	    TextField password_field = new TextField();
	    password_field.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 300px;             /* Use -fx-pref-width for preferred width */\r\n"
	    		+ "    -fx-pref-height: 41px;             /* Use -fx-pref-height for preferred height */\r\n"
	    		+ "    -fx-padding: 0 10 0 48;            /* Use -fx-padding for padding (top, right, bottom, left) */\r\n"
	    		+ "    -fx-background-color: #FFFFFF;     /* Use -fx-background-color for background color */\r\n"
	    		+ "    -fx-text-fill: #444444;            /* Use -fx-text-fill for text color */\r\n"
	    		+ "    -fx-border-color: #EBEBEB;         /* Use -fx-border-color for border color */\r\n"
	    		+ "    -fx-border-width: 1px;             /* Use -fx-border-width for border width */\r\n"
	    		+ "    -fx-border-style: solid;            /* Use -fx-border-style for border style */\r\n"
	    		+ "    -fx-background-radius: 6px;         /* Use -fx-background-radius for border radius */\r\n"
	    		+ "    -fx-font-family: \"Inter\";           /* Use -fx-font-family for font family */\r\n"
	    		+ "    -fx-font-weight: 500;               /* Use -fx-font-weight for font weight */\r\n"
	    		+ "    -fx-font-size: 14px;                /* Use -fx-font-size for font size */\r\n"
	    		+ "	-fx-line-spacing: 1.2em;        /* Use -fx-line-spacing to control line height (1.3 times the font size) */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;         /* Align text to the left */");
	    password_field.setLayoutX(896);
	    password_field.setLayoutY(481);
	    password_field.setPromptText("Enter Password");
	    
	    Button logIn_btn = new Button("Log in");
	    logIn_btn.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 300px;           /* Preferred width */\r\n"
	    		+ "    -fx-pref-height: 41px;           /* Preferred height */\r\n"
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
	    
	    logIn_btn.setOnMouseEntered(e -> logIn_btn.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 300px;           /* Preferred width */\r\n"
	    		+ "    -fx-pref-height: 41px;           /* Preferred height */\r\n"
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
	    
	    logIn_btn.setOnMouseExited(e -> logIn_btn.setStyle("-fx-spacing: 15;\r\n"
	    		+ "    -fx-pref-width: 300px;           /* Preferred width */\r\n"
	    		+ "    -fx-pref-height: 41px;           /* Preferred height */\r\n"
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
	    logIn_btn.setLayoutX(896);
	    logIn_btn.setLayoutY(551);
	    
	    
	    Button create_btn = new Button("Create account");
		create_btn.setStyle("-fx-spacing: 15;\r\n"
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
		create_btn.setOnMouseEntered(e -> create_btn.setStyle("-fx-spacing: 15;\r\n"
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
		create_btn.setOnMouseExited(e -> create_btn.setStyle("-fx-spacing: 15;\r\n"
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
	    create_btn.setTranslateX(1045);
	    create_btn.setTranslateY(601);
	    
	    
	    Button forgot_btn = new Button("Forgot password?");
	    forgot_btn.setStyle("-fx-pref-width: 140px;            /* Preferred width */\r\n"
	    		+ "    -fx-pref-height: 24px;            /* Preferred height */\r\n"
	    		+ "    -fx-text-fill: #AF3A11;           /* Text color */\r\n"
	    		+ "    -fx-font-family: \"Source Sans 3\"; /* Font family */\r\n"
	    		+ "    -fx-font-weight: 400;              /* Font weight */\r\n"
	    		+ "    -fx-font-size: 15px;               /* Font size */\r\n"
	    		+ "    -fx-underline: true;               /* Underline text */\r\n"
	    		+ "    -fx-line-spacing: 1.3;             /* Line spacing */\r\n"
	    		+ "    -fx-alignment: CENTER_LEFT;               /* Text alignment */\r\n"
	    		+ "	-fx-background-color: transparent;   /* Background color */\r\n"
	    		+ "	-fx-border-color: transparent;");
	    forgot_btn.setLayoutX(885);
	    forgot_btn.setLayoutY(601);
	    
	    Image ASU_logo = new Image("ASU_logo.png");
	    ImageView ASU = new ImageView(ASU_logo);
	    ASU.setFitWidth(400);
	    ASU.setFitHeight(200);
	    ASU.setPreserveRatio(true);
	    ASU.setLayoutX(865);
	    ASU.setLayoutY(80);
	    
	    Label title = new Label("Sun Devil \nBook Exchange");
	    title.setStyle("-fx-pref-width: 331px;\r\n"
	    		+ "    -fx-pref-height: 143px;\r\n"
	    		+ "    -fx-text-fill: #BF0046;\r\n"
	    		+ "    -fx-font-family: \"Alumni Sans\";\r\n"
	    		+ "    -fx-font-weight: bold; /* 700 corresponds to bold */\r\n"
	    		+ "    -fx-font-size: 40px;\r\n"
	    		+ "    -fx-line-spacing: 1; /* This may be adjusted as needed */\r\n"
	    		+ "    -fx-alignment: center; /* Center alignment */\r\n"
	    		+ "    -fx-text-alignment: center; /* Center text alignment */");
	    title.setLayoutX(243);
	    title.setLayoutY(125);
	    
	    Image book_logo = new Image("book.png");
	    ImageView bookLogo = new ImageView(book_logo);
	    bookLogo.setFitWidth(400);
	    bookLogo.setFitHeight(300);
	    bookLogo.setPreserveRatio(true);
	    bookLogo.setLayoutX(260);
	    bookLogo.setLayoutY(255);
	    
	    Rectangle deco1 = new Rectangle();
	    deco1.setStyle("-fx-pref-width: 1366px;               /* Preferred width */\r\n"
				+ "    -fx-pref-height: 104px;              /* Preferred height */\r\n"
				+ "    -fx-padding: 8px;                    /* Padding (top, right, bottom, left) */\r\n"
				+ "	-fx-fill: #BF0046;              /* Fill color */\r\n"
				+ "	-fx-stroke: #BF0046;        /* Border color */\r\n"
				+ "	-fx-stroke-width: 1;           /* Border width */");
	    deco1.setWidth(1366);
	    deco1.setHeight(200);
	    deco1.setLayoutX(0);
	    deco1.setLayoutY(600);
	    
	    Image main_logo = new Image("mail.png");
	    ImageView mailLogo = new ImageView(main_logo);
	    mailLogo.setFitWidth(23);
	    mailLogo.setFitHeight(21);
	    mailLogo.setPreserveRatio(true);
	    mailLogo.setLayoutX(910);
	    mailLogo.setLayoutY(421);
	    
	    Image password_logo = new Image("password.png");
	    ImageView passwordLogo = new ImageView(password_logo);
	    passwordLogo.setFitWidth(23);
	    passwordLogo.setFitHeight(21);
	    passwordLogo.setPreserveRatio(true);
	    passwordLogo.setLayoutX(910);
	    passwordLogo.setLayoutY(492);
	    
		getChildren().addAll(deco1, mainRect, ASU, bookLogo, title, create_btn, forgot_btn, signIn, Instruction, ID, id_field, mailLogo, password, password_field, passwordLogo, logIn_btn);
		
		Label Warning1 = new Label("Error: Please enter ID and password!");
		Warning1.setLayoutX(895); 
		Warning1.setLayoutY(250);
		Warning1.setTextFill(Color.RED);
		Warning1.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 15px;\r\n");
		
		Label Warning2 = new Label("Error: Wrong ID or password!");
		Warning2.setLayoutX(895); 
		Warning2.setLayoutY(250);
		Warning2.setTextFill(Color.RED);
		Warning2.setStyle("-fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 15px;\r\n");
		
		create_btn.setOnAction((ActionEvent e) -> {
			getChildren().remove(Warning1);
    		getChildren().remove(Warning2);
			id_field.setText("");
			password_field.setText("");
    		callNext1();
    	});
		
		forgot_btn.setOnAction((ActionEvent e) -> {
			getChildren().remove(Warning1);
    		getChildren().remove(Warning2);
			id_field.setText("");
			password_field.setText("");
    		callNext2();
    	});
		
		logIn_btn.setOnAction((ActionEvent e) -> {
			try {
				read();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	log_id = id_field.getText();
	    	log_pass = password_field.getText();
	    	if (log_id.length() <= 0 || log_pass.length() <= 0) {
	    		getChildren().remove(Warning1);
				getChildren().remove(Warning2);
				getChildren().add(Warning1);;
	    		return;
	    	}
	    	for (int i = 0; i < credentialsArray.size(); i++) {
	    		if (log_id.equals(credentialsArray.get(i)) && log_pass.equals(passwordArray.get(i))) {
	    			
	    	    	mainMenuPage.welcomeName.setText("Welcome " + log_id);
	    	    	credentialsArray.clear();
	    	    	passwordArray.clear();
	    	    	getChildren().remove(Warning1);
	        		getChildren().remove(Warning2);
	    			id_field.setText("");
	    			password_field.setText("");
	    			
	    	    	callNext3();
	    			return;
	    		}
	    		
	    	}
	    	getChildren().remove(Warning1);
			getChildren().remove(Warning2);
			getChildren().add(Warning2);;
    	});
	}
    
    
}
