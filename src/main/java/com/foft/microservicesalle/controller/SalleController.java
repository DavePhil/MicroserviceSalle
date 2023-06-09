package com.foft.microservicesalle.controller;

import com.foft.microservicesalle.modele.Salle;
import com.foft.microservicesalle.repository.SalleRepository;
import com.foft.microservicesalle.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class SalleController {
    

    @Autowired
    private SalleService salleService;

    @PostMapping("/Salle")
    public Salle createSalle(@RequestBody Salle salle) {
        return salleService.saveSalle(salle);
    }

    @GetMapping("/Salle/{id}")
    public Salle getSalle(@PathVariable("id") final Integer id) {
        Optional<Salle> salle = salleService.getSalle(id);
        if (salle.isPresent()) {
            return salle.get();
        } else {
            return null;
        }
    }

    @GetMapping("/Salle")
    public Iterable<Salle> getSalles() {
        return salleService.getSalles();
    }

    @DeleteMapping("/Salle/{id}")
    public void deleteSalle(@PathVariable("id") final Integer id) {
        salleService.deleteSalle(id);
    }

}
