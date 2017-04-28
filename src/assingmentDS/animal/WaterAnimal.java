package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 * Wassertier (lebt im Wasser)
 */
public abstract class WaterAnimal extends Animal {
    WaterAnimal(String name, String art, boolean istGiftig, boolean mayFly, boolean isPredator, double avgSize, boolean isstAas) {
        super(name, art, istGiftig, mayFly, true, isPredator, avgSize,isstAas);
    }
}
