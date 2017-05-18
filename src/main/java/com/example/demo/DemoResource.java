package com.example.demo;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by jpairaiturkar on 5/17/17.
 */
@Component
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

    @Context
    HttpServletRequest request;

    @Inject
    private DemoRepository demoDao ;

    @GET
    @Path("/{id}")
    public DemoEntity findOne(@PathParam("id") String id) {
        // dummy shard identification
        setShard(id);

        return demoDao.findOne(id);
    }

    @POST
    public Response createOne(DemoEntity entity) {

        //assign id using some logic
        //this is just copy paste
        entity.setId(entity.getDisplayName());

        //assign shard
        setShard(entity.getId());
        if ( entity.getDisplayName().length() % 2  != 0) {
            request.setAttribute("CURRENT_TENANT_IDENTIFIER","SHARD_1");
        } else {
            request.setAttribute("CURRENT_TENANT_IDENTIFIER","SHARD_2");
        }
        demoDao.save(entity);
        return Response.status(202).build();
    }

    private void setShard(String id) {
        if ( id.length() % 2  != 0) {
            request.setAttribute("CURRENT_TENANT_IDENTIFIER","SHARD_1");
        } else {
            request.setAttribute("CURRENT_TENANT_IDENTIFIER","SHARD_2");
        }
    }
}
