package application;

/*
 * Zählt die richtigen Antworten
 */
public class Counter {
	
	public static int result = 0;
	
	public int max = 0;
	
	public Counter(int max) {
		this.max = max;
	}
	
	public void increment() {
		result++;
	}
	
	public void reset(int max) {
		this.max = max;
		result = 0;
	}

}
