package com.trade.api.rest.resources.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces("application/json")
@Consumes("application/json")
@Api(value = "Test resource", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
public class TestResource {

    /* Constructors */
    public TestResource() {
        // Default constructor
    }

    @GET
    @Path("/hello")
    @ApiOperation(value = "API Say Hello", notes = "This is just an test API to check if Server is working", response = Response.class)
    public String hello() {
        return "Hello";
    }
}
