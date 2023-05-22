package com.foft.microservicesalle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foft.microservicesalle.modele.Salle;

public interface SalleRepository extends JpaRepository<Salle, Integer> {}
