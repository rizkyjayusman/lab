package tech.noar.configurations;


import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ApplicationConfig {

    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    public void onStart(@Observes StartupEvent event) {
        log.info("ApplicationConfig::onStart");
        // set default timezone for all instances
//        System.setProperty("user.timezone", "UTC");
//        System.setProperty("quarkus.hibernate-orm.jdbc.timezone", "UTC");
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    }

    public void onStop(@Observes ShutdownEvent event) {
        log.info("ApplicationConfig::onStop");

        // do gracefully shutdown
    }

}

