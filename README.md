## API Connection

This project describes a set of Java methods for making API requests to retrieve user data from an external API. The methods are part of the apiConnection class and include functionality to search for a specific user by user code and retrieve a list of all users from the API.
I hope you like it ;).

## Folder Structure

The workspace contains :

- `src`: the folder to maintain sources
  - `models`: the folder contains the classes to read this specific api
  - `utils`: the folder contains the methods to read the api
- `lib`: the folder to maintain dependencies

## Method Descriptions
# searchUser 

The searchUser method allows you to search for a specific user by providing a user code as a parameter. Here's how it works:

1. Define the base URL for the external API, which is "https://jsonplaceholder.typicode.com/users/".
2. Construct a URI by appending the provided user code to the base URL.
3. Convert the URI to a URL object.
4. Open an HTTP connection to the URL using HttpURLConnection.
5. Retrieve the input stream from the connection to read the API response.
6. Utilize the Jackson ObjectMapper to map the API response to a Java object of the User class.
7. The method returns the User object containing the user information.
   
# readAllUsers 
The readAllUsers method allows you to retrieve a list of all users from the external API. Here's how it works:

1. Define the base URL for the external API, which is "https://jsonplaceholder.typicode.com/users/".
2. Create a URI without appending a specific user code to the base URL.
3. Convert the URI to a URL object.
4. Open an HTTP connection to the URL using HttpURLConnection.
5. Retrieve the input stream from the connection to read the API response.
6. Utilize the Jackson ObjectMapper to map the API response to a list of Java objects of the User class.
7. The method returns an ArrayList containing multiple User objects representing all the users from the API.

Feel free to adapt and integrate these methods into your Java project to interact with external APIs and retrieve user data.

