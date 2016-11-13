package wget.conc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fluff on 7/27/16.
 */
public class RetrieveURLs {
    public List<URL> getChildren(URL url) throws IOException {
        url.openConnection();
        return new ArrayList<URL>();
    }

    public boolean testURL(URL url) throws IOException {
        return true;
    }
}
