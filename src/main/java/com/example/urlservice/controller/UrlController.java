package com.example.urlservice.controller;


import com.example.urlservice.entity.Url;
import com.example.urlservice.request.UrlCreationRequest;
import com.example.urlservice.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService redirectService) {
        this.urlService = redirectService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handleUrl(@PathVariable String alias) throws URISyntaxException {
        Url url = urlService.getUrl(alias);
        System.out.println("We're here!" + url);
        URI uri = new URI(url.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<?> createUrl(@RequestBody UrlCreationRequest urlCreationRequest) {
        return ResponseEntity.ok(urlService.createUrl(urlCreationRequest));
    }
}
