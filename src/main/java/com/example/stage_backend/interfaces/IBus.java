package com.example.stage_backend.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.stage_backend.entities.Bus;


public interface IBus {
    List<Bus> getAll();
    Optional<Bus> getBusById(Long id);
    List<Bus> getAllBusEtatActiver();
    List<Bus> getAllBusEtatArchiver();
    void saveBus(Bus bus);
    void updateBus(Long id, Bus bus);
    void archiverBus(Long busId);
    void activerBus(Long busId);
    void deleteBus(Long busId);
}

