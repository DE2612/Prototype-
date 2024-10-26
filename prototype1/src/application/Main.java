package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {

        // Create a Pane to allow positioning
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Fxml/login.fxml")); // Adjust the path as needed
        Parent root = loader.load();

        // Create the Scene
        Scene scene = new Scene(root, 1366, 768);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Prototype login page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
