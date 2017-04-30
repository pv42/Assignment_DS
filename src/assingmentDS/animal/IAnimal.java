package assingmentDS.animal;

import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Stuff;

/***
 * Created on 24.04.2017.
 * Garantiert Funktionalitäten in der Animalsklasse
 */
public interface IAnimal {
    String getName();
    Enclosure getEnclosure();
    String getSpecies();
    boolean isAlive();
}
