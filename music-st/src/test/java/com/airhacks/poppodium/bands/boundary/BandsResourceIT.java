/*
 */
package com.airhacks.poppodium.bands.boundary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class BandsResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:9080/music/resources/ping");
    }

    @Test
    public void ping() {
        String ping = this.tut.request().get(String.class);
        System.out.println("ping = " + ping);
    }


}
