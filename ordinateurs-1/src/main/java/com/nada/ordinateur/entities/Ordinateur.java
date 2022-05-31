package com.nada.ordinateur.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ordinateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrdinateur;
	
	@NotNull
	
	private String nomOrdinateur;
	
	private double PrixOrdinateur;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date dateCreation;
	
	@ManyToOne
	private Marque marque;
	
	public Ordinateur() {
	super();
	}
	public Ordinateur(String nomOrdinateur, double PrixOrdinateur, Date dateCreation) {
	super();
	this.nomOrdinateur = nomOrdinateur;
	
	this.dateCreation = dateCreation;
	this.PrixOrdinateur=PrixOrdinateur;
	}
	
	public Long getIdOrdinateur() {
		return idOrdinateur;
		}
		public void setIdOrdinateur(Long idOrdinateur) {
		this.idOrdinateur = idOrdinateur;
		}
		public String getNomOrdinateur() {
		return nomOrdinateur;
		}
		public void setNomOrdinateur(String nomOrdinateur) {
		this.nomOrdinateur = nomOrdinateur;
		}
		public double getPrixOrdinateur() {
			return PrixOrdinateur;
			}
			public void setPrixOrdinateur(double PrixOrdinateur) {
			this.PrixOrdinateur = PrixOrdinateur;}
		
		public Date getDateCreation() {
			return dateCreation;
			}
			public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
			}
			
			
			
			
			@Override
			public String toString() {
			return "Ordinateur [idOrdianteur=" + idOrdinateur + ", nomOrdinateur=" +

			nomOrdinateur + ", prenomSinger=" + ", date de creation" + dateCreation+"]";

			}
			
			public Marque getMarque() {
				return marque;
			}
			public void setMarque(Marque marque2) {
				this.marque = marque2;
				
			}
			
}
