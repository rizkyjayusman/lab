package tech.noar.restweb.controllers.publics;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

public class OtpController {

    @POST
    @Path("/request-otp")
    public Uni<Response> forgotPassword() {
        return Uni.createFrom()
                .item(Response.ok().build());
    }
}
