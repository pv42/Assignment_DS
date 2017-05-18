package assingmentDS.animal;

/***
 * Created on 24.04.2017.
 * Ein Landsäugetier (lebt nicht Unterwasser)
 */
public abstract class LandMammal extends Mammal {

    LandMammal(String name, String species, boolean isPoisonous, boolean mayFly, boolean isPredator, double avgSize, boolean isScavenger) {
        super(name, species, isPoisonous, mayFly, false, isPredator, avgSize, isScavenger);
    }
}
