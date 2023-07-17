package com.anon007.quillcraftapi.repositories;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import com.anon007.quillcraftapi.entities.PostEntity;
import com.anon007.quillcraftapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findByUser(UserEntity user);

    List<PostEntity> findByCategory(CategoryEntity user);
}
