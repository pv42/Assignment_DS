package assingmentDS.gehege;

import assingmentDS.Log;
import assingmentDS.NamedObject;
import assingmentDS.Zoo;
import assingmentDS.tier.Tier;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public abstract class Gehege implements NamedObject {
    private Zoo zoo;
    private List<Tier> tiere;
    private String name;


    public Gehege(String name) {
        tiere = new ArrayList<>();
        this.name = name;
    }
    public Zoo getZoo() {
        return zoo;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public List<Tier> getTiere() {
        return tiere;
    }
    public void addTier(Tier tier) {
        if(tier.getGehege() != null) tier.getGehege().removeTier(tier); // if animal is already in other enclosure remove it
        tier.setGehege(this);
        Log.added(tier.getArt(),tier,this);
        if(Aquarium.class.isInstance(this) ^  tier.isLebtUnterWasser())  { //check if fish out of water or not fish in water and probably kill it
            tier.kill("Unpassendes Gehege"); // leaves corpses

        }
        tiere.add(tier);
        for (int i = 0 ; i < tiere.size()- 1; i++) {//check for predator activities
            Tier t = tiere.get(i);
            if(tiere.contains(tier)) { // may alreday been removed due to eating
                if(performEating(t,tier)) i--; //todo think about is this code safe ??
                if(performEating(tier,t)) i--;// if a animal got removed indexes are shifted
            }
        }
    }
    private boolean performEating(Tier t1, Tier t2) {
        if(t1.istRaubtier() && t1.isAlive() && t1.getDurchschnittlicheSize() > t2.getDurchschnittlicheSize() && t2.isAlive() && (t1.kannFliegen() || !t2.kannFliegen())) { // predators kills the prey and eats it
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
    public boolean removeTier(Tier tier) {
        boolean succses =  tiere.remove(tier);
        Log.removed(tier.getArt(),tier,this,succses);
        return succses;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gehege{" +
                "name=" + name  + ", " +
                "tiere=" + tiere +
                '}';
    }
}
