# Auto-complete Country Name Application
This is an Auto-complete Country Name Application
which can search countries present in Database
based on the keyword passed in request as parameter.
It also provides flexibility to limit the results
by passing the limit as request parameter.
It can also be used to fetch all the countries' data
from the database... all in real time.

## Getting started
These instructions will get you a copy of 
the project up and running on your local 
machine for development and testing purposes.

### Prerequisites
This project is designed and developed 
using following libraries and tools.
To run this application successfully and
avoid compatibility issues, please 
install / update them to at least the 
versions mentioned. Most of it will be handled
by Gradle.
- Java 1.8
- Gradle 5.5.1
- Git 2.21.0

### Setup

Clone the repository to your local:

```sh
$ git clone https://github.com/r3dark/auto-complete.git
```

To set up the project, open terminal at root 
of project and execute : 

```sh
$ gradle clean test
$ gradle clean build --refresh-dependencies
```

This will run the test suite, 
build the application with required dependencies, 
and get it ready for execution.

### Execute / Run
To run this project, either import it in
**Intellij Idea** or run the following command
at root of the project :

```sh
$ java -jar build/libs/auto-complete-1.0-SNAPSHOT.jar
```

### How to use
- Import the **Postman Collection** provided in : 

```
src/main/resources/autoComplete_PostmanCollection.json
```

- Use [**Swagger**](http://localhost:8080/auto-complete/swagger-ui.html) (recommended).

- Use cURL :

```sh
$ curl -X GET 'http://localhost:8080/auto-complete/countries?keyword=ro&limit=5' -H 'Accept: application/json'
```
```sh
$ curl -X GET 'http://localhost:8080/auto-complete/countries/all' -H 'Accept: application/json'
```
