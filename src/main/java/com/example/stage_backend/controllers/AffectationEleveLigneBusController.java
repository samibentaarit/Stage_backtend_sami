package com.example.stage_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.stage_backend.entities.AffectationEleveLigneBus;
import com.example.stage_backend.services.AffectationEleveLigneBusService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/affectations-eleve-ligne-bus")
public class AffectationEleveLigneBusController {

    private final AffectationEleveLigneBusService affectationEleveLigneBusService;

    @Autowired
    public AffectationEleveLigneBusController(AffectationEleveLigneBusService affectationEleveLigneBusService) {
        this.affectationEleveLigneBusService = affectationEleveLigneBusService;
    }

    @GetMapping
    public ResponseEntity<List<AffectationEleveLigneBus>> getAllAffectations() {
        List<AffectationEleveLigneBus> affectations = affectationEleveLigneBusService.getAllAffectations();
        return new ResponseEntity<>(affectations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationEleveLigneBus> getAffectationById(@PathVariable Long id) {
        Optional<AffectationEleveLigneBus> affectation = affectationEleveLigneBusService.getAffectationById(id);
        return affectation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AffectationEleveLigneBus> createAffectation(@RequestBody AffectationEleveLigneBus affectationEleveLigneBus) {
        AffectationEleveLigneBus createdAffectation = affectationEleveLigneBusService.createAffectation(affectationEleveLigneBus);
        return new ResponseEntity<>(createdAffectation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationEleveLigneBus> updateAffectation(@PathVariable Long id, @RequestBody AffectationEleveLigneBus updatedAffectation) {
        AffectationEleveLigneBus affectation = affectationEleveLigneBusService.updateAffectation(id, updatedAffectation);
        if (affectation != null) {
            return new ResponseEntity<>(affectation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PutMapping("/{id}/archiver")
    public void archiverAffectationEleveLigneBus(@PathVariable("id") Long id) {
    	affectationEleveLigneBusService.archiverAffectationEleveLigneBus(id);
    }

    @PutMapping("/{id}/activer")
    public void activerAffectationEleveLigneBus(@PathVariable("id") Long id) {
    	affectationEleveLigneBusService.activerAffectationEleveLigneBus(id);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectationEleveLigneBus(@PathVariable Long id) {
        affectationEleveLigneBusService.deleteAffectation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping("/activer")
    public List<AffectationEleveLigneBus> getAllAffectationEleveLigneBusEtatActiver() {
        return affectationEleveLigneBusService.getAllAffectationEleveLigneBusEtatActiver();
    }
    @GetMapping("/archiver")
    public List<AffectationEleveLigneBus> getAllAffectationEleveLigneBusEtatArchiver() {
        return affectationEleveLigneBusService.getAllAffectationEleveLigneBusEtatArchiver();
    }
}
