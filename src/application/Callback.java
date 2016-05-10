package application;

import javafx.application.Platform;

public class Callback {
	
	public Callback(final long time, final Runnable r) {
		new Thread(() -> {
			try { Thread.sleep(time); } catch(Exception e) {}
			Platform.runLater(r);
		}).start(); //Perfect lol
	}

}
