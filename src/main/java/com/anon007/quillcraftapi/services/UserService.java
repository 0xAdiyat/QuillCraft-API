package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO user, String userId);

    void deleteUser(String userId);

    UserDTO getUserByID(String userId);

    List<UserDTO> getAllUsers();


}
