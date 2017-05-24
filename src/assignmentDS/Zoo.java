package assignmentDS;

import assignmentDS.animal.Animal;
import assignmentDS.enclosure.Enclosure;
import assignmentDS.person.Stuff;
import assignmentDS.util.Log;
import assignmentDS.util.MyBinTree;
import assignmentDS.util.MyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/***
 * Created on 24.04.2017.
 */
public class Zoo implements NamedObject{
    private Collection<Enclosure> enclosures;
    private List<Stuff> stuffList;
    private String name;

    public Zoo(String name) {
        this.name = name;
        enclosures = new MyBinTree<>();
        stuffList = new ArrayList<>();
        Log.created("Zoo", this);
    }

    public List<Enclosure> getEnclosures() {
        return new ArrayList<>(enclosures);
    }
    public List<Stuff> getStuffList() {
        return new ArrayList<>(stuffList);

    }

    //ordnet gehege dem Zoo zu, sollte nicht Außerhalb des Gehehekonstuktors gerufen werden
    public void addEnclosure(Enclosure enclosure) {
        enclosure.setOwner(this);
        enclosures.add(enclosure);
        Log.added("Gehege", enclosure,this);
    }

    // fügt Angestellte hinzu
    public void addStuff(Stuff stuff) {
        stuffList.add(stuff);
        stuff.setWorkplace(this);
        Log.added("Angestellter", stuff,this);
    }

    // gibt die Tiere aller Gehege zurück
    public List<Animal> getAnimals() {
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

    public Iterator<Enclosure> getEnclosureIterator(){
        return enclosures.iterator();
    }
    @Override
    public String toString() {
        return "Zoo{" +
                "enclosures=" + enclosures + ", " +
                "stuffList=" + stuffList +
                '}';
    }
}
