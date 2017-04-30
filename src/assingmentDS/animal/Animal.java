package assingmentDS.animal;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Stuff;

/***
 * Created by pv42 on 24.04.2017.
 * Implementiert functionalität aller Tiere
 */
public abstract class Animal implements IAnimal, NamedObject{
    private Enclosure enclosure;
    private String name;
    private String art;
    private boolean isAlive;
    //Arteigenschaften
    private boolean isPoisones;
    private boolean mayFly;
    private boolean lebtUnterWasser; // if false dies in Aquaiums
    private boolean isPredator; // if true eats non  or smaller predators
    private double avgSize; // in m
    private boolean isstAas;

    public Animal(String name, String art, boolean istGiftig, boolean mayFly, boolean lebtUnterWasser, boolean isPredator, double avgSize, boolean isstAas) {
        this.name = name;
        this.art = art;
        this.isPoisones = istGiftig;
        this.mayFly = mayFly;
        this.lebtUnterWasser = lebtUnterWasser;
        this.isPredator = isPredator;
        this.avgSize = avgSize;
        this.isAlive = true;
        this.isstAas = isstAas;
        Log.created(art,this);
    }


    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    } //todo possibis data confict with Enclosure.java !!
    public String getName() {
        return name;
    }

    public String getArt() {
        return art;
    }

    public boolean isPoisones() {
        return isPoisones;
    }

    public boolean mayFly() {
        return mayFly;
    }

    public boolean isLebtUnterWasser() {
        return lebtUnterWasser;
    }

    public boolean isPredator() {
        return isPredator;
    }
    public boolean istIsstAas() {
        return isstAas;
    }
    public void kill(String reason) {
        Log.write(getArt() + " " + getName() + " starb. Grund: " + reason);
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getAvgSize() {
        return avgSize;
    }
}
