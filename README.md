# Parking App

The program is designed to integrate the following functionality into the client-side as iOS and Android applications:
- User information retrieval
- Authorization
- Registration
- User's car information retrieval
- Adding and removing user's cars
- Retrieving parking history information
- Starting a new parking session
- Streaming data on parking space availability
- Streaming data on completed parking sessions

The interaction between the client-side and server-side of the application occurs through a REST API, using the transmission/reception of HTTP requests and responses, as well as streaming data transmission via gRPC. 

## Installation and Setup

To run the program locally, follow these steps:

1. Ensure you have the required hardware and software components mentioned in the "Execution Conditions" section.
2. Clone the repository to your local machine.
3. Install the necessary dependencies.
4. Configure the server and client applications to connect to the appropriate endpoints and resources.
5. Build and run the client-side applications on your desired platforms (iOS and Android).
6. Start the server application and ensure it is properly running.
7. Use the client applications to interact with the server and access the program's functionality.

## Usage

### Calling the Program

To use the program's functions, you need to make requests to the server via the REST API with the root URL "https://mrmotor.herokuapp.com".

### Requesting Verification Code

To request a verification code, send a POST request from the client-side. The request body should contain a JSON object with the phone number. The object is then passed to the business logic method, which generates the verification code. After the verification code request, the server returns a string with the request identifier. This algorithm is implemented in the `requestCode` method of the `AuthenticationController` class, located at the relative path "/auth/request".

### Checking Verification Code for Authorization

To check the verification code for authorization, send a POST request from the client-side. The request body should contain a JSON object with the request identifier, verification code, and phone number. The object is then passed to the business logic method, which validates the verification code. After successful verification, the server returns a string with the user's authentication JWT token. This algorithm is implemented in the `verifyCode` method of the `AuthenticationController` class, located at the relative path "/auth/verify".

### Checking Verification Code for Registration

To check the verification code for registration, send a POST request from the client-side. The request body should contain a JSON object with the request identifier, verification code, and phone number. The object is then passed to the business logic method, which validates the verification code. After successful verification, the server returns a string with the confirmed phone number. This algorithm is implemented in the `login` method of the `AuthenticationController` class, located at the relative path "/auth/login".

### Registering a New User

To register a new user, send a POST request from the client-side. The request body should contain a JSON object with the user's full name and phone number. The object is then passed to the business logic method, which adds the user to the database. After successful registration, the server returns a string with the user's authentication JWT token. This algorithm is implemented in the `register` method of the `AuthenticationController` class, located at the relative path "/auth/register".

### Getting the Current User

To retrieve the current user, send a GET request from the client-side. The request should include the access JWT token passed in the authorization header. The object is then passed to the business logic method, which returns the user information as a JSON object. This algorithm is implemented in the `getCurrentUser` method of the `UserController` class, located at the relative path "/users/me".

### Getting a User by Identifier

To retrieve a user by identifier, send a GET request from the client-side. The request should include the user ID parameter passed in the request path. The object is then passed to the business logic method, which returns the user information as a JSON object. This algorithm is implemented in the `getUserById` method of the `UserController` class, located at the relative path "/users/{id}".

### Getting a User by Phone Number

To retrieve a user by phone number, send a GET request from the client-side. The request body should contain a JSON object with the user's phone number. The object is then passed to the business logic method, which returns the user information as a JSON object. This algorithm is implemented in the `getUserByPhone` method of the `UserController` class, located at the relative path "/users/byPhone".

### Deleting a User

To delete a user, send a POST request from the client-side. The request should include the user ID parameter passed in the request path. The object is then passed to the business logic method, which performs the user deletion. After the user is successfully deleted, the server returns an HTTP status indicating the successful deletion. This algorithm is implemented in the `deleteUser` method of the `UserController` class, located at the relative path "/users/delete/{id}".

### Retrieving Order History for a User

To retrieve the order history for a user, send a GET request from the client-side. The request should include the user ID parameter passed in the request path. The object is then passed to the business logic method, which returns a list of parking history for the user. After receiving the request, the server returns this list as a JSON object. This algorithm is implemented in the `getParkingHistoryForUser` method of the `UserController` class, located at the relative path "/users/history/{id}".

### Retrieving the Last Order for a User

