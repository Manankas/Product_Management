package com.tsiry.poc.DTO;

public class ProduitDTO {
	private Long id;

	private String designation;

	private double prix;
	
	private String categorie;

	public ProduitDTO() {
		super();
	}

	public ProduitDTO(Long id, String designation, double prix, String categorie) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}

	public ProduitDTO(String designation, double prix, String categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	

}
