package assingmentDS;

import assingmentDS.gehege.Gehege;
import assingmentDS.person.Personal;
import assingmentDS.tier.Tier;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Zoo {
    private List<Gehege> geheges;
    private List<Personal> angestellte;

    public Zoo() {
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
    }
    public void addAngestellter(Personal personal) {
        angestellte.add(personal);
        personal.setArbeitsplatz(this);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "geheges=" + geheges + ", " +
                "angestellte=" + angestellte +
                '}';
    }
}
