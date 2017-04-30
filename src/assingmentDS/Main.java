package assingmentDS;

import assingmentDS.enclosure.Aquarium;
import assingmentDS.enclosure.LandMammalEnclosure;
import assingmentDS.enclosure.Aviary;
import assingmentDS.person.Visiter;
import assingmentDS.person.Stuff;
import assingmentDS.animal.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

import static assingmentDS.person.Person.GENDER_MALE;
import static assingmentDS.person.Person.GENDER_FEMALE;

/**
 * Created on 24.04.2017.
 * Hauptklasse, enthaelt den Startcode, Verarbeitung von Kommandozeilenargumenten
 * sowie das in der Aufgabenstellung geforderte Beispiel.
 */

public class Main {
    // Startfunktion, behandelt Kommandozeilenargumente
    public static void main(String[] args) {
        System.out.println(args.length);
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
        List<Visiter> visiter = new ArrayList<>();
        // 1.
        Aquarium wahlhaibecken = new Aquarium("Wahlhaibecken");
        Aquarium kugelfischtank = new Aquarium("Kugelfischtank");
        zoo.addGehege(wahlhaibecken);
        zoo.addGehege(kugelfischtank);
        LandMammalEnclosure landgehege1 = new LandMammalEnclosure("Landgehege1");
        LandMammalEnclosure landgehege2 = new LandMammalEnclosure("Landgehege2");
        LandMammalEnclosure landgehege3 = new LandMammalEnclosure("Landgehege3");
        LandMammalEnclosure landgehege4 = new LandMammalEnclosure("Landgehege4");
        zoo.addGehege(landgehege1);
        zoo.addGehege(landgehege2);
        zoo.addGehege(landgehege3);
        zoo.addGehege(landgehege4);
        Aviary adlergehege = new Aviary("Adlergehege");
        Aviary papgeienGehege = new Aviary("Papageiengehege");
        zoo.addGehege(papgeienGehege);
        zoo.addGehege(adlergehege);
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
        Zebra arya = new Zebra("arya");
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
        Kugelfisch kugelfisch;
        for(int i = 1; i<=10;i++) {
            kugelfisch = new Kugelfisch("Lenny" + i); //Alle Kugelfische heißen Lenny #trueStory // TODO remove
            kugelfischtank.addAnimal(kugelfisch);
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
        Stuff ramsay = new Stuff("Ramsay", GENDER_MALE);
        Stuff sam = new Stuff("Sam", GENDER_MALE);
        Stuff daenerys = new Stuff("Daenerys", GENDER_FEMALE);
        zoo.addStuff(ramsay);
        zoo.addStuff(sam);
        zoo.addStuff(daenerys);
        for(Animal tier:zoo.getTiere()) { // überprüft Tier auf Klasse und weisst entsprechend Personal zu
            if(LandMammal.class.isInstance(tier)) ramsay.addAnimal(tier);
            else if(WaterAnimal.class.isInstance(tier)) sam.addAnimal(tier);
            else if(Bird.class.isInstance(tier)) daenerys.addAnimal(tier);
            else throw new ConcurrentModificationException(); //animal should not be any other
        }
        //TODO
        //9.
        Visiter catelyn = new Visiter("Catelyn", GENDER_FEMALE);
        Visiter aerys = new Visiter("Aerys", GENDER_MALE);
        Visiter bronn = new Visiter("Bronn", GENDER_MALE);
        Visiter sansa = new Visiter("Sansa", GENDER_FEMALE);
        Visiter willy = new Visiter("Willy", GENDER_MALE);
        catelyn.setEnclosure(landgehege1);
        aerys.setEnclosure(adlergehege);
        bronn.setEnclosure(kugelfischtank);
        sansa.setEnclosure(wahlhaibecken);
        willy.setEnclosure(landgehege2);
        visiter.add(catelyn);
        visiter.add(aerys);
        visiter.add(bronn);
        visiter.add(sansa);
        visiter.add(willy);
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
        Log.write(visiter.toString());
    }
}
