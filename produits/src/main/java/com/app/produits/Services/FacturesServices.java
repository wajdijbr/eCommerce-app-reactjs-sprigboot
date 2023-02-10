package com.app.produits.Services;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.app.produits.Entities.Factures;

public interface FacturesServices {

    Factures saveFactures(Factures factures);

    Factures updateFactures(Factures factures);
    void deleteFactures(Factures factures);
    void deleteFacturesById(Long id);
    Factures getFactures(Long id) throws NotFoundException;
    List<Factures> getAllFactures();
}
