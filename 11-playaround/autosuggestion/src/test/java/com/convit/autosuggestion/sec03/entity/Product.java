package com.convit.autosuggestion.sec03.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Data
@Builder
@Document(indexName = "products")
@Mapping(mappingPath = "sec03/index-mapping.json")
public class Product {

    @Id
    private Integer id;
    private String name;
    private String brand;
    private String category;
    private Integer price;
    private Integer quantity;
}
