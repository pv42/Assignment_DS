package assignmentDS.animal;

import assignmentDS.util.Log;
import assignmentDS.NamedObject;
import assignmentDS.enclosure.Enclosure;
import assignmentDS.person.Stuff;

/***
 * Created on 24.04.2017.
 * Implementiert Funktionalität aller Tiere
 */
public abstract class Animal implements IAnimal, NamedObject{
    private Enclosure enclosure;
    private String name;
    private String species;
    private boolean isAlive;
    private Stuff stuff;
    //Arteigenschaften
    private boolean isPoisonous;
    private boolean mayFly;
    private boolean isLivingSubmerged; // legt Überleben an Land/im Wasser fest
    private boolean isPredator;
    private double avgSize; // in Meter
    private boolean isScavenger;

    //Konstruktor
    Animal(String name, String species, boolean isPoisonous, boolean mayFly, boolean isLivingSubmerged, boolean isPredator, double avgSize, boolean isScavenger) {
        this.name = name;
        this.species = species;
        this.isPoisonous = isPoisonous;
        this.mayFly = mayFly;
        this.isLivingSubmerged = isLivingSubmerged;
        this.isPredator = isPredator;
        this.avgSize = avgSize;
        this.isAlive = true;
        this.isScavenger = isScavenger;
        Log.created(species,this);
    }

    //getters

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public boolean mayFly() {
        return mayFly;
    }

    public boolean isLivingSubmerged() {
        return isLivingSubmerged;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public double getAvgSize() {
        return avgSize;
    }

    public boolean isScavenger() {
        return isScavenger;
    }


    //setters

    // sollte nur aus der Klasse Stuff gerufen werden
    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    // diese Funktion sollte nur aus der Klasse Enclosure gerufen werden
    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    // other methods

    public void kill(String reason) {
        isAlive = false;
        Log.died(getSpecies(), this, reason);
    }

    @Override
    public String toString() {
        String enclosureName;
        if(enclosure == null) enclosureName = "-";
        else enclosureName = enclosure.getName();
        return species + "{" +
                "enclosure=" + enclosureName +
                ", name='" + name + '\'' +
                ", isAlive=" + isAlive +
                ", isPoisonous=" + isPoisonous +
                ", mayFly=" + mayFly +
                ", isLivingSubmerged=" + isLivingSubmerged +
                ", isPredator=" + isPredator +
                ", avgSize=" + avgSize +
                ", isScavenger=" + isScavenger +
                '}';
    }
}
