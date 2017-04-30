package assingmentDS;

import assingmentDS.animal.Animal;
import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Person;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created on 24.04.2017.
 * Ausgabeklasse, übernimmt alle Augabefunktionen außer Kommandzeilenhilfe/-version
 */
public class Log {
    private static PrintStream out = System.out; // Ausgabestream, standartmäßig die Standartausgabe(Konsole)

    //gibt aus, das etwas erzeugt wurde
    public static void created(String type,NamedObject namedObject) {
        write(type + " " + namedObject .getName()+ " wurde erstellt.");
    }

    //gibt aus, das etwas irgendwo hinzugefugt wurde
    public static void added(String type,NamedObject sub, NamedObject sup) {
        write(type  + " " + sub.getName() + " wurde zu " + sup.getName() + " hinzugefügt.");
    }

    //gibt aus, das etwas entfernt wurde
    public static void removed(String type,NamedObject sub, NamedObject sup,boolean succses) {
        if(succses) write(type  + " " + sub.getName() + " wurde von " + sup.getName() + " entfernt.");
        else write(type  + " " + sub.getName() + " konnte nicht  von " + sup.getName() + " entfernt werden.");
    }

    //gibt aus, dass Besucher Gehege beobachtet und was er/sie sieht
    public static void watch(String type, Person person, Enclosure enclosure) {
        String thirdPersonArticle;
        if(person.getGender() == Person.GENDER_MALE) {
            thirdPersonArticle = "Er";
        } else if (person.getGender() == Person.GENDER_FEMALE) {
            thirdPersonArticle = "Sie";
        } else {
            thirdPersonArticle = "Es";
        }
        String animalsString = "";
        for(Animal animal : enclosure.getAnimals()) {
            animalsString += animal.getSpecies() + " " + animal.getName();
            if(!animal.isAlive()) animalsString += " (Tot)";
            animalsString += ", ";
        }
        animalsString = animalsString.substring(0,animalsString.length() - 2); // anfernt letzes Komma
        write(type + " " + person.getName() + " besucht " + enclosure.getName() + ". "
                + thirdPersonArticle + " könnte "  + enclosure.getAnimals().size() + " Tiere sehen: " + animalsString + ".");
    }

    //gibt aus, das etwas starb
    public static void died(String type, NamedObject namedObject, String reason) {
        write(type + " " + namedObject.getName() + " starb. Grund:" + reason);
    }

    //gibt etwas aus
    public static void write(String s) {
        out.println(s);
    }

    //leited die Augabe in eine Datei um
    public static void redirectToFile(String filename) {
        try {
            out = new PrintStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Ausgabe konnte nicht umgeleitet werden");
        }
    }
}
