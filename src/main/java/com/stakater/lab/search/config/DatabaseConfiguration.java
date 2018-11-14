package com.stakater.lab.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("com.stakater.lab.search.repository")
public class DatabaseConfiguration {
}
