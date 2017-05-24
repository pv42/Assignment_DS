package assignmentDS.enclosure;

import assignmentDS.util.Log;
import assignmentDS.NamedObject;
import assignmentDS.Zoo;
import assignmentDS.animal.Animal;
import assignmentDS.util.MyBinTree;
import assignmentDS.util.MyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/***
 * Created on 24.04.2017.
 * Repräsentiert die Funktionalitäten aller Gehege
 */
public class Enclosure implements NamedObject {
    private Zoo owner;
    private Collection<Animal> animals;
    private String name;

    //erzeugt leeres Gehege mit Namen
    public Enclosure(String name,Zoo owner) {
        animals = new MyLinkedList<>();
        this.name = name;
        this.owner = owner;
        owner.addEnclosure(this);
    }

    // gibt dem Zoo, dem das Gehege zugeordnet ist zurück.
    public Zoo getOwner() {
        return owner;
    }

    // Ordnet dem Enclosure eine Zoo zu
    // sollte nur von der Zooklasse aus gerufen werden, wenn das enclosure einem Zoo zugeordnet wird
    public void setOwner(Zoo owner) {
        this.owner = owner;
    }

    // gibt eine Liste aller enthaltenen Tiere zurück
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    // fügt dem Gehege ein Tier hinzu, falls nötig entfernt es das Tier aus dem vorherigen Gehege
    // tötet Tiere, die nicht im Gegehe überleben können, gefressen werden, oder giftiges Fressen hatten
    public void addAnimal(Animal animal) {
        if(animal.getEnclosure() != null) animal.getEnclosure().removeTier(animal);
        animal.setEnclosure(this);
        Log.added(animal.getSpecies(),animal,this);
        if(Aquarium.class.isInstance(this) ^  animal.isLivingSubmerged())  {
            animal.kill("Unpassendes Gehege"); // lässt Leiche zurück
        }
        animals.add(animal);
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {// überprüft Raubtieraktivitäten zwischen neuem und alten Tieren
            Animal t = iterator.next();
            if(animals.contains(animal)) { // Tier könnte bereits gegessen worden sein
                performEating(animal,t); // wenn Tier t gegessen wird wird index verschoben
                performEating(t,animal); // Wenn Tier animal gegessen wird, wird dieser Code nicht mehr ausgeführt.
            }
        }
    }
    // setzt fressen, gefressen werden, Aas fressen, giftige Beute um
    private boolean performEating(Animal t1, Animal t2) {
        if(t1.isPredator() && t1.isAlive() && t1.getAvgSize() > t2.getAvgSize() && t2.isAlive() && (t1.mayFly() || !t2.mayFly())) { // predators kills the prey and eats it
            t2.kill("Raubtier");
            this.removeTier(t2);
            if(t2.getStuff() != null) t2.getStuff().removeAnimal(t2); // wenn Tier gefressen wird, muss sich niemand um es kümmern
            return true;
        }
        if(t1.isScavenger() && t1.isAlive() && !t2.isAlive()) { // Aasfresser
            if(t2.isPoisonous()) t1.kill("Gift in der Nahrung");
            this.removeTier(t2);
            if(t2.getStuff() != null) t2.getStuff().removeAnimal(t2); // wenn Tier gefressen wird, muss sich niemand um es kümmern
            return true;
        }
        return false;
    }
    // entfernt Animal aus Gehege, gibt bei erfolg wahr zurück
    public boolean removeTier(Animal animal) {
        boolean succses =  animals.remove(animal);
        Log.removed(animal.getSpecies(),animal,this,succses);
        animal.setEnclosure(null);
        return succses;
    }

    // gibt den Name des Geheges zuruck
    public String getName() {
        return name;
    }

    public Iterator<Animal> getAnimalIterator(){
        return animals.iterator();
    }

    @Override
    public String toString() {
        return "Enclosure{" +
                "name=" + name  + ", " +
                "animals=" + animals + ", " +
                "owner=" + owner.getName() +
                '}';
    }
}
