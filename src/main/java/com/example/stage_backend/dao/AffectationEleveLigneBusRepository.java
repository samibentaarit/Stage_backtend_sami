package com.example.stage_backend.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stage_backend.entities.AffectationEleveLigneBus;


public interface AffectationEleveLigneBusRepository   extends JpaRepository<AffectationEleveLigneBus, Long>{
	  List<AffectationEleveLigneBus> findByEtat(String etat, Sort sort);

}
