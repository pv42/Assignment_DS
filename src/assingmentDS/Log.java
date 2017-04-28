package assingmentDS;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by pv42 on 24.04.2017.
 * Ausgabeklasse, übernimmt alle Augabefunktionen außer Kommandzeilenhilfe/-version
 */
public class Log {
    private static PrintStream out = System.out;
    public static void created(String type,NamedObject namedObject) {
        write(type + " " + namedObject .getName()+ " erstellt");
    }
    public static void added(String type,NamedObject sub, NamedObject sup) {
        write(type  + " " + sub.getName() + " zu " + sup.getName() + " hinzugefügt");
    }
    public static void removed(String type,NamedObject sub, NamedObject sup,boolean succses) {
        if(succses) write(type  + " " + sub.getName() + " von " + sup.getName() + " entfernt");
        else write(type  + " " + sub.getName() + " konnte nicht  von " + sup.getName() + " entfernt werden");
    }
    public static void watch(String type,NamedObject sub, NamedObject sup) {
        write(type + " " + sub.getName() + " besucht " + sup.getName());
    }
    public static void write(String s) {
        out.println(s);
    }
    public static void redirectToFile(String filename) {
        try {
            out = new PrintStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Ausgabe konnte nicht umgeleitet werden");
        }
    }
}
