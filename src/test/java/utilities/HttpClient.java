package utilities;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {

    protected static CloseableHttpClient client;

    public static CloseableHttpClient getInstance() {
        if (null == client) {
            client = HttpClients.createDefault();
        }
        return client;
    }
}