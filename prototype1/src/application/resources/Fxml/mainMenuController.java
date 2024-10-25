package application.resources.Fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class mainMenuController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public FXMLLoader loader2 = new FXMLLoader(getClass().getResource("login.fxml")); // Adjust the path as needed

    @FXML
    private Label welcomeName;
    
    public static Label labelName;
    
    public void initialize() {
    	labelName = welcomeName;
    }
    
    public void logOut(ActionEvent e) throws IOException {
    	root = loader2.load();
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    

}
