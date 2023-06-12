package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.UserEntity;
import com.anon007.quillcraftapi.exceptions.ResourceNotFoundException;
import com.anon007.quillcraftapi.payloads.UserDTO;
import com.anon007.quillcraftapi.repositories.UserRepo;
import com.anon007.quillcraftapi.services.UserService;
import com.anon007.quillcraftapi.utils.conversation.ConversationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.anon007.quillcraftapi.utils.conversation.ConversationUtils.dtoToUserEntity;
import static com.anon007.quillcraftapi.utils.conversation.ConversationUtils.userEntityToDTO;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = dtoToUserEntity(userDTO);
        UserEntity savedUser = this.userRepo.save(userEntity);


        return userEntityToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {

        UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        userEntity.setName(userDTO.getName());
        userEntity.setBio(userDTO.getBio());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());

        UserEntity updatedUser = this.userRepo.save(userEntity);

        return userEntityToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {

        UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        this.userRepo.delete(userEntity);
    }

    @Override
    public UserDTO getUserByID(Long userId) {
        UserEntity userEntity = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        return userEntityToDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepo.findAll().stream().map(ConversationUtils::userEntityToDTO).collect(Collectors.toList());
    }


}
