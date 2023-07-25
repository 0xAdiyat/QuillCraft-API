package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.PostDTO;

import java.util.List;
import java.util.UUID;

public interface PostService {


    PostDTO createPost(PostDTO postDTO, UUID userId, Integer categoryId);

    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    PostDTO getPostById(Integer postId);

    List<PostDTO> getAllPosts();


    // Get all posts by category
    List<PostDTO> getPostsByCategory(Integer categoryId);

    // Get all posts by user
    List<PostDTO> getPostsByUser(Integer userId);

    List<PostDTO> searchPosts(String searchKeyword);

}
