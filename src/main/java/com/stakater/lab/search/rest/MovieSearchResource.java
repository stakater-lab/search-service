package com.stakater.lab.search.rest;

import com.stakater.lab.search.service.MovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SuppressWarnings("unused")
public class MovieSearchResource {

    private final MovieSearchService movieSearchService;

    @Autowired
    public MovieSearchResource(MovieSearchService movieSearchService) {
        this.movieSearchService = movieSearchService;
    }

}
