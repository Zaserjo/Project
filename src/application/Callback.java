package application;

import javafx.application.Platform;

public class Callback {
	
	public Callback(final Runnable r) {
		new Thread(() -> {
			try { Thread.sleep(2500); } catch(Exception e) {}
			Platform.runLater(r);
		}).start();
	}

}
