package com.orsys.formation.services;

import com.orsys.formation.dao.CategoryDAO;
import com.orsys.formation.models.Book;
import com.orsys.formation.models.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found with ID : " + id));
    }

    @Override
    public Category addCategory(Category category) {
        return categoryDAO.save(new Category(category.getTitle()));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category myCategory = categoryDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));

        myCategory.setTitle(category.getTitle());

        return categoryDAO.save(myCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category myCategory = categoryDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));

        categoryDAO.deleteById(id);
    }

    @Override
    public void deleteCategories() {
        categoryDAO.deleteAll();
    }
}
