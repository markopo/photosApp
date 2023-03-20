package com.marko.photosapp;

import com.marko.photosapp.dto.Item;
import com.marko.photosapp.services.GoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


@RestController
public class GoogleBooksController {

    private GoogleBooksService googleBooksService;

    @Autowired
    public GoogleBooksController(GoogleBooksService googleBooksService) {
        this.googleBooksService = googleBooksService;
    }

    @GetMapping("/findbooks")
    public ArrayList<String> findBooks(String search) throws IOException, URISyntaxException, InterruptedException {
        var gb = this.googleBooksService.Search(search);
        var titles = new ArrayList<String>();
        for(Item item : gb.getItems()) {
            titles.add(item.getVolumeInfo().getTitle());
        }

        return titles;
    }


}
