package com.tripshots.postsservice.repositories;

import com.tripshots.postsservice.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostsRepository extends CrudRepository<Post, Long> {
    List<Post> findPostsByUsername(String username);
    List<Post> findPostsByPlaceId(Long placeId);
}
