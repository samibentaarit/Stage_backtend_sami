package com.example.stage_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.stage_backend.dao.LigneRepository;
import com.example.stage_backend.entities.Ligne;

import java.util.List;
import java.util.Optional;

@Service
public class LigneService {

    private final LigneRepository ligneRepository;

    @Autowired
    public LigneService(LigneRepository ligneRepository) {
        this.ligneRepository = ligneRepository;
    }

    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    public Optional<Ligne> getLigneById(Long id) {
        return ligneRepository.findById(id);
    }

    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }

    public Ligne updateLigne(Long id, Ligne updatedLigne) {
        Optional<Ligne> existingLigne = ligneRepository.findById(id);
        if (existingLigne.isPresent()) {
            Ligne ligne = existingLigne.get();
            ligne.setNomLigne(updatedLigne.getNomLigne());
            ligne.setTypeTrajet(updatedLigne.getTypeTrajet());
            return ligneRepository.save(ligne);
        }
        return null; // You can handle error cases as needed, e.g., throw an exception.
    }

    public void deleteLigne(Long id) {
        ligneRepository.deleteById(id);
    }
    

 
    public void archiverLigne(Long ligneId) {
        Ligne ligne = ligneRepository.findById(ligneId).orElse(null);

        if (ligne != null) {
            ligne.setEtat("archiver");
            ligneRepository.save(ligne);
        } else {
            throw new IllegalArgumentException("Ligne with ID " + ligneId + " does not exist.");
        }
    }

   
    public void activerLigne(Long ligneId) {
        Ligne ligne = ligneRepository.findById(ligneId).orElse(null);

        if (ligne != null) {
            ligne.setEtat("activer");
            ligneRepository.save(ligne);
        } else {
            throw new IllegalArgumentException("Ligne with ID " + ligneId + " does not exist.");
        }
    }
    
    public List<Ligne> getAllLigneEtatActiver() {
        return ligneRepository.findByEtat("activer", Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<Ligne> getAllLigneEtatArchiver() {
        return ligneRepository.findByEtat("archiver", Sort.by(Sort.Direction.ASC, "id"));
    }
}
