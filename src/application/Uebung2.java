package application;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JLabel;

import application.Uebung1.ObjectTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class Uebung2 {
	@FXML TextArea textInput2;
	
	public void uebung2run() throws IOException, ScriptException, InterruptedException {
		ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");

        //Objekte zum Eingeben erzeugt
        ObjectTest ueberpruefen = new ObjectTest();
        ObjectTest sonst = new ObjectTest();

        //In engine einfügen
		engine.put("if", ueberpruefen);
		//engine.put("else", sonst);

        String test = textInput2.getText();
        String remove = test.substring(1, (test.length()-1));
        engine.eval(test); // user kann js code eingeben
        System.out.println(remove);
        String fehler = "";
        
        int mistakes = 0;
        if(remove.equals("xyz")) {
        	System.out.println("drai");
        } else {
        	fehler+= "If false";
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
