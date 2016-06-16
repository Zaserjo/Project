package application;

/*
 * Fragenauswahl Enum
 */
public enum FragenTyp {
	
	SPORT(1),
	POLITIK(2),
	GESCHICHTE(3),
	SPIELE(4),
	OESTERREICH(5),
	LITERATUR(6),
	FILM(7),
	ESSEN_TRINKEN(8),
	NATURWISSENSCHAFTEN(9); //alle gebiete
	
	public final int value;
	FragenTyp (int value) { this.value = value; }

}