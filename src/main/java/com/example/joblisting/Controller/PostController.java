package com.example.joblisting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.joblisting.repository.SearchRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.joblisting.Model.Post;
import com.example.joblisting.repository.PostRepository;

import javax.validation.Valid;


@RestController
public class PostController {

    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;

    // Hide this endpoint from Swagger UI
    @ApiIgnore
    @RequestMapping(value="/")
    public void redirectToSwagger(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/swagger-ui.html");
    }
    // Show all posts in Swagger
    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
    // Show paginated posts in Swagger
    /**
        * Returns paginated list of posts.
        * Example: GET /posts/page?page=0&size=10&sort=exp,desc
    */
    @io.swagger.annotations.ApiImplicitParams({
        @io.swagger.annotations.ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
        value = "Page number (0..N)"),
        @io.swagger.annotations.ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
        value = "Number of records per page"),
        @io.swagger.annotations.ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
        value = "Sorting criteria in the format: property,(asc|desc)")
    })


    @GetMapping("/api/posts/page")
    public Page<Post> getPostsPage(
        @PageableDefault(size = 10, sort = "exp", direction = Sort.Direction.DESC)
        Pageable pageable) {
        return repo.findAll(pageable);
    }


    @GetMapping("/api/posts/{text}")
    public List<Post> search(@PathVariable String text){

        return srepo.findByText(text);

    }

    @PostMapping("/api/post")    //@PostMapping annotation to handle POST HTTP requests
    public Post addPost(@Valid@RequestBody Post post) {  //@RequestBody annotation to bind the HTTP request body to a transfer or domain object
        return repo.save(post);  // Save the post to the database and return the saved post

    }
}
