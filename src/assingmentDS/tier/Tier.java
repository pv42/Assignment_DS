package assingmentDS.tier;

import assingmentDS.gehege.Gehege;

/**
 * Created by pv42 on 24.04.2017.
 */
public abstract class Tier implements ITier{
    private Gehege gehege;
    private String name;

    public Tier(String name) {
        this.name = name;
    }

    public Gehege getGehege() {
        return gehege;
    }

    public void setGehege(Gehege gehege) {
        this.gehege = gehege;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "name='" + name + '\'' +
                '}';
    }
}
