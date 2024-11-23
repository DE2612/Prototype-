package application;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class userProfile extends CycledView{

    userProfile(String log_id, String log_pass, CycledView next1, CycledView next2, CycledView next3, CycledView next4, CycledView next5) {
        super(next1, next2, next3, next4, next5);
        this.log_id = log_id;
        this.log_pass = log_pass;
    }

    String log_id = loginPage.log_id;  // Placeholder for user ID
    String log_pass = loginPage.log_pass ; // Placeholder for user password
    private TextField passwordField;
    private TextField userNameField;

    void readCredentials() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String first = reader.readLine();
            int num = Integer.parseInt(first);
            for (int i = 0; i < num; i++) {
                String id = reader.readLine();
                String pass = reader.readLine();
                if (id.equals(log_id)) {
                    log_pass = pass;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateCredentials() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            String first = reader.readLine();
            lines.add(first);
            int num = Integer.parseInt(first);
            for (int i = 0; i < num; i++) {
                String id = reader.readLine();
                String pass = reader.readLine();
                if (id.equals(log_id)) {
                    lines.add(userNameField.getText()); // Update user name
                    lines.add(passwordField.getText()); // Update password
                } else {
                    lines.add(id);
                    lines.add(pass);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt"))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void createGUI() {
        Rectangle mainRect = new Rectangle();
        mainRect.setX(50);
        mainRect.setY(80);
        mainRect.setWidth(420);
        mainRect.setHeight(600);
        mainRect.setFill(Color.WHITE);
        mainRect.setStyle("-fx-padding: 8px; -fx-fill: #FFEEB7;");

        Label profileTitle = new Label("User Profile");
        profileTitle.setStyle("-fx-min-width: 301px; -fx-min-height: 56px; -fx-text-fill: #444444; -fx-font-family: \"Arial\"; -fx-font-weight: 800; -fx-font-size: 30px;");
        profileTitle.setLayoutX(50);
        profileTitle.setLayoutY(40);

        Label appTitle = new Label("Sun Devil Book Exchange");
        appTitle.setStyle("-fx-min-width: 301px; -fx-min-height: 56px; -fx-text-fill: #BF0046; -fx-font-family: \"Arial\"; -fx-font-weight: bold; -fx-font-size: 40px;");
        appTitle.setLayoutX(50);
        appTitle.setLayoutY(-10);

        Label idLabel = new Label("New User Name: ");
        idLabel.setStyle("-fx-spacing: 15; -fx-text-fill: #7A7A7A; -fx-font-family: \"Arial\"; -fx-font-size: 14px;");
        idLabel.setLayoutX(50);
        idLabel.setLayoutY(125);

        userNameField = new TextField(log_id);
        userNameField.setStyle("-fx-pref-width: 300px; -fx-background-color: #FFFFFF; -fx-border-color: #EBEBEB;");
        userNameField.setLayoutX(50);
        userNameField.setLayoutY(150);

        Label currentIdLabel = new Label("Current ID: " + loginPage.log_id);
        currentIdLabel.setStyle("-fx-spacing: 15; -fx-text-fill: #7A7A7A; -fx-font-family: \"Arial\"; -fx-font-size: 14px;");
        currentIdLabel.setLayoutX(50);
        currentIdLabel.setLayoutY(100);

        Label currentPasswordLabel = new Label("Current Password: " + log_pass);
        currentPasswordLabel.setStyle("-fx-spacing: 15; -fx-text-fill: #7A7A7A; -fx-font-family: \"Arial\"; -fx-font-size: 14px;");
        currentPasswordLabel.setLayoutX(50);
        currentPasswordLabel.setLayoutY(225);

        Label passLabel = new Label("New Password");
        passLabel.setStyle("-fx-spacing: 15; -fx-text-fill: #7A7A7A; -fx-font-family: \"Arial\"; -fx-font-size: 14px;");
        passLabel.setLayoutX(50);
        passLabel.setLayoutY(250);

        passwordField = new TextField(log_pass);
        passwordField.setStyle("-fx-pref-width: 300px; -fx-background-color: #FFFFFF; -fx-border-color: #EBEBEB;");
        passwordField.setLayoutX(50);
        passwordField.setLayoutY(275);

        Button updateButton = new Button("Update Credentials");
        updateButton.setStyle("-fx-pref-width: 300px; -fx-background-color: #BF0046; -fx-text-fill: #FFFFFF; -fx-border-radius: 9px;");
        updateButton.setLayoutX(50);
        updateButton.setLayoutY(325);
        updateButton.setOnAction(e -> {
            try {
                updateCredentials();
                // Update the local variables with the new values
                log_id = userNameField.getText();
                log_pass = passwordField.getText();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-pref-width: 100px; -fx-background-color: #BF0046; -fx-text-fill: #FFFFFF; -fx-border-radius: 9px;");
        backButton.setLayoutX(50);
        backButton.setLayoutY(375);
        backButton.setOnAction(e -> {
            mainMenuPage.welcomeName.setText("Welcome " + log_id);
            callNext2();
        });

        this.getChildren().addAll(mainRect, appTitle, profileTitle, idLabel, userNameField, currentIdLabel, currentPasswordLabel, passLabel, passwordField, updateButton, backButton);
    }
}
