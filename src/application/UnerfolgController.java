package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
	
	public void init(String error) {
		fehlerListe.setText("Du hast die Übung leider nicht erfolgreich absolviert. Deine Fehler waren:" + error);
	}
	
	public void uebungen() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebungen.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
