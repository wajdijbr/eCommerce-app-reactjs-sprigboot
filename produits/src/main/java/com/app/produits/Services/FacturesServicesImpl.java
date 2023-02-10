package com.app.produits.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.app.produits.Entities.Factures;
import com.app.produits.Repos.FacturesRepository;

import java.util.List;
@Service
public class FacturesServicesImpl implements FacturesServices{
    @Autowired
    FacturesRepository facturesRepository;
    @Override
    public Factures saveFactures(Factures factures) {
        return facturesRepository.save(factures);

    }

    @Override
    public Factures updateFactures(Factures factures) {
        return facturesRepository.save(factures);
    }
    @Override
    public void deleteFactures(Factures factures) {
        facturesRepository.delete(factures);
    }
    @Override
    public void deleteFacturesById(Long id) {
        facturesRepository.deleteById(id);
    }
    @Override
    public Factures getFactures(Long id) throws NotFoundException {
        Factures prod = facturesRepository.findById(id).get();
        if(prod  ==  null) throw new NotFoundException();
        return prod;
    }

    @Override
    public List<Factures> getAllFactures() {
        return facturesRepository.findAll();
    }



}
