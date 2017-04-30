package assingmentDS.enclosure;

import assingmentDS.Log;
import assingmentDS.Zoo;

/***
 * Created on 24.04.2017.
 * Repräsentiert die Umsetzung einse Aquariums
 */
public class Aquarium extends Enclosure {
    //erzeugt ein Aquarium
    public Aquarium(String name, Zoo zoo) {
        super(name, zoo);
        Log.created("Aquarium",this); // gibt Erzeugen aus
    }
}
