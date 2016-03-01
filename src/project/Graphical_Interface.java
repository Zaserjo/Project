package project;

import java.awt.*;
import javax.swing.*;

public class Graphical_Interface {

	 public static void main(String[] args) {
		 JFrame meinJFrame = new JFrame();
	     meinJFrame.setTitle("Spiel");
	     meinJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	     
	     JPanel panel = new JPanel();
	     panel.setLayout(null);
	     panel.setPreferredSize(new Dimension(1000,1000));
	     
	     // JButton mit Text "Spiel" wird erstellt
	     JButton spielButton = new JButton("Spiel");
	     JButton profilButton = new JButton("Spielerprofil");
	     
	     Cursor c = new Cursor(12);
	     //
	     
	     /*
	      * Cursor-Art
	      * Größe
	      * Hintegrund
	      * Schriftart
	      * Position
	      */
	     spielButton.setCursor(c);
	     spielButton.setBackground(Color.GREEN);
	     spielButton.setBounds(10, 10, 500, 500);
	     spielButton.setFont(new Font("Arial Bold", 20, 45));
	     
	     profilButton.setCursor(c);
	     profilButton.setBackground(Color.RED);
	     profilButton.setBounds(510,10,500,500);
	     profilButton.setFont(new Font("Arial Bold", 20, 45));
	     
	     
	 
	     // JButton wird dem Panel hinzugefügt
	     panel.add(spielButton);
	     panel.add(profilButton);
	     
	     meinJFrame.add(panel);
	 
	     // Fenstergröße wird so angepasst, dass 
	     // der Inhalt reinpasst    
	     meinJFrame.pack();
	 
	     meinJFrame.setResizable(true);
	     meinJFrame.setVisible(true);
	  }
}