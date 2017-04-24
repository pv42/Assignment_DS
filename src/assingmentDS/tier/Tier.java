package assingmentDS.tier;

import assingmentDS.gehege.Gehege;
import assingmentDS.person.Personal;

/**
 * Created by pv42 on 24.04.2017.
 */
public abstract class Tier implements ITier{
    private Gehege gehege;
    private String name;
    private Personal personal;

    public Tier(String name) {
        this.name = name;
    }

    public Gehege getGehege() {
        return gehege;
    }

    public void setGehege(Gehege gehege) {
        this.gehege = gehege;
    } //possibis data confict with Gehege.java
    public String getName() {
        return name;
    }
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Personal getPersonal() {
        return personal;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "name='" + name + '\'' +
                '}';
    }
}
