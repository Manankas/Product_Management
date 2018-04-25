package com.tsiry.poc.DO;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author tsiriniavo
 * @version 1.0
 * @created 21-fevr.-2018 17:42:01
 */
@Entity
@Table(name="Categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "label", unique = true)
	private String label;

	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // association bi-directionnelle
	//fetch = FetchType.LAZY signifie : quand on recupere 1 categorie à partir de la base
	// ne pas recuperer la liste de produit qui va avec,  pour l'avoir : faire un getProduits()
	public Collection<Produit> produits;

	public Categorie() {
		super();
	}

	public Categorie(Long id, String label, Collection<Produit> produits) {
		super();
		this.id = id;
		this.label = label;
		this.produits = produits;
	}

	

	public Categorie(String label) {
		super();
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	

}