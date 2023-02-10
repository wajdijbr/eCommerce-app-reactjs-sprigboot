package com.app.produits.Repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.produits.Entities.Factures;

@RepositoryRestResource
public interface FacturesRepository extends JpaRepository<Factures, Long> {
     public List<Factures> findAll();

}
