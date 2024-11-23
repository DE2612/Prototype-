module test_1 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.swt;

	opens application to javafx.graphics, javafx.fxml;
}
