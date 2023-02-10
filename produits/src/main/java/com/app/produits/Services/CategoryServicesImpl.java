package com.app.produits.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.app.produits.Entities.Category;
import com.app.produits.Repos.CategoryRepository;

import java.util.List;
@Service
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category cat) {
        return categoryRepository.save(cat);

    }

    @Override
    public Category updateCategory(Category cat) {
        return categoryRepository.save(cat);
    }
    @Override
    public void deleteCategory(Category cat) {
        categoryRepository.delete(cat);
    }
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
    @Override
    public Category getCategory(Long id) throws NotFoundException {
        Category prod = categoryRepository.findById(id).get();
        if(prod  ==  null) throw new NotFoundException();
        return prod;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }



}
