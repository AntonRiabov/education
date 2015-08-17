package com.paladii.school.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by anton.riabov on 8/13/2015.
 */
@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    @Path("{name}/")
    public String hello(@PathParam("name") String name){
        return String.format("hello %s, you are lucky! at least you have deal with rest's", name);
    }

}
