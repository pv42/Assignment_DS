package assingmentDS.animal;

/***
 * Created by pv42 on 24.04.2017.
 */
public final class Lion extends LandMammal {
    public Lion(String name) {
        super(name,"Löwe",false,false,true,2.6,false);
    }

    @Override
    public String toString() {
        return "Löwe{" +
                "name=" + getName() +
                "}";
    }
}
