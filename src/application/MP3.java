package application;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/*
 * Musik abspielen
 */
public class MP3 extends Application {

	private MediaPlayer mediaPlayer;
	private ArrayList<String> songs;
	public static boolean isPlaying = false;
	
	/*
	 * Konstruktor
	 */
	public MP3() throws Exception {
		songs = new ArrayList<String>();
		start(MainApp.primary);
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * Wird ausgeführt
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		String song = "";
		for(int i = 0; i < songs.size(); i++) {
			song = songs.get(i);
		}
	    final URL resource = getClass().getResource(song);
	    final Media media = new Media(resource.toString());
	    mediaPlayer = new MediaPlayer(media);
    }
	
	/*
	 * Lieder werden eingefügt
	 * (non-Javadoc)
	 * @see javafx.application.Application#init()
	 */
	public void init() {
		songs.add("music/BringMeTheHorizonThrone.mp3");
		songs.add("music/Daddy.mp3");
		songs.add("music/Fade.mp3");
		songs.add("music/GangnamStyle.mp3");
		songs.add("music/IdontLikeIt.mp3");
		songs.add("music/IgottaFeeling.mp3");
		songs.add("music/LeanOn.mp3");
		songs.add("music/LushLife.mp3");
		songs.add("music/OMFG-Hello.mp3");
		songs.add("music/PartyRockAnthem.mp3");
		songs.add("music/Spectre.mp3");
		Collections.shuffle(songs);
	}
	
	/*
	 * Musik startet
	 */
    public void play() {
    	isPlaying = true;
    	mediaPlayer.play();
	}
    
    /*
     * Musik stoppt
     * (non-Javadoc)
     * @see javafx.application.Application#stop()
     */
    public void stop() {
    	isPlaying = false;
    	mediaPlayer.pause();
    }
}