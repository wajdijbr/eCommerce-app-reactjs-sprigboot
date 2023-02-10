package com.app.produits.Services;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.app.produits.Entities.Commandes;

public interface CommandesServices {

    Commandes saveCommandes(Commandes commandes);

    Commandes updateCommandes(Commandes commandes);
    void deleteCommandes(Commandes commandes);
    void deleteCommandesById(Long id);
    Commandes getCommandes(Long id) throws NotFoundException;
    List<Commandes> getAllCommandes();
}
