package com.anon007.quillcraftapi.repositories;

import com.anon007.quillcraftapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
