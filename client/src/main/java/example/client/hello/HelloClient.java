package example.client.hello;

import io.servicetalk.data.jackson.JacksonSerializationProvider;
import io.servicetalk.http.api.BlockingHttpClient;
import io.servicetalk.http.api.HttpClient;
import io.servicetalk.http.api.HttpResponse;
import io.servicetalk.http.api.HttpSerializationProvider;
import io.servicetalk.http.netty.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

import static io.servicetalk.http.api.HttpSerializationProviders.jsonSerializer;

/**
 * Client that sends requests to the hello-service application.
 */
public class HelloClient {
    private static final Logger LOG = LoggerFactory.getLogger(HelloClient.class);

    public static void main(String... args) throws Exception {
        String name = null;
        if (args.length == 1) {
            name = args[0];
        }

        String urlFragment = "/v1/hello";
        if (name != null && !name.isEmpty()) {
            urlFragment += "?name=" + name;
        }

        HttpSerializationProvider serializer = jsonSerializer(new JacksonSerializationProvider());

        try (BlockingHttpClient client = HttpClients.forSingleAddress("localhost", 8080).buildBlocking()) {
            HttpResponse httpResponse = client.request(client.get(urlFragment));
            HelloResponse helloResponse = httpResponse.payloadBody(serializer.deserializerFor(HelloResponse.class));

            LOG.info("Response: " + helloResponse.getMessage());
        }
    }
}
