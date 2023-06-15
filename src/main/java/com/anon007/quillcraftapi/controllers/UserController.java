package com.anon007.quillcraftapi.controllers;

import com.anon007.quillcraftapi.payloads.APIResponse;
import com.anon007.quillcraftapi.payloads.UserDTO;
import com.anon007.quillcraftapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user, @PathVariable("userId") UUID user_id) {

        UserDTO updateUserDTO = this.userService.updateUser(user, user_id);


        return ResponseEntity.ok(updateUserDTO);
    }

    @DeleteMapping("/{userId}")
    public APIResponse deleteUser(@PathVariable UUID userId) {
        this.userService.deleteUser(userId);


        return new APIResponse("User deleted successfully", true, HttpStatus.OK.value());

    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") UUID userId) {
        UserDTO userDTO = this.userService.getUserByID(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
