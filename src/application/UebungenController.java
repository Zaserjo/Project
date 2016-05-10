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

import application.Main.ObjectTest;
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
	
	public void uebung1_run() {
		int mistakes = 0;
		JFrame jFrame = new JFrame();
		JLabel jLabel = new JLabel();
		jFrame.add(jLabel);
		String[] x = textInput.getText().split(";");
		if(x[0].equals("frage.set(Was ist 3+3?)")) {
			frage_input.setText("Was ist 3+3?");
		} else {
			jLabel.setText(jLabel.getText()+", Frage wurde falsch gesetzt!");
			mistakes++;
		}
		if(x[1].equals("antwort1.set(6)")) {
			antwort1_input.setText("6");
		} else {
			jLabel.setText(jLabel.getText()+", Antwort1 wurde falsch gesetzt!");
			mistakes++;
		}
		if(x[2].equals("antwort2.set(5)")) {
			antwort2_input.setText("5");
		} else {
			jLabel.setText(jLabel.getText()+", Antwort2 wurde falsch gesetzt!");
			mistakes++;
		}
		if(x[3].equals("antwort3.set(4)")) {
			antwort3_input.setText("4");
		} else {
			jLabel.setText(jLabel.getText()+", Antwort3 wurde falsch gesetzt!");
			mistakes++;
		}
		if(x[4].equals("antwort4.set(7)")) {
			antwort4_input.setText("7");
		} else {
			jLabel.setText(jLabel.getText()+", Antwort4 wurde falsch gesetzt!");
		}
		if(mistakes == 0) {
			jLabel.setText("Du hast die Übung erfolgreich absolviert");
		} else {
			jLabel.setText(jLabel.getText()+"Du hast "+mistakes+" Fehler!");
		}
		jLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				jFrame.setVisible(false);
				
			}
		});
		jFrame.setLocation(960, 540);
		jLabel.setFont(new Font("Arial", 0, 20));
		jFrame.setUndecorated(true);
		jFrame.setSize(350,100);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public void uebung1run() throws IOException, ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("nashorn");

        ObjectTest object = new ObjectTest();
		engine.put("access", object); // platziere objekt unter namen "access" in js
        engine.eval("access.set('hello world')"); // rufe access.print via JS auf

        
        String test = textInput.getText();
        engine.eval(test); // user kann js code eingeben
       
        
        frage_input.setText(object.eingabeString.toString());
        if(frage_input.getText().equals("test")) {
        	System.out.println("Richtig!");
        } else {
        	System.out.println("Falsch!");
        }
        
	}
	
	public static class ObjectTest {
		private String eingabeString;
		
        public void set(String msg) { // soll von javascript aufgerufen werden
        	eingabeString = msg;
        }
	}
	
	public void exit()
	{
		System.exit(1);
	}
}
