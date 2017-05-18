package assingmentDS.animal;

/**
 * Created by pv42 on 18.05.2017.
 */
public abstract class Mammal extends Animal {
    Mammal(String name, String species, boolean isPoisonous, boolean mayFly, boolean isLivingSubmerged, boolean isPredator, double avgSize, boolean isScavenger) {
        super(name, species, isPoisonous, mayFly, isLivingSubmerged, isPredator, avgSize, isScavenger);
    }
}
