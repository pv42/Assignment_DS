package assingmentDS.person;

import assingmentDS.Log;
import assingmentDS.Zoo;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Stuff extends Person {
    private Zoo arbeitsplatz;
    //todo use interface itier
    public Stuff(String name) {
        super(name);
        Log.created("Stuff", this);
    }

    public Zoo getArbeitsplatz() {
        return arbeitsplatz;
    }

    public void setArbeitsplatz(Zoo arbeitsplatz) {
        this.arbeitsplatz = arbeitsplatz;
    }

}
