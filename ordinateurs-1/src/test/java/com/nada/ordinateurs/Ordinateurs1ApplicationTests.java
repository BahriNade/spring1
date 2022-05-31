package com.nada.ordinateurs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.nada.ordinateur.entities.Ordinateur;
import com.nada.ordinateur.repos.OrdinateurRepository;
import com.nada.ordinateur.service.OrdinateurService;

@SpringBootTest
class SingerApplicationTests {

	@Autowired
	private OrdinateurRepository ordinateurRepository;
	
	@Autowired
	private OrdinateurService ordinateurService;
	
	@Test
	public void testCreateSinger() {
	Ordinateur ordinateur = new Ordinateur("pc1",15.2,new Date());
	ordinateurRepository.save(ordinateur);
	}
	
	@Test
	public void testFindSinger()
	{
	Ordinateur p = ordinateurRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateSinger()
	{
	Ordinateur p = ordinateurRepository.findById(1L).get();
	p.setNomOrdinateur("nom");
	ordinateurRepository.save(p);
	}
	
	@Test
	public void testDeleteSinger()
	{
	ordinateurRepository.deleteById(2L);;
	}
	
	@Test
	public void testListerTousSinger()
	{
	List<Ordinateur> ordinateurs = ordinateurRepository.findAll();
	for (Ordinateur p : ordinateurs)
	{
	System.out.println(p);
	}

	}
	
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateursParPage(0,2);
	System.out.println(ordinateurs.getSize());
	System.out.println(ordinateurs.getTotalElements());
	System.out.println(ordinateurs.getTotalPages());
	ordinateurs.getContent().forEach(s -> {System.out.println(s.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	

}
