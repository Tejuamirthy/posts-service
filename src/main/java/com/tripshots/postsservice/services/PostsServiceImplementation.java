package com.tripshots.postsservice.services;

import com.tripshots.postsservice.entity.Itinerary;
import com.tripshots.postsservice.entity.Post;
import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.exceptions.PostAlreadyExists;
import com.tripshots.postsservice.exceptions.PostNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.model.PostDTO;
import com.tripshots.postsservice.repositories.ItineraryRepository;
import com.tripshots.postsservice.repositories.PostsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImplementation implements PostsService {

    @Autowired
    private PostsRepository postsRepository;


    @Override
    public List<PostDTO> getAllPosts(String username) throws PostNotFound {
        List<Post> posts = postsRepository.findPostsByUsername(username);

        if (posts == null || posts.size() == 0)
            throw new PostNotFound("No posts found for: "+username);
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post: posts
             ) {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post,postDTO);
            postDTOs.add(postDTO);
        }
        return  postDTOs;
    }

    @Override
    public List<PostDTO> getPostsByPlaceId(Long placeId) throws PostNotFound {
        List<Post> posts = postsRepository.findPostsByPlaceId(placeId);
        if(posts == null || posts.size() == 0) {
            throw new PostNotFound("No posts found for given place");
        }
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post: posts) {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

    @Override
    public PostDTO getPost(Long postId) throws PostNotFound {
        Optional<Post> post = postsRepository.findById(postId);
        if (post.isPresent()) {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post.get(), postDTO);
            return postDTO;
        }
        throw new PostNotFound("Post not found");
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) throws PostAlreadyExists {
        if (postsRepository.existsById(postDTO.getId()))
            throw new PostAlreadyExists("Post Already Exists");
        Post post = new Post();
        BeanUtils.copyProperties(postDTO,post);
        postsRepository.save(post);
        return postDTO;
    }

    @Override
    public PostDTO deletePost(PostDTO postDTO) throws PostNotFound {
        postNotFoundErrorFromId(postDTO.getId(),"Failed to delete.");
        postsRepository.deleteById(postDTO.getId());
        return postDTO;
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) throws PostNotFound {
        postNotFoundErrorFromId(postDTO.getId(),"Failed to update.");
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        postsRepository.save(post);
        return postDTO;
    }

    private void postNotFoundErrorFromId(Long postId, String errorMessage) throws PostNotFound {
        if(!postsRepository.existsById(postId))
            throw new PostNotFound(errorMessage+" Post Not Found.");
    }


}
