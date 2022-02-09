package com.example.urlservice.service;

import com.example.urlservice.entity.Url;
import com.example.urlservice.exception.BadRequestException;
import com.example.urlservice.exception.NotFoundException;
import com.example.urlservice.repository.UrlRepository;
import com.example.urlservice.request.UrlCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository redirectRepository) {
        this.urlRepository = redirectRepository;
    }

    public Optional<Url> createUrl(UrlCreationRequest urlCreationRequest) {
        if (urlRepository.existsByAlias(urlCreationRequest.getAlias())) {
            throw new BadRequestException("Alias already exists");
        }
        System.out.println("Url Request " + urlCreationRequest.toString());
        Url url = new Url(urlCreationRequest.getAlias(), urlCreationRequest.getUrl());

        Url postSaveUrl = urlRepository.save(url);
        System.out.println("Url" + postSaveUrl);


        return Optional.ofNullable(postSaveUrl);
    }

    public Url getUrl(String alias) {
        Url url = urlRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Hey we don't have that alias ! Try making it"));
        return url;
    }

}
