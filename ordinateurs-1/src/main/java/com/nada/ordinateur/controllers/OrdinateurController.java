package com.nada.ordinateur.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nada.ordinateur.entities.Marque;
import com.nada.ordinateur.entities.Ordinateur;
import com.nada.ordinateur.service.MarqueService;
import com.nada.ordinateur.service.OrdinateurService;

@Controller
public class OrdinateurController {

	@Autowired
	OrdinateurService ordinateurService;
	
	@Autowired
	MarqueService marqueService;
	
	
	
	@RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<Marque> marques = marqueService.getAllMarques();
        Ordinateur ordinateur = new Ordinateur();
        Marque marque = new Marque();
        marque = marques.get(0); // prendre la première catégorie de la liste
        ordinateur.setMarque(marque); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
        modelMap.addAttribute("ordinateur",ordinateur);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("marques", marques);
        return "formOrdinateur";
    }
	
	
	
	
	
	
	
	
	@RequestMapping("/saveProduit")
	public String saveOrdinateur(@Valid Ordinateur ordinateur,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formOrdinateur";
	ordinateurService.saveOrdinateur(ordinateur);
	return "redirect:/ListeProduits";
	}
	
	@RequestMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Ordinateur> ordinateur = ordinateurService.getAllOrdinateursParPage(page, size);
	modelMap.addAttribute("ordinateur", ordinateur);

	modelMap.addAttribute("pages", new int[ordinateur.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeOrdinateur";
	}
	

	
	
	
	
	@RequestMapping("/supprimerProduit")
	public String supprimerOrd(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	ordinateurService.deleteOrdinateurById(id);
	Page<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateursParPage(page,size);

	modelMap.addAttribute("ordinateurs", ordinateurs);
	modelMap.addAttribute("pages", new int[ordinateurs.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "redirect:/ListeProduits";
	}
	
	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Ordinateur p= ordinateurService.getOrdinateur(id);
	List<Marque> cats = marqueService.findAll();
	cats.remove(p.getMarque());
	modelMap.addAttribute("marques", cats);
	modelMap.addAttribute("ordinateur", p);
	modelMap.addAttribute("mode", "edit");
	return "formOrdinateur";
	}
	
	@RequestMapping("/updateProduit")
	public String updateOrd(@ModelAttribute("ordinateur") Ordinateur ordinateur,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
	//conversion de la date
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	ordinateur.setDateCreation(dateCreation);
	ordinateurService.updateOrdinateur(ordinateur);
	List<Ordinateur> ordinateurs = ordinateurService.getAllOrdinateurs();
	modelMap.addAttribute("ordinateurs", ordinateurs);
	return "listeOrdinateur";
	
	}
	
	
	
	
	
	
	@RequestMapping("/ListeMarques")
	public String listeMarques(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
		Page<Marque> marques = marqueService.getAllMarquesParPage(page, size);
		
		modelMap.addAttribute("marques", marques);

	modelMap.addAttribute("pages", new int[marques.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeMarque";
	}
	
	@RequestMapping("/showCreateB")
	public String showCreateB(ModelMap modelMap)
	{
	modelMap.addAttribute("marque", new Marque());
	modelMap.addAttribute("mode", "new");
	return "formMarque";
	}
	
	@RequestMapping("/saveMarque")
	public String saveMarque(@Valid Marque marque,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formMarque";
	marqueService.saveMarque(marque);
	return "redirect:/ListeMarques";
	}
	
	
	@RequestMapping("/modifierMarque")
	public String editerMarque(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Marque b = marqueService.getMarque(id);
	modelMap.addAttribute("marque", b);
	modelMap.addAttribute("mode", "edit");
	return "formMarque";
	}
	
	
	@RequestMapping("/supprimerMarque")
	public String supprimerMarque(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{ 
		marqueService.deleteMraqueById(id);
	List<Marque> cats = marqueService.findAll();
	modelMap.addAttribute("marques", cats);
	return "redirect:/ListeMarques";
	}
	
	@RequestMapping("/search")
	public String recherNom(@RequestParam("nom") String nom,
	ModelMap modelMap)
	{
		List<Marque> cats = marqueService.findAll();
		modelMap.addAttribute("marques", cats);
	List<Ordinateur> prods = ordinateurService.findByNomOrdinateur(nom);
	modelMap.addAttribute("ordinateur",prods);
	modelMap.addAttribute("mode", "SearchNomP");
	return "listeOrdinateur";
	}
	
	
	@RequestMapping("/searchCat")
	public String recherCat(@RequestParam("cat") Long cat,ModelMap modelMap)
	{
	Marque marques = new Marque();
	marques.setIdMarque(cat);
	List<Marque> cats2 = marqueService.findAll();
	modelMap.addAttribute("marques", cats2);
	List<Ordinateur> prods = ordinateurService.findByMarque(marques);
	modelMap.addAttribute("ordinateur",prods);
	modelMap.addAttribute("mode", "Searchcat");
	return "listeOrdinateur";
	}
}
