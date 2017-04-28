package assingmentDS;

import assingmentDS.enclosure.Aquarium;
import assingmentDS.enclosure.LandMammalEnclosure;
import assingmentDS.enclosure.Aviary;
import assingmentDS.person.Besucher;
import assingmentDS.person.Personal;
import assingmentDS.tier.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by pv42 on 24.04.2017.
 * Hauptklasse, enthaelt den Startcode, Verarbeitung von Kommandozeilenargumenten
 * sowie das in der Aufgabenstellung geforderte Beispiel.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        if(args.length > 0) {
            if(Objects.equals(args[0], "-h")) {
                printHelp();
                return;
            } else if(Objects.equals(args[1], "-v")) {
                printVersion();
                return;
            } else if(Objects.equals(args[1], "-f")) {
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
    private static void printHelp() {
        System.out.print("Argumente:\n" +
                "   <keine Argument> führt Programm aus\n" +
                "   -h          zeigt dies Hilfe\n" +
                "   -v          zeigt Versionsinformationen\n" +
                "   -f <datei>  leitet Ausgabe in Datei um\n");
    }
    private static void printVersion() {
        System.out.println("Zoo Version: 1.0");
    }
    private static void test() {
        Zoo zoo = new Zoo("Zoo");
        List<Besucher> besucher = new ArrayList<>();
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
        papgeienGehege.addTier(tick);
        papgeienGehege.addTier(trick);
        papgeienGehege.addTier(track);
        //3.  Zalana, Eddard, Bran, Robb, Arya
        Zebra zalana = new Zebra("Zalana");
        Zebra eddard = new Zebra("Eddard");
        Zebra bran = new Zebra( "Bran");
        Zebra robb = new Zebra("Robb");
        Zebra arya = new Zebra("arya");
        landgehege1.addTier(eddard);
        landgehege1.addTier(robb);
        landgehege2.addTier(bran);
        landgehege2.addTier(arya);
        landgehege2.addTier(zalana);
        //4.   Tywin, Jaime, Cersei, Joffrey
        Löwe tywin = new Löwe("Tywin");
        Löwe jaime = new Löwe("Jaime");
        Löwe cersei = new Löwe("Cersei");
        Löwe joffrey = new Löwe("Joffrey");
        landgehege3.addTier(tywin);
        landgehege3.addTier(cersei);
        landgehege3.addTier(joffrey);
        landgehege3.addTier(jaime);
        //5. Lenny
        Kugelfisch kugelfisch;
        for(int i = 1; i<=10;i++) {
            kugelfisch = new Kugelfisch("Lenny" + i);
            kugelfischtank.addTier(kugelfisch);
        }
        //6. Moby Dick
        Walhai moby = new Walhai("Moby");
        Walhai dick = new Walhai("Dick");
        wahlhaibecken.addTier(moby);
        wahlhaibecken.addTier(dick);
        //7. American Dream
        Adler american = new Adler("American");
        Adler dream = new Adler("Dream");
        adlergehege.addTier(american);
        adlergehege.addTier(dream);
        //8. Ramsay Sam Daenerys
        Personal ramsay = new Personal("Ramsay");
        Personal sam = new Personal("Sam");
        Personal daenerys = new Personal("Daenerys");
        zoo.addAngestellter(ramsay);
        zoo.addAngestellter(sam);
        zoo.addAngestellter(daenerys);
        for(Tier tier:zoo.getTiere()) { // checks if the animnal is land, water or air and asign personal
            if(Landsäugetier.class.isInstance(tier)) tier.setPersonal(sam);
            else if(Wassertier.class.isInstance(tier)) tier.setPersonal(sam);
            else if(Vogel.class.isInstance(tier)) tier.setPersonal(sam);
            else System.err.print("Error"); //todo remove!
        }
        //TODO
        //9.
        Besucher catelyn = new Besucher("Catelyn");
        Besucher aerys = new Besucher("Aerys");
        Besucher bronn = new Besucher("Bronn");
        Besucher sansa = new Besucher("Sansa");
        Besucher willy = new Besucher("Willy");
        catelyn.setEnclosure(landgehege1);
        aerys.setEnclosure(adlergehege);
        bronn.setEnclosure(kugelfischtank);
        sansa.setEnclosure(wahlhaibecken);
        willy.setEnclosure(landgehege2);
        besucher.add(catelyn);
        besucher.add(aerys);
        besucher.add(bronn);
        besucher.add(sansa);
        besucher.add(willy);
        //10.
        wahlhaibecken.addTier(joffrey);
        //11.
        landgehege1.addTier(tywin);
        //12.
        sansa.setEnclosure(landgehege1);
        //13.
        adlergehege.addTier(cersei);
        //crazy stuff
        //adlergehege.addTier(kugelfisch);
        //out
        System.out.println(zoo);
        System.out.println(besucher);
    }
}
