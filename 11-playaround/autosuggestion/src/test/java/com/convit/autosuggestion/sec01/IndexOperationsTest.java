package com.convit.autosuggestion.sec01;

import com.convit.autosuggestion.AbstractTest;
import com.convit.autosuggestion.sec01.entity.Customer;
import com.convit.autosuggestion.sec01.entity.Movie;
import com.convit.autosuggestion.sec01.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;

@Slf4j
public class IndexOperationsTest extends AbstractTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void createIndex() {
        var indexOperations = this.elasticsearchOperations.indexOps(IndexCoordinates.of("albums"));
        Assertions.assertTrue(indexOperations.create());
        this.verify(indexOperations, 1, 1);
    }

    @Test
    public void createIndexWithSettings(){
        var indexOperations = this.elasticsearchOperations.indexOps(Review.class);
        Assertions.assertTrue(indexOperations.create());
        this.verify(indexOperations, 2, 2);
    }

    @Test
    public void createIndexWithSettingsAndMappings(){
        var indexOperations = this.elasticsearchOperations.indexOps(Customer.class);
        Assertions.assertTrue(indexOperations.createWithMapping());
        this.verify(indexOperations, 3, 0);
    }

    @Test
    public void createIndexWithFieldMappings(){
        var indexOperations = this.elasticsearchOperations.indexOps(Movie.class);
        Assertions.assertTrue(indexOperations.createWithMapping());
        this.verify(indexOperations, 1, 1);
    }

    private void verify(IndexOperations indexOperations, int expectedShards, int expectedReplicas){
        var settings =  indexOperations.getSettings();
        log.info("settings: {}", settings);
        log.info("mapping: {}", indexOperations.getMapping());

        Assertions.assertEquals(String.valueOf(expectedShards), settings.get("index.number_of_shards"));
        Assertions.assertEquals(String.valueOf(expectedReplicas), settings.get("index.number_of_replicas"));

        // delete the index
        Assertions.assertTrue(indexOperations.delete());
    }
}
