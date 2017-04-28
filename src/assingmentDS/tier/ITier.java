package assingmentDS.tier;

import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Personal;

/**
 * Created by pv42 on 24.04.2017.
 */
public interface ITier {
    public void setPersonal(Personal personal);
    public Personal getPersonal();
    public String getName();
    public void setEnclosure(Enclosure enclosure);
    public Enclosure getEnclosure();
}
