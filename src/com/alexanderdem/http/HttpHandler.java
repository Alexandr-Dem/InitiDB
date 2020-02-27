package com.alexanderdem.http;

import com.alexanderdem.InitDB;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandler {
    private InitDB initDB;
    private HttpClient client;

    public HttpHandler(InitDB initDB) {
        this.initDB = initDB;
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    }

    public HttpResponse requestGET (URI requestUri) throws IOException, InterruptedException {
        HttpRequest requestGet = HttpRequest.newBuilder()
                .GET()
                .uri(requestUri)
                .build();
        HttpResponse response = null;
        response = client.send(requestGet, HttpResponse.BodyHandlers.ofString());
        initDB.showMessage("2. JSON получен");
        return response;
    }

}
