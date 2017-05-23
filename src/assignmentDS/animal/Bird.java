package assignmentDS.animal;

/***
 * Created on 24.04.2017.
 * Ein Vogel als Tier (lebt nicht unter Wasser)
 */
public abstract class Bird extends Animal {
    Bird(String name, String art, boolean isPoisonous, boolean mayFly, boolean isPredator, double avgSize, boolean isScavenger) {
        super(name, art, isPoisonous, mayFly,false, isPredator, avgSize, isScavenger);
    }
}
