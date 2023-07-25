package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import com.anon007.quillcraftapi.entities.PostEntity;
import com.anon007.quillcraftapi.entities.UserEntity;
import com.anon007.quillcraftapi.exceptions.ResourceNotFoundException;
import com.anon007.quillcraftapi.payloads.PostDTO;
import com.anon007.quillcraftapi.repositories.CategoryRepo;
import com.anon007.quillcraftapi.repositories.PostRepo;
import com.anon007.quillcraftapi.repositories.UserRepo;
import com.anon007.quillcraftapi.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo, CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO, UUID userId, Integer categoryId) {

        UserEntity user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        CategoryEntity category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        PostEntity post = dtoToEntityMM(postDTO);

        post.setImageName("myImage.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        PostEntity createPost = this.postRepo.save(dtoToEntityMM(postDTO));

//        this.postRepo.save(modelMapper.map(postDTO, PostEntity.class));
        return entityToDTOMM(createPost);
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

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDTO> searchPosts(String searchKeyword) {
        return null;
    }

    private PostDTO entityToDTOMM(PostEntity entity) {
        return modelMapper.map(entity, PostDTO.class);
    }

    private PostEntity dtoToEntityMM(PostDTO dto) {
        return modelMapper.map(dto, PostEntity.class);
    }
}
