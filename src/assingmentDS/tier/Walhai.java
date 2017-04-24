package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Walhai extends Wassertier{
    public Walhai(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Walhai{" +
                "name=" + getName() + ", " +
                "personal=" + getPersonal() +
                "}";
    }
}
