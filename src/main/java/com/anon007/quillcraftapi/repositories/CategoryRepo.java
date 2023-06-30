package com.anon007.quillcraftapi.repositories;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
}
