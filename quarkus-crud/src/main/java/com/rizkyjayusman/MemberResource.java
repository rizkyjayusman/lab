package com.rizkyjayusman;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

    @GET
    public List<Member> getAll() {
        return Member.listAll();
    }

    @POST
    @Transactional
    public Member create(Member member) {
        Member.persist(member);
        return member;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Member update(@PathParam("id") Long id, Member member) {
        Member entity = Member.findById(id);
        if (entity == null) throw new NotFoundException();
        entity.name = member.name;
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        if (!Member.deleteById(id)) {
            throw new NotFoundException();
        }
    }

}
