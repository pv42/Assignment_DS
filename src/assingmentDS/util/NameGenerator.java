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
            int data;
            String side = "";
            while ((data = in.read())!= -1 ) {
                side += (char)data;
            }
            Log.write(side);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
