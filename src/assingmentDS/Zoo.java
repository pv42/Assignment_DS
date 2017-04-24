package assingmentDS;

import assingmentDS.gehege.Gehege;
import assingmentDS.person.Personal;
import assingmentDS.tier.Tier;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Zoo implements NamedObject{
    private List<Gehege> geheges;
    private List<Personal> angestellte;
    private String name;

    public Zoo(String name) {
        this.name = name;
        geheges = new ArrayList<>();
        angestellte = new ArrayList<>();
    }

    public List<Gehege> getGeheges() {
        return new ArrayList<>(geheges);
    }
    public List<Personal> getAngestellte() {
        return new ArrayList<>(angestellte);

    }

    public void addGehege(Gehege gehege) {
        gehege.setZoo(this);
        geheges.add(gehege);
        Log.added("Gehege",gehege,this);
    }
    public void addAngestellter(Personal personal) {
        angestellte.add(personal);
        personal.setArbeitsplatz(this);
        Log.added("Personal",personal,this);
    }
    public List<Tier> getTiere() {
        ArrayList<Tier> tiere = new ArrayList<>();
        for(Gehege g:geheges) {
            for(Tier t:g.getTiere()) {
                tiere.add(t);
            }
        }
        return tiere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "geheges=" + geheges + ", " +
                "angestellte=" + angestellte +
                '}';
    }
}
