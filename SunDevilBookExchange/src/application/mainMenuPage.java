package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class mainMenuPage extends CycledView {

	mainMenuPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
		super(next1, next2, next3, next4, next5);
		// TODO Auto-generated constructor stub
	}
	
	public static Label welcomeName = new Label();
	public static Label Instruction = new Label();
	public static Label title = new Label();
	public static Button buy_btn = new Button();
	public static Button sell_btn = new Button();
	public static Button log_out_btn = new Button();
	public static Rectangle titleRect = new Rectangle();

	@Override
	void createGUI() {
		welcomeName.setText("Welcome <Name>,");
		welcomeName.setStyle("-fx-pref-width: 900px;          /* Preferred width */\r\n"
				+ "    -fx-pref-height: 60px;          /* Preferred height */\r\n"
				+ "    -fx-text-fill: #BF0046;         /* Text color */\r\n"
				+ "    -fx-font-family: \"Alumni Sans\"; /* Font family */\r\n"
				+ "    -fx-font-weight: bold;          /* Font weight */\r\n"
				+ "    -fx-font-size: 40px;            /* Font size */\r\n"
				+ "    -fx-line-spacing: 0;            /* Line height adjustment */\r\n"
				+ "    -fx-text-alignment: left;       /* Text alignment */");
		welcomeName.setLayoutX(91);
		welcomeName.setLayoutY(146);
		
		
		Instruction.setText("Please select whether you would like to buy books \nor post books to sell using the options on the right.");
		Instruction.setStyle("-fx-pref-width: 592px;\r\n"
				+ "    -fx-pref-height: 70px;\r\n"
				+ "    -fx-text-fill: #232323E0;\r\n"
				+ "    -fx-font-family: \"Helvetica\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 24px;\r\n"
				+ "    -fx-line-height: 1.3;\r\n"
				+ "    -fx-alignment: left;");
		Instruction.setLayoutX(91);
		Instruction.setLayoutY(239);
		
		
		buy_btn.setText("Buy");
		buy_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;");
		buy_btn.setOnMouseEntered(e -> buy_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FFFFFF;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;")); 
		buy_btn.setOnMouseExited(e -> buy_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;"));
		buy_btn.setLayoutX(829);
		buy_btn.setLayoutY(316);
		
		
		
		sell_btn.setText("Sell");
		sell_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;");
		sell_btn.setOnMouseEntered(e -> sell_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #A60038;\r\n"
				+ "    -fx-text-fill: #FFFFFF;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;")); 
		sell_btn.setOnMouseExited(e -> sell_btn.setStyle("-fx-pref-width: 261px;\r\n"
				+ "    -fx-pref-height: 54px;\r\n"
				+ "    -fx-padding: 0px 10px 0px 10px;\r\n"
				+ "    -fx-background-color: #BF0045;\r\n"
				+ "    -fx-text-fill: #EBEBEB;\r\n"
				+ "    -fx-border-color: #BF0045;\r\n"
				+ "    -fx-border-width: 1px;\r\n"
				+ "    -fx-border-style: solid;\r\n"
				+ "    -fx-border-radius: 3px 3px 3px 3px;\r\n"
				+ "    -fx-font-family: \"Arial\";\r\n"
				+ "    -fx-font-weight: bold;\r\n"
				+ "    -fx-font-size: 36px;\r\n"
				+ "    -fx-alignment: center;"));
		sell_btn.setLayoutX(829);
		sell_btn.setLayoutY(411);
		
		
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
		
		titleRect.setStyle("-fx-pref-width: 1366px;               /* Preferred width */\r\n"
				+ "    -fx-pref-height: 104px;              /* Preferred height */\r\n"
				+ "    -fx-padding: 8px;                    /* Padding (top, right, bottom, left) */\r\n"
				+ "	-fx-fill: #BF0046;              /* Fill color */\r\n"
				+ "	-fx-stroke: #BF0046;        /* Border color */\r\n"
				+ "	-fx-stroke-width: 1;           /* Border width */");
		titleRect.setWidth(1366);
		titleRect.setHeight(104);
		titleRect.setX(0);
		titleRect.setY(0);
		
		title.setText("Sun Devil Book Exchange");
		title.setStyle("-fx-pref-width: 900px;          /* Preferred width */\r\n"
				+ "    -fx-pref-height: 130px;         /* Preferred height */\r\n"
				+ "    -fx-text-fill: #FFEAA6;         /* Text color */\r\n"
				+ "    -fx-font-family: \"Alumni Sans\"; /* Font family */\r\n"
				+ "    -fx-font-weight: bold;          /* Font weight */\r\n"
				+ "    -fx-font-size: 60px;            /* Font size */\r\n"
				+ "    -fx-line-spacing: 0;            /* Line height adjustment */\r\n"
				+ "    -fx-text-alignment: center;     /* Text alignment */");
		title.setLayoutX(364);
		title.setLayoutY(-18);
		
		getChildren().addAll(titleRect, title, welcomeName, Instruction, buy_btn, sell_btn, log_out_btn);
		
		log_out_btn.setOnAction((ActionEvent e) -> {
    		callNext1();
    	});

		buy_btn.setOnAction((ActionEvent e) -> {
			callNext2();
		});
		
		sell_btn.setOnAction((ActionEvent e) -> {
			callNext3();
		});
		
		// TODO Auto-generated method stub
		
	}
	
}