To retrieve the last order for a user, send a GET request from the client-side. The request should include the user ID parameter passed in the request path. The object is then passed to the business logic method, which returns the latest parking session for the user. After receiving the request, the server returns the parking history as a JSON object. This algorithm is implemented in the `getLastOrderForUser` method of the `UserController` class, located at the relative path "/users/history/{id}/last".

### Adding an Order to User History

To add an order to the user's history, send a POST request from the client-side. The request body should contain a JSON object with the user ID, parking spot number, start and end time of the parking session, parking service price, and car number. The object is then passed to the business logic method, which adds the session as history to the database. After adding the order to the user's history, the server returns the parking history as a JSON object. This algorithm is implemented in the `addOrdertoUserHistory` method of the `UserController` class, located at the relative path "/users/history/{id}".

### Getting a List of All Parking Spots

To retrieve a list of all parking spots, send a GET request from the client-side. The request body should not contain anything. The object is then passed to the business logic method, which returns a list of all parking spots. After receiving the request, the server returns the list of all parking spots as a JSON object. This algorithm is implemented in the `getAllParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots".

### Adding a New Parking Spot

To add a new parking spot, send a POST request from the client-side. The request body should contain a JSON object with the parking sensor ID, parking spot number, longitude, and latitude of the parking spot. The object is then passed to the business logic method, which adds the parking spot to the database. After adding the new parking spot, the server returns the parking spot as a JSON object. This algorithm is implemented in the `createParkingSpot` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/new".

### Retrieving a Parking Spot by Sensor ID

To retrieve a parking spot by the sensor ID, send a GET request from the client-side. The request should include the parking sensor ID parameter passed in the request path. The object is then passed to the business logic method, which returns information about the parking spot. After retrieving the parking spot by sensor ID, the server returns the parking spot as a JSON object. This algorithm is implemented in the `getParkingSpotBySensorId` method of the `UserController` class, located at the relative path "/parking-spots/sensors/{id}".

### Retrieving a Parking Spot by Identifier

To retrieve a parking spot by the spot identifier, send a GET request from the client-side. The request should include the parking spot ID parameter passed in the request path. The object is then passed to the business logic method, which returns information about the parking spot. After retrieving the parking spot by identifier, the server returns the parking spot as a JSON object. This algorithm is implemented in the `getParkingSpotById` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/{id}".

### Deleting a Parking Spot

To delete a parking spot, send a POST request from the client-side. The request should include the parking spot ID parameter passed in the request path. The object is then passed to the business logic method, which deletes the parking spot from the database. After deleting the parking spot, the server returns the HTTP status indicating the successful deletion of the parking spot. This algorithm is implemented in the `deleteParkingSpotById` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/delete/{id}".

### Starting a Parking Session

To start a parking session, send a POST request from the client-side. The request should include the parking spot ID parameter passed in the request path and a JSON object in the request body containing the user ID and car number. The object is then passed to the business logic method, which assigns the user with the car number to the parking spot. After starting the parking session, the server returns the parking spot as a JSON object with updated session information. This algorithm is implemented in the `startParkingSession` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/{id}/start-session".

### Ending a Parking Session

To end a parking session, send a POST request from the client-side. The request should include the parking spot ID parameter passed in the request path and a JSON object in the request body containing the user ID, car number, parking spot number, and start time of the session. The object is then passed to the business logic method, which records the end time of the parking session and calculates the parking service fee. After ending the parking session, the server returns the parking session as a JSON object with updated session information. This algorithm is implemented in the `stopParkingSession` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/{id}/stop-session".

### Retrieving a List of Available Parking Spots Based on Coordinates

To retrieve a list of available parking spots based on the passed coordinates, send a POST request from the client-side. The request body should contain a JSON object with the longitude, latitude of the current location, and the search radius in meters. The object is then passed to the business logic method, which calculates the available parking spots within the radius. After receiving the request, the server returns a JSON object with a list of all possible parking spots. This algorithm is implemented in the `getAvailableParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/available".

### Retrieving a List of Possible Parking Spots for Parking

