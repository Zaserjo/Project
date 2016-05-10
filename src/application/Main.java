package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class Main {
        public static class ObjectTest {
        		private String eingabeString;
        		
                public void set(String msg) { // soll von javascript aufgerufen werden
                	eingabeString = msg;
                        JOptionPane.showMessageDialog(null, "nashorn -> java: " + msg);
                }
        }

        public static void main(String[] args) throws ScriptException, IOException {
                ScriptEngineManager manager = new ScriptEngineManager();

                ScriptEngine engine = manager.getEngineByName("nashorn");

                ObjectTest object = new ObjectTest();
				engine.put("access", object); // platziere objekt unter namen "access" in js
                engine.eval("access.set('hello world')"); // rufe access.print via JS auf

                
                String test = new BufferedReader(new InputStreamReader(System.in)).readLine();
                System.out.println(test);
                engine.eval(test); // user kann js code eingeben
               
                
                // hat er das richtige?
                if(object.eingabeString.equals("ASDF")) {
                	System.out.println("RICHTIG!!");
                } else {
                	System.out.println("FALSCH");
                }
                new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
}
