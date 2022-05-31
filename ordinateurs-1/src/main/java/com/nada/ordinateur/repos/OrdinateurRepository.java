package com.nada.ordinateur.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nada.ordinateur.entities.Marque;
import com.nada.ordinateur.entities.Ordinateur;

	public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {

		List<Ordinateur> findByNomOrdinateur(String nom);

		List<Ordinateur> findByMarque(Marque marques);
	}
