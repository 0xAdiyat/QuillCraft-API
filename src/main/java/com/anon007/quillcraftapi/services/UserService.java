package com.anon007.quillcraftapi.services;

import com.anon007.quillcraftapi.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Integer userId);

    void deleteUser(Integer userId);

    UserDTO getUserByID(Integer userId);

    List<UserDTO> getAllUsers();


}