To retrieve a list of possible parking spots for parking, send a POST request from the client-side. The request body should contain a JSON object with the longitude, latitude of the current location, and the search radius in meters. The object is then passed to the business logic method, which calculates the possible parking spots within the radius where the user could park. After receiving the request, the server returns a JSON object with a list of all possible parking spots. This algorithm is implemented in the `getPossibleParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/possible".

### Checking gRPC Connection

To check the gRPC connection, send a POST request from the client-side. The request should include the parking spot ID parameter passed in the request path. The object is then passed to gRPC. After the request, if the gRPC connection is successful, the server will return an HTTP status indicating the successful gRPC connection. This algorithm is implemented in the `getAvailableParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/available".

### Input and Output Data

#### Requesting Verification Code

The input data for requesting a verification code is a JSON object received from the request body, containing the phone number. The output data for requesting a verification code is the server response, containing a JSON object in the response body with the request ID.

#### Verifying the Verification Code for Authorization

The input data for verifying the verification code for authorization is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the verification code is the server response, containing a string with the JWT authentication token for the user.

#### Verifying the Verification Code for Registration

The input data for verifying the verification code for registration is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the verification code is the server response, containing a JSON object with the confirmed phone number.

#### Registering a New User

The input data for registering a new user is a JSON object received from the request body, containing the full name of the user and the phone number. The output data for registering a new user is the server response, containing a JSON object with the user information.

#### Retrieving the Current User

The input data for retrieving the current user is the access JWT token passed in the request's authentication header. The output data for retrieving the current user is the server response, containing a JSON object with the user information.

#### Retrieving a User by Identifier

The input data for retrieving a user by identifier is the user ID parameter passed in the request path. The output data for retrieving a user by identifier is the server response, containing a JSON object with the user information.

### Retrieving a List of Available Parking Spots Based on Coordinates

To retrieve a list of available parking spots based on the passed coordinates, send a POST request from the client-side. The request body should contain a JSON object with the longitude, latitude of the current location, and the search radius in meters. The object is then passed to the business logic method, which calculates the available parking spots within the radius. After receiving the request, the server returns a JSON object with a list of all possible parking spots. This algorithm is implemented in the `getAvailableParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/available".

### Retrieving a List of Possible Parking Spots for Parking

To retrieve a list of possible parking spots for parking, send a POST request from the client-side. The request body should contain a JSON object with the longitude, latitude of the current location, and the search radius in meters. The object is then passed to the business logic method, which calculates the possible parking spots within the radius where the user could park. After receiving the request, the server returns a JSON object with a list of all possible parking spots. This algorithm is implemented in the `getPossibleParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/possible".

### Checking gRPC Connection

To check the gRPC connection, send a POST request from the client-side. The request should include the parking spot ID parameter passed in the request path. The object is then passed to gRPC. After the request, if the gRPC connection is successful, the server will return an HTTP status indicating the successful gRPC connection. This algorithm is implemented in the `getAvailableParkingSpots` method of the `ParkingSpotController` class, located at the relative path "/parking-spots/available".

### Input and Output Data

#### Requesting Verification Code

The input data for requesting a verification code is a JSON object received from the request body, containing the phone number. The output data for requesting a verification code is the server response, containing a JSON object in the response body with the request ID.

#### Verifying the Verification Code for Authorization

The input data for verifying the verification code for authorization is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the verification code is the server response, containing a string with the JWT authentication token for the user.

#### Verifying the Verification Code for Registration

The input data for verifying the verification code for registration is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the verification code is the server response, containing a JSON object with the confirmed phone number.

#### Registering a New User

The input data for registering a new user is a JSON object received from the request body, containing the full name of the user and the phone number. The output data for registering a new user is the server response, containing a JSON object with the user information.

#### Retrieving the Current User

The input data for retrieving the current user is the access JWT token passed in the request's authentication header. The output data for retrieving the current user is the server response, containing a JSON object with the user information.

#### Retrieving a User by Identifier

The input data for retrieving a user by identifier is the user ID parameter passed in the request path. The output data for retrieving a user by identifier is the server response, containing a JSON object with the user information.
### Retrieving a User by Phone Number

The input data for retrieving a user by phone number is a JSON object received from the request body, containing the phone number. The output data for retrieving a user by phone number is the server response, containing a JSON object with the user information.

### Deleting a User

The input data for deleting a user is the user ID parameter passed in the request path. The output data for deleting a user is the server response with an HTTP status indicating the successful deletion of the user.

### Retrieving the Order History for a User

The input data for retrieving the order history for a user is the user ID parameter passed in the request path. The output data for retrieving the order history for a user is the server response, containing a JSON object with information about the parking history.

