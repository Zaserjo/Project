package application;
import java.net.URL;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlaySound extends Application {
	private ArrayList<String> playList = new ArrayList<String>();
	private URL resource;
	private Media media;
	private MediaPlayer mediaPlayer;
	private boolean temp;
	
	public void init() {
		playList.add("music/Spectre.mp3");
		playList.add("music/Fade.mp3");
		playList.add("music/I Dont Like It, I Love It.mp3");
		playList.add("music/Lush Life.mp3");
		playList.add("music/Throne.mp3");
		playList.add("music/DADDY.mp3");
		playList.add("music/Gangnam Style.mp3");
		playList.add("music/I gotta Feeling.mp3");
		playList.add("music/Lean On.mp3");
		playList.add("music/OMFG - Hello.mp3");
		playList.add("music/Spectre.mp3");
	}

	@Override
	public void start(Stage primaryStage) {
		if(mediaPlayer != null) {
			mediaPlayer.stop();
		}
		String song = playList.get(randomSelectSong());
		resource = getClass().getResource(song);
		media = new Media(resource.toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		mediaPlayer.autoPlayProperty();
	}
	
	public int randomSelectSong() {
		init();
		Random r = new Random();
		int x = r.nextInt(playList.size());
		return x;
	}

  
}
