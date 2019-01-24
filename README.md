# demo-microservice-city-connection-finder-prototype
Prototype MVP (Minimum Viable Product) Version of City Connection Finder Microservice

Go [here](https://github.com/aifoss/demo-microservice-city-connection-finder-full-version) for an extended version.

## Tools/Technologies Used

* Java 1.8
* Spring Boot
* JUnit, Mockito
* Spring Tool Suite
* Swagger 2

## Assumptions/Decisions Made

* Input file contains valid city names in specified format.
* Input file may contain duplicate lines.
* City names, from both the input file and parameters, are standardized to lower case to allow for case-insensitive matching.
* If an identical city name is provided for both origin and destination, "yes" will be returned (even if the city does not appear in the input file).

## Approach to Problem

Build a graph where each city becomes a node and a direct path between two cities becomes an edge. 

In order to detect a connection between two given cities, use the following algorithm:

1. Check base/edge cases:

   a. If the two cities are identical, i.e., represent the same city, return true.

   b. If either of the two cities is not a node in the graph, return false.

   c. If the two cities are directly connected, i.e., there is an edge between the two cities, return true.

2. Use BFS algorithm to check the connection between the two cities:

   Initially, the queue and visited set contain one of the two cities, regarded as the origin city.

   While the queue is not empty, poll a city from the queue, and check each of the adjacent cities directly connected.
   
   		a. If an adjacent city is the destination city, return true.
   	
   		b. Else, if the adjacent city has not been visited yet, mark it as visited and add it to the queue.

   Once the queue is emptied out, it means that there is no connection between the two input cities, so return false.
  
## Run Instructions

### Prerequisites

Clone the repository or download zip.

Executable city-connection-finder-prototype-0.jar is located in city-connection-finder-prototype/target directory.

### Run Option 1: Web Browser

Start the application by issuing the following command (from the directory where the above jar is located):

java -jar city-connection-finder-prototype-0.jar CityConnectionFinderPrototypeApplication.class

Open a browser and try the following API calls:

http://localhost:8080/connected?origin=Boston&destination=Newark
(Should return yes)

http://localhost:8080/connected?origin=Boston&destination=Philadelphia
(Should return yes)

http://localhost:8080/connected?origin=Philadelphia&destination=Albany
(Should return no)

### Run Option 2: Swagger UI

Start the application as described in Run Option 1.

Open a browser and go to http://localhost:8080/swagger-ui.html.

On the City Connection Finder API page, click on the arrow next to "city-connection-finder-controller".

Click on "GET /connected".

Click on "Try it out" button.

Provide origin and destination city names.

Click on "Execute".

### Run Option 3: Postman

Start the application as described in Run Option 1.
Send GET requests on Postman using the URLs as above.
