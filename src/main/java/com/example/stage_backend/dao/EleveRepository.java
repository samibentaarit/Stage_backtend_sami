package com.example.stage_backend.dao;

import com.example.stage_backend.entities.Eleve;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
    List<Eleve> findByEtat(String etat, Sort sort);
}
