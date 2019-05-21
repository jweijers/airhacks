
package com.airhacks.ping.boundary;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 *
 * @author airhacks.com
 */
public class BandsProxy {
    private Client client;
    private WebTarget tut;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry registry;


    @PostConstruct
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:9080/music/resources/ping");
    }

    @Timed
    public String ping() {
        Response response = this.tut.request().get();
        registry.counter("music_response_" + response.getStatus()).inc();
        return response.readEntity(String.class);
    }
}
