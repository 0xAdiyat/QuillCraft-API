package com.anon007.quillcraftapi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class UserDTO {
    private UUID id;
    @NotEmpty
    @Size(min = 4, message = "Username must be minimum 4 characters long")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty(message = "Password can't be empty")
    @Size(min = 6, max = 10, message = "Password must be min of 3 chars and max of 15 chars long")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,32}$", message = "Password must meet the following criteria: at least one digit, one lowercase letter, one uppercase letter, and one special character")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit"),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "(?=.*[^A-Za-z0-9]).+", message = "Password must contain at least one special character")
    })
    private String password;
    @NotEmpty
    private String bio;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
