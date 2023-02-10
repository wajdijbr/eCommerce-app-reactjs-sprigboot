package com.app.produits.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.app.produits.Entities.Factures;
import com.app.produits.Services.FacturesServices;

import java.util.List;
@RestController

@RequestMapping("/factures")
@CrossOrigin("* ")
public class ControllerFactures {
    @Autowired
    private FacturesServices services;

    @RequestMapping(method = RequestMethod.GET)
    public List<Factures> getAllFactures() {
        return services.getAllFactures();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Factures getFacturesById(@PathVariable("id") Long id) throws NotFoundException
    {
        return services.getFactures(id);
    }
    


    @RequestMapping(method = RequestMethod.POST)
    public Factures createFactures(@RequestBody Factures factures) {
        return services.saveFactures(factures) ;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Factures updateFactures(@RequestBody Factures factures) {
        return services.updateFactures(factures);

    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteFactures(@PathVariable("id") Long id)
    {
        Factures prod = null;
        try {
            prod = services.getFactures(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Get Factures");
        }
        services.deleteFactures(prod);
    }



}