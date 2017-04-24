package assingmentDS;

import assingmentDS.gehege.Aquarium;
import assingmentDS.gehege.Landsäugetiergehege;
import assingmentDS.gehege.Vogelgehege;
import assingmentDS.tier.*;

/**
 * Created by pv42 on 24.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        // 1.
        Aquarium wahlhaibecken = new Aquarium("Wahlhaibecken");Aquarium kugelfischtank = new Aquarium("Kugelfischtank");
        zoo.addGehege(wahlhaibecken);
        zoo.addGehege(kugelfischtank);
        Landsäugetiergehege landsäugetiergehege1 = new Landsäugetiergehege("Landsäugetiergehege1");
        Landsäugetiergehege landsäugetiergehege2 = new Landsäugetiergehege("Landsäugetiergehege2");
        Landsäugetiergehege landsäugetiergehege3 = new Landsäugetiergehege("Landsäugetiergehege3");
        Landsäugetiergehege landsäugetiergehege4 = new Landsäugetiergehege("Landsäugetiergehege4");
        zoo.addGehege(landsäugetiergehege1);
        zoo.addGehege(landsäugetiergehege2);
        zoo.addGehege(landsäugetiergehege3);
        zoo.addGehege(landsäugetiergehege4);
        Vogelgehege adlerGehege = new Vogelgehege("Adlergehege");
        Vogelgehege papgeienGehege = new Vogelgehege("Papageiengehege");
        zoo.addGehege(papgeienGehege);
        zoo.addGehege(adlerGehege);
        //2. Tick Trick Track
        Papagei tick = new Papagei("Tick");
        Papagei trick = new Papagei("Trick");
        Papagei track = new Papagei("Track");
        papgeienGehege.addTier(tick);
        papgeienGehege.addTier(trick);
        papgeienGehege.addTier(track);
        //3.  Zalana, Eddard, Bran, Robb, Arya
        Zebra zalana = new Zebra("Zalana");
        Zebra eddaed = new Zebra("Eddaed");
        Zebra bran = new Zebra( "Bran");
        Zebra robb = new Zebra("Robb");
        Zebra arya = new Zebra("arya");
        landsäugetiergehege1.addTier(eddaed);
        landsäugetiergehege1.addTier(robb);
        landsäugetiergehege2.addTier(bran);
        landsäugetiergehege2.addTier(arya);
        landsäugetiergehege2.addTier(zalana);
        //4.   Tywin, Jaime, Cersei, Joffrey
        Löwe tywin = new Löwe("Tywin");
        Löwe jaime = new Löwe("Jaime");
        Löwe cersei = new Löwe("Cersei");
        Löwe joffrey = new Löwe("Joffrey");
        landsäugetiergehege3.addTier(tywin);
        landsäugetiergehege3.addTier(cersei);
        landsäugetiergehege3.addTier(joffrey);
        landsäugetiergehege3.addTier(jaime);
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
        //
        System.out.print(zoo);
    }
}
