package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;
import javafx.scene.Scene;

/*
 * Uebungen werden verwaltet
 */
public class UebungenController {
	@FXML TextArea textInput;
	@FXML Label frage_input;
	@FXML Button antwort1_input;
	@FXML Button antwort2_input;
	@FXML Button antwort3_input;
	@FXML Button antwort4_input;
	@FXML TextArea textInput2;
	public static int number;

	
	/*
	 * Zurück zum Startmenü
	 */
	public void back()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("JavaGUI.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*
	 * About wird geöffnet
	 */
	public void about()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("About.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Uebung1 wird geöffnet
	 */
	public void uebung1() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebung1.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Uebung2 wird geöffnet
	 */
	public void uebung2() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebung2.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Uebung3 wird geöffnet
	 */
	public void uebung3() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebung3.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Uebung4 wird geöffnet
	 */
	public void uebung4() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebung4.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*
	 * Programm beenden
	 */
	public void exit()
	{
		System.exit(1);
	}
	
	/*
	 * Wenn Uebung ohne Fehler absolviert, wird das in einem Extra Fenster gezeigt
	 */
	public void uebungErfolgreich()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("UebungErfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Bei Fehler wird der Fehler in Extra-Fenster angezeigt
	 */
	public void uebungUnerfolgreich(String error) {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("UebungUnerfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			LaunchedManager.notifyListener(error);
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Liste für die Übungs-Auswahl
	 */
	public void uebungen()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebungen.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}