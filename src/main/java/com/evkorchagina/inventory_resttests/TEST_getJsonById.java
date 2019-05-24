package com.evkorchagina.inventory_resttests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Evgeniya
 */
public class TEST_getJsonById {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TESTING METHOD getJsonById \n");
        int input=2;
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/Inventory_RESTServer/webresources/inventory/byid/"+input).build());
        System.out.println("Server output for id " + input + "\n");
        System.out.println();
        System.out.println(service.accept(MediaType.APPLICATION_JSON).get(String.class));
    }
    
}
