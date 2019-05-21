
package com.airhacks.poppodium.bands.boundary;

import com.airhacks.poppodium.bands.entity.Band;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.metrics.annotation.Metered;

/**
 *
 * @author airhacks.com
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("bands")
public class BandsResource {

    @Inject
    BandManager manager;

    @GET
    @Metered
    public List<Band> bands() {
        return this.manager.getBands();
    }

    @POST
    public Response gig(@Context UriInfo info, Band band) {
        this.manager.save(band);
        URI uri = info.getAbsolutePathBuilder().path("/" + band.loudness).build();
        return Response.created(uri).build();
    }


}
