package com.example.stage_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.stage_backend.entities.AffectationLigneBus;
import com.example.stage_backend.services.AffectationLigneBusService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/affectations")
public class AffectationLigneBusController {

    private final AffectationLigneBusService affectationLigneBusService;

    @Autowired
    public AffectationLigneBusController(AffectationLigneBusService affectationLigneBusService) {
        this.affectationLigneBusService = affectationLigneBusService;
    }

    @GetMapping
    public List<AffectationLigneBus> getAllAffectations() {
        return affectationLigneBusService.getAllAffectations();
    }

    @GetMapping("/{id}")
    public Optional<AffectationLigneBus> getAffectationById(@PathVariable Long id) {
        return affectationLigneBusService.getAffectationById(id);
    }

    @PostMapping
    public AffectationLigneBus createAffectation(@RequestBody AffectationLigneBus affectationLigneBus) {
        return affectationLigneBusService.createAffectation(affectationLigneBus);
    }

    @PutMapping("/{id}")
    public AffectationLigneBus updateAffectation(@PathVariable Long id, @RequestBody AffectationLigneBus updatedAffectation) {
        return affectationLigneBusService.updateAffectation(id, updatedAffectation);
    }

    
    @PutMapping("/{id}/archiver")
    public void archiverAffectationLigneBus(@PathVariable("id") Long id) {
    	affectationLigneBusService.archiverAffectationLigneBus(id);
    }

    @PutMapping("/{id}/activer")
    public void activerAffectationLigneBus(@PathVariable("id") Long id) {
    	affectationLigneBusService.activerAffectationLigneBus(id);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteAffectation(@PathVariable Long id) {
        affectationLigneBusService.deleteAffectation(id);
    }
    
    
    @GetMapping("/activer")
    public List<AffectationLigneBus> getAllAffectationLigneBusEtatActiver() {
        return affectationLigneBusService.getAllAffectationLigneBusEtatActiver();
    }
    @GetMapping("/archiver")
    public List<AffectationLigneBus> getAllAffectationLigneBusEtatArchiver() {
        return affectationLigneBusService.getAllAffectationLigneBusEtatArchiver();
    }
}
