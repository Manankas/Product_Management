package com.tsiry.poc.service.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tsiry.poc.DO.Categorie;
import com.tsiry.poc.DO.Produit;
import com.tsiry.poc.DTO.ProduitDTO;
import com.tsiry.poc.commun.Message;
import com.tsiry.poc.commun.ResponseDTO;
import com.tsiry.poc.repository.CategorieRepository;
import com.tsiry.poc.repository.ProduitRepository;

@Service("serviceProduitV2")
public class ServiceProduit_Version2 implements IServiceProduit_Version2{
	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public ResponseEntity<ProduitDTO> add(ProduitDTO p) {
		ResponseEntity<ProduitDTO> rep = null;
		// dto to do
		Categorie c = categorieRepository.findByLabel(p.getCategorie());

		if (c != null) {
			Produit produit = new Produit(p.getDesignation(), p.getPrix(), c);
			produit = produitRepository.save(produit);

			p.setId(produit.getId());
			rep = new ResponseEntity<ProduitDTO>(p, HttpStatus.CREATED);
			
		} else {
			rep = new ResponseEntity<ProduitDTO>(p, HttpStatus.valueOf("Category not in DB"));
		}

		return rep;
	}

}
