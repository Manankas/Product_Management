package com.tsiry.poc.service.produit;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tsiry.poc.DTO.ProduitDTO;
import com.tsiry.poc.commun.ResponseDTO;

public interface IServiceProduit {
	//CRUD
	public ResponseDTO add(ProduitDTO p);
	public ResponseDTO get(Long idProduit);
	public List<ProduitDTO> getAll(int page , int size);
	public ResponseDTO update(ProduitDTO p);
	public String delete (Long idProduit);
	
	public List<ProduitDTO> searchByDesignation(String designation,int page , int size);
}
