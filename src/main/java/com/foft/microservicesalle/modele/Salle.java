package com.foft.microservicesalle.modele;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.*;


@Data
@Entity
@DynamicUpdate
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;




    public Salle(Integer id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
 
    }

    public Salle() {
        super();
    }


}
