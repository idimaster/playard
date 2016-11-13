package wget.conc;

import java.net.URL;
import java.util.*;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by fluff on 7/27/16.
 */
public class Wget {
    final private URL url;
    final private List<URL> broken;
    final private List<URL> correct;
    final private Set<URL> processed;

    public Wget(URL url) {
        if (url == null) throw new IllegalArgumentException("url cannot be null");
        this.url = url;
        broken = new ArrayList<URL>();
        correct = new ArrayList<URL>();
        processed = new HashSet<URL>();
    }

    public void start() {
        List<URL> urls = new ArrayList<URL>();
        urls.add(url);
        process(url.getHost(), urls);
    }

    private void process(String host, List<URL> urls) {
        Collection<Worker> workers = new ArrayList<Worker>();
        for(URL url: urls) {
            if (!processed.contains(url)) {
                processed.add(url);
                workers.add(new Worker(host, url));
            }
        }
        Collection<Worker> results = ForkJoinTask.invokeAll(workers);
        for (Worker result : results) {
            WorkerResult res = result.join();
            if (res.result == Result.Invalid) {
                broken.add(url);
            } else {
                correct.add(url);
                if(res.result == Result.HTMM) {
                    process(url.getHost(), res.children);
                }
            }
        }
    }

    public List<URL> getBroken() {
        return broken;
    }

    public List<URL> getCorrect() {
        return correct;
    }
}
