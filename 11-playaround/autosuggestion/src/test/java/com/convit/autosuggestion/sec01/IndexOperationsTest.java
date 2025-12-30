package com.convit.autosuggestion.sec01;

import com.convit.autosuggestion.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

@Slf4j
public class IndexOperationsTest extends AbstractTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void createIndex() {
        var indexOperations = this.elasticsearchOperations.indexOps(IndexCoordinates.of("albums"));
        Assertions.assertTrue(indexOperations.create());

        log.info("settings: {}", indexOperations.getSettings());
    }
}
