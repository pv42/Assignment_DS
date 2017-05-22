package assingmentDS.person;

import assingmentDS.util.Log;
import assingmentDS.NamedObject;
import assingmentDS.enclosure.Enclosure;

/***
 * Created by pv42 on 24.04.2017.
 * Repräsentiert alle benötogten Eigenschaften aller Personen
 * In der Aufgabenstellung heißt diese Klasse Personen (plural), das wurde geändert,
 * da sie nur eine Person repräsentiert.
 */
public abstract class Person implements NamedObject {
    private String name;
    private Gender gender;
    private Enclosure enclosure; /* dieses Attribut ist eigenlich nur für Besucher wichtig, soll aber laut Klassendiagramm
     in die abstrakte Klasse, ist null bei Personal */

    //erzeugt eine Person mit Name
    public Person(String name,Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    // gibt den Name der Person zurück
    public String getName() {
        return name;
    }

    // weist der Person ein Gehege zu, welches sie beobachtet
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
        Log.watch("Besucher",this, enclosure); // Ausgabe
    }

    // gibt Gehege zurück
    public Enclosure getEnclosure() {
        return enclosure;
    }

    public Gender getGender() {
        return gender;
    }



}
