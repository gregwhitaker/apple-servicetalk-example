package example.service.hello;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * Hello world JAX-RS application
 */
public class HelloServiceApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(HelloResource.class);
    }
}
