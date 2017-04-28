package assingmentDS;

import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Personal;
import assingmentDS.tier.Tier;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Zoo implements NamedObject{
    private List<Enclosure> enclosures;
    private List<Personal> angestellte;
    private String name;

    public Zoo(String name) {
        this.name = name;
        enclosures = new ArrayList<>();
        angestellte = new ArrayList<>();
    }

    public List<Enclosure> getEnclosures() {
        return new ArrayList<>(enclosures);
    }
    public List<Personal> getAngestellte() {
        return new ArrayList<>(angestellte);

    }

    public void addGehege(Enclosure enclosure) {
        enclosure.setZoo(this);
        enclosures.add(enclosure);
        Log.added("Enclosure", enclosure,this);
    }
    public void addAngestellter(Personal personal) {
        angestellte.add(personal);
        personal.setArbeitsplatz(this);
        Log.added("Personal",personal,this);
    }
    public List<Tier> getTiere() {
        ArrayList<Tier> tiere = new ArrayList<>();
        for(Enclosure g: enclosures) {
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
                "enclosures=" + enclosures + ", " +
                "angestellte=" + angestellte +
                '}';
    }
}
