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

public class loginController extends mainMenuController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public FXMLLoader loader2 = new FXMLLoader(getClass().getResource("createAccount.fxml")); // Adjust the path as needed
	public FXMLLoader loader3 = new FXMLLoader(getClass().getResource("forgot.fxml")); // Adjust the path as needed
	public FXMLLoader loader4 = new FXMLLoader(getClass().getResource("mainMenu.fxml")); // Adjust the path as needed
	
	
	private ArrayList<String> credentials = new ArrayList<String>();
	private ArrayList<String> password = new ArrayList<String>();
	
	
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
    private Button create_btn;

    @FXML
    private Button forgot_btn;

    @FXML
    private TextField id_field;

    @FXML
    private Button logIn_btn;

    @FXML
    private TextField password_field;
    
    String log_id;
	String log_pass;

    
    public void switchToCreate(ActionEvent e) throws IOException {
    	root = loader2.load();
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void switchToForgot(ActionEvent e) throws IOException {
    	root = loader3.load();
    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void login(ActionEvent e) throws IOException {
    	read();
    	log_id = id_field.getText();
    	log_pass = password_field.getText();
    	if (log_id.length() <= 0 || log_pass.length() <= 0) {
    		System.out.println("Please enter ID and password");
    		return;
    	}
    	for (int i = 0; i < credentials.size(); i++) {
    		if (log_id.equals(credentials.get(i)) && log_pass.equals(password.get(i))) {
    			/*
    			try {
    	    		BufferedWriter writer = new BufferedWriter(new FileWriter("current user.txt"));
    	    		writer.write(credentials.get(i) + "\n");
    	    		writer.close();
    	    	} catch (IOException E) {
    	    		E.printStackTrace();
    	    	}
    	    	*/
    			
    			root = loader4.load();
    	    	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	    	scene = new Scene(root);
    	    	stage.setScene(scene);
    	    	labelName.setText("Welcome " + log_id);
    	    	stage.show();
    			return;
    		}
    		
    	}
    	System.out.println("Wrong ID or password");
    }
    
    
}
