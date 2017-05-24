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
    private boolean isActive = true;
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

    // gibt einen neuen Namen zuruck
    public String getNextName() {
        if(!isActive) throw new IllegalStateException("NameGenerator is closed");
        return getNextName(false);
    }

    // 'bestellt' Name im vorraus, um die Zugriffszeit mit getNextName zu senken
    public void cacheNames(int amount) {
        if(!isActive) throw new IllegalStateException("NameGenerator is closed");
        if (amount < 0) throw new IllegalArgumentException("At least 0 expected");
        for (int i = 0; i < amount; i++) {
            NameDownloader nameDownloader = new NameDownloader();
            ordered++;
            nameDownloader.start();
        }
    }

    //gibt einen neuen Namen zurück, ermöglicht die erzwungenen Offlineenerierung
    public String getNextName(boolean forceOffline) {
        if(!isActive) throw new IllegalStateException("NameGenerator is closed");
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

    //stellt den Namegenerator auf off-/online
    public void setTryOnline(boolean tryOnline) {
        if(!isActive) throw new IllegalStateException("NameGenerator is closed");
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

        void terminate() {
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
                StringBuilder data = new StringBuilder();
                while ((d = br.readLine()) != null && !stop) {
                    data.append(d);
                }
                conn.disconnect();
                if (stop) return;
                String[] acenter = data.toString().split("<center>")[1].split("<a class=\"plain");
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
                    running--;
                    ordered--;
                }

            }

        }
    }

    //Methode beendet den Namegenerator, trennt Netzwerkverbindungen und bricht alle 'Namenbestellungen' ab.
    public void close() {
        if(!isActive) throw new IllegalStateException("NameGenerator is already closed");
        for (NameDownloader t : threads) {
            if (t.isAlive()) t.terminate();
        }
        for (NameDownloader t : threads) {
            try {
                if (t.isAlive()) {
                    t.interrupt();
                    t.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Wenn das nicht geschlossen wurde, wird das mit dem Aufruf des GarbageCollectors getan
    @Override
    protected void finalize() throws Throwable {
        close();
    }
}
