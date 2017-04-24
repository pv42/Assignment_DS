package assingmentDS.tier;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.gehege.Gehege;
import assingmentDS.person.Personal;

/**
 * Created by pv42 on 24.04.2017.
 */
public abstract class Tier implements ITier, NamedObject{
    private Gehege gehege;
    private String name;
    private Personal personal;
    private String art;

    public Tier(String name,String art) {
        this.name = name;
        this.art = art;
        Log.created(art,this);
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

    public String getArt() {
        return art;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "name='" + name + '\'' +
                '}';
    }
}
