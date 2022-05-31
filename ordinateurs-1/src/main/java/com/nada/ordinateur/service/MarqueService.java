package com.nada.ordinateur.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nada.ordinateur.entities.Marque;

public interface MarqueService {

	
	Marque saveMarque(Marque p);
	Marque updateMarque(Marque p);
	void deleteMarue(Marque p);
	void deleteMraqueById(Long id);
	Marque getMarque(Long id);
	List<Marque> getAllMarques();
	
	List<Marque> findAll();
	Page<Marque> getAllMarquesParPage(int page, int size);
	
	
	
}
