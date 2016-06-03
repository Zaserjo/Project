package application;

import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.transform.Templates;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * A sample media player which loops indefinitely over the same video
 */
public class Abspann {
	
	private boolean abspann;
	
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
		mediaPlayer.play();
		stage.setScene(scene);
		stage.show();
	}

	public void weiter() {
		new Thread(new Runnable() {

			@Override
			public void run() {

				if(!abspann) {
					Platform.runLater(() -> {
						start(MainApp.primary);
					});
					return;
				}
					

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
		}).start();
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
}