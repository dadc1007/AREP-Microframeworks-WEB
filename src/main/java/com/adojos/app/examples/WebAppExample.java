package com.adojos.app.examples;

import java.io.IOException;
import java.net.URISyntaxException;

import com.adojos.app.HttpServer;

public class WebAppExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpServer.staticfiles("/webroot/public");

        HttpServer.get("/App/hello", (req, res) -> "Hello " + req.getValues("name"));
        HttpServer.get("/App/pi", (req, res) -> String.valueOf(Math.PI));
        HttpServer.get("/App/euler", (req, res) -> String.valueOf(Math.E));

        HttpServer.main(args);
    }
}
