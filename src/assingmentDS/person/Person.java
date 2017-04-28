package assingmentDS.person;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.enclosure.Enclosure;

/***
 * Created by pv42 on 24.04.2017.
 * Repräsentiert alle benötogten Eigenschaften aller Personen
 * In der Aufgabenstellung heißt diese Klasse Personen (plural), das wurde geändert,
 * da sie nur eine Person repräsentiert.
 */
//TODO description -> ...
public abstract class Person implements NamedObject {
    private String name;
    private Enclosure enclosure; /* dieses Attribut ist eigenlich nur für Besucher wichtig, soll aber laut Klassendiagramm
     in die abstrakte Klasse */

    //erzeugt eine Person min Name
    public Person(String name) {
        this.name = name;
    }

    // gibt den Name der Person zuruck
    public String getName() {
        return name;
    }

    // weisst der Person ein Gehege zu, welches sie beobachtet
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        Log.watch("Besucher",this, enclosure); // Ausgabe
    }

    // gibt Gehege zurück
    public Enclosure getEnclosure() {
        return enclosure;
    }

    @Override
    public String toString() {
        if(enclosure != null) {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", enclosure=" + enclosure.getName() +
                    '}';
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
