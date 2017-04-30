package assingmentDS.person;

import assingmentDS.Log;
import assingmentDS.Zoo;
import assingmentDS.animal.IAnimal;

import java.util.ArrayList;
import java.util.List;

/***
 * Created on 24.04.2017.
 */
public class Stuff extends Person {
    private Zoo workPlace;
    private List<IAnimal> animals;
    public Stuff(String name, int gender) {
        super(name, gender);
        animals = new ArrayList<>();
        Log.created("Stuff", this);
    }

    public Zoo getWorkplace() {
        return workPlace;
    }

    // sollte nur von Zoo.addStuff() gerufen werden
    public void setWorkplace(Zoo workplace) {
        this.workPlace = workplace;
    }

    public void addAnimal(IAnimal animal) {
        animals.add(animal);
        Log.animalsStuffSet(animal,this);
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "name=" + getName() +
                ", animals=" + animals +
                ", gender=" + getGender() +
                ", workPlace=" + workPlace.getName() +
                '}';
    }
}
