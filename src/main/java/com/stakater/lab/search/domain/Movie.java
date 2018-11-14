package com.stakater.lab.search.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import com.stakater.lab.search.support.CollectionUtil;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Set;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
@JsonDeserialize(builder = Movie.Builder.class)
@Document(indexName = "movie", type = "movie")
@Setting(settingPath = "/es/settings.json")
@SuppressWarnings("unused")
public class Movie {

    // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
    // data members

    @Id
    @Field(type = FieldType.Long,
            store = true)
    private final Long id;
    private final String title;

    private final Set<Genre> genres;
    private final Set<Actor> actors;

    // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
    // ctor

    // do not remove it
    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private Movie(Long id, String title, Set<Genre> genres, Set actors) {
        this.id = id;
        this.title = title;
        this.genres = CollectionUtil.asSafeSet(genres);
        this.actors = CollectionUtil.asSafeSet(actors);
    }

    // ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
    // builder

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}
