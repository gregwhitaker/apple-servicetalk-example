package example.client.hello;

import io.servicetalk.data.jackson.JacksonSerializationProvider;
import io.servicetalk.http.api.HttpClient;
import io.servicetalk.http.api.HttpDeserializer;
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

        CountDownLatch latch = new CountDownLatch(1);

        LOG.info("Sending request to hello service for name: '{}'", name);

        HttpSerializationProvider serializer = jsonSerializer(new JacksonSerializationProvider());

        try (HttpClient client = HttpClients.forSingleAddress("localhost", 8080).build()) {
            String url = "/v1/hello";
            if (name != null && !name.isEmpty()) {
                url += "?name=" + name;
            }

            client.request(client.get(url))
                    .whenFinally(latch::countDown)
                    .subscribe(httpResponse -> {
                        LOG.info("Response: " + httpResponse.payloadBody(serializer.deserializerFor(HelloResponse.class)));
                    });
        }

        latch.await();
    }
}
