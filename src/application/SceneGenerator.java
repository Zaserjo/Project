package application;

import java.io.*;

import java.net.URI;
import java.nio.file.Paths;
import java.util.*;
import javafx.application.Platform;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.util.Duration;

public class SceneGenerator {
	final Label currentlyPlaying = new Label();
	final ProgressBar progress = new ProgressBar();
	private ChangeListener<Duration> progressChangeListener;

	public Scene createScene() {
		final StackPane layout = new StackPane();

		// determine the source directory for the playlist
		final File dir = new File("assets/music");
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("Cannot find music source directory: " + dir);
			Platform.exit();
			return null;
		}

		// create some media players.
		final List<MediaPlayer> players = new ArrayList<MediaPlayer>();
		for (String file : dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".mp3");
			}

		})) {
			
			players.add(createPlayer(Paths.get(dir.toString(), file).toUri()));
		}
		if (players.isEmpty()) {
			System.out.println("No audio found in " + dir);
			Platform.exit();
			return null;
		}

		// create a view to show the mediaplayers.
		final MediaView mediaView = new MediaView(players.get(0));
		final Button skip = new Button("Skip");
		final Button play = new Button("Pause");

		// play each audio file in turn.
		long seed = System.nanoTime();
		for (int i = 0; i < players.size(); i++) {
			final MediaPlayer player = players.get(i);
			final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
			// Collections.shuffle(players, new Random(seed));
			player.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					player.currentTimeProperty().removeListener(progressChangeListener);
					mediaView.setMediaPlayer(nextPlayer);
					nextPlayer.play();
				}
			});
		}

		// allow the user to skip a track.
		skip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				final MediaPlayer curPlayer = mediaView.getMediaPlayer();
				MediaPlayer nextPlayer = players.get((players.indexOf(curPlayer) + 1) % players.size());
				mediaView.setMediaPlayer(nextPlayer);
				curPlayer.currentTimeProperty().removeListener(progressChangeListener);
				curPlayer.stop();
				nextPlayer.play();
				play.setText("Pause");
			}
		});

		// allow the user to play or pause a track.
		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if ("Pause".equals(play.getText())) {
					mediaView.getMediaPlayer().pause();
					play.setText("Play");
				} else {
					mediaView.getMediaPlayer().play();
					play.setText("Pause");
				}
			}
		});

		// display the name of the currently playing track.
		mediaView.mediaPlayerProperty().addListener(new ChangeListener<MediaPlayer>() {
			@Override
			public void changed(ObservableValue<? extends MediaPlayer> observableValue, MediaPlayer oldPlayer,
					MediaPlayer newPlayer) {
				setCurrentlyPlaying(newPlayer);
			}
		});

		// start playing the first track.
		mediaView.setMediaPlayer(players.get(0));
		mediaView.getMediaPlayer().play();
		setCurrentlyPlaying(mediaView.getMediaPlayer());

		// silly invisible button used as a template to get the actual preferred
		// size of the Pause button.
		Button invisiblePause = new Button("Pause");
		invisiblePause.setVisible(false);
		play.prefHeightProperty().bind(invisiblePause.heightProperty());
		play.prefWidthProperty().bind(invisiblePause.widthProperty());

		// layout the scene.
		layout.setStyle("-fx-background-color: cornsilk; -fx-font-size: 20; -fx-padding: 20; -fx-alignment: center;");
		layout.getChildren().addAll(invisiblePause,
				VBoxBuilder
						.create().spacing(10).alignment(Pos.CENTER).children(currentlyPlaying, mediaView, HBoxBuilder
								.create().spacing(10).alignment(Pos.CENTER).children(skip, play, progress).build())
						.build());
		progress.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(progress, Priority.ALWAYS);
		return new Scene(layout, 500, 300);
	}

	/**
	 * sets the currently playing label to the label of the new media player and
	 * updates the progress monitor.
	 */
	private void setCurrentlyPlaying(final MediaPlayer newPlayer) {
		progress.setProgress(0);
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue,
					Duration newValue) {
				progress.setProgress(
						1.0 * newPlayer.getCurrentTime().toMillis() / newPlayer.getTotalDuration().toMillis());
			}
		};
		newPlayer.currentTimeProperty().addListener(progressChangeListener);

		String source = newPlayer.getMedia().getSource();
		source = source.substring(0, source.length() - ".mp3".length());
		source = source.substring(source.lastIndexOf("/") + 1).replaceAll("%20", " ");
		currentlyPlaying.setText("Now Playing: " + source);
	}

	/**
	 * @return a MediaPlayer for the given source which will report any errors
	 *         it encounters
	 */
	private MediaPlayer createPlayer(URI aMediaSrc) {
		// System.out.println("Creating player for: " + aMediaSrc);
		final MediaPlayer player = new MediaPlayer(new Media(aMediaSrc.toASCIIString()));
		player.setOnError(new Runnable() {
			@Override
			public void run() {
				System.out.println("Media error occurred: " + player.getError());
			}
		});
		return player;
	}
}