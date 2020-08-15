package com.example.messenger.messenger.controller;

import com.example.messenger.messenger.model.Post;
import com.example.messenger.messenger.repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.HashSet;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper  = new ObjectMapper();

    @MockBean
    PostRepository postRepository;
    Post post1;
    Post post2;
    List<Post> postList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        post1 = new Post(1L, "tets1", "tets1", "test1", new HashSet<>());
        post2 = new Post(2L, "tets2", "tets2", "test2", new HashSet<>());
        postList.add(post1);
        postList.add(post2);
    }

    @AfterEach
    void tearDown() {
        post1 = null;
        post2 = null;
        postList.remove(post1);
        postList.remove(post2);
    }

    @Test
    void getAllPosts() throws Exception {
//        Pageable page = new PageRequest.of(0, 10,  Sort.by("name").descending());
//        Page<Post> allPost = postRepository.findAll(page);
//        Page<T> findAll(Pageable var1);
        Page<Post> sightingPageMockResponse = new PageImpl<Post>(new ArrayList<Post>());
        Pageable page = PageRequest.of(0, 10,  Sort.by(Sort.Direction.ASC, "title"));
        when(postRepository.findAll(page)).thenReturn(sightingPageMockResponse);
        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
               // .andExpect(content().contentType(MediaType.valueOf("application/json")));
               //.andExpect(jsonPath("$.content", hasSize(0)));

    }

    @Test
    void createPost() throws Exception {
        when(postRepository.save(post1)).thenReturn(post1);
        mockMvc.perform(post("/posts")
                .content(objectMapper.writeValueAsString(post1))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(1)));

    }

    @Test
    void createdPostNotValid() throws Exception {
        Post postError = new Post();
      //  when(postRepository.save(postError)).thenReturn(postError);
        mockMvc.perform(post("/posts")
                .content(objectMapper.writeValueAsString(postError))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors", hasSize(3)));

    }


    @Test
    void updatePost() throws Exception{
        when(postRepository.save(post1)).thenReturn(post2);
        when(postRepository.findById(1L)).thenReturn(Optional.of(post1));
        mockMvc.perform(put("/posts/1")
                .content(objectMapper.writeValueAsString(post1))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(2)));
               // .andExpect(jsonPath(""))


    }

    @Test
    void deletePost() throws Exception {
        when(postRepository.findById(5L)).thenReturn(Optional.of(post1));
        doNothing().when(postRepository).delete(post1);
        mockMvc.perform(delete("/posts/5"))
                .andExpect(status().isOk());
        verify(postRepository, times(1)).delete(post1);
    }
}