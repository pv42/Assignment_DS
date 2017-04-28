package assingmentDS.enclosure;

import assingmentDS.Log;

/**
 * Created by pv42 on 24.04.2017.
 */
public class LandMammalEnclosure extends Enclosure {
    public LandMammalEnclosure(String name) {
        super(name);
        Log.write("LandMammalEnclosure " + name + " erstellt");
    }
}
