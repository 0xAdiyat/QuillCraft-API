package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO user, UUID userId);

    void deleteUser(UUID userId);

    UserDTO getUserByID(UUID userId);

    List<UserDTO> getAllUsers();


}
