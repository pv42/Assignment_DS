package assignmentDS.animal;

/**
 * Created by pv42 on 17.05.2017.
 * Ein Pinguin (nicht giftig, kann nicht fliegen, Raubtier, kein Aasfresser)
 */
public class Penguin extends Bird{
    Penguin(String name) {
        super(name, "Penguin", false, false, true, 0.7, false);
    }
}
