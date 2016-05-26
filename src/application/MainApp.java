package application;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage primary;
	@Override
	public void start(Stage primaryStage) {
		this.primary = primaryStage;
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("JavaGUI.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		//primaryStage.sizeToScene();
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}