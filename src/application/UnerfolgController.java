package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/*
 * Gibt bei Übungen die Fehler aus
 */
public class UnerfolgController {
	
	@FXML Button fehlerListe;
	
	public UnerfolgController() {
		LaunchedManager.addListener(new Launched() {
			
			@Override
			public void launched(Object value) {
				// TODO Auto-generated method stub
				init((String)value);
			}
		});
	}
	
	/*
	 * Standardfehler wird gesetzt.
	 */
	public void init(String error) {
		fehlerListe.setText("Du hast die Übung leider nicht erfolgreich absolviert. Deine Fehler waren:" + error);
	}
	
	/*
	 * bei Klicken auf die Fehlermeldung wird entsprechende Übung wieder geöffnet
	 */
	public void uebungen() {
		try {
			System.out.println(UebungenController.number);
			Parent root = null;
			int x = UebungenController.number;
			switch (x) {
			case 1:
				root = FXMLLoader.load(MainApp.class.getResource("Uebung1.fxml"));
				break;
			case 2:
				root = FXMLLoader.load(MainApp.class.getResource("Uebung2.fxml"));			
				break;
			case 3:
				root = FXMLLoader.load(MainApp.class.getResource("Uebung3.fxml"));
				break;
			case 4:
				root = FXMLLoader.load(MainApp.class.getResource("Uebung4.fxml"));
				break;
			default:
				break;
			}
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
