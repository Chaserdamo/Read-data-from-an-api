package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;

public class apiConnection {

    // Method to search for a specific user by user code
    public static User searchUser(int userCode) {
        User userFound = null;

        try {
            // Define the base URL for the API
            String baseUrl = "https://jsonplaceholder.typicode.com/users/";
            // Create a URI by appending the user code to the base URL
            URI uri = new URI(baseUrl + userCode);

            // Convert the URI to a URL
            URL url = uri.toURL();
            // Open an HTTP connection to the URL
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            // Get the input stream from the connection to read API response
            InputStream input = new BufferedInputStream(urlConnect.getInputStream());

            // Use Jackson ObjectMapper to map the API response to a User object
            ObjectMapper mapper = new ObjectMapper();
            userFound = mapper.readValue(input, User.class);
        } catch (Exception e) {
            System.out.println("Error: Find user - " + e);
        }

        return userFound;
    }

    // Method to retrieve a list of all users from the API
    public static ArrayList<User> readAllUsers() {
        ArrayList<User> userList = new ArrayList<>();

        try {
            String baseUrl = "https://jsonplaceholder.typicode.com/users/";
            URI uri = new URI(baseUrl);

            URL url = uri.toURL();
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();

            // Get the input stream from the connection to read API response
            InputStream input = new BufferedInputStream(urlConnect.getInputStream());

            // Use Jackson ObjectMapper to map the API response to a list of User objects
            ObjectMapper mapper = new ObjectMapper();
            userList = mapper.readValue(input, new TypeReference<ArrayList<User>>() {
            });

        } catch (Exception e) {
            System.out.println("Error: Read all users - " + e);
        }

        return userList;
    }

}
