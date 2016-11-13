package wget.conc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by fluff on 7/27/16.
 */
public class Worker extends RecursiveTask<WorkerResult> {
    final private String host;
    final private RetrieveURLs retriever = new RetrieveURLs();
    final private URL url;

    public Worker(String host,URL url) {
        if (url == null) throw new IllegalArgumentException("url cannot be null");
        this.url = url;
        this.host = host;
    }

    @Override
    protected WorkerResult compute() {
        try {
            if (url.getFile().endsWith(".jpg")) {
                if(retriever.testURL(url)) {
                    return new WorkerResult(Result.Image);
                }
            }
            if (!url.getHost().equals(host)) {
                if(retriever.testURL(url)) {
                    return new WorkerResult(Result.OtherDomaian);
                }
            }
            return new WorkerResult(Result.HTMM, retriever.getChildren(url));
        } catch (Exception ex) {
            return new WorkerResult(Result.Invalid);
        }
    }
}
