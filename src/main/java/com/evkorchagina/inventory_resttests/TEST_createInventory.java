package com.evkorchagina.inventory_resttests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import entities.Inventory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Evgeniya
 */
public class TEST_createInventory {

    public static void main(String[] args) {
        System.out.println("TESTING METHOD createInventory \n");
                
        String email = "him@him";
        String artist = "Beaylk";
        String album = "ooops";
        Integer year = 1977;
        String state = "VG";
        String state_detailed = "unknown";
        String upc = "unknown";
        String notes = "1 copy";
       
        try {
            Inventory inv = new Inventory();            
            
            inv.setEmail(email);
            inv.setArtist(artist);
            inv.setAlbum(album);
            inv.setYear(year);
            inv.setState(state);
            inv.setState_detailed(state_detailed);
            inv.setUpc(upc);
            inv.setNotes(notes);
           
            String resturl = "http://localhost:8080/Inventory_RESTServer/webresources/inventory/create";
            Client client = Client.create();
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

        } catch (Exception e) {

        }
    }

}
