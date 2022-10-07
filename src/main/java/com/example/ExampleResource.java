package com.example;

import io.quarkiverse.cxf.annotation.CXFClient;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fruits")
@ApplicationScoped
public class ExampleResource {

    @Inject
    @CXFClient("my-fruitservice-client")
    FruitWebService clientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
       return Response.ok(clientService.list()).build();
    }
}