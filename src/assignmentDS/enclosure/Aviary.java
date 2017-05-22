package assignmentDS.enclosure;

import assignmentDS.util.Log;
import assignmentDS.Zoo;

/***
 * Created on 24.04.2017.
 * Repräsentiert die Umsetzung einse Vogelgeheges
 */
public class Aviary extends Enclosure {
    public Aviary(String name, Zoo zoo) {
        super(name, zoo);
        Log.created("Vogelgehege",this);
    }
}
