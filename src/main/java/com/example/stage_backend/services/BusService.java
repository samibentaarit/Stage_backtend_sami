package com.example.stage_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage_backend.dao.BusRepository;
import com.example.stage_backend.entities.Bus;
import com.example.stage_backend.interfaces.IBus;


@Service
public class BusService implements IBus {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    @Override
    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    @Override
    public List<Bus> getAllBusEtatActiver() {
        return busRepository.findByEtat("activer");
    }

    @Override
    public List<Bus> getAllBusEtatArchiver() {
        return busRepository.findByEtat("archiver");
    }

    @Override
    public void saveBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public void updateBus(Long id, Bus bus) {
        Bus existingBus = busRepository.findById(id).orElse(null);

        if (existingBus != null) {
            existingBus.setNum_bus(bus.getNum_bus());
            existingBus.setMarque_bus(bus.getMarque_bus());
            existingBus.setImmatriculation_bus(bus.getImmatriculation_bus());
            existingBus.setNb_places(bus.getNb_places());
            busRepository.save(existingBus);
        } else {
            throw new IllegalArgumentException("La bus avec l'ID " + id + " n'existe pas.");
        }
    }

    @Override
    public void archiverBus(Long busId) {
        Bus bus = busRepository.findById(busId).orElse(null);

        if (bus != null) {
            bus.setEtat("archiver");
            busRepository.save(bus);
        } else {
            throw new IllegalArgumentException("La bus avec l'ID " + busId + " n'existe pas.");
        }
    }

    @Override
    public void activerBus(Long busId) {
        Bus bus = busRepository.findById(busId).orElse(null);

        if (bus != null) {
            bus.setEtat("activer");
            busRepository.save(bus);
        } else {
            throw new IllegalArgumentException("La bus avec l'ID " + busId + " n'existe pas.");
        }
    }

    @Override
    public void deleteBus(Long busId) {
        Bus bus = busRepository.findById(busId).orElse(null);

        if (bus != null) {
            busRepository.delete(bus);
        } else {
            throw new IllegalArgumentException("La bus avec l'ID " + busId + " n'existe pas.");
        }
    }
}