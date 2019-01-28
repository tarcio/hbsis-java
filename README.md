# HBSIS - Java

This project was developed using Java 1.8 and [Spring Boot](https://spring.io) framework.

## Install

Clone the project and run `maven clean install` to download all dependencies and build/test the project.  
Change `src/main/resources/application.json` to point to correct [MongoDB](https://mongodb.com) installation. It assumes MongoDB is running on `localhost:27017`.  

## Development server

Run `Application.class` as a Java Application. It should start running the app on `http://localhost:8080`  
There is a builded version of [hbsis-angular](https://github.com/tarcio/hbsis-angular), where you can check going to `http://localhost:8080`.

## MongoDB

If you don't have MongoDB installed, there is a remote database that you can use for tests.  
Remove all `spring.data.mongodb.*` from application.json and add `spring.data.mongodb.uri=mongodb://hbsis:hbsis123@ds113855.mlab.com:13855/hbsis`.

## Straight to the app!

Yuo can also just download the `hbsis-java.jar` and run it using `java -jar hbsis-jar`. It is configured to use the remote MongoDB database.  

Go to `localhost:8080` and enjoy.

## TODO

Improve Tests; Improve Repo Classes; Better Handler for OpenWeather Result.
