package com.amt.controllers;

import com.amt.entities.CategoryEntity;
import com.amt.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MedMalek on 08/11/2015.
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/category")
    public @ResponseBody Iterable<CategoryEntity> getAllCategories() {
        Iterable<CategoryEntity> toReturn = categoryRepository.findAll();
        return toReturn;
    }
}
