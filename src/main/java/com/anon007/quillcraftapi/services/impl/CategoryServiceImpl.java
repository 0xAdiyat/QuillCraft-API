package com.anon007.quillcraftapi.services.impl;

import com.anon007.quillcraftapi.entities.CategoryEntity;
import com.anon007.quillcraftapi.exceptions.ResourceNotFoundException;
import com.anon007.quillcraftapi.payloads.CategoryDTO;
import com.anon007.quillcraftapi.repositories.CategoryRepo;
import com.anon007.quillcraftapi.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity category = categoryDTOToEntityMM(categoryDTO);
        CategoryEntity createdCategory = this.categoryRepo.save(category);

        return categoryEntityToDTOMM(createdCategory);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        CategoryEntity category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        CategoryEntity updatedCategory = this.categoryRepo.save(category);
        return categoryEntityToDTOMM(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        CategoryEntity category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        CategoryEntity category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        return categoryEntityToDTOMM(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return this.categoryRepo.findAll()
                .stream()
                .map(this::categoryEntityToDTOMM)
                .toList();

    }

    private CategoryEntity categoryDTOToEntityMM(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }

    private CategoryDTO categoryEntityToDTOMM(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }
}
