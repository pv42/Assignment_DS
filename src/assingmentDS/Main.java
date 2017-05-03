package assingmentDS;

import assingmentDS.enclosure.Aquarium;
import assingmentDS.enclosure.LandMammalEnclosure;
import assingmentDS.enclosure.Aviary;
import assingmentDS.person.Visitor;
import assingmentDS.person.Stuff;
import assingmentDS.animal.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

import static assingmentDS.person.Gender.MALE;
import static assingmentDS.person.Gender.FEMALE;

/***
 * Created on 24.04.2017.
 * Hauptklasse, enthaelt den Startcode, Verarbeitung von Kommandozeilenargumenten
 * sowie das in der Aufgabenstellung geforderte Beispiel.
 */

public class Main {
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
        test();
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
        System.out.println("Zoo Version: 1.0");
    }

    // Aufgabenstellung
    private static void test() {
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
        for(int i = 1; i<=10;i++) {
            pufferFish = new PufferFish("Lenny" + i); //Alle Kugelfische heißen Lenny
            kugelfischtank.addAnimal(pufferFish);
        }
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
            else throw new ConcurrentModificationException(); //animal should not be any other
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
}
