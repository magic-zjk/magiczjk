package top.magiczjk.mongodb;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ConditionalOnClass(Mongo.class)
public class MorphiaFactory {

    @Autowired
    private Mongo mongo;

    @Autowired
    MongoProperties mongoProperties;

    @Bean
    public Datastore dataStore() {
        Morphia morphia = new Morphia();
        return morphia.createDatastore((MongoClient) mongo,mongoProperties.getDatabase());
    }
}