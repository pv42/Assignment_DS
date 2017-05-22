package assingmentDS.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pv42 on 22.05.2017.
 * Generiert Namen für die Tiere
 */
public class NameGenerator {
    private static String NAME_URL = "https://www.behindthename.com/random/random.php?number=2&gender=m&surname=&all=yes";
    public static String generateName() {
        try {
            URL url = new URL(NAME_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            int d;
            String data = "";
            while ((d = in.read())!= -1 ) {
                data += (char)d;
            }
            String firstName = data.split("<center>")[1].split("<a class \"plain")[1].split(">")[1].split("</a>")[0];
            Log.write(firstName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
