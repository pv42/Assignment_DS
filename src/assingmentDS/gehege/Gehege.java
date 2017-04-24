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
        if(tier.getGehege() != null) tier.getGehege().removeTier(tier);
        tier.setGehege(this);
        tiere.add(tier);
        Log.added(tier.getArt(),tier,this);
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
