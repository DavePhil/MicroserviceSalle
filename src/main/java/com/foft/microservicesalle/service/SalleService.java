package com.foft.microservicesalle.service;

import com.foft.microservicesalle.modele.Salle;
import com.foft.microservicesalle.repository.SalleRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Data
@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    public Optional<Salle> getSalle(Integer id){
        return salleRepository.findById(id);
    }

    public Iterable<Salle> getSalles(){
        return salleRepository.findAll();
    }

    public void deleteSalle (int id){
       try {salleRepository.deleteById(id);}
       catch (Exception e){ }
    }


    public Salle saveSalle (Salle specialite){
        Salle saved = salleRepository.save(specialite);
        return saved;
    }

    public Salle saveSalleToDB(String name)
    {
        Salle salle = new Salle();
        salle.setNom(name);

        salleRepository.save(salle);


        return salle;
    }


    public void updateinformation(int id,String name)
{
    Salle del=new Salle();
    del=salleRepository.findById(id).get();
        del.setNom(name);
    salleRepository.save(del);
}
}
