package com.app.produits.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.app.produits.Entities.Commandes;
import com.app.produits.Services.CommandesServices;

import java.util.List;
@RestController

@RequestMapping("/commandes")
@CrossOrigin("*")
public class ControllerCommandes {
    @Autowired
    private CommandesServices services;

    @RequestMapping(method = RequestMethod.GET)
    public List<Commandes> getAllCommandes() {
        return services.getAllCommandes();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Commandes getCommandesById(@PathVariable("id") Long id) throws NotFoundException
    {
        return services.getCommandes(id);
    }
    


    @RequestMapping(method = RequestMethod.POST)
    public Commandes createCommandes(@RequestBody Commandes commandes) {
        return services.saveCommandes(commandes) ;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Commandes updateCommandes(@RequestBody Commandes commandes) {
        return services.updateCommandes(commandes);

    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteCommandes(@PathVariable("id") Long id)
    {
        Commandes prod = null;
        try {
            prod = services.getCommandes(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Get produit");
        }
        services.deleteCommandes(prod);
    }



}