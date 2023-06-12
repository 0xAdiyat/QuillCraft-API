package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.UserEntity;
import com.anon007.quillcraftapi.payloads.UserDTO;
import com.anon007.quillcraftapi.repositories.UserRepo;
import com.anon007.quillcraftapi.services.UserService;

import java.util.List;

import static com.anon007.quillcraftapi.utils.conversation.ConversationUtils.dtoToUserEntity;
import static com.anon007.quillcraftapi.utils.conversation.ConversationUtils.userEntityToDTO;

public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO createUser(UserDTO user) {

        UserEntity userEntity = dtoToUserEntity(user);
        UserEntity savedUser = userRepo.save(userEntity);
        

        return userEntityToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO user, Integer userId) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public UserDTO getUserByID(Integer userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }


}
