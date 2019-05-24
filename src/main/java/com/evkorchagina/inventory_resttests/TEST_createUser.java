package com.evkorchagina.inventory_resttests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import entities.Inventory;
import entities.Users;

/**
 *
 * @author Evgeniya
 */
public class TEST_createUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TESTING METHOD createUser \n");

        String firstname = "Alla";
        String lastname = "Matveeve";
        String street = "King Street";
        String city = "New York";
        String province = "NY";
        String country = "USA";
        String postal = "H6T U7J";
        String email = "alla@alla";
        String password = "alla";
        try {
            Users u = new Users();

            u.setEmail(email);
            u.setFirstname(firstname);
            u.setLastname(lastname);
            u.setStreet(street);
            u.setCity(city);
            u.setProvince(province);
            u.setCountry(country);
            u.setPostal(postal);
            u.setPassword(password);

            String resturl = "http://localhost:8080/Inventory_RESTServer/webresources/users/create";
            Client client = Client.create();
            WebResource webResource = client.resource(resturl);

            ClientResponse response = webResource.accept("application/json")
                    .post(ClientResponse.class, u);
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
