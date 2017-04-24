package assingmentDS.tier;

import assingmentDS.Log;

/**
 * Created by pv42 on 24.04.2017.
 */
public final class Zebra extends  Landsäugetier{
    public Zebra(String name) {
        super(name,"Zebra");
    }
    @Override
    public String toString() {
        return "Zebra{" +
                "name=" + getName() + ", " +
                "personal=" + getPersonal() +
                "}";
    }
}
