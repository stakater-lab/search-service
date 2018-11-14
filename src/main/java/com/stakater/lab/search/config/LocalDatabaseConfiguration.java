package com.stakater.lab.search.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pl.allegro.tech.embeddedelasticsearch.EmbeddedElastic;
import pl.allegro.tech.embeddedelasticsearch.PopularProperties;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

/**
 * Downloads and runs elasticsearch as part of the application just during development and test
 */
@Configuration
@AutoConfigureBefore(value = {ElasticsearchAutoConfiguration.class})
@Profile("!" + SpringProfiles.SPRING_PROFILE_PRODUCTION)
public class LocalDatabaseConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final EmbeddedElastic EMBEDDED_ELASTIC = EmbeddedElastic.builder()
            .withElasticVersion("6.4.2")
            // These settings should match the ones application.yaml
            .withSetting(PopularProperties.TRANSPORT_TCP_PORT, 9350)
            .withSetting(PopularProperties.CLUSTER_NAME, "local_es_cluster")
            .withStartTimeout(30, TimeUnit.SECONDS)
            .build();

    public LocalDatabaseConfiguration() {
        try {
            EMBEDDED_ELASTIC.start();
        } catch (IOException e) {
            LOGGER.error("Failed to start elasticsearch!",e);
        } catch (InterruptedException e) {
            LOGGER.error("Failed to start elasticsearch!",e);
        }
    }

}
