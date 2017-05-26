package assignmentDS.enclosure;

import assignmentDS.util.Log;
import assignmentDS.Zoo;

/***
 * Created on 24.04.2017.
 * ein Landsäugetiergehege
 */
public class LandMammalEnclosure extends Enclosure {
    public LandMammalEnclosure(String name, Zoo zoo, boolean useTree) {
        super(name, zoo ,useTree);
        Log.created("Landsäugetiergehege",this);
    }
}
