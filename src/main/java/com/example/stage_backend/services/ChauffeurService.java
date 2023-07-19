package com.example.stage_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage_backend.dao.ChauffeurRepository;
import com.example.stage_backend.entities.Chauffeur;
import com.example.stage_backend.interfaces.IChauffeur;


@Service
public class ChauffeurService implements IChauffeur {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public List<Chauffeur> getAll() {
        return chauffeurRepository.findAll();
    }

    @Override
    public Optional<Chauffeur> getChauffeurById(Long id) {
        return chauffeurRepository.findById(id);
    }

    @Override
    public List<Chauffeur> getAllChauffeurEtatActiver() {
        return chauffeurRepository.findByEtat("activer");
    }

    @Override
    public List<Chauffeur> getAllChauffeurEtatArchiver() {
        return chauffeurRepository.findByEtat("archiver");
    }

    @Override
    public void saveChauffeur(Chauffeur chauffeur) {
        chauffeurRepository.save(chauffeur);
    }

    @Override
    public void updateChauffeur(Long id, Chauffeur chauffeur) {
        Chauffeur existingChauffeur = chauffeurRepository.findById(id).orElse(null);

        if (existingChauffeur != null) {
            existingChauffeur.setNom(chauffeur.getNom());
            existingChauffeur.setPrenom(chauffeur.getPrenom());
            existingChauffeur.setNum(chauffeur.getNum());
            existingChauffeur.setEmail(chauffeur.getEmail());
            chauffeurRepository.save(existingChauffeur);
        } else {
            throw new IllegalArgumentException("La chauffeur avec l'ID " + id + " n'existe pas.");
        }
    }

    @Override
    public void archiverChauffeur(Long chauffeurId) {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElse(null);

        if (chauffeur != null) {
            chauffeur.setEtat("archiver");
            chauffeurRepository.save(chauffeur);
        } else {
            throw new IllegalArgumentException("La chauffeur avec l'ID " + chauffeurId + " n'existe pas.");
        }
    }

    @Override
    public void activerChauffeur(Long chauffeurId) {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElse(null);

        if (chauffeur != null) {
            chauffeur.setEtat("activer");
            chauffeurRepository.save(chauffeur);
        } else {
            throw new IllegalArgumentException("La chauffeur avec l'ID " + chauffeurId + " n'existe pas.");
        }
    }

    @Override
    public void deleteChauffeur(Long chauffeurId) {
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElse(null);

        if (chauffeur != null) {
            chauffeurRepository.delete(chauffeur);
        } else {
            throw new IllegalArgumentException("La chauffeur avec l'ID " + chauffeurId + " n'existe pas.");
        }
    }
}