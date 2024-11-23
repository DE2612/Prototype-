module SunDevilBookExchange {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
