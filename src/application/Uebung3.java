package application;

import java.io.IOException;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * Uebung 3
 */
public class Uebung3 {
	@FXML TextField textInput3;
	@FXML Label ergebnis_tf;
	
	/*
	 * Benutzereingaben werden überprüft und Ergebnis wird geliefert
	 */
	public void uebung3run() {
		UebungenController.number = 3;
        String test = textInput3.getText();
        String fehler = "";
        
        int mistakes = 0;
        if(!(test.substring(test.length()-1,test.length()).equals(";"))) {
        	fehler+= "; fehlt ";
        }
        if(test.equals("a+b+c;") || test.equals("a + b + c;")) {
        	ergebnis_tf.setText("32");
        } else {
        	mistakes++;
        	ergebnis_tf.setText("Es wurde falsch gerechnet");
        	fehler+= "Variablen nicht richtig addiert";
        }
        
        
        
       final String tempFehler = fehler;
       final int temp = mistakes; 
       new Callback(() -> {
    	   if(temp > 0) {
           	uebungUnerfolgreich(tempFehler);
           } else {
           	uebungErfolgreich();
           }
       });
	}	
	
	/*
	 * Wenn alles richtig gemacht wird, kommt man zum UebungErfolgreich-Fenster
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
	 * Bei einem Fehler wird Fehler in einem Extra-Fenster angezeigt
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
	 * Zurück ins Startmenü
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
	 * Programm beenden
	 */
	public void exit()
	{
		System.exit(1);
	}
}
