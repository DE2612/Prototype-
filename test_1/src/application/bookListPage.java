
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;


import java.nio.file.Path;
import java.nio.file.Files;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.BufferedReader;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;


public class bookListPage extends CycledView {

  bookListPage(CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
    super(next1, next2, next3, next4, next5);
  }
  /*public void start(Stage bookSearchStage) {
    bookSearchStage.setTitle("Book Search");

    Scene bookSearchScene = new Scene(this, 1366, 768);
    bookSearchStage.setScene(bookSearchScene);
    bookSearchStage.show();
    
  }
*/
  public static Label pageTitle = new Label();
  public static Label title = new Label();
  public static Button log_out_btn = new Button();
  public static Rectangle titleRect = new Rectangle();
/*
  void read() throws IOException {
    int numBooks;
    try {
      File booksFile = new File("booksTest.txt");
      Path booksPath = booksFile.toPath();
      numBooks = (int) Files.lines(booksPath).count();
      
      String[] booksArray = new String[numBooks];
      
      BufferedReader reader = new BufferedReader(new FileReader(booksPath));
      String first = reader.readLine();
  
      for (int i = 0; i < numBooks; i++) {
        booksArray.add(reader.readLine());
      }
    } catch(IOException E) {
      E.printStackTrace();
    }

  }
  */

  //public static InputStream booksFile = new FileInputStream("booksTests.txt");
  //public static Image booksAvailable = new Image(booksFile);
  public static ImageView booksDisplay = new ImageView();
  public static ScrollPane bookScroll = new ScrollPane();

  @Override
    void createGUI() {
      Rectangle conditionsRect = new Rectangle(1075,260,250,220);// right, down, width, height
      /*mainRect.setX(836);
      mainRect.setY(236);
      mainRect.setWidth(420);
      mainRect.setHeight(414);*/
      conditionsRect.setFill(Color.RED);
      conditionsRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");

      Rectangle categoryRect = new Rectangle(1075,490,250,220);// right, down, width, height
      /*mainRect.setX(836);
      mainRect.setY(236);
      mainRect.setWidth(420);
      mainRect.setHeight(414);*/
      categoryRect.setFill(Color.GREY);
      categoryRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");

      Rectangle resultsRect = new Rectangle(50,260,1000,450);// right, down, width, height
      /*mainRect.setX(836);
      mainRect.setY(236);
      mainRect.setWidth(420);
      mainRect.setHeight(414);*/
      resultsRect.setFill(Color.WHITE);
      resultsRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");

      Rectangle searchRect = new Rectangle(50,200,600,50);// right, down, width, height
      /*mainRect.setX(836);
      mainRect.setY(236);
      mainRect.setWidth(420);
      mainRect.setHeight(414);*/
      searchRect.setFill(Color.BLUE);
      searchRect.setStyle("-fx-padding: 8px; /* Padding (top, right, bottom, left) */\r\n"
              + "	-fx-stroke: transparent;"
              + "	-fx-stroke-width: 0;"
              + "	-fx-arc-width: 10px;"
              + "	-fx-arc-height: 10px;");
      
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

        

      /*

      booksDisplay.setImage(booksAvailable); // display books
      booksDisplay.setLayoutX(145);
      booksDisplay.setLayoutY(0);
      booksDisplay.setFitWidth(1366);
      booksDisplay.setFitHeight(768);
      booksDisplay.setPreserveRatio(true);

      bookScroll.setPrefSize(1366, 768);
      bookScroll.setContent(booksDisplay);
      */
      //getChildren().addAll(titleRect, title, pageTitle, log_out_btn, bookScroll);

      getChildren().addAll(titleRect, title, pageTitle, log_out_btn, searchRect, conditionsRect, categoryRect, resultsRect);

      log_out_btn.setOnAction((ActionEvent e) -> {
          callNext1();
        });

      // TODO Auto-generated method stub

    }
}