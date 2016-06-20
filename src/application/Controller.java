package application;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import application.Encoding.EncodingType;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/*
 * Class to control all actions
 */
public class Controller {

	/*
	 * Alle FXML Komponente werden initialisiert
	 */
	@FXML
	GridPane pane_parent;
	@FXML
	TextField vorname_tf;
	@FXML
	TextField nachname_tf;
	@FXML
	TextField username_tf;
	@FXML
	PasswordField password_pf;
	@FXML
	Label fragennr_id;
	@FXML
	Pane paneMusic;
	@FXML
	ToggleButton tgl_btn1;
	@FXML
	ToggleButton tgl_btn2;
	@FXML
	ToggleButton tgl_btn3;
	@FXML
	ToggleButton tgl_btn4;
	@FXML
	ToggleButton tgl_btn5;
	@FXML
	ToggleButton tgl_btn6;
	@FXML
	ToggleButton tgl_btn7;
	@FXML
	ToggleButton tgl_btn8;
	@FXML
	ToggleButton tgl_btn9;
	@FXML
	MediaView mediaView = new MediaView();
	private MP3 mp3;
	static String vorname;
	static String nachname;
	static String username;
	static String password;
	private Media media;
	private MediaPlayer mediaPlayer;

	/*
	 * MP3-Player wird initialisiert
	 */
	public Controller() throws Exception {
		mp3 = new MP3();
	}

	/*
	 * Öffnet die Projekt Website wenn in About gedrückt
	 */
	public void open() throws URISyntaxException {
		URI path = new URI("www.Zaserjo-POS_Projekt.netau.net");
		try {
			Desktop.getDesktop().browse(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void download() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("PaneToggle.fxml"));
			MainApp.primary.setScene(new Scene(root));
			/*
			 * mainWindow.setHeight(Main.height);
			 * mainWindow.setWidth(Main.width);
			 */
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void back() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("JavaGUI.fxml"));
			// MainApp.primary.setScene(new Scene(root));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*
	 * Startet den Abspann
	 */
	/*public void abspann2() {
		Abspann abspann = new Abspann();
		abspann.weiter();
	}*/
	
	/*
	 * Starten den Abspann
	 */
	public void abspann() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Abspann.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			init();
			// mainWindow.setResizable(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void init() {
		media = new Media("http://www.musik_projekt.net23.net/Credits.mp4");
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.setAutoPlay(true);
	}

	/*
	 * Überprüft ob Musik läuft und wenn nicht, dann startet die Musik
	 */
	public void musik() throws Exception {
		if (MP3.isPlaying) {
			mp3.stop();
		} else {
			mp3.play();
		}
	}

	
	/*
	 * Öffnet das About-Fenster
	 */
	public void about() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("About.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Öffnet das Menü zum Auswählen zwischen ProfilErstellen bzw. Neu Laden
	 */
	public void profil() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuOderLaden.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Fragen> alleFragen = new ArrayList<Fragen>();
	public static int currentIndex = 0;

	/*
	 * Themen werder ausgewählt.
	 */
	public void fragen() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Fragen.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			initFragen();
			LaunchedManager.notifyListener(alleFragen.get(0));
		} catch (Exception e) {
		}
	}

	/*
	 * Je nach Auswahl werden die Fragen in die ArrayList eingefügt
	 */
	public void initFragen() throws IOException {
		alleFragen = new ArrayList<Fragen>();
		if (tgl_btn1.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.SPORT, 10));
		}
		if (tgl_btn2.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.POLITIK, 10));
		}
		if (tgl_btn3.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.GESCHICHTE, 10));
		}
		if (tgl_btn4.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.SPIELE, 10));
		}
		if (tgl_btn5.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.OESTERREICH, 10));
		}
		if (tgl_btn6.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.LITERATUR, 10));
		}
		if (tgl_btn7.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.FILM, 10));
		}
		if (tgl_btn8.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.ESSEN_TRINKEN, 10));
		}
		if (tgl_btn9.isSelected()) {
			alleFragen.addAll(Fragen.getFragen(FragenTyp.NATURWISSENSCHAFTEN, 10));
		}
		if (!tgl_btn1.isSelected() && !tgl_btn2.isSelected() && !tgl_btn3.isSelected() && !tgl_btn4.isSelected()
				&& !tgl_btn5.isSelected() && !tgl_btn6.isSelected() && !tgl_btn7.isSelected() && !tgl_btn8.isSelected()
				&& !tgl_btn9.isSelected()) {
			try {
				Parent root = FXMLLoader.load(MainApp.class.getResource("ThemenAuswahlException.fxml"));
				MainApp.primary.setScene(new Scene(root));
				MainApp.primary.show();
				// mainWindow.setResizable(false);
			} catch (Exception e) {

			}
		}
	}

	/*
	 * Öffnet das Menü zur Auswahl zwischen Profil erstellen und Laden.
	 */
	public void profilNeuOderLaden() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuOderLaden.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Zeigt die Bestätigung, dass das Profil erfolgreich erstellt wurde
	 */
	public void profilErfolgreich() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilErfolgreichErstellt.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Zeigt die Bestätigung, dass das Profil erfolgreich geladen wurde
	 */
	public void profilErfolgreichGeladen() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilErfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Zeigt, dass das Profil unerfolgreich geladen wurde
	 */
	public void profilUnerfolgreich() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilUnerfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Zeigt, dass das Profil nicht erstellt wurde
	 */
	public void profilNeuUnerfolgreich() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("ProfilNeuUnerfolgreich.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Schreibt das erstellte Profil in eine Textdatei
	 */
	public void profilErstellen() throws IOException, NoSuchAlgorithmException {
		Encoding encoding = new Encoding(password_pf.getText(), EncodingType.MD5);
		password = encoding.getHashcodeAsString();
		if (vorname_tf.getText().equals("") || nachname_tf.getText().equals("") || username_tf.getText().equals("")
				|| password_pf.getText().equals("")) {
			profilNeuUnerfolgreich();
		} else {
			vorname = vorname_tf.getText();
			nachname = nachname_tf.getText();
			username = username_tf.getText();
			BufferedWriter writer = new BufferedWriter(new FileWriter("profil.txt"));
			writer.write(vorname_tf.getText() + ";");
			writer.write(nachname_tf.getText() + ";");
			writer.write(username_tf.getText() + ";");
			writer.write(password);
			writer.flush();
			profilErfolgreich();
			writer.close();
		}
	}

	/*
	 * Lädt das gespeicherte Profil aus der Textdatei 
	 */
	public void profilLaden() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("profil.txt"));
			String zeile = reader.readLine();
			String[] werte = zeile.split(";");
			vorname = werte[0];
			nachname = werte[1];
			username = werte[2];
			password = werte[3];
			Thread.sleep(250);
			profilErfolgreichGeladen();
			reader.close();
		} catch (Exception e) {
			profilUnerfolgreich();
		}

	}

	/*
	 * Man gelangt zum Menü, um ein neues Profil zu erstellen
	 */
	public void profilNeu() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("NeuesProfil.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*
	 * Man gelangt zur Übungsauswahl
	 */
	public void uebungen() {
		try {
			Parent root = FXMLLoader.load(MainApp.class.getResource("Uebungen.fxml"));
			MainApp.primary.setScene(new Scene(root));
			MainApp.primary.show();
			// mainWindow.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*
	 * Beendet das Programm
	 */
	public void exit() {
		System.exit(0);
	}
}
