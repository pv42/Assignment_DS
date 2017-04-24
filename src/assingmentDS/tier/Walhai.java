package assingmentDS.tier;

import assingmentDS.Log;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Walhai extends Wassertier{
    public Walhai(String name) {
        super(name,"Walhai",false,false,false,10,false);
    }
    @Override
    public String toString() {
        return "Walhai{" +
                "name=" + getName() + ", " +
                "personal=" + getPersonal() +
                "}";
    }
}