### Retrieving the Last Order for a User

The input data for retrieving the last order for a user is the user ID parameter passed in the request path. The output data for retrieving the last order for a user is the server response, containing a JSON object with information about the last parking history.

### Adding an Order to the User's History

The input data for adding an order to the user's history is the user ID parameter passed in the request path and a JSON object received from the request body, containing the user ID, parking spot number, car number, start and end time of the parking session. The output data for adding an order to the user's history is the server response, containing a JSON object with information about the parking session.

### Retrieving a List of All Parking Spots

There is no input data required for retrieving a list of all parking spots. The output data for retrieving a list of all parking spots is the server response, containing a JSON object with a list of all parking spots.

### Adding a New Parking Spot

There is no input data required for adding a new parking spot. The output data for adding a new parking spot is the server response, containing a JSON object with the newly created parking spot.

### Retrieving a Parking Spot by Sensor ID

The input data for retrieving a parking spot by sensor ID is the sensor ID parameter passed in the request path. The output data for retrieving a parking spot by sensor ID is the server response, containing a JSON object with information about the parking spot.

### Retrieving a Parking Spot by ID

The input data for retrieving a parking spot by ID is the parking spot ID parameter passed in the request path. The output data for retrieving a parking spot by ID is the server response, containing a JSON object with information about the parking spot.

### Deleting a Parking Spot

The input data for deleting a parking spot by ID is the parking spot ID parameter passed in the request path. The output data for deleting a parking spot by ID is the server response with an HTTP status indicating the successful deletion of the parking spot.

### Starting a Parking Session

The input data for starting a parking session is the parking spot ID parameter passed in the request path and a JSON object, inside which the user ID and car number are provided. The output data for starting a parking session is the server response, containing a JSON object with information about the parking spot.

### Ending a Parking Session

The input data for ending a parking session is the parking spot ID parameter passed in the request path. The output data for ending a parking session is the server response, containing a JSON object with information about the parking session.

### Retrieving a List of Available Parking Spots Based on Coordinates

The input data for retrieving a list of available parking spots based on coordinates is a JSON object, within which the search radius, longitude, and latitude of the current location are provided. The output data for retrieving a list of available parking spots based on coordinates is the server response, containing JSON objects with a list of available parking spots.

### Retrieving a List of Possible Parking Spots for Parking

The input data for retrieving a list of possible parking spots for parking is a JSON object, within which the search radius, longitude, and latitude of the current location are provided. The output data for retrieving a list of possible parking spots for parking is the server response, containing JSON objects with a list of possible parking spots.

### Checking gRPC Connectivity

The input data for checking gRPC connectivity is the parking spot ID parameter passed in the request path. The output data for checking gRPC connectivity is the server response with an HTTP status indicating successful gRPC connectivity.

### Verification Code Request

The input data for the verification code request is a JSON object received from the request body, containing the phone number. The output data for the verification code request is the server response, containing a JSON object with the request ID.

### Verification Code Check for Authorization

The input data for verifying the authorization code is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the authorization code is the server response, containing a string with the user authentication JWT token.

### Verification Code Check for Registration

The input data for verifying the registration code is a JSON object received from the request body, containing the request ID, verification code, and phone number. The output data for verifying the registration code is the server response, containing a JSON object with the entered phone number.

### User Registration

The input data for user registration is a JSON object received from the request body, containing the full name and phone number, verification code, and phone number. The output data for user registration is the server response, containing a JSON object with the user information.

### Retrieving the Current User

The input data for retrieving the current user is the access JWT token passed in the authentication header of the request. The output data for retrieving the current user is the server response, containing a JSON object with the user information.

### Retrieving a User by ID

The input data for retrieving a user by ID is the user ID parameter passed in the request path. The output data for retrieving a user by ID is the server response, containing a JSON object with the user information.


### Server Requirements
- Operating System: Windows 7 or higher
- Operating System: MacOS Sierra or higher
- Hard Disk: 512 MB of free space
- RAM: 4 GB or more
- Processor: Intel Core i3 or equivalent

### Client Requirements
- Processor: 4-core, 2.90 GHz or higher
- Platform: 32-bit or 64-bit
- RAM: 4 GB or more
- Hard Disk: 512 MB of free space or more

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

