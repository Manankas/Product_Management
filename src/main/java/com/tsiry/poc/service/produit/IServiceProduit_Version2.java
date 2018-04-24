package com.tsiry.poc.service.produit;

import org.springframework.http.ResponseEntity;

import com.tsiry.poc.DTO.ProduitDTO;

public interface IServiceProduit_Version2 {
	public ResponseEntity<ProduitDTO> add(ProduitDTO p);
}
