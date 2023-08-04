package com.example.stage_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.stage_backend.entities.Ligne;
import com.example.stage_backend.services.LigneService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/lignes")
public class LigneController {

    private final LigneService ligneService;

    @Autowired
    public LigneController(LigneService ligneService) {
        this.ligneService = ligneService;
    }

    @GetMapping
    public List<Ligne> getAllLignes() {
        return ligneService.getAllLignes();
    }

    @GetMapping("/{id}")
    public Optional<Ligne> getLigneById(@PathVariable Long id) {
        return ligneService.getLigneById(id);
    }

    @PostMapping
    public Ligne createLigne(@RequestBody Ligne ligne) {
        return ligneService.createLigne(ligne);
    }

    @PutMapping("/{id}")
    public Ligne updateLigne(@PathVariable Long id, @RequestBody Ligne updatedLigne) {
        return ligneService.updateLigne(id, updatedLigne);
    }
    
    @PutMapping("/{id}/archiver")
    public void archiverLigne(@PathVariable("id") Long id) {
    	ligneService.archiverLigne(id);
    }

    @PutMapping("/{id}/activer")
    public void activerLigne(@PathVariable("id") Long id) {
    	ligneService.activerLigne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLigne(@PathVariable Long id) {
        ligneService.deleteLigne(id);
    }
    @GetMapping("/activer")
    public List<Ligne> getAllLigneEtatActiver() {
        return ligneService.getAllLigneEtatActiver();
    }
    @GetMapping("/archiver")
    public List<Ligne> getAllLigneEtatArchiver() {
        return ligneService.getAllLigneEtatArchiver();
    }
}
