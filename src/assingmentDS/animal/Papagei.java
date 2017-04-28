package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Papagei extends Bird {
    public Papagei(String name) {
        super(name,"Papagei",false,true,false,0.4,false);
    }
    @Override
    public String toString() {
        return "Papagei{" +
                "name=" + getName() + ", " +
                "personal=" + getStuff() + ", " +
                "}";
    }
}
