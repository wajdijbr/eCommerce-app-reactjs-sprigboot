package com.app.produits.Services;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.app.produits.Entities.Produit;

public interface ProduitServices {

    Produit saveProduit(Produit p);

    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id) throws NotFoundException;
    List<Produit> getAllProduits();
}
