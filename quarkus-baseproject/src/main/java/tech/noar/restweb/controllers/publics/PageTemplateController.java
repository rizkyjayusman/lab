package tech.noar.restweb.controllers.publics;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public class PageTemplateController {

    @GET
    @Path("/page-template/{code}")
    public Uni<Response> pageTemplate(@PathParam("code") String templateCode) {
        return Uni.createFrom()
                .item(Response.ok().build());
    }

}
