package com.convit.autosuggestion.sec05.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.List;

@Data
@Builder
@Document(indexName = "garments")
@Mapping(mappingPath = "sec05/index-mapping.json")
public class Garment {

    private String id;
    private String name;
    private Integer price;
    private List<String> color;
    private List<String> size;
    private String material;
    private String brand;
    private String occasion;
    private String neckStyle;
}
