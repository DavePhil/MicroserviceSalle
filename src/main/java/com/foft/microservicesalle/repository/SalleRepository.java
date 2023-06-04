package com.foft.microservicesalle.repository;

import com.foft.microservicesalle.modele.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Integer> {}
