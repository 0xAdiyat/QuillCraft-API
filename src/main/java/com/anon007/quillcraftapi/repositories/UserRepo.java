package com.anon007.quillcraftapi.repositories;

import com.anon007.quillcraftapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<UserEntity, UUID> {

}
