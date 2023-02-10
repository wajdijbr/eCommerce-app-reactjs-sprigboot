package com.app.produits.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.app.produits.Entities.Commandes;
import com.app.produits.Repos.CommandesRepository;

import java.util.List;
@Service
public class CommandesServicesImpl implements CommandesServices{
    @Autowired
    CommandesRepository commandesRepository;
    @Override
    public Commandes saveCommandes(Commandes commandes) {
        return commandesRepository.save(commandes);

    }

    @Override
    public Commandes updateCommandes(Commandes commandes) {
        return commandesRepository.save(commandes);
    }
    @Override
    public void deleteCommandes(Commandes commandes) {
        commandesRepository.delete(commandes);
    }
    @Override
    public void deleteCommandesById(Long id) {
        commandesRepository.deleteById(id);
    }
    @Override
    public Commandes getCommandes(Long id) throws NotFoundException {
        Commandes prod = commandesRepository.findById(id).get();
        if(prod  ==  null) throw new NotFoundException();
        return prod;
    }

    @Override
    public List<Commandes> getAllCommandes() {
        return commandesRepository.findAll();
    }



}
