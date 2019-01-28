# HBSIS - Java

This project was developed using Java 1.8 and [Spring Boot](https://spring.io) framework.

## Install

Clone the project and run `maven clean install` to download all dependencies and build/test the project.  
Change `src/main/resources/application.json` to point to correct [MongoDB](https://mongodb.com) installation. It assumes MongoDB is running on `localhost:27017`.  

## Development server

Run `Application.class` as a Java Application. It should start running the app on `http://localhost:8080`  
There is a builded version of [hbsis-angular](https://github.com/tarcio/hbsis-angular), where you can check going to `http://localhost:8080`.

## TODO

Improve Tests; Improve Repo Classes; Better Handler for OpenWeather Result.
