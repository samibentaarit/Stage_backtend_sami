package com.example.stage_backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stage_backend.entities.Bus;



@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByEtat(String etat);
    // Ajoutez ici des méthodes personnalisées si nécessaire
}
