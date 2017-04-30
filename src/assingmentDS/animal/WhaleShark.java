package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 * Walhai (nicht giftig, nicht Aasfresser, nicht Raubtier, kann nicht fliegen)
 */
public final class WhaleShark extends WaterAnimal {
    public WhaleShark(String name) {
        super(name,"Walhai",false,false,false,10,false);
    }
    @Override
    public String toString() {
        return "Walhai{" +
                "name=" + getName() +
                "}";
    }
}
