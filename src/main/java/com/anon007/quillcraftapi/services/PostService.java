package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.PostDTO;

import java.util.List;

public interface PostService {


    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    PostDTO getPostById(Integer postId);

    List<PostDTO> getAllPosts();
}
