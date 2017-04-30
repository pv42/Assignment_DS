package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 * Ein Landsäugetier (lebt nicht Unterwasser)
 */
public abstract class LandMammal extends Animal {

    LandMammal(String name, String art, boolean istGiftig, boolean kannFliegen, boolean istRaubtier, double durchschnittlicheSize, boolean isstAas) {
        super(name, art, istGiftig, kannFliegen, false, istRaubtier, durchschnittlicheSize,isstAas);
    }
}
