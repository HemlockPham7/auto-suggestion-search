package com.convit.autosuggestion.sec02.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Builder
@Data
@Document(indexName = "employee")
@Mapping(mappingPath = "sec02/index-mapping.json")
public class Employee {

    @Id
    private Integer id;
    private String name;
    private Integer age;
}
