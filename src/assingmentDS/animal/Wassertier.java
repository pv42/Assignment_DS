package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Wassertier extends Animal {


    public Wassertier(String name, String art, boolean istGiftig, boolean kannFliegen, boolean istRaubtier, double durchschnittlicheSize,boolean isstAas) {
        super(name, art, istGiftig, kannFliegen, true, istRaubtier, durchschnittlicheSize,isstAas);
    }
}
