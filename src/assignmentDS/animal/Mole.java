package assignmentDS.animal;

/**
 * Created by pv42 on 17.05.2017.
 * Ein Mull (nicht giftig, kann nicht fliegen, kein Raubtier, kein Aasfresser)
 */
public final class Mole extends LandMammal{
    Mole(String name) {
        super(name, "Mole", false, false, false, 0.09, false);
    }
}
