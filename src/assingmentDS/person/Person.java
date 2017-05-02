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
public abstract class Person implements NamedObject {
    public static final int GENDER_MALE = 0;
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_APACHE = 2;
    private String name;
    private int gender;
    private Enclosure enclosure; /* dieses Attribut ist eigenlich nur für Besucher wichtig, soll aber laut Klassendiagramm
     in die abstrakte Klasse, ist null bei Personal */

    //erzeugt eine Person mit Name
    public Person(String name,int gender) {
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

    public int getGender() {
        return gender;
    }



}
