package assingmentDS.tier;

import assingmentDS.Log;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Löwe extends Landsäugetier{
    public Löwe(String name) {
        super(name,"Löwe");
    }

    @Override
    public String toString() {
        return "Löwe{" +
                "name=" + getName() +", " +
                "personal=" + getPersonal() +
                "}";
    }
}
