package example.service.hello;

import example.service.hello.model.HelloResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("v1")
public class HelloResource {

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResponse sayHello() {
        return new HelloResponse("Hello, You!");
    }
}
