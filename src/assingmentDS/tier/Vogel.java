package assingmentDS.tier;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Vogel extends Tier{
    private boolean kannFliegen;
    public Vogel(String name, boolean kannFliegen) {
        super(name);
        this.kannFliegen = kannFliegen;
    }

    public boolean isKannFliegen() {
        return kannFliegen;
    }

    @Override
    public String toString() {
        return "Vogel{" +
                "kannFliegen=" + kannFliegen + ", " +
                "name='" + getName() + '\'' +
                '}';
    }
}
