package com.app.produits.Repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.produits.Entities.Commandes;

@RepositoryRestResource
public interface CommandesRepository extends JpaRepository<Commandes, Long> {
     public List<Commandes> findAll();

}
