package application;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Uebung1 {
	@FXML TextArea textInput;
	@FXML Label frage_input;
	@FXML Button antwort1_input;
	@FXML Button antwort2_input;
	@FXML Button antwort3_input;
	@FXML Button antwort4_input;
	
	/*
	 * Statische Klasse, um Eingaben zu benutzen.
	 */
	public static class ObjectTest {
		String eingabeString;
		
        public void set(String msg) { // soll von javascript aufgerufen werden
        	eingabeString = msg;
        }
	}
	
	/*
	 * Uebung 1 wird initialisiert und die Eingaben werden überprüft 	
	 */
	public void uebung1run() throws IOException, ScriptException, InterruptedException {
		UebungenController.number = 1;
		ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");

        //Objekte zum Eingeben erzeugt
        ObjectTest frage = new ObjectTest();
        ObjectTest antwort1 = new ObjectTest();
        ObjectTest antwort2 = new ObjectTest();
        ObjectTest antwort3 = new ObjectTest();
        ObjectTest antwort4 = new ObjectTest();

        //In engine einfügen
		engine.put("frage", frage);
		engine.put("antwort1", antwort1);
		engine.put("antwort2", antwort2);
		engine.put("antwort3", antwort3);
		engine.put("antwort4", antwort4);

        String test = textInput.getText();
	    try {
	    	engine.eval(test); // user kann js code eingeben
	        
	        //eingegeben Code in String umgewandelt und in die Komponenten eingefügt
	        frage_input.setText(frage.eingabeString);
	        antwort1_input.setText(antwort1.eingabeString);
	        antwort2_input.setText(antwort2.eingabeString);
	        antwort3_input.setText(antwort3.eingabeString);
	        antwort4_input.setText(antwort4.eingabeString);
        	String fehler = "";
            
            //System.out.println(fehlerListe.getText());
            int mistakes = 0;
            if(frage_input.getText().equals("Was ist 3+3?")) {
            } else {
            	mistakes++;
            	fehler += " Frage wurde nicht richtig gesetzt!";
            }
            if(antwort1_input.getText().equals("6")) {
            	
            } else {
            	mistakes++;
            	fehler += " erste Antwort wurde nicht richtig gesetzt!";
            }
            if(antwort2_input.getText().equals("5")) {
            	
            } else {
            	mistakes++;
            	fehler += " zweite Antwort wurde nicht richtig gesetzt!";
            }
            if(antwort3_input.getText().equals("4")) {
            	
            } else {
            	mistakes++;
            	fehler += " dritte Antwort wurde nicht richtig gesetzt!";
            }
            if(antwort4_input.getText().equals("7")) {
            	
            } else {
            	mistakes++;
            	fehler += " vierte Antwort wurde nicht richtig gesetzt!";
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
        catch(Exception e) {
        	uebungUnerfolgreich("");
        }
        
	}
	
	/*
	 * Bei erfolgreicher Absolvierung öffnet sich das Uebungerfolgreich-Fenster
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
	 * Bei unerfolgreicher Absolvierung öffnet sich das Uebungunerfolgreich-Fenster, wo auch die Fehler angezeigt werden.
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
	 * Öffnet das About
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
	 * Schließt das Programm
	 */
	public void exit()
	{
		System.exit(1);
	}
}