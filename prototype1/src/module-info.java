module prototype1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires org.xerial.sqlitejdbc;
	
	opens application to javafx.graphics, javafx.fxml;
    opens application.resources.Fxml to javafx.fxml; // Allow access to the FXML files
	exports application;
	exports application.models;
	exports application.views;
}
