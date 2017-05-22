package assignmentDS.animal;

import assignmentDS.enclosure.Enclosure;
import assignmentDS.person.Stuff;

/***
 * Created on 24.04.2017.
 * Garantiert Funktionalitäten in der Animalsklasse
 */
public interface IAnimal {
    String getName();
    Enclosure getEnclosure();
    String getSpecies();
    boolean isAlive();
    void setStuff(Stuff stuff);
}
