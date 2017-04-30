package assingmentDS.enclosure;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.Zoo;
import assingmentDS.animal.Animal;

import java.util.ArrayList;
import java.util.List;

/***
 * Created on 24.04.2017.
 * Repräsentiert die Funktionalitäten aller Gehege
 */
public abstract class Enclosure implements NamedObject {
    private Zoo zoo;
    private List<Animal> animals;
    private String name;

    //erzeugt leeres Gehege mit Namen
    public Enclosure(String name,Zoo zoo) {
        animals = new ArrayList<>();
        this.name = name;
        this.zoo = zoo;
        zoo.addEnclosure(this);
    }

    // gibt dem Zoo, dem das Gehege zugeordnet ist zurück.
    public Zoo getZoo() {
        return zoo;
    }

    // Ordnet dem Enclosure eine Zoo zu
    // sollte nur von der Zooklasse aus gerufen werden, wenn das enclosure einem Zoo zugeordnet wird
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
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
        for (int i = 0; i < animals.size()- 1; i++) {// überprüft Raubtieraktivitäten zwischen neuem und alten Tieren
            Animal t = animals.get(i);
            if(animals.contains(animal)) { // may alreday been removed due to eating
                if(performEating(t,animal)) i--; //todo think about is this code safe ??
                if(performEating(animal,t)) i--;// if a animal got removed indexes are shifted
            }
        }
    }
    // setzt fressen, gefressen werden, Aas fressen, giftige Beute um
    private boolean performEating(Animal t1, Animal t2) {
        if(t1.isPredator() && t1.isAlive() && t1.getAvgSize() > t2.getAvgSize() && t2.isAlive() && (t1.mayFly() || !t2.mayFly())) { // predators kills the prey and eats it
            t2.kill("Raubtier");
            this.removeTier(t2);
            return true;
        }
        if(t1.isScavenger() && t1.isAlive() && !t2.isAlive()) { // scavenger eating carrion
            if(t2.isPoisonous()) t1.kill("Gift in der Nahrung");
            this.removeTier(t2);
            return true;
        }
        return false;
    }
    // entfernt Animal aus Gehege, gibt bei erfolg wahr zurück
    public boolean removeTier(Animal tier) {
        boolean succses =  animals.remove(tier);
        Log.removed(tier.getSpecies(),tier,this,succses);
        return succses;
    }

    // gibt den Name des Geheges zuruck
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Enclosure{" +
                "name=" + name  + ", " +
                "animals=" + animals +
                '}';
    }
}
