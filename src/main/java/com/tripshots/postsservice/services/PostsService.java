package com.tripshots.postsservice.services;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.exceptions.PostAlreadyExists;
import com.tripshots.postsservice.exceptions.PostNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.model.PostDTO;

import java.util.List;

public interface PostsService {
    List<PostDTO> getAllPosts(String Username) throws PostNotFound;
    List<PostDTO> getPostsByPlaceId(Long placeId) throws PostNotFound;

    PostDTO getPost(Long postId) throws PostNotFound;
    PostDTO createPost(PostDTO postDTO) throws PostAlreadyExists;
    PostDTO deletePost(PostDTO postDTO) throws PostNotFound;
    PostDTO updatePost(PostDTO postDTO) throws PostNotFound;

}
