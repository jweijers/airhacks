
package com.airhacks.poppodium.bands.boundary;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
public class GoldenAreTheLoudestException extends WebApplicationException {

    public GoldenAreTheLoudestException(String message) {
        super(Response.status(400).header("reason", message).build());
    }


}
