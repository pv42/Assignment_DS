package assingmentDS.person;

import assingmentDS.Log;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Visitor extends Person {

    public Visitor(String name, int gender) {
        super(name, gender);
        Log.created("Besucher", this);
    }

    @Override
    public String toString() {
        return "Besucher{" +
                "name='" + getName() + '\'' +
                ", enclosure=" + getEnclosure().getName() +
                '}';
    }
}
