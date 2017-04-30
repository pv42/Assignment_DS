package assingmentDS.animal;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.enclosure.Enclosure;

/***
 * Created on 24.04.2017.
 * Implementiert Funktionalität aller Tiere
 */
public abstract class Animal implements IAnimal, NamedObject{
    private Enclosure enclosure;
    private String name;
    private String species; //todo species
    private boolean isAlive;
    //Arteigenschaften
    private boolean isPoisones;
    private boolean mayFly;
    private boolean isLivingSubmerged; // legt Überleben an Land/im Wasser fest
    private boolean isPredator;
    private double avgSize; // in Meter
    private boolean isScavenger;

    //Konstruktor
    Animal(String name, String species, boolean isPoisones, boolean mayFly, boolean isLivingSubmerged, boolean isPredator, double avgSize, boolean isScavenger) {
        this.name = name;
        this.species = species;
        this.isPoisones = isPoisones;
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

    public boolean isPoisones() {
        return isPoisones;
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
    public void setEnclosure(Enclosure enclosure) { // diese Funktion sollte nur aus der Klasse enclosure gerufen werden
        this.enclosure = enclosure;
    }

    // other methodes
    public void kill(String reason) {
        Log.write(getSpecies() + " " + getName() + " starb. Grund: " + reason);
        isAlive = false;
    }
}
