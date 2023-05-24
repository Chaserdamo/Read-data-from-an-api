package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;

public class apiConnection {

    public static User searchUser(int userCode) {

        User userFound = null;

        try {
            String urlConecction = "https://jsonplaceholder.typicode.com/users/";
            urlConecction += userCode;

            URL url = new URL(urlConecction);
            URLConnection urlConnect = url.openConnection();

            InputStream input = new BufferedInputStream(urlConnect.getInputStream());

            // Map the api response to my user object
            ObjectMapper mapper = new ObjectMapper();

            userFound = mapper.readValue(input, User.class);

        } catch (Exception e) {
            System.out.println("Error : Find user - " + e);
        }

        return userFound;
    }

    public static ArrayList<User> readAllUsers() {

        ArrayList<User> userList = new ArrayList<>();

        try {
            String urlConecction = "https://jsonplaceholder.typicode.com/users/";

            URL url = new URL(urlConecction);
            URLConnection urlConnect = url.openConnection();

            InputStream input = new BufferedInputStream(urlConnect.getInputStream());

            // Map the api response to my user object
            ObjectMapper mapper = new ObjectMapper();

            userList = mapper.readValue(input, new TypeReference<ArrayList<User>>() {
            });

        } catch (Exception e) {
            System.out.println("Error : Find user - " + e);
        }

        return userList;

    }

}
