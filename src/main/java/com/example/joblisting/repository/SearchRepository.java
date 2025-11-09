package com.example.joblisting.repository;
import com.example.joblisting.Model.Post;
import java.util.List;

public interface SearchRepository {
    // Define custom search methods here

    List<Post> findByText(String text);


}   