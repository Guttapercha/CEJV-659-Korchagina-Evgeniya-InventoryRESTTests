package com.evkorchagina.inventory_resttests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import entities.Credentials;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Evgeniya
 */
public class TEST_passwordValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TESTING METHOD getJsonByUser \n");
        
        //valid credentials
        //String email = "me@me";
        //String password = "evgeniya";
        
        //invalid credentials
        String email = "me@me";
        String password = "evgen";
        
        Credentials credentials = new Credentials();
        credentials.setEmail(email);
        credentials.setPassword(password);        
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        System.out.println("Server output for email " + email +"\n");
        
        String resturl = "http://localhost:8080/Inventory_RESTServer/webresources/users/login";
        WebResource webResource = client.resource(resturl);

        ClientResponse response = webResource.accept("application/json")
                .post(ClientResponse.class, credentials);
        String output = response.getEntity(String.class);

        System.out.println("Server response : " + response.getStatus());
        System.out.println();
        System.out.println(output);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
    }
    
}
