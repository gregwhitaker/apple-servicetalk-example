package example.service.hello;

import io.servicetalk.http.netty.HttpServers;
import io.servicetalk.http.router.jersey.HttpJerseyRouterBuilder;
import io.servicetalk.transport.api.ServerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Starts the hello-service application.
 */
public class HelloServer {
    private static final Logger LOG = LoggerFactory.getLogger(HelloServer.class);

    private HelloServer() {
        // Noop
    }

    public static void main(String... args) throws Exception {
        ServerContext serverContext = HttpServers.forPort(8080)
                .listenAndAwait(new HttpJerseyRouterBuilder()
                        .build(new HelloServiceApplication()));

        LOG.info("Listening on {}", serverContext.listenAddress());

        serverContext.awaitShutdown();
    }
}
