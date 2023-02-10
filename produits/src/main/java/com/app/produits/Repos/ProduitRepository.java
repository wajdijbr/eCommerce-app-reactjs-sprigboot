package com.app.produits.Repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.produits.Entities.Produit;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    public List<Produit> findAll();
    // @Query("SELECT u FROM Produit u WHERE u.Date = :email")
    // Produit findByDate(@Param("email") String email);
    public static Produit saveCategory(Produit produit) {
        return null;
    }
}
