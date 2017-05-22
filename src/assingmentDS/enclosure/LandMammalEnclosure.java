package assingmentDS.enclosure;

import assingmentDS.util.Log;
import assingmentDS.Zoo;

/***
 * Created on 24.04.2017.
 * ein Landsäugetiergehege
 */
public class LandMammalEnclosure extends Enclosure {
    public LandMammalEnclosure(String name, Zoo zoo) {
        super(name, zoo);
        Log.created("Landsäugetiergehege",this);
    }
}
