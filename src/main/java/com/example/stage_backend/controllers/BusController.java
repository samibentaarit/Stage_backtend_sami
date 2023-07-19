package com.example.stage_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stage_backend.entities.Bus;
import com.example.stage_backend.services.BusService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/bus", produces = "application/json")
public class BusController {

    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuss() {
        List<Bus> buss = busService.getAll();
        return ResponseEntity.ok(buss);
    }


    @GetMapping("/activer")
    public List<Bus> getAllBusEtatActiver() {
        return busService.getAllBusEtatActiver();
    }

    @GetMapping("/archiver")
    public List<Bus> getAllBusEtatArchiver() {
        return busService.getAllBusEtatArchiver();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable("id") Long id) {
        Optional<Bus> bus = busService.getBusById(id);
        return bus.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bus> saveBus(@RequestBody Bus bus) {
        busService.saveBus(bus);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable("id") Long id, @RequestBody Bus bus) {
        busService.updateBus(id, bus);
        return new ResponseEntity<>(bus, HttpStatus.OK);
    }

    @PutMapping("/{id}/archiver")
    public void archiverBus(@PathVariable("id") Long id) {
        busService.archiverBus(id);
    }

    @PutMapping("/{id}/activer")
    public void activerBus(@PathVariable("id") Long id) {
        busService.activerBus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable("id") Long id) {
        busService.deleteBus(id);
    }
}