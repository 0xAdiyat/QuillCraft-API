package com.anon007.quillcraftapi.controllers;


import com.anon007.quillcraftapi.payloads.APIResponse;
import com.anon007.quillcraftapi.payloads.CategoryDTO;
import com.anon007.quillcraftapi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public APIResponse createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = this.categoryService.createCategory(categoryDTO);
        return new APIResponse("Category created", true, HttpStatus.CREATED.value());
    }
}
