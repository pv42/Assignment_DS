package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Löwe extends Landsäugetier{
    public Löwe(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Löwe{" +
                "name=" + getName() +", " +
                "personal=" + getPersonal() +
                "}";
    }
}
