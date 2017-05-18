package assingmentDS.animal;

/**
 * Created by pv42 on 17.05.2017.
 */
public abstract class Reptile extends Animal{
    Reptile(String name, String species, boolean isPoisonous, boolean mayFly, boolean isLivingSubmerged, boolean isPredator, double avgSize, boolean isScavenger) {
        super(name, species, isPoisonous, mayFly, isLivingSubmerged, isPredator, avgSize, isScavenger);
    }
}
