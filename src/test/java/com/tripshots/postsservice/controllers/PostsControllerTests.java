package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.PostNotFound;
import com.tripshots.postsservice.model.PostDTO;
import com.tripshots.postsservice.services.PostsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsControllerTests {

    @Mock
    @Autowired
    private PostsService postsService;

    @InjectMocks
    private PostsController postsController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPostById() throws PostNotFound {
        PostDTO postDTO = getPostDTO();
        when(postsService.getPost(postDTO.getId())).thenReturn(postDTO);

        PostDTO resDTO = postsController.getPost(postDTO.getId());
        assertEquals(postDTO, resDTO);
    }

    @Test
    public void testGetPostsByUsername() throws PostNotFound {
        String username = "TestUsername";
        PostDTO postDTO = getPostDTO();
        List<PostDTO> list = new ArrayList<>();
        list.add(postDTO);
        when(postsService.getAllPosts(username)).thenReturn(list);
        List<PostDTO> resList = postsController.getAllPosts(username);
        assertEquals(list, resList);
    }

    private PostDTO getPostDTO() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(1L);
        postDTO.setPostTitle("Test Title");
        return postDTO;
    }
}
