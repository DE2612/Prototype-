package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CenteredTextExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Label with newline
        Label label = new Label("Sun Devil\nBook Exchange");
        label.setFont(Font.font("Alumni Sans", FontWeight.BOLD, 60));
        label.setTextFill(Color.web("#BF0046"));
        label.setWrapText(true); // Allows wrapping in case of space issues
        label.setTextAlignment(TextAlignment.CENTER); // Center alignment

        // Create a StackPane to center the Label
        StackPane root = new StackPane(label);
        root.setStyle("-fx-pref-width: 331px; -fx-pref-height: 143px;");

        // Create the Scene
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Centered Text Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
