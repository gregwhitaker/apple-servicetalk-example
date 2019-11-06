package example.service.hello;

import example.service.hello.model.HelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("v1")
public class HelloResource {
    private static final Logger LOG = LoggerFactory.getLogger(HelloResource.class);

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResponse sayHello(@QueryParam("name") @DefaultValue("You") String name) {
        LOG.info("Received hello request for: {}", name);
        return new HelloResponse(String.format("Hello, %s!", name));
    }
}
