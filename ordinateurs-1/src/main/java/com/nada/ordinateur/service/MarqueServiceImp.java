package com.nada.ordinateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nada.ordinateur.entities.Marque;
import com.nada.ordinateur.repos.MarqueRepository;

@Service
public class MarqueServiceImp  implements MarqueService{

	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
    public List <Marque> findAll() {
        return marqueRepository.findAll();
    }

	@Override
	public Marque saveMarque(Marque p) {
		return marqueRepository.save(p);
	}

	@Override
	public Marque updateMarque(Marque p) {
		return marqueRepository.save(p);
	}

	@Override
	public void deleteMarue(Marque p) {
		marqueRepository.delete(p);
		
	}

	@Override
	public void deleteMraqueById(Long id) {
		marqueRepository.deleteById(id);
		
	}

	@Override
	public Marque getMarque(Long id) {
		return marqueRepository.findById(id).get();
	}

	@Override
	public List<Marque> getAllMarques() {
		return marqueRepository.findAll();
	}

	@Override
	public Page<Marque> getAllMarquesParPage(int page, int size) {
		return marqueRepository.findAll(PageRequest.of(page, size));
	}
	
	

	
}

