package com.example.stage_backend.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stage_backend.entities.AffectationLigneBus;


public interface AffectationLigneBusRepository  extends JpaRepository<AffectationLigneBus, Long>{
	  List<AffectationLigneBus> findByEtat(String etat, Sort sort);

}
