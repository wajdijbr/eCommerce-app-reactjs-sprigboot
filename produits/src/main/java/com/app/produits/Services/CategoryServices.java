package com.app.produits.Services;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.app.produits.Entities.Category;

public interface CategoryServices {

    Category saveCategory(Category cat);

    Category updateCategory(Category cat);
    void deleteCategory(Category cat);
    void deleteCategoryById(Long id);
    Category getCategory(Long id) throws NotFoundException;
    List<Category> getAllCategory();
}
