package assingmentDS.person;

import assingmentDS.util.Log;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Visitor extends Person {

    public Visitor(String name, Gender gender) {
        super(name, gender);
        Log.created("Besucher", this);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", gender=" + getGender() +
                ", enclosure=" + getEnclosure().getName() +
                '}';
    }
}
