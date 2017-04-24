package assingmentDS;

/**
 * Created by pv42 on 24.04.2017.
 */
public class Log {
    public static void created(String type,NamedObject namedObject) {
        System.out.println(type + " " + namedObject .getName()+ " erstellt");
    }
    public static void added(String type,NamedObject sub, NamedObject sup) {
        System.out.println(type  + " " + sub.getName() + " zu " + sup.getName() + " hinzugefügt");
    }
    public static void removed(String type,NamedObject sub, NamedObject sup,boolean succses) {
        if(succses) System.out.println(type  + " " + sub.getName() + " von " + sup.getName() + " entfernt");
        else System.err.println(type  + " " + sub.getName() + " konnte nicht  von " + sup.getName() + " entfernt werden");
    }
    public static void watch(String type,NamedObject sub, NamedObject sup) {
        System.out.println(type + " " + sub.getName() + " besucht " + sup.getName());
    }
    public static void i(String s) {
        System.out.println(s);
    }
}
