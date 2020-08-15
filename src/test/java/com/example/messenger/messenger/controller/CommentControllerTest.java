package com.example.messenger.messenger.controller;

import com.example.messenger.messenger.model.Comment;
import com.example.messenger.messenger.model.Post;
import com.example.messenger.messenger.repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    CommentRepository commentRepository;
    Comment comment1;
    Comment comment2;
    List<Comment> commentList = new ArrayList<>();
    Pageable pageable = PageRequest.of(0, 3, Sort.by("id"));

    @BeforeEach
    void setUp() {
        comment1 = new Comment();
        comment1.setId(1L);
        comment1.setText("Test1");
        comment1.setPost(new Post());
        comment2.setId(2L);
        comment2.setText("Text2");
        comment2.setPost(new Post());
        commentList.add(comment1);
        commentList.add(comment2);


    }

    @AfterEach
    void tearDown() {
        comment1 = null;
        comment2 = null;
        commentList.remove(comment1);
        commentList.remove(comment2);

    }

//    @Test
//    void getAllCommentsByPostId() throws Exception {
//        when(commentRepository.findByPostId(1L, pageable)).thenReturn((Page<Comment>) commentList);
//        mockMvc.perform(get("/posts/1/comments"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content", hasSize(1)));
//    }

    @Test
    void createComment() {
    }

    @Test
    void updateComment() throws Exception {
        Page<Post> sightingPageMockResponse = new PageImpl<Post>(new ArrayList<Post>());
        Pageable page = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "text"));
        when(commentRepository.save(comment1)).thenReturn(comment1);
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment1));
        mockMvc.perform(put("posts/1/comments/1")
                .content(objectMapper.writeValueAsString(comment1))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

   }

        @Test
        void deleteComment () {
        }
    }