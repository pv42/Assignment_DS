package assingmentDS.person;

import assingmentDS.NamedObject;
import assingmentDS.gehege.Gehege;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Personen implements NamedObject {
    private String name;
    private Gehege gehege;
    public Personen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGehege(Gehege gehege) {
        this.gehege = gehege;
    }

    public Gehege getGehege() {
        return gehege;
    }

    @Override
    public String toString() {
        if(gehege != null) {
            return "Personen{" +
                    "name='" + name + '\'' +
                    ", gehege=" + gehege.getName() +
                    '}';
        } else {
            return "Personen{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
