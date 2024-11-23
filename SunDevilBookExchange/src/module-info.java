module SunDevilBookExchange {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.swt;

	opens application to javafx.graphics, javafx.fxml;
}
