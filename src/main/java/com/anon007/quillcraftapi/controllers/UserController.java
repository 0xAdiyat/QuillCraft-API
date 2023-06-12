package com.anon007.quillcraftapi.controllers;

import com.anon007.quillcraftapi.payloads.APIResponse;
import com.anon007.quillcraftapi.payloads.UserDTO;
import com.anon007.quillcraftapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }

    // Put update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user, @PathVariable("userId") String user_id) {

        UserDTO updateUserDTO = this.userService.updateUser(user, user_id);

//        return new ResponseEntity<>(updateUserDTO, HttpStatus.ACCEPTED);

        return ResponseEntity.ok(updateUserDTO);
    }

    // delete - delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);

//        return new ResponseEntity(Map.of("message", "user deleted successfully"), HttpStatus.OK);
        return new ResponseEntity(new APIResponse("User" + userId + "deleted successfully", true), HttpStatus.OK);

    }

    //get - user get

}
