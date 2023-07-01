package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.UserEntity;
import com.anon007.quillcraftapi.exceptions.ResourceNotFoundException;
import com.anon007.quillcraftapi.payloads.UserDTO;
import com.anon007.quillcraftapi.repositories.UserRepo;
import com.anon007.quillcraftapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity user = dtoToUserEntityMM(userDTO);
        UserEntity createdUser = this.userRepo.save(user);

        return userEntityToDTOMM(createdUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, UUID userId) {

        UserEntity user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDTO.getName());
        user.setBio(userDTO.getBio());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        UserEntity updatedUser = this.userRepo.save(user);

        return userEntityToDTOMM(updatedUser);
    }

    @Override
    public void deleteUser(UUID userId) {

        UserEntity user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);

//        this.userRepo.findById(userId).ifPresent(userRepo::delete);

    }

    @Override
    public UserDTO getUserByID(UUID userId) {
        UserEntity user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return userEntityToDTOMM(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepo.findAll()
                .stream()
                .map(this::userEntityToDTOMM)
                .toList();
    }

    private UserEntity dtoToUserEntityMM(UserDTO userDTO) {


        return modelMapper.map(userDTO, UserEntity.class);
    }

    private UserDTO userEntityToDTOMM(UserEntity userEntity) {

        return modelMapper.map(userEntity, UserDTO.class);
    }

}
