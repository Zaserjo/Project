package application;

import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.security.auth.x500.X500Principal;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UebungenController {
	@FXML TextArea textInput;
	@FXML Label frage_input;
	@FXML Button antwort1_input;
	@FXML Button antwort2_input;
	@FXML Button antwort3_input;
	@FXML Button antwort4_input;
	//@FXML Button fehlerListe;
	
	public UebungenController() {
		
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
	
	public void uebung1run() throws IOException, ScriptException, InterruptedException {
		ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");

        //Objekte zum Eingeben erzeugt
        ObjectTest frage = new ObjectTest();
        ObjectTest antwort1 = new ObjectTest();
        ObjectTest antwort2 = new ObjectTest();
        ObjectTest antwort3 = new ObjectTest();
        ObjectTest antwort4 = new ObjectTest();

        //In engine einf�gen
		engine.put("frage", frage);
		engine.put("antwort1", antwort1);
		engine.put("antwort2", antwort2);
		engine.put("antwort3", antwort3);
		engine.put("antwort4", antwort4);

        String test = textInput.getText();
        engine.eval(test); // user kann js code eingeben
        
        //eingegeben Code in String umgewandelt und in die Komponenten eingef�gt
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
        	fehler += " Frage wurde falsch gesetzt!";
        }
        if(antwort1_input.getText().equals("6")) {
        	
        } else {
        	mistakes++;
        	fehler += " erste Antwort wurde falsch gesetzt!";
        }
        if(antwort2_input.getText().equals("5")) {
        	
        } else {
        	mistakes++;
        	fehler += " zweite Antwort wurde falsch gesetzt!";
        }
        if(antwort3_input.getText().equals("4")) {
        	
        } else {
        	mistakes++;
        	fehler += " dritte Antwort wurde falsch gesetzt!";
        }
        if(antwort4_input.getText().equals("7")) {
        	
        } else {
        	mistakes++;
        	fehler += " vierte Antwort wurde falsch gesetzt!";
        }
        
       final String tempFehler = fehler;
       final int temp = mistakes; 
       new Callback(3000, () -> {
    	   if(temp > 0) {
           	uebungUnerfolgreich(tempFehler);
           } else {
           	uebungErfolgreich();
           }
       });
	}
	
	public static class ObjectTest {
		String eingabeString;
		
        public void set(String msg) { // soll von javascript aufgerufen werden
        	eingabeString = msg;
        }
	}
	
	public void exit()
	{
		System.exit(1);
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