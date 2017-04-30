package assingmentDS.person;

import assingmentDS.Log;
import assingmentDS.Zoo;
import assingmentDS.animal.IAnimal;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by pv42 on 24.04.2017.
 */
public class Stuff extends Person {
    private Zoo arbeitsplatz;
    private List<IAnimal> animals;
    //todo use interface itier
    public Stuff(String name, int gender) {
        super(name, gender);
        animals = new ArrayList<>();
        Log.created("Stuff", this);
    }

    public Zoo getArbeitsplatz() {
        return arbeitsplatz;
    }

    public void setArbeitsplatz(Zoo arbeitsplatz) {
        this.arbeitsplatz = arbeitsplatz;
    }

    public void addAnimal(IAnimal animal) {
        animals.add(animal);
    }
}
