package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.PostEntity;
import com.anon007.quillcraftapi.exceptions.ResourceNotFoundException;
import com.anon007.quillcraftapi.payloads.PostDTO;
import com.anon007.quillcraftapi.repositories.PostRepo;
import com.anon007.quillcraftapi.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        PostEntity createdPost = this.postRepo.save(dtoToEntityMM(postDTO));
//        this.postRepo.save(modelMapper.map(postDTO, PostEntity.class));
        return entityToDTOMM(createdPost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        PostEntity post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(postDTO
                .getTitle());
        post.setContent(postDTO
                .getContent());
        post.setAddedDate(postDTO
                .getAddedDate());
        post.setImageName(postDTO
                .getImageName());
//        post.setCategory(post.getCategory());
//        post.setUser(post.getUser());
        PostEntity updatedPost = this.postRepo.save(post);
        return entityToDTOMM(updatedPost);
    }

    @Override
    public void deletePost(Integer postId) {
        this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        PostEntity post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return entityToDTOMM(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return this.postRepo.findAll()
                .stream()
                .map(this::entityToDTOMM)
                .toList();
    }

    private PostDTO entityToDTOMM(PostEntity entity) {
        return modelMapper.map(entity, PostDTO.class);
    }

    private PostEntity dtoToEntityMM(PostDTO dto) {
        return modelMapper.map(dto, PostEntity.class);
    }
}
