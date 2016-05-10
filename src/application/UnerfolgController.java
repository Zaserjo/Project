package application;

import javax.naming.InitialContext;

import javafx.fxml.FXML;
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

}
