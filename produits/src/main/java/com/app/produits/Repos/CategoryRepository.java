package com.app.produits.Repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.produits.Entities.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAll();



    public static Category saveCategory(Category category) {
        return null;
    }

}
