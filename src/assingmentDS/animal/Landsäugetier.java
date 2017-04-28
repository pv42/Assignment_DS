package assingmentDS.animal;

/**
 * Created by pv42 on 24.04.2017.
 */
public abstract class Landsäugetier extends Animal {

    public Landsäugetier(String name, String art, boolean istGiftig,boolean kannFliegen, boolean istRaubtier, double durchschnittlicheSize,boolean isstAas) {
        super(name, art, istGiftig, kannFliegen, false, istRaubtier, durchschnittlicheSize,isstAas);
    }
}
