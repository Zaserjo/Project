package application;

import java.util.List;
import java.util.ArrayList;

/*
 * Alle Launches werden hier verwaltet
 */
public class LaunchedManager {

	private static List<Launched> liste = new ArrayList<Launched>();
	
	/*
	 * Listener hinzufügen
	 */
	public static void addListener(final Launched l) {
		if(l != null) liste.add(l);
	}
	
	/*
	 * ListenerManager wird benachrichtigt
	 */
	public static void notifyListener(Object value) {
		for(Launched l: liste) {
			l.launched(value);
		}
		liste.clear();
	}
}
