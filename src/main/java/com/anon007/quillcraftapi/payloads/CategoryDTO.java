package com.anon007.quillcraftapi.payloads;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO {
    private Integer categoryId;
    @NotEmpty(message = "Category title is required")
    private String categoryTitle;
    @NotEmpty(message = "Category description is required")
    private String categoryDescription;


    public CategoryDTO() {
    }

    public CategoryDTO(Integer categoryId, String categoryTitle, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
