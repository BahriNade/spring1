package com.nada.ordinateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nada.ordinateur.entities.Marque;
import com.nada.ordinateur.entities.Ordinateur;
import com.nada.ordinateur.repos.MarqueRepository;
import com.nada.ordinateur.repos.OrdinateurRepository;


@Service
public class OrdinateurServiceImp implements OrdinateurService {

	@Autowired
	OrdinateurRepository ordinateurRepository;
	

@Override
public Ordinateur saveOrdinateur(Ordinateur p) {
	return  ordinateurRepository.save(p);}

@Override
public Ordinateur updateOrdinateur(Ordinateur p) {
	return  ordinateurRepository.save(p);
}

@Override
public void deleteOrdinateur(Ordinateur p) {
	ordinateurRepository.delete(p);
	
}

@Override
public void deleteOrdinateurById(Long id) {
	ordinateurRepository.deleteById(id);
	
}

@Override
public Ordinateur getOrdinateur(Long id) {
	return  ordinateurRepository.findById(id).get();

}

@Override
public List<Ordinateur> getAllOrdinateurs() {
	return ordinateurRepository.findAll();
}

@Override
public Page<Ordinateur> getAllOrdinateursParPage(int page, int size) {
	return ordinateurRepository.findAll(PageRequest.of(page, size));
}

@Override
public List<Ordinateur> findByNomOrdinateur(String nom) {
	return ordinateurRepository.findByNomOrdinateur(nom);
}

@Override
public List<Ordinateur> findByMarque(Marque marques) {
	return ordinateurRepository.findByMarque(marques);
}
}
