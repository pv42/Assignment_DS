package assignmentDS.enclosure;

import assignmentDS.util.Log;
import assignmentDS.Zoo;

/***
 * Created on 24.04.2017.
 * Repräsentiert die Umsetzung einse Aquariums
 */
public class Aquarium extends Enclosure {
    //erzeugt ein Aquarium
    public Aquarium(String name, Zoo zoo, boolean useTree) {
        super(name, zoo, useTree);
        Log.created("Aquarium",this); // gibt Erzeugen aus
    }
}
