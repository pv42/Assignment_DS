package assingmentDS.animal;

/**
 * Created by pv42 on 24.04.2017.
 * Ein Adler
 */
public final class Eagle extends Bird {
    public Eagle(String name) {
        super(name,"Adler",false,true,true,1,true);
    } //

    @Override
    public String toString() {
        return "Adler{" +
                "name=" + getName() +
                "}";
    }
}
