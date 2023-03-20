package com.marko.photosapp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marko.photosapp.dto.GoogleBooks;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GoogleBooksService {

    private String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=";


    public GoogleBooks Search(String search) throws IOException, InterruptedException, URISyntaxException {
        var request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + search))
                .GET()
                .build();
        var clientBuilder = HttpClient.newBuilder();
        var client = clientBuilder.build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var body = response.body();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body, GoogleBooks.class);
    }


}
