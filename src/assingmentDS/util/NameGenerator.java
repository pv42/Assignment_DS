package assingmentDS.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by pv42 on 22.05.2017.
 * Generiert Namen für die Tiere
 */
public class NameGenerator {
    private static final String NAME_URL = "https://www.behindthename.com/random/random.php?number=2&gender=both&surname=&all=yes";
    private int lennyCount;
    private boolean tryOnline;
    private SynchronousQueue<String> nameCache = new SynchronousQueue<>();

    private int ordered = 0;

    public NameGenerator() {
        this.lennyCount = 0;
        this.tryOnline = true;
    }

    public String getNextName() {
        return getNextName(false);
    }

    public void cacheNames(int amount) {
        ordered += amount;
        NameDownloader[] nameDownloaders = new NameDownloader[amount];
        for (NameDownloader nameDownloader : nameDownloaders) {
            nameDownloader = new NameDownloader();
            nameDownloader.start();
        }
    }

    public String getNextName(boolean forceOffline) {
        if(!forceOffline && tryOnline) {
            if(ordered == 0) cacheNames(1);
            String name = null;
            do {
                name = nameCache.poll();
            } while (name == null && tryOnline);
            if (name != null) try {
                return URLDecoder.decode(name,"UTF-8");
            } catch (UnsupportedEncodingException ignored){} // UTF-8 sollte unterstützt werden
        }
        //Wenn der Netzwerkabruf fehlgeschlagen ist oder online deaktiviert ist werden Tiere Lenny 1, Lenny 2 usw. gennant
        lennyCount ++;
        return "Lenny " + lennyCount;
    }
    public void setTryOnline(boolean tryOnline) {
        this.tryOnline = tryOnline;
    }
    private class NameDownloader extends Thread {
        @Override
        public void run() {
            URL url = null;
            try {
                url = new URL(NAME_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String d;
                String data = "";
                while ((d = br.readLine()) != null) {
                    data += d;
                }
                String[] acenter = data.split("<center>")[1].split("<a class=\"plain");
                String firstName = acenter[1].split(">")[1].split("<")[0];
                String secondName = acenter[2].split(">")[1].split("<")[0];
                firstName = java.net.URLDecoder.decode(firstName,"utf-8");
                try {
                    nameCache.put(firstName + " " +secondName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ordered--;
            } catch (IOException e) {
                if (tryOnline) {
                    Log.networkError();
                    setTryOnline(false);
                }

            }

        }
    }
}
