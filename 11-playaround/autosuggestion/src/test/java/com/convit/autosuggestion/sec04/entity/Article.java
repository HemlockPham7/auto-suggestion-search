package com.convit.autosuggestion.sec04.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Data
@Builder
@Document(indexName = "articles")
@Mapping(mappingPath = "sec04/index-mapping.json")
public class Article {

    @Id
    private String id;
    private String title;
    private String body;
}
