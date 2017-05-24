package assignmentDS.util;

import assignmentDS.NamedObject;
import assignmentDS.animal.Animal;
import assignmentDS.animal.IAnimal;
import assignmentDS.enclosure.Enclosure;
import assignmentDS.person.Gender;
import assignmentDS.person.Person;
import assignmentDS.person.Stuff;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created on 24.04.2017.
 * Ausgabeklasse, übernimmt alle Augabefunktionen außer Kommandzeilenhilfe/-version
 */
public class Log {
    private static PrintStream out = System.out; // Ausgabestream, standartmäßig die Standartausgabe(Konsole)

    //gibt aus, das etwas erzeugt wurde
    public static void created(String type, NamedObject namedObject) {
        writeln(type + " " + namedObject .getName()+ " wurde erstellt.");
    }

    //gibt aus, das etwas irgendwo hinzugefugt wurde
    public static void added(String type,NamedObject sub, NamedObject sup) {
        writeln(type  + " " + sub.getName() + " wurde zu " + sup.getName() + " hinzugefügt.");
    }

    //gibt aus, das etwas entfernt wurde
    public static void removed(String type,NamedObject sub, NamedObject sup,boolean succses) {
        if(succses) writeln(type  + " " + sub.getName() + " wurde von " + sup.getName() + " entfernt.");
        else writeln(type  + " " + sub.getName() + " konnte nicht  von " + sup.getName() + " entfernt werden.");
    }

    //gibt aus, dass Besucher Gehege beobachtet und was er/sie sieht
    public static void watch(String type, Person person, Enclosure enclosure) {
        String thirdPersonArticle;
        if(person.getGender() == Gender.MALE) {
            thirdPersonArticle = "Er";
        } else if (person.getGender() == Gender.FEMALE) {
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
        writeln(type + " " + person.getName() + " besucht " + enclosure.getName() + ". "
                + thirdPersonArticle + " könnte "  + enclosure.getAnimals().size() + " Tiere sehen: " + animalsString + ".");
    }

    //gibt aus, das etwas starb
    public static void died(String type, NamedObject namedObject, String reason) {
        writeln(type + " " + namedObject.getName() + " starb. Grund:" + reason);
    }

    //gibt aus das ein Pfeger sich um ein Tier kümmert
    public static void animalsStuffAdd(IAnimal animal, Stuff stuff) {
        writeln(animal.getSpecies() + " " + animal.getName() + " wurde Pfleger " + stuff.getName() + " zugeordnet.");
    }

    public static void animalsStuffRemove(IAnimal animal, Stuff stuff, boolean sucsses) {
        if(sucsses) writeln(animal.getSpecies() + " " + animal.getName() + " wurde  aus der Verantwortung von Pfleger " + stuff.getName() + " entfernt.");
        else writeln("Entfernen von " + animal.getSpecies() + " " + animal.getName() + " aus der Verantwortung von Pfleger " + stuff.getName() + " fehlgeschlagen.");
    }

    //gibt etwas aus
    public static void writeln(String s) {
        out.println(s);
    }
    public static void write(String s) {
        out.print(s);
    }

    //leited die Augabe in eine Datei um
    public static void redirectToFile(String filename) {
        try {
            out = new PrintStream(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Ausgabe konnte nicht umgeleitet werden. StackTrace:");
            e.printStackTrace();
        }
    }

    public static void networkError() {
        System.err.println("A Network Error caused the online name generation to fail. Falling back to offline mode");
    }
}
