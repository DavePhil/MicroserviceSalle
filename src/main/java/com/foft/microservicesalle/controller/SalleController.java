package com.foft.microservicesalle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foft.microservicesalle.modele.Salle;
import com.foft.microservicesalle.repository.SalleRepository;
import com.foft.microservicesalle.service.SalleService;


@RestController
public class SalleController {
    

    @Autowired
    private SalleService salleService;
    @Autowired
    private SalleRepository salleRepository;

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

    /*-----------------------------------> FAT<-------------------------------------*/
    @GetMapping("/ListSalle")
    public String allEnseigant(Model model) //, @PathVariable("id") int id)
    {

        List<Salle> salles = salleRepository.findAll();
        model.addAttribute("sales", salles);


//niveauService.CreateNiveauToDB(code);// PostMapping
        return "salle.html";

    }
    @PostMapping("/Createsalle")
    public String  CreatSalle(Model model,@RequestParam("nom") String nom)//,@PathVariable("id") int id)
    {//model.addAttribute("userid", id);
        salleService.saveSalleToDB(nom);
        return "redirect:/ListSalle";
    }

    @GetMapping("/deleteSalle/{id}")
    public String deleteSalles(@PathVariable("id") int id)
    {

        salleService.deleteSalle(id);
        return "redirect:/ListSalle";
    }


    @PostMapping("/ChangeSalle/{id}")
    public String changeDelegueAll(
                            @PathVariable("id") int id,
                            @RequestParam("nom") String nom
    )
       { salleService.updateinformation(id, nom);
        // la page en question return "redirect:/listProducts.html";
        return "redirect:/ListDelegue";
    }
}
