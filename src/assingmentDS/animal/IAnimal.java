package assingmentDS.animal;

import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Stuff;

/**
 * Created by pv42 on 24.04.2017.
 */
public interface IAnimal {
    public String getName();
    public void setEnclosure(Enclosure enclosure);
    public Enclosure getEnclosure();
}
