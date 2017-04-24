package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Papagei extends Vogel{
    public Papagei(String name) {
        super(name,true);
    }
    @Override
    public String toString() {
        return "Papagei{" +
                "name=" + getName() + ", " +
                "personal=" + getPersonal() + ", " +
                "kannFiegen=" + isKannFliegen() +
                "}";
    }
}
