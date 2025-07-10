package com.orsys.formation.services;

import com.orsys.formation.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryById(Long id);

    Category addCategory(Category book);

    Category updateCategory(Category book, Long id);

    void deleteCategoryById(Long id);

    void deleteCategories();

}
