package com.airhacks.full.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Metered;

@Path("/ping")
public class PingResource {

    @Inject
    BandManager manager;
    
    @GET
    @Metered
    @Produces(MediaType.APPLICATION_JSON)
    public Band hello() {
        Band band = new Band();
        band.name = "hello " + this.manager.all();
        return band;
    }
}