package com.anon007.quillcraftapi.controllers;


import com.anon007.quillcraftapi.payloads.APIResponse;
import com.anon007.quillcraftapi.payloads.CategoryDTO;
import com.anon007.quillcraftapi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public APIResponse createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = this.categoryService.createCategory(categoryDTO);
        return new APIResponse("Category created", true, HttpStatus.CREATED.value());
    }

    @PostMapping("/{categoryId}")
    public APIResponse updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer categoryId) {
        CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDTO, categoryId);
        return new APIResponse("Category updated for " + updatedCategory, true, HttpStatus.OK.value());
    }

    @DeleteMapping("/{categoryId}")
    public APIResponse deleteCategory(@PathVariable Integer categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new APIResponse("Deleted category: " + categoryId, true, HttpStatus.OK.value());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId) {
        CategoryDTO getCategory = this.categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(getCategory);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> allCategories = this.categoryService.getAllCategories();

        return ResponseEntity.ok(allCategories);
    }

}
