package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * 
 */
public class ErgebnisController {
	
	@FXML Label punktanzahl;
	@FXML Label ergebnis_text;
	
	public ErgebnisController() {
		LaunchedManager.addListener(new Launched() {

			@Override
			public void launched(Object value) {
				try {
					initialize((int[])value);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		LaunchedManager.addListener(new Launched() {

			@Override
			public void launched(Object value) {
				initializeText((int[])value);
			}
			
		});
	}
	
	/*
	 * Ergebnistext wird hinzugefügt
	 */
	public void initialize(int[] points) throws IOException {
		int earned = points[0];
		int max = points[1];
		punktanzahl.setText(Controller.vorname+", du hast " + earned + " von " + max + " Punkte erreicht!");
		FragenController.richtig.reset(0);
	}
	
	/*
	 * Fürs Ergebnis wird Prozent ausgerechnet
	 */
	public void initializeText(int[] points) {
		int earned = points[0];
		int max = points[1];
		double x = ((double)earned/(double)max*100.0);
		if(x <= 50.0) {
			ergebnis_text.setText("Du musst noch üben!");
			return;
		}
		else if(x > 50.0 && x <= 70.0) {
			ergebnis_text.setText("Du weißt ein bisschen!");
			return;
		}
		else if(x > 70.0 && x <= 85.0) {
			ergebnis_text.setText("Du weißt schon Einiges. Beim nächsten mal hast du sicher alle Fragen richtig!");
		}
		else if(x > 85.0 && x < 100.0) {
			ergebnis_text.setText("Super, du kennst dich gut aus. Du hast fast alle Fragen richtig!");
			return;
		}
		else {
			ergebnis_text.setText("Super, du kennst dich sehr gut aus. Du hast alle Fragen richtig!");
			return;
		}
		FragenController.richtig.reset(0);
	}		
	
	/*
	 * Programm wird beendet
	 */
	public void exit()
	{
		System.exit(1);
	}
	
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
}