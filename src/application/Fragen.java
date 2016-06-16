package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/*
 * Fragen Initialisierung
 */
public class Fragen {
	
	private String frage;
	private String antwort;
	private String[] antworten;
	
	/*
	 * Konstruktor
	 */
	private Fragen(String frage, String richtige_antwort, String[] antworten) {
		this.frage = frage;
		this.antwort = richtige_antwort;
		this.antworten = antworten;
	}
	
	public String getFrage() {
		return frage;
	}
	
	public String getAntwort() {
		return antwort;
	}
	
	public String[] getLoesungen() {
		return antworten;
	}
	
	/*
	 * Aus der Datenbank werden die Fragen geladen
	 */
	public static List<Fragen> getFragen(FragenTyp typ, int maxanzahl) throws IOException {
		List<Fragen> fragen = new ArrayList<Fragen>();
		String content = getContent("http://kappa-zaserjo.hol.es/?typ=" + typ.value + "&anz=" + maxanzahl);
		String[] teile = content.split("<br>");
		for(String s : teile) {
			String[] innerteile = s.split(";");
			fragen.add(new Fragen(innerteile[0], innerteile[1], (innerteile[2] + ";" + innerteile[3] + ";" + innerteile[4]).split(";")));
		}
		return fragen;
	}
	
	/*
	 * Fragen werden entschlüsselt
	 */
	//get String from internet and decode it
	private static String decode(String encoded) { //get string from base64
        try {
			return new String(javax.xml.bind.DatatypeConverter.parseBase64Binary(encoded), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	/*
	 * Inhalt wird zurückgeliefert
	 */
	private static String getContent(String url) throws IOException {
        URLConnection con = new URL(url).openConnection(); //Open the connection
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); //get the reader
        //Read the content from the url
        String result = br.readLine();
        br.close();
        //decode and return the content
        return decode(result);
    }
}
