package com.app.produits.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.app.produits.Entities.Category;
import com.app.produits.Services.CategoryServices;
import java.util.List;
@RestController

@RequestMapping("/category")
@CrossOrigin("*")
public class ControllerCategory {
    @Autowired
    private CategoryServices services;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return services.getAllCategory();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("id") Long id) throws NotFoundException
    {
        return services.getCategory(id);
    }
    


    @RequestMapping(method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category) {
        return services.saveCategory(category) ;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Category updateCategory(@RequestBody Category category) {
        return services.updateCategory(category);

    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("id") Long id)
    {
        Category prod = null;
        try {
            prod = services.getCategory(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Get produit");
        }
        services.deleteCategory(prod);
    }



}