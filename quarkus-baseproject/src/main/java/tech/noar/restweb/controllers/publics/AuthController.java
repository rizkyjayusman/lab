package tech.noar.restweb.controllers.publics;


import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.RoutingContext;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.commons.models.restweb.request.auth.RegistrationRequest;
import tech.noar.services.AuthService;

@RouteBase(path = "/auth", consumes = {"application/json"}, produces = {"application/json"})
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Inject
    AuthService authService;

    @Route(path = "/register", methods = Route.HttpMethod.POST)
    public Uni<Response> registration(@Body @Valid RegistrationRequest request) {
        return authService.register(request)
                .map(authUser -> Response.ok(authUser).build());
    }


    @POST
    @Path("/login")
    public Uni<Response> login() {
        return Uni.createFrom()
                .item(Response.ok().build());
    }

    @POST
    @Path("/forgot-password")
    public Uni<Response> forgotPassword() {
        return Uni.createFrom()
                .item(Response.ok().build());
    }

}
