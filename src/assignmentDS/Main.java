package assignmentDS;

import assignmentDS.enclosure.Aquarium;
import assignmentDS.enclosure.Enclosure;
import assignmentDS.enclosure.LandMammalEnclosure;
import assignmentDS.enclosure.Aviary;
import assignmentDS.person.Visitor;
import assignmentDS.person.Stuff;
import assignmentDS.animal.*;
import assignmentDS.util.Log;
import assignmentDS.util.MyBinTree;
import assignmentDS.util.NameGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static assignmentDS.person.Gender.MALE;
import static assignmentDS.person.Gender.FEMALE;

/**
 * Created on 24.04.2017.
 * Hauptklasse, enthaelt den Startcode, Verarbeitung von Kommandozeilenargumenten
 * sowie das in der Aufgabenstellung geforderte Beispiel.
 */

public class Main {
    private static final String VERSION = "1.0.1";
    // Startfunktion, behandelt Kommandozeilenargumente
    public static void main(String[] args) {
        if(args.length > 0) {
            if(Objects.equals(args[0], "-h")) {
                printHelp();
                return;
            } else if(Objects.equals(args[0], "-v")) {
                printVersion();
                return;
            } else if(Objects.equals(args[0], "-f")) {
                if( args.length < 2) {
                    printHelp();
                    return;
                } else {
                    Log.redirectToFile(args[1]);
                }
            } else {
                printHelp();
            }
        }
        //assignment1();
        assignment2();
        //nameGT();
        //treetest();
    }

    //zeigt Kommandozeilehilfe
    private static void printHelp() {
        System.out.print("Argumente:\n" +
                "   <keine Argument> führt Programm aus\n" +
                "   -h          zeigt diese Hilfe an\n" +
                "   -v          zeigt Versionsinformationen\n" +
                "   -f <datei>  leitet Ausgabe in Datei um und führt Programm aus\n");
    }

    //zeigt Version
    private static void printVersion() {
        System.out.println("Zoo Version: " + VERSION);
    }

