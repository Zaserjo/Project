package application;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlaySound extends Application {
	private boolean temp;
	private MediaPlayer mediaPlayer;
	
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
	
    public void player() {
    	mediaPlayer.play();
	}
    
    public void stop() {
    	mediaPlayer.stop();
    }

	public boolean isTemp() {
		return temp;
	}

	public void setTemp(boolean temp) {
		this.temp = temp;
	}
}
