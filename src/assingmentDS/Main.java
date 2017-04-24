package assingmentDS;

import assingmentDS.gehege.Aquarium;
import assingmentDS.gehege.Landsäugetiergehege;
import assingmentDS.gehege.Vogelgehege;
import assingmentDS.person.Besucher;
import assingmentDS.person.Personal;
import assingmentDS.tier.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pv42 on 24.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        List<Besucher> besucher = new ArrayList<>();
        // 1.
        Aquarium wahlhaibecken = new Aquarium("Wahlhaibecken");Aquarium kugelfischtank = new Aquarium("Kugelfischtank");
        zoo.addGehege(wahlhaibecken);
        zoo.addGehege(kugelfischtank);
        Landsäugetiergehege landgehege1 = new Landsäugetiergehege("Landgehege1");
        Landsäugetiergehege landgehege2 = new Landsäugetiergehege("Landgehege2");
        Landsäugetiergehege landgehege3 = new Landsäugetiergehege("Landgehege3");
        Landsäugetiergehege landgehege4 = new Landsäugetiergehege("Landgehege4");
        zoo.addGehege(landgehege1);
        zoo.addGehege(landgehege2);
        zoo.addGehege(landgehege3);
        zoo.addGehege(landgehege4);
        Vogelgehege adlergehege = new Vogelgehege("Adlergehege");
        Vogelgehege papgeienGehege = new Vogelgehege("Papageiengehege");
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
        for(int i = 1; i<=10;i++) {
            Kugelfisch kugelfisch = new Kugelfisch("Lenny " + i);
            kugelfischtank.addTier(kugelfisch);
        }
        //6. Moby Dick
        Walhai moby = new Walhai("Moby");
        Walhai dick = new Walhai("Dick");
        wahlhaibecken.addTier(moby);
        wahlhaibecken.addTier(dick);
        //7.
        Adler american = new Adler("American");
        Adler dream = new Adler("Dream");
        adlergehege.addTier(american);
        adlergehege.addTier(dream);
        //8.
        Personal ramsay = new Personal("Ramsay");
        Personal sam = new Personal("Sam");
        Personal daenerys = new Personal("Daenerys");
        zoo.addAngestellter(ramsay);
        zoo.addAngestellter(sam);
        zoo.addAngestellter(daenerys);
        //TODO
        //9.
        Besucher catelyn = new Besucher("Catelyn");
        Besucher aerys = new Besucher("Aerys");
        Besucher bronn = new Besucher("Bronn");
        Besucher sansa = new Besucher("Sansa");
        Besucher willy = new Besucher("Willy");
        catelyn.setGehege(landgehege1);
        aerys.setGehege(adlergehege);
        bronn.setGehege(kugelfischtank);
        sansa.setGehege(wahlhaibecken);
        willy.setGehege(landgehege2);
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
        sansa.setGehege(landgehege1);
        //13.
        adlergehege.addTier(cersei);
        //out
        System.out.print(zoo);
        System.out.print(besucher);
    }
}
