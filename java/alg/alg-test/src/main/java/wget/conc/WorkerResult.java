package wget.conc;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fluff on 7/27/16.
 */
enum Result {
    OtherDomaian,
    Image,
    HTMM,
    Invalid
}

public class WorkerResult {
    final public Result result;
    final public List<URL> children;

    public WorkerResult(Result result, List<URL> children) {
        this.result = result;
        this.children = children;
    }

    public WorkerResult(Result result) {
        this.result = result;
        this.children = new ArrayList<URL>(0);
    }
}
