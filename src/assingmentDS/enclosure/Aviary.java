package assingmentDS.enclosure;

import assingmentDS.Log;

/**
 * Created by pv42 on 24.04.2017.
 * Repräsentiert die Umsetzung einse Vogelgeheges
 */
public class Aviary extends Enclosure {
    public Aviary(String name) {
        super(name);
        Log.created("Vogelgehege",this);
    }
}
