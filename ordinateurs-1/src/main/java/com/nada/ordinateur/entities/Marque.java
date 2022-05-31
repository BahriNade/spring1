package com.nada.ordinateur.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;
	
	private String nomMarque;
	
	@OneToMany(mappedBy = "marque")
	private List<Ordinateur> ordinateurs;

	
	public Marque() {}
	public Marque(String nomMarque,  List<Ordinateur> ordinateurs)
	{

	super();
	this.nomMarque = nomMarque;
	
	this.ordinateurs = ordinateurs;
	}
	
	public Long getIdMarque() {
		return idMarque;
		}
		public void setIdMarque(Long idMarque) {
		this.idMarque= idMarque;
		}
		public String getNomMarque() {
		return nomMarque;
		}
		public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
		}
		
		public List<Ordinateur> getOrdinateurs() {
		return ordinateurs;
		}
		public void setProduits(List<Ordinateur> ordinateurs) {
			this.ordinateurs = ordinateurs;
			}
}
