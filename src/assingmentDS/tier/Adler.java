package assingmentDS.tier;

import assingmentDS.Log;

/**
 * Created by pv42 on 24.04.2017.
 */
public final class Adler extends Vogel{
    public Adler(String name) {
        super(name,"Adler",false,true,true,1,true);
    }

    @Override
    public String toString() {
        return "Adler{" +
                "name=" + getName() +", " +
                "personal=" + getPersonal() +
                "}";
    }
}
