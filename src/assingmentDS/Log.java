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
    public static void i(String s) {
        System.out.println(s);
    }
}
