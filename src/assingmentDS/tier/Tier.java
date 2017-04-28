package assingmentDS.tier;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.enclosure.Enclosure;
import assingmentDS.person.Personal;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Tier implements ITier, NamedObject{
    private Enclosure enclosure;
    private String name;
    private Personal personal;
    private String art;
    private boolean isAlive;
    //Arteigenschaften
    private boolean istGiftig;
    private boolean kannFliegen;
    private boolean lebtUnterWasser; // if false dies in Aquaiums
    private boolean istRaubtier; // if true eats non  or smaller predators
    private double durchschnittlicheSize; // in m



    private boolean isstAas;

    public Tier(String name, String art, boolean istGiftig, boolean kannFliegen, boolean lebtUnterWasser, boolean istRaubtier, double durchschnittlicheSize, boolean isstAas) {
        this.name = name;
        this.art = art;
        this.istGiftig = istGiftig;
        this.kannFliegen = kannFliegen;
        this.lebtUnterWasser = lebtUnterWasser;
        this.istRaubtier = istRaubtier;
        this.durchschnittlicheSize = durchschnittlicheSize;
        this.isAlive = true;
        this.isstAas = isstAas;
        Log.created(art,this);
    }


    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    } //todo possibis data confict with Enclosure.java
    public String getName() {
        return name;
    }
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public String getArt() {
        return art;
    }

    public boolean istGiftig() {
        return istGiftig;
    }

    public boolean kannFliegen() {
        return kannFliegen;
    }

    public boolean isLebtUnterWasser() {
        return lebtUnterWasser;
    }

    public boolean istRaubtier() {
        return istRaubtier;
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

    public double getDurchschnittlicheSize() {
        return durchschnittlicheSize;
    }
}
