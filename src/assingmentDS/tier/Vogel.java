package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Vogel extends Tier{
    public Vogel(String name, String art, boolean istGiftig, boolean kannFliegen, boolean istRaubtier, double durchschnittlicheSize, boolean isstAas) {
        super(name, art, istGiftig, kannFliegen,false, istRaubtier, durchschnittlicheSize, isstAas);
    }

    @Override
    public String toString() {
        return "Vogel{" +

                "name='" + getName() + '\'' +
                '}';
    }
}
