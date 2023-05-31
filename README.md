# Program Name

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

## Features

- Display parking spaces as points
- Display parking space availability with red and green colors for occupied and free spaces respectively
- Display the user's car list in a user-friendly format
- Display the user's parking history based on the latest date in a readable format
- Display authorization-related pages in a user-friendly and structured manner
- Receive and process data entered by the user through text fields, as well as handle user button clicks
- Send HTTP requests to the server via the REST API and handle the responses received from the server.

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

The program provides various features and endpoints for different operations. Here are some examples:

- Request verification code: `POST /auth/request`
- Check verification code for authorization: `POST /auth/verify`
- Register a new user: `POST /user/register`
- Get the current user: `GET /user/current`
- Start a parking session: `POST /parking/start`
- Delete a user: `DELETE /user/{id}`
- Get order history for a user: `GET /user/{id}/orders`
- Get a list of all parking spaces: `GET /parking/spaces`
- Add a new parking space: `POST /parking/space`
- Delete a parking space: `DELETE /parking/space/{id}`
- Get a list of available parking spaces: `GET /parking/spaces/available`

Refer to the API documentation for detailed information on each endpoint and their usage.

## System Requirements

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

## License

This program is licensed under the [MIT License](LICENSE).
