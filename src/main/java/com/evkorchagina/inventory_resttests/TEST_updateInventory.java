package com.evkorchagina.inventory_resttests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import entities.Inventory;
import java.io.IOException;
import javax.json.stream.JsonGenerationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Evgeniya
 */
public class TEST_updateInventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("TESTING METHOD updateInventory \n");
        //get inventory by id
        int input = 1;
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/Inventory_RESTServer/webresources/inventory/byid/" + input).build());
        System.out.println("Server output for id " + input + "\n");
        System.out.println();
        String js = service.accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(js);

        //convert JSON to Invetory Object
        Inventory inv = null;

        ObjectMapper mapper = new ObjectMapper();
        inv = mapper.readValue(js, Inventory.class);
        System.out.println(inv);
        //updating year
        inv.setYear(1999);

        String resturl = "http://localhost:8080/Inventory_RESTServer/webresources/inventory/update";
        WebResource webResource = client.resource(resturl);

        ClientResponse response = webResource.accept("application/json")
                .post(ClientResponse.class, inv);
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
