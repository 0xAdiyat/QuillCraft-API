package com.anon007.quillcraftapi.utils.conversation;

import com.anon007.quillcraftapi.entities.UserEntity;
import com.anon007.quillcraftapi.payloads.UserDTO;


public class ConversationUtils {

    public static UserEntity dtoToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtils.generateUUID());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setBio(userDTO.getBio());

        return userEntity;
    }

    public static UserDTO userEntityToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(UUIDUtils.generateUUID());
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setBio(userEntity.getBio());
        userDTO.setEmail(userEntity.getEmail());

        return userDTO;
    }


}
