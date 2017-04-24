package assingmentDS.person;

import assingmentDS.gehege.Gehege;

/**
 * Created by pv42 on 24.04.2017.
 */
public abstract class Personen {
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
}
