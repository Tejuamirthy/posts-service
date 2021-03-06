package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.PostAlreadyExists;
import com.tripshots.postsservice.exceptions.PostNotFound;
import com.tripshots.postsservice.model.PostDTO;
import com.tripshots.postsservice.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostsController {

    static final String USER_SERVICE = "http://localhost:8080/user/";

    @Autowired
    private PostsService postsService;



    @GetMapping(path = "/{postId}")
    public PostDTO getPost(@PathVariable Long postId) throws PostNotFound {
        return postsService.getPost(postId);
    }

    @GetMapping(path = "/getAll/{username}")
    public List<PostDTO> getAllPosts(@PathVariable String username) throws PostNotFound {
        return postsService.getAllPosts(username);
    }


    @GetMapping(path = "/place/{placeId}")
    public List<PostDTO> getPostsByPlaceId(@PathVariable Long placeId) throws PostNotFound {
        return postsService.getPostsByPlaceId(placeId);
    }

    @GetMapping(path = "/rating/{rating}")
    public List<PostDTO> getPostsByRating(@PathVariable Float rating) throws PostNotFound {
        return postsService.getPostsByRating(rating);
    }

    @PostMapping(path = "", consumes = "application/json")
    public PostDTO createPost(@RequestBody PostDTO postDTO) throws PostAlreadyExists {
        return postsService.createPost(postDTO);
    }

    @DeleteMapping(path = "", consumes = "application/json")
    public PostDTO deletePost(@RequestBody PostDTO postDTO) throws PostNotFound {
        return postsService.deletePost(postDTO);
    }

    @PutMapping(path = "", consumes = "application/json")
    public PostDTO updatePost(@RequestBody PostDTO postDTO) throws PostNotFound {
        return postsService.updatePost(postDTO);
    }




}
