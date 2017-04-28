package assingmentDS.enclosure;

import assingmentDS.Log;

/**
 * Created by pv42 on 24.04.2017.
 * Repräsentiert die Umsetzung einse Aquariums
 */
public class Aquarium extends Enclosure {
    //erzeugt ein Aquarium
    public Aquarium(String name) {
        super(name);
        Log.created("Aquarium",this); // gibt Erzeugen aus
    }
}
