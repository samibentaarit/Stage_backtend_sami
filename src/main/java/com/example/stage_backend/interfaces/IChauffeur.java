package com.example.stage_backend.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.stage_backend.entities.Chauffeur;


public interface IChauffeur {
    List<Chauffeur> getAll();
    Optional<Chauffeur> getChauffeurById(Long id);
    List<Chauffeur> getAllChauffeurEtatActiver();
    List<Chauffeur> getAllChauffeurEtatArchiver();
    void saveChauffeur(Chauffeur bus);
    void updateChauffeur(Long id, Chauffeur bus);
    void archiverChauffeur(Long busId);
    void activerChauffeur(Long busId);
    void deleteChauffeur(Long busId);
}
