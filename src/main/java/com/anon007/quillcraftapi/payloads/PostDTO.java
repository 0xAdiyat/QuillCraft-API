package com.anon007.quillcraftapi.payloads;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import com.anon007.quillcraftapi.entities.UserEntity;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class PostDTO {

    private Integer postId;
    @NotEmpty(message = "Post title cannot be empty")
    private String title;

    private String content;
    private String imageName;
    private Date addedDate;

    private UserEntity user;
    private CategoryEntity category;

    public PostDTO() {
    }

    public PostDTO(Integer postId, String title, String content, String imageName, Date addedDate, UserEntity user, CategoryEntity category) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.addedDate = addedDate;
        this.user = user;
        this.category = category;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
