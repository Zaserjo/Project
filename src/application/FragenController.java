package application;


import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class FragenController {
	
	@FXML Label fragennr_id;
	@FXML Button antwort1_btn;
	@FXML Button antwort2_btn;
	@FXML Button antwort3_btn;
	@FXML Button antwort4_btn;
	private String antwort;
	
	static Counter richtig = new Counter(Controller.alleFragen.size());
	
	

	
	public FragenController() {
		LaunchedManager.addListener(new Launched() {
			@Override
			public void launched(Object value) {
				richtig = new Counter(Controller.alleFragen.size());
				initialize((Fragen)value);
			}
		});
	}
	
	public void initialize(Fragen f) {
		fragennr_id.setText(f.getFrage());
		String[] fragen = f.getLoesungen();
		fragen = Arrays.copyOf(fragen,  fragen.length +1);
		fragen[3] = f.getAntwort();
		fragen = getRandom(fragen);
		antwort = f.getAntwort();
		
		antwort1_btn.setText(fragen[0]);
		antwort2_btn.setText(fragen[1]);
		antwort3_btn.setText(fragen[2]);
		antwort4_btn.setText(fragen[3]);

	}
	
	private String[] getRandom(String[] input) {
		long seed = System.nanoTime();
		List<String> temp = Arrays.asList(input);
		Collections.shuffle(temp, new Random(seed));
		return temp.toArray(new String[0]);
	}
	
	private void disableAll() {
		antwort1_btn.setDisable(true);
		antwort2_btn.setDisable(true);
		antwort3_btn.setDisable(true);
		antwort4_btn.setDisable(true);

	}
	
	public void checkAnswer1() {
		disableAll();
		if(antwort1_btn.getText().equals(antwort)) {
			richtig.increment();
			antwort1_btn.setStyle("-fx-background-color: lightgreen;");
		}
		else {
			antwort1_btn.setStyle("-fx-background-color: tomato;");
		}
		weiter();
	}
	
	public void checkAnswer2() {
		disableAll();
		if(antwort2_btn.getText().equals(antwort)) {
			richtig.increment();
			antwort2_btn.setStyle("-fx-background-color: lightgreen;");
		}
		else {
			antwort2_btn.setStyle("-fx-background-color: tomato;");
		}
		weiter();
	}
	
	public void checkAnswer3() {
		disableAll();
		if(antwort3_btn.getText().equals(antwort)) {
			richtig.increment();
			antwort3_btn.setStyle("-fx-background-color: lightgreen;");
		}
		else {
			antwort3_btn.setStyle("-fx-background-color: tomato;");
		}
		weiter();
	}
	
	public void checkAnswer4() {
		disableAll();
		if(antwort4_btn.getText().equals(antwort)) {
			richtig.increment();
			antwort4_btn.setStyle("-fx-background-color: lightgreen;");
		}
		else {
			antwort4_btn.setStyle("-fx-background-color: tomato;");
		}
		weiter();
	}
		
	public void weiter() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				Controller.currentIndex++;
				
				if(Controller.currentIndex >= Controller.alleFragen.size()) {
					Platform.runLater(() -> {
						ergebnis();
					});
					return;
				}
	
				Platform.runLater(() -> {
					Parent root;
					try {
						root = FXMLLoader.load(MainApp.class.getResource("Fragen.fxml"));
						MainApp.primary.setScene(new Scene(root));
						MainApp.primary.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					LaunchedManager.notifyListener(Controller.alleFragen.get(Controller.currentIndex));
				});
		}}).start();
	}
	
	
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
	
	public void ergebnis()
	{
		try {

			Parent root = FXMLLoader.load(MainApp.class.getResource("Ergebnis.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			Controller.alleFragen.clear();
			Controller.currentIndex = 0;
			LaunchedManager.notifyListener(new int[] {richtig.result, richtig.max});
			richtig.reset(0);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	public void exit()
	{
		System.exit(1);
	}
}
