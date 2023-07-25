package com.anon007.quillcraftapi.payloads;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import com.anon007.quillcraftapi.entities.UserEntity;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class PostDTO {

    @NotEmpty(message = "Post title cannot be empty")
    private String title;

    private String content;
    private String imageName = "default.png";
    private Date addedDate;


    public PostDTO() {
    }

    public PostDTO(String title, String content, String imageName, Date addedDate, UserEntity user, CategoryEntity category) {
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.addedDate = addedDate;

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


}
