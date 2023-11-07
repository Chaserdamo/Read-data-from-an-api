import java.util.ArrayList;

import models.User;
import utils.apiConnection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("----- Hello , let's read from an api -----");

        // A selected user
        System.out.println("----- A selected user -----");
        // Search for a specific user with user code 10
        User user1 = apiConnection.searchUser(10);
        System.out.println(user1);

        // A list of all users
        System.out.println("\n----- A list of all users -----");
        // Fetch a list of all users from the API
        ArrayList<User> list = apiConnection.readAllUsers();
        System.out.println(list);

    }
}
