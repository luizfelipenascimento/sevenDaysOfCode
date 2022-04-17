package com.example.luiz;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1)
            throw new RuntimeException(new Error("An argument with IMDb API Key is required"));

        String IMDb_API_KEY = args[0];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + IMDb_API_KEY))
                .GET()
                .build();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
