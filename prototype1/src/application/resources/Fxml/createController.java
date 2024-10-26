package application.resources.Fxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class createController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public FXMLLoader loader1 = new FXMLLoader(getClass().getResource("login.fxml")); // Adjust the path as needed
	
	private ArrayList<String> credentials = new ArrayList<String>();
	private ArrayList<String> password = new ArrayList<String>(); 
	
	private String newID;
	private String newPassword;
	
	void read() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
			String first = reader.readLine();
			int num = Integer.parseInt(first);
			for (int i = 0; i < num; i++) {
				credentials.add(reader.readLine());
				password.add(reader.readLine());
			}
		} catch(IOException E) {
			E.printStackTrace();
		}
		
	}
	

	@FXML
    private TextField ID_field;

    @FXML
    private Button create_btn;

    @FXML
    private TextField password_field;
    
    @FXML
    void goBack(ActionEvent e) throws IOException {
    	root = loader1.load();
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void switchToLogIn(ActionEvent e) throws IOException {
    	credentials.clear();
		password.clear();
    	read();
    	
    	newID = ID_field.getText();
    	System.out.println(newID);
    	newPassword = password_field.getText();
    	
    	if (newID.length() <= 0 || newPassword.length() <= 0) {
    		System.out.println("Please enter ID or password");
    		return;
    	}
    	
    	
    	for (int i = 0; i < credentials.size(); i++) {
    		if (newID.equals(credentials.get(i))) {
    			System.out.println("Error: ID already exists");
    			return;
    		}
    	}
    	
    	
    	credentials.add(newID);
    	password.add(newPassword);
 
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt"));
    		System.out.println(credentials.size());
    		writer.write(credentials.size() + "\n");
    		for (int i = 0; i < credentials.size(); i++) {
    			writer.write(credentials.get(i) + "\n");
    			writer.write(password.get(i) + "\n");
    		}
    		credentials.clear();
    		password.clear();
    		writer.close();
    	} catch (IOException E) {
    		E.printStackTrace();
    	}
    	
    	
    	root = loader1.load();
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}

