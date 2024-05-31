<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Student Server REST API</h1>
    <p>This project contains a simple server application with REST API endpoints to manage student data, and a Java client application using Apache HttpClient to interact with these endpoints.</p>
    <p>I have used this similar Apache HttpClient for my semester project!.</p>
    <h2>Server Application</h2>
    <p>The server application is built using Spring Boot and provides the following REST API endpoints:</p>
    <ul>
        <li><strong>GET /student</strong>: Retrieves a list of all students in JSON format.</li>
        <li><strong>GET /student/{id}</strong>: Retrieves the details of a specific student by ID.</li>
        <li><strong>POST /saveStudent</strong>: Saves a new student record from the provided JSON data.</li>
    </ul>
    <p>The server code is located in the <code>com.student.studentServer.restControllers</code> package, and uses Spring Data JPA for data persistence.</p>  
    <h2>Client Application</h2>
    <p>The client application is written in Java and uses the Apache HttpClient library to communicate with the server's REST API. It includes the following methods:</p>
    <ul>
        <li><strong>simpleGetData()</strong>: Sends a GET request to the <code>/student</code> endpoint and prints the list of students.</li>
        <li><strong>getParametrizedData(int id)</strong>: Sends a GET request to the <code>/student/{id}</code> endpoint to retrieve a specific student's details by ID.</li>
        <li><strong>postStudent()</strong>: Sends a POST request to the <code>/saveStudent</code> endpoint to save a new student record.</li>
    </ul>
    <p>The client code is located in the <code>org.voting</code> package, and uses Jackson for JSON processing.</p> 
    <hr>
        <p>For the understanding of how the json object is created and how the json object is mapper i have mentioned the comments near the code itsef.</p>
        <p>Go through it for understanding.</p>
    <hr>
    <h2>How to Run</h2>
    <h3>Server Application</h3>
    <ol>
        <li>Ensure you have Java and Maven installed.</li>
        <li>Clone the repository and navigate to the server project directory.</li>
        <li>Run <code>mvn spring-boot:run</code> to start the server.</li>
    </ol>   
    <h3>Client Application</h3>
    <ol>
        <li>Ensure you have Java installed.</li>
        <li>Clone the repository and navigate to the client project directory.</li>
        <li>Compile and run the client application to test the different methods.</li>
    </ol>
    <h2>Dependencies</h2>
    <h3>Server Application</h3>
    <ul>
        <li>Spring Boot</li>
        <li>Spring Data JPA</li>
        <li>H2 Database (for testing purposes)</li>
    </ul>  
    <h3>Client Application</h3>
    <ul>
        <li>Apache HttpClient</li>
        <li>Jackson</li>
    </ul>  
    <h2>Contributing</h2>
    <p>Contributions are welcome! Please fork the repository and submit pull requests.</p>
    <p>U can add more Http methods and play around them!</p>
</body>
</html>
