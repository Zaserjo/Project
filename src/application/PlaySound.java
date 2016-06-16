package application;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/*
 * Töne beim Quiz
 */
public class PlaySound extends Application {
	private boolean temp;
	private MediaPlayer mediaPlayer;
	
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * Führt Soundeffekte aus
	 */
	@Override
	public void start(Stage primaryStage) {
		String song = "";
		if(temp) {
			song = "sound/applaus.mp3";
		} else {
			song = "sound/raunen.mp3";
		}
	    final URL resource = getClass().getResource(song);
	    final Media media = new Media(resource.toString());
	    mediaPlayer = new MediaPlayer(media);
    }
	
	/*
	 * Startet den Ton
	 */
    public void player() {
    	mediaPlayer.play();
	}
    
    /*
     * (non-Javadoc)
     * @see javafx.application.Application#stop()
     * Stoppt den Ton
     */
    public void stop() {
    	mediaPlayer.stop();
    }

	/**
	 * @return the temp
	 */
	public boolean isTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(boolean temp) {
		this.temp = temp;
	}
}
