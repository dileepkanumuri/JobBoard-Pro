package com.example.joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.example.joblisting.Model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    private MongoClient client;          // <-- field injection (or use constructor injection)

    @Autowired
    private MongoConverter converter;    // <-- import org.springframework.data.mongodb.core.convert.MongoConverter

    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts = new ArrayList<>();

        // Use your actual database/collection names
        MongoDatabase db = client.getDatabase("ProjectJob");
        MongoCollection<Document> collection = db.getCollection("JobPost");

        // Atlas Search pipeline (requires an Atlas Search index)
        AggregateIterable<Document> result = collection.aggregate(
            Arrays.asList(
                new Document("$search",
                    new Document("text",
                        new Document("query", text)
                            .append("path", Arrays.asList("techs", "desc", "profile"))
                    )
                ),
                new Document("$sort", new Document("exp", 1L)),
                new Document("$limit", 5L)
            )
        );

        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }
}
