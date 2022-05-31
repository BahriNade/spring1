package com.nada.ordinateur.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nada.ordinateur.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {

}
