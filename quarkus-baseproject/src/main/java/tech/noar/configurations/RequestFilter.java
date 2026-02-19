package tech.noar.configurations;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.vertx.UniHelper;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import org.jboss.resteasy.reactive.server.spi.ResteasyReactiveContainerRequestContext;
import tech.noar.dao.entity.auth.user.AuthUser;

import java.util.concurrent.atomic.AtomicReference;

@Provider
public class RequestFilter {

//    @Inject
//    ThreadContext threadContext;

    private static final Logger log = Logger.getLogger(RequestFilter.class);

    @ServerRequestFilter(preMatching = true)
    @ActivateRequestContext
    public Uni<Void> preRequest(ResteasyReactiveContainerRequestContext requestContext) {

        requestContext.setProperty("PROP_1", "Property100");
        requestContext.setProperty("PROP_2", "Property200");
        requestContext.setProperty("PROP_3", "Property300");

        return Uni.createFrom()
                .voidItem()
//                .attachContext()
//                .withContext((uni, ctx) -> {
//                    ctx.put("PROP_1_RC", "Context 1");
//                    ctx.put("PROP_2_RC", "Context 2");
//                    return uni;
//                })
                ;
        /*
                .runSubscriptionOn(Infrastructure.getDefaultExecutor())
                .onSubscription()
                .invoke(() -> {
                    log.infof("Subscribed");
                });
        */


    }

}
