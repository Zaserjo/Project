package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Controller {

	@FXML GridPane pane_parent;
	@FXML TextField vorname_tf;
	@FXML TextField nachname_tf;
	@FXML TextField username_tf;
	@FXML PasswordField password_pf;
	@FXML Label fragennr_id;
	@FXML Pane paneMusic;
	@FXML ToggleButton tgl_btn1;
	@FXML ToggleButton tgl_btn2;
	@FXML ToggleButton tgl_btn3;
	@FXML ToggleButton tgl_btn4;
	@FXML ToggleButton tgl_btn5;
	@FXML ToggleButton tgl_btn6;
	@FXML ToggleButton tgl_btn7;
	@FXML ToggleButton tgl_btn8;
	@FXML ToggleButton tgl_btn9;


	public Controller() {

	}

	public void download()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("PaneToggle.fxml"));
			MainApp.primary.setScene(new Scene(root));
			/*mainWindow.setHeight(Main.height);
			mainWindow.setWidth(Main.width);*/
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void back()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("JavaGUI.fxml"));
			//MainApp.primary.setScene(new Scene(root));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void musik() {
		SceneGenerator sceneGenerator = new SceneGenerator();
		MainApp.primary.setScene(sceneGenerator.createScene());
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

	public void profil()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuOderLaden.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static List<Fragen> alleFragen = new ArrayList<Fragen>();
	public static int currentIndex = 0;

	public void fragen()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Fragen.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			initFragen();
			LaunchedManager.notifyListener(alleFragen.get(0));
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			//e.printStackTrace();

		}
	}

	public void initFragen() throws IOException {
		alleFragen = new ArrayList<Fragen>();
		if(tgl_btn1.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.SPORT, 10));
		}
		if(tgl_btn2.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.POLITIK, 10));
		}
		if(tgl_btn3.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.GESCHICHTE, 10));
		}
		if(tgl_btn4.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.SPIELE, 10));
		}
		if(tgl_btn5.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.OESTERREICH, 10));
		}
		if(tgl_btn6.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.LITERATUR, 10));
		}
		if(tgl_btn7.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.FILM, 10));
		}
		if(tgl_btn8.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.ESSEN_TRINKEN, 10));
		}
		if(tgl_btn9.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.NATURWISSENSCHAFTEN, 10));
		}
		if(!tgl_btn1.isSelected() && !tgl_btn2.isSelected() && !tgl_btn3.isSelected() && !tgl_btn4.isSelected() && !tgl_btn5.isSelected() && !tgl_btn6.isSelected() && !tgl_btn7.isSelected() && !tgl_btn8.isSelected() && !tgl_btn9.isSelected()) {
			try {
				Parent root = FXMLLoader.load(MainApp.class.getResource("ThemenAuswahlException.fxml"));
				MainApp.primary.setScene(new Scene(root));
				MainApp.primary.show();
				//mainWindow.setResizable(false);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}

	public void profilNeuOderLaden()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuOderLaden.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void profilErfolgreich()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilErfolgreichErstellt.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void profilErfolgreichGeladen()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilErfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void profilUnerfolgreich()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilUnerfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void profilNeuUnerfolgreich()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuUnerfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			//mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void profilErstellen() throws IOException {

		if(vorname_tf.getText().equals("") || nachname_tf.getText().equals("") || username_tf.getText().equals("") || password_pf.getText().equals("")) {
			profilNeuUnerfolgreich();
		}
		else {
			BufferedWriter writer = new BufferedWriter(new FileWriter("profil.txt"));
			writer.write(vorname_tf.getText()+";");
			writer.write(nachname_tf.getText()+";");
			writer.write(username_tf.getText()+";");
			writer.write(password_pf.getText());
			writer.flush();
			profilErfolgreich();
		}




	}

	public void profilLaden() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("profil.txt"));
			String zeile = reader.readLine();
			String[] werte = zeile.split(";");
			String vorname = werte[0];
			String nachname = werte[1];
			String username = werte[2];
			String password = werte[3];
			Thread.sleep(250);
			profilErfolgreichGeladen();
		}
		catch(Exception e) {
			profilUnerfolgreich();
		}

	}

	public void profilNeu()
	{
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("NeuesProfil.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
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

	public void exit()
	{
		System.exit(0);
	}
}
