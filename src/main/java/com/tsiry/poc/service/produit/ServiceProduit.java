package com.tsiry.poc.service.produit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tsiry.poc.DO.Categorie;
import com.tsiry.poc.DO.Produit;
import com.tsiry.poc.DTO.ProduitDTO;
import com.tsiry.poc.commun.Message;
import com.tsiry.poc.commun.ResponseDTO;
import com.tsiry.poc.repository.CategorieRepository;
import com.tsiry.poc.repository.ProduitRepository;

@Service("serviceProduit")
public class ServiceProduit implements IServiceProduit {

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public ResponseDTO add(ProduitDTO p) {
		
		ResponseDTO rep;
		
		//dto to do
		Categorie c = categorieRepository.findByLabel(p.getCategorie());
		
		if (c != null){
			Produit produit = new Produit(p.getDesignation(), p.getPrix(), c);
			produit = produitRepository.save(produit);
			
			p.setId(produit.getId());
			
			rep = new ResponseDTO(Message.addSuccess.getMessage(), p);
		}
		else{
			rep = new ResponseDTO(Message.addErrorProd_Cat404.getMessage(), null);
		}
		
		return rep;
	}

	@Override
	public ResponseDTO get(Long idProduit) {
		ResponseDTO rep;
		Produit produit = produitRepository.findOne(idProduit);
		
		//si ke produit existe en base
		if(produit!=null){
			ProduitDTO p = new ProduitDTO(produit.getId(),produit.getDesignation(), produit.getPrix(), produit.getCategorie().getLabel());
			rep = new ResponseDTO(Message.success.getMessage(), p); 
		}
		else{
			rep = new ResponseDTO(Message.errorProd_404.getMessage(), null);
		}
		return rep;
	}

	@Override
	public ResponseDTO update(ProduitDTO p) {
		ResponseDTO rep;
		
		//dto to do
		Categorie c = categorieRepository.findByLabel(p.getCategorie());
		
		if (c != null){
			Produit produit = new Produit(p.getId(),p.getDesignation(), p.getPrix(), c);
			produit = produitRepository.save(produit);
			
			p.setId(produit.getId());
			
			rep = new ResponseDTO(Message.success.getMessage(), p);
		}
		else{
			rep = new ResponseDTO(Message.addErrorProd_Cat404.getMessage(), null);
		}
		
		return rep;
	}

	@Override
	public String delete(Long idProduit) {
		if(idProduit == -1) return "insert product id";
		
		if (produitRepository.exists(idProduit)){
			produitRepository.delete(idProduit);
			return Message.success.getMessage();
					
		}
		else
			return Message.errorProd_404.getMessage();
		
		
	}

	@Override
	public List<ProduitDTO> getAll(int page , int size) {
		List<ProduitDTO> produits = new ArrayList<>();
		 Page<Produit> prods =  produitRepository.findAll(new PageRequest(page, size));
		 if(prods != null){
			 for(Produit p : prods) {
				 produits.add(new ProduitDTO(p.getId(),p.getDesignation(), p.getPrix(), p.getCategorie().getLabel()));
			 }
		 }
		 
		 return produits;
		 
	}

	@Override
	public List<ProduitDTO> searchByDesignation(String designation, int page, int size) {
		 List<ProduitDTO> produits = null;
		if(! StringUtils.isEmpty(designation) ){
			produits = new ArrayList<>();
			List<Produit> prods = produitRepository.searchByDesignation("%"+designation+"%", new PageRequest(page, size));
			for(Produit p : prods ){
				produits.add(new ProduitDTO(p.getId(), p.getDesignation(), p.getPrix(), p.getCategorie().getLabel()));
			}
		}
		return produits;
	}

	public List<ProduitDTO> findAllByDesignation(String designation, int page, int size) {
		List<ProduitDTO> produits = null;
		if (!StringUtils.isEmpty(designation)) {
			produits = new ArrayList<>();
			List<Produit> prods = produitRepository.findAllByDesignationLike("%"+designation+"%",new PageRequest(page, size));
			for (Produit p : prods) {
				produits.add(new ProduitDTO(p.getId(), p.getDesignation(), p.getPrix(), p.getCategorie().getLabel()));
			}
		}
		return produits;
	}
	
	public List<ProduitDTO> findAllByCategorie(String cat, int page, int size) {
		List<ProduitDTO> produits = null;
		if (!StringUtils.isEmpty(cat)) {
			produits = new ArrayList<>();
			Categorie c = categorieRepository.findByLabel(cat);
			List<Produit> prods = produitRepository.findAllByCategorie(c,new PageRequest(page, size));
			for (Produit p : prods) {
				produits.add(new ProduitDTO(p.getId(), p.getDesignation(), p.getPrix(), p.getCategorie().getLabel()));
			}
		}
		return produits;
	}
}

