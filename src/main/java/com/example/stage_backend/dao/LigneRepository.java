package com.example.stage_backend.dao;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stage_backend.entities.Ligne;


public interface LigneRepository extends JpaRepository<Ligne, Long> {
	  List<Ligne> findByEtat(String etat, Sort sort);
        }