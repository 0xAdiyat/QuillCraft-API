package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO user, Long userUniqueId);

    void deleteUser(Long userId);

    UserDTO getUserByID(Long userId);

    List<UserDTO> getAllUsers();


}
