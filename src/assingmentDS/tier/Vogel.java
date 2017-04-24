package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Vogel extends Tier{
    public Vogel(String name, String art) {
        super(name,art);
    }


    @Override
    public String toString() {
        return "Vogel{" +

                "name='" + getName() + '\'' +
                '}';
    }
}
