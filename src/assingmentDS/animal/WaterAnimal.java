package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 * Wassertier (lebt im Wasser)
 */
public abstract class WaterAnimal extends Animal {
    WaterAnimal(String name, String species, boolean isPoisonous, boolean mayFly, boolean isPredator, double avgSize, boolean isScavenger) {
        super(name, species, isPoisonous, mayFly, true, isPredator, avgSize,isScavenger);
    }
}
