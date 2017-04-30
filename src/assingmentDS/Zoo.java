package assingmentDS;

import assingmentDS.animal.Animal;
import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Stuff;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Zoo implements NamedObject{
    private List<Enclosure> enclosures;
    private List<Stuff> angestellte;
    private String name;

    public Zoo(String name) {
        this.name = name;
        enclosures = new ArrayList<>();
        angestellte = new ArrayList<>();
    }

    public List<Enclosure> getEnclosures() {
        return new ArrayList<>(enclosures);
    }
    public List<Stuff> getAngestellte() {
        return new ArrayList<>(angestellte);

    }

    public void addGehege(Enclosure enclosure) {
        enclosure.setZoo(this);
        enclosures.add(enclosure);
        Log.added("Gehege", enclosure,this);
    }
    public void addStuff(Stuff stuff) {
        angestellte.add(stuff);
        stuff.setArbeitsplatz(this);
        Log.added("Angestellter", stuff,this);
    }
    public List<Animal> getTiere() {
        ArrayList<Animal> tiere = new ArrayList<>();
        for(Enclosure g: enclosures) {
            tiere.addAll(g.getAnimals());
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
