package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
		
		/*
		//Hover CSS:
		button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FFA4A4;")); 
		button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #DDFFA4;"));
		*/
		
		CycledView loginScene = new loginPage(null, null, null, null, null);
		CycledView createAccountScene = new createAccountPage(null, null, null, null, null);
		CycledView forgotPasswordScene = new forgotPasswordPage(null, null, null, null, null);
		CycledView mainMenuScene = new mainMenuPage(null, null, null, null, null);
		CycledView bookSearchScene = new bookSearchPage(null, null, null, null, null);
		CycledView sellBookScene = new sellBookPage(null, null, null, null, null);
		CycledView bookViewScene = new bookViewPage(null, null, null, null, null);
		CycledView cartScene = new cartPage(null, null, null, null, null);
		CycledView userProfile = new userProfile(null,null,null,null,null); //breck
		
		userProfile.setStyle("-fx-background-color: #FFEEB7;");//breck
		mainMenuScene.next4 = userProfile; //bn code
		userProfile.next1 = mainMenuScene;
		userProfile.next2 = mainMenuScene;
		
		loginScene.setStyle("-fx-background-color: #FFEEB7;");
		loginScene.next1 = createAccountScene;
		loginScene.next2 = forgotPasswordScene;
		loginScene.next3 = mainMenuScene;
		
		createAccountScene.setStyle("-fx-background-color: #FFEEB7;");
		createAccountScene.next1 = loginScene;
		
		forgotPasswordScene.setStyle("-fx-background-color: #FFEEB7;");
		forgotPasswordScene.next1 = loginScene;
		
		mainMenuScene.setStyle("-fx-background-color: #FFEEB7;");
		mainMenuScene.next1 = loginScene;
		mainMenuScene.next2 = bookSearchScene;
		mainMenuScene.next3 = sellBookScene;

		bookSearchScene.setStyle("-fx-background-color: #FFEEB7;");
		bookSearchScene.next1 = loginScene;
		bookSearchScene.next2 = mainMenuScene; //meg
		bookSearchScene.next3 = cartScene; //uncomment when cart scene is created
		bookSearchScene.next4 = bookViewScene;
		bookSearchScene.next5 = bookSearchScene;
		
		sellBookScene.setStyle("-fx-background-color: #FFEEB7;");
		sellBookScene.next1 = loginScene;
		sellBookScene.next2 = mainMenuScene;
		
		bookViewScene.setStyle("-fx-background-color: #FFEEB7;");
		bookViewScene.next1 = bookSearchScene;
		bookViewScene.next2 = loginScene;
		bookViewScene.next3 = cartScene;
		
		cartScene.setStyle("-fx-background-color: #FFEEB7;");
		cartScene.next2 = bookSearchScene;
		cartScene.next1 = loginScene;
		cartScene.next3 = mainMenuScene;

		Scene scene = new Scene(loginScene, 1366, 768);
        
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Homework 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
