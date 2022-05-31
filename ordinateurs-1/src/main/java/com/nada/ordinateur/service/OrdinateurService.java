package com.nada.ordinateur.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nada.ordinateur.entities.Marque;
import com.nada.ordinateur.entities.Ordinateur;

public interface OrdinateurService {

	Ordinateur saveOrdinateur(Ordinateur p);
	Ordinateur updateOrdinateur(Ordinateur p);
	void deleteOrdinateur(Ordinateur p);
	void deleteOrdinateurById(Long id);
	Ordinateur getOrdinateur(Long id);
	List<Ordinateur> getAllOrdinateurs();
	Page<Ordinateur> getAllOrdinateursParPage(int page, int size);
	List<Ordinateur> findByNomOrdinateur(String nom);
	List<Ordinateur> findByMarque(Marque marques);
}
