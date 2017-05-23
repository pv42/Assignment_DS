package assignmentDS.util;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by pv42 on 22.05.2017.
 * Generiert Namen für die Tiere
 */
public class NameGenerator implements Closeable {
    private static final String NAME_URL = "https://www.behindthename.com/random/random.php?number=1&gender=both&surname=&all=no&usage_eng=1&usage_ger=1&usage_fntsy=1";
    private static final int MAX_RUNNING = 5;
    private int lennyCount;
    private boolean tryOnline;
    private SynchronousQueue<String> nameCache = new SynchronousQueue<>();
    private List<NameDownloader> threads = new ArrayList<>();
    private int ordered = 0;
    private int running = 0;

    public NameGenerator() {
        this.lennyCount = 0;
        this.tryOnline = true;
    }

    public String getNextName() {
        return getNextName(false);
    }

    public void cacheNames(int amount) { //läd Namen in die Cache, jedoch nur über Netzwerk
        if (amount < 0) throw new IllegalArgumentException("At least 0 expected");
        NameDownloader[] nameDownloaders = new NameDownloader[amount];
        for (NameDownloader nameDownloader : nameDownloaders) {
            nameDownloader = new NameDownloader();
            ordered++;
            nameDownloader.start();
        }
    }

    public String getNextName(boolean forceOffline) { //
        if (!forceOffline && tryOnline) {
            if (ordered == 0) cacheNames(1);
            String name = null;
            do {
                name = nameCache.poll();
            } while (name == null && tryOnline);
            if (name != null) {
                return name;
            }
        }
        //Wenn der Netzwerkabruf fehlgeschlagen ist oder online deaktiviert ist werden Tiere Lenny 1, Lenny 2 usw. gennant
        lennyCount++;
        return "Lenny " + lennyCount;
    }

    public void setTryOnline(boolean tryOnline) {
        this.tryOnline = tryOnline;
    }

    private static String decode(String string) {
        return HTMLDecoder.unescapeHtml(string);
    }

    private class NameDownloader extends Thread {
        private boolean stop;

        NameDownloader() {
            threads.add(this);
        }

        public void terminate() {
            stop = true;
        }

        @Override
        public void run() {
            try {
                while (running >= MAX_RUNNING) try {
                    sleep(10);
                } catch (InterruptedException ignored) {
                }
                if (stop) return;
                running++;
                URL url;
                url = new URL(NAME_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String d;
                String data = "";
                while ((d = br.readLine()) != null && !stop) {
                    data += d;
                }
                if (stop) return;
                String[] acenter = data.split("<center>")[1].split("<a class=\"plain");
                String firstName;
                try{
                    firstName = decode(acenter[1].split(">")[1].split("<")[0]);
                }catch(ArrayIndexOutOfBoundsException e){
                    firstName = getNextName(true);
                }
                try {
                    if (stop) return;
                    nameCache.put(firstName);
                } catch (InterruptedException ignored) {
                }
                running--;
                ordered--;
            } catch (IOException e) {
                if (tryOnline) {
                    Log.networkError();
                    setTryOnline(false);
                }

            }

        }
    }

    public void close() {
        int closed = 0;
        for (NameDownloader t : threads) {
            if (t.isAlive()) t.terminate();
        }
        for (NameDownloader t : threads) {
            try {
                if (t.isAlive()) {
                    t.interrupt();
                    t.join();
                    closed++;
                    System.out.println(closed);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