    // Aufgabenstellung
    private static void assignment1() {
        Zoo zoo = new Zoo("Zoo");
        List<Visitor> visitors = new ArrayList<>();
        // 1.
        Aquarium wahlhaibecken = new Aquarium("Wahlhaibecken", zoo);
        Aquarium kugelfischtank = new Aquarium("Kugelfischtank", zoo);
        LandMammalEnclosure landgehege1 = new LandMammalEnclosure("Landgehege1", zoo);
        LandMammalEnclosure landgehege2 = new LandMammalEnclosure("Landgehege2", zoo);
        LandMammalEnclosure landgehege3 = new LandMammalEnclosure("Landgehege3", zoo);
        LandMammalEnclosure landgehege4 = new LandMammalEnclosure("Landgehege4", zoo);
        Aviary adlergehege = new Aviary("Adlergehege", zoo);
        Aviary papgeienGehege = new Aviary("Papageiengehege", zoo);
        zoo.addEnclosure(papgeienGehege);
        zoo.addEnclosure(adlergehege);
        //2. Tick Trick Track
        Papagei tick = new Papagei("Tick");
        Papagei trick = new Papagei("Trick");
        Papagei track = new Papagei("Track");
        papgeienGehege.addAnimal(tick);
        papgeienGehege.addAnimal(trick);
        papgeienGehege.addAnimal(track);
        //3.  Zalana, Eddard, Bran, Robb, Arya
        Zebra zalana = new Zebra("Zalana");
        Zebra eddard = new Zebra("Eddard");
        Zebra bran = new Zebra( "Bran");
        Zebra robb = new Zebra("Robb");
        Zebra arya = new Zebra("Arya");
        landgehege1.addAnimal(eddard);
        landgehege1.addAnimal(robb);
        landgehege2.addAnimal(bran);
        landgehege2.addAnimal(arya);
        landgehege2.addAnimal(zalana);
        //4.   Tywin, Jaime, Cersei, Joffrey
        Lion tywin = new Lion("Tywin");
        Lion jaime = new Lion("Jaime");
        Lion cersei = new Lion("Cersei");
        Lion joffrey = new Lion("Joffrey");
        landgehege3.addAnimal(tywin);
        landgehege3.addAnimal(cersei);
        landgehege3.addAnimal(joffrey);
        landgehege3.addAnimal(jaime);
        //5. Lenny
        PufferFish pufferFish;
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.cacheNames(10);
        for(int i = 1; i<=10;i++) {
            pufferFish = new PufferFish(nameGenerator.getNextName()); //Alle Kugelfische heißen Lenny wenn kein Internet da ist
            kugelfischtank.addAnimal(pufferFish);
        }
        nameGenerator.close();
        //6. Moby Dick
        WhaleShark moby = new WhaleShark("Moby");
        WhaleShark dick = new WhaleShark("Dick");
        wahlhaibecken.addAnimal(moby);
        wahlhaibecken.addAnimal(dick);
        //7. American Dream
        Eagle american = new Eagle("American");
        Eagle dream = new Eagle("Dream");
        adlergehege.addAnimal(american);
        adlergehege.addAnimal(dream);
        //8. Ramsay Sam Daenerys
        Stuff ramsay = new Stuff("Ramsay", MALE);
        Stuff sam = new Stuff("Sam", MALE);
        Stuff daenerys = new Stuff("Daenerys", FEMALE);
        zoo.addStuff(ramsay);
        zoo.addStuff(sam);
        zoo.addStuff(daenerys);
        for(Animal tier: zoo.getAnimals()) { // überprüft Tier auf Klasse und weisst entsprechend Personal zu
            if(LandMammal.class.isInstance(tier)) ramsay.addAnimal(tier);
            else if(WaterAnimal.class.isInstance(tier)) sam.addAnimal(tier);
            else if(Bird.class.isInstance(tier)) daenerys.addAnimal(tier);
        }
        //9.
        Visitor catelyn = new Visitor("Catelyn", FEMALE);
        Visitor aerys = new Visitor("Aerys", MALE);
        Visitor bronn = new Visitor("Bronn", MALE);
        Visitor sansa = new Visitor("Sansa", FEMALE);
        Visitor willy = new Visitor("Willy", MALE);
        catelyn.setEnclosure(landgehege1);
        aerys.setEnclosure(adlergehege);
        bronn.setEnclosure(kugelfischtank);
        sansa.setEnclosure(wahlhaibecken);
        willy.setEnclosure(landgehege2);
        visitors.add(catelyn);
        visitors.add(aerys);
        visitors.add(bronn);
        visitors.add(sansa);
        visitors.add(willy);
        //10.
        wahlhaibecken.addAnimal(joffrey);
        //11.
        landgehege1.addAnimal(tywin);
        //12.
        sansa.setEnclosure(landgehege1);
        //13.
        adlergehege.addAnimal(cersei);
        //out
        Log.write(zoo.toString());
        Log.write("Besucher" + visitors.toString());
    }
    private static void assignment2() {
        Zoo zoo = new Zoo("zoo");
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.cacheNames(237);
        Aviary vogelgehege1 = new Aviary("vogelgehege1", zoo);
        for(int i = 0; i<3; i++){
            Papagei papagei = new Papagei(nameGenerator.getNextName());
            vogelgehege1.addAnimal(papagei);
        }
        Aviary vogelgehege2 = new Aviary("Vogelgehege2", zoo);
        for(int i = 0; i<2; i++){
            Penguin penguin = new Penguin(nameGenerator.getNextName());
            vogelgehege2.addAnimal(penguin);
        }
        Enclosure wüste = new Enclosure("Wüste", zoo);
        for(int i = 0; i<17; i++){
            Scorpion scorpion = new Scorpion(nameGenerator.getNextName());
            wüste.addAnimal(scorpion);
        }
        Enclosure fluss = new Enclosure("Fluss", zoo);
        for(int i = 0; i<2; i++){
            Hippopotamus hippopotamus = new Hippopotamus(nameGenerator.getNextName());
            fluss.addAnimal(hippopotamus);
        }
        Crocodile crocodile = new Crocodile(nameGenerator.getNextName());
        fluss.addAnimal(crocodile);

        Enclosure erde = new Enclosure("Erde", zoo);
        for(int i = 0; i<212; i++) {
            MoleRat moleRat = new MoleRat(nameGenerator.getNextName());
            erde.addAnimal(moleRat);
        }
        Iterator<Enclosure> iterator = zoo.getEnclosureIterator();
        while (iterator.hasNext()) {
            Enclosure enclosure = iterator.next();
            System.out.println("Besucher besucht Gehege "+enclosure.getName()+".");
            System.out.print("Er sieht:");
            Iterator<Animal> animalIterator = enclosure.getAnimalIterator();
            while (animalIterator.hasNext()){
                Animal animal = animalIterator.next();
                System.out.print(animal.getSpecies() + " " + animal.getName() +", ");
            }
        }
    }

    //Test für den Namegenerator
    private static void nameGT() {

        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.cacheNames(500);
        for(int i = 0; i< 500; i++) {
            Log.write(nameGenerator.getNextName());
        }
        Log.write("----------------------------------------------------");
        for(int i = 0; i< 1; i++) {
            //Log.write(nameGenerator.getNextName());
        }
        nameGenerator.close();
    }
    private static void treetest() {
        MyBinTree<String> tree = new MyBinTree<>();
        NameGenerator nameGenerator = new NameGenerator();
        for(int i = 0; i<= 14; i++) {
            tree.insert(nameGenerator.getNextName());
        }
        Log.write(tree.toString());
        Iterator<String> iterator = tree.iterator();
        while (iterator.hasNext()) {
            Log.write(iterator.next());
        }
        nameGenerator.close();
    }
}
