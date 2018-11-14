package com.stakater.lab.search.repository;

import com.stakater.lab.search.domain.Movie;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@SuppressWarnings("unused")
public interface MovieSearchRepository extends ElasticsearchRepository<Movie, Long> {
}
