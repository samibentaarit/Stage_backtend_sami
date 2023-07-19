package com.example.stage_backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stage_backend.entities.Chauffeur;


@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    List<Chauffeur> findByEtat(String etat);
    // Ajoutez ici des méthodes personnalisées si nécessaire
}