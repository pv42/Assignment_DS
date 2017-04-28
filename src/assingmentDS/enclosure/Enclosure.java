package assingmentDS.enclosure;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.Zoo;
import assingmentDS.animal.Animal;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 * Repräsentiert die Funktionalitäten aller Gehege
 */
public abstract class Enclosure implements NamedObject {
    private Zoo zoo;
    private List<Animal> tiere;
    private String name;

    //erzeugt leeres Gehege mit Namen
    public Enclosure(String name) {
        tiere = new ArrayList<>();
        this.name = name;
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

    // gibt eine Liste aller enthaltenen Animal zurück
    public List<Animal> getTiere() {
        return tiere;
    }

    // fügt dem Gehege ein Animal hinzu, falls nötig entfernt es das Animal aus dem vorherigen Gehege
    // tötet Tiere, die nicht im Gegehe überleben können, gefressen werden, oder giftiges Fressen hatten
    public void addTier(Animal tier) {
        if(tier.getEnclosure() != null) tier.getEnclosure().removeTier(tier);
        tier.setEnclosure(this);
        Log.added(tier.getArt(),tier,this);
        if(Aquarium.class.isInstance(this) ^  tier.isLebtUnterWasser())  {
            tier.kill("Unpassendes Enclosure"); // lässt Leiche zurück
        }
        tiere.add(tier);
        for (int i = 0 ; i < tiere.size()- 1; i++) {// überprüft Raubtieraktivitäten zwischen neuem und alten Tieren
            Animal t = tiere.get(i);
            if(tiere.contains(tier)) { // may alreday been removed due to eating
                if(performEating(t,tier)) i--; //todo think about is this code safe ??
                if(performEating(tier,t)) i--;// if a animal got removed indexes are shifted
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
        if(t1.istIsstAas() && t1.isAlive() && !t2.isAlive()) { // scavenger eating carrion
            if(t2.istGiftig()) t1.kill("Gift in der Nahrung");
            this.removeTier(t2);
            return true;
        }
        return false;
    }
    // entfernt Animal aus Gehege, gibt bei erfolg wahr zurück
    public boolean removeTier(Animal tier) {
        boolean succses =  tiere.remove(tier);
        Log.removed(tier.getArt(),tier,this,succses);
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
                "tiere=" + tiere +
                '}';
    }
}
