package com.orsys.formation.controllers;

import com.orsys.formation.dto.request.BookRequestDTO;
import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.models.Category;
import com.orsys.formation.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getCtagories() {
        try {
            return new ResponseEntity<List<Category>>(categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        try {
             return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
