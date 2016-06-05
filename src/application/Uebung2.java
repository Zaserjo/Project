package application;

import java.io.IOException;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Uebung2 {
	@FXML TextField textInput2;
	@FXML Button antwort1_input;
	@FXML Button antwort2_input;
	@FXML Button antwort3_input;
	@FXML Button antwort4_input;
	
	public void uebung2run() {
        String test = textInput2.getText();
        String fehler = "";
        
        int mistakes = 0;
        if(test.equals("userAntwort==richtigeAntwort") || test.equals("userAntwort == richtigeAntwort") ||test.equals("richtigeAntwort == userAntwort") ||test.equals("richtigeAntwort==userAntwort")){
        	
        } else {
        	mistakes++;
        	fehler+= "If false";
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
	
	public void exit()
	{
		System.exit(1);
	}
}
