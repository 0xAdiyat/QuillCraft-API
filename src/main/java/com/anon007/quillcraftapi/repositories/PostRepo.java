package com.anon007.quillcraftapi.repositories;

import com.anon007.quillcraftapi.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
}
