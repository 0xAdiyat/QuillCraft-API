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

        UserEntity user = dtoToUserEntity(userDTO);
        UserEntity savedUser = this.userRepo.save(user);

        return userEntityToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userId) {

        UserEntity user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        user.setName(userDTO.getName());
        user.setBio(userDTO.getBio());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        UserEntity updatedUser = this.userRepo.save(user);

        return userEntityToDTO(updatedUser);
    }

    @Override
    public void deleteUser(String userId) {

        UserEntity user = this.userRepo.findByStringId(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        this.userRepo.delete(user);

//        this.userRepo.findById(userId).ifPresent(userRepo::delete);

    }

    @Override
    public UserDTO getUserByID(String userId) {
        UserEntity user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
        return userEntityToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepo.findAll().stream().map(ConversationUtils::userEntityToDTO).collect(Collectors.toList());
    }


}
