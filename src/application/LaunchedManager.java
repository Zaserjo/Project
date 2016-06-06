package application;

import java.util.List;
import java.util.ArrayList;

public class LaunchedManager {

	private static List<Launched> liste = new ArrayList<Launched>();
	
	public static void addListener(final Launched l) {
		if(l != null) liste.add(l);
	}
	
	public static void notifyListener(Object value) {
		for(Launched l: liste) {
			l.launched(value);
		}
		liste.clear();
	}
}
