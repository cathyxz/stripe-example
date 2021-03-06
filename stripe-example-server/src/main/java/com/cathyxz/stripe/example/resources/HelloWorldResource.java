package com.cathyxz.stripe.example.resources;

import com.cathyxz.stripe.example.api.ImmutableSaying;
import com.cathyxz.stripe.example.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    public HelloWorldResource() {
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") String name) {
        return ImmutableSaying.builder()
                .content(name)
                .build();
    }
}
