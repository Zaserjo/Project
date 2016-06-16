package application;

import java.nio.file.Paths;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * Credits
 */
public class Abspann {
	
	/*
	 * Video wird abgespielt
	 */
	public void start(Stage stage) {
		double height = MainApp.primary.getHeight();
		double width = MainApp.primary.getWidth();

		// Create media player
		Media media = new Media(Paths.get("Unbenannt.mp4").toUri().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);

		// Add media display node to the scene graph
		MediaView mediaView = new MediaView(mediaPlayer);
		Group root = new Group();
		Scene scene = new Scene(root, width, height);

		root.getChildren().add(mediaView);
	
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Platform.runLater(() -> {
					Parent root;
					try {
						root = FXMLLoader.load(MainApp.class.getResource("JavaGUI.fxml"));
						MainApp.primary.setScene(new Scene(root));
						MainApp.primary.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		});
		
		mediaPlayer.play();
		MainApp.primary.setScene(scene);
		MainApp.primary.show();
	}

	/*
	 * Zurück zum Startmenü
	 */
	public void weiter() {
		new Thread(() -> {
					Platform.runLater(() -> {
						start(MainApp.primary);
					});
		}).start();
				
	}
}