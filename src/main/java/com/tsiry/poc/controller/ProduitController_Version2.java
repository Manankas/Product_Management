package com.tsiry.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsiry.poc.DO.Produit;
import com.tsiry.poc.DTO.ProduitDTO;
import com.tsiry.poc.repository.CriteriaRepository;
import com.tsiry.poc.service.produit.ServiceProduit_Version2;

@RestController
public class ProduitController_Version2 {
	@Autowired
	ServiceProduit_Version2 serviceProduit;
	
	@RequestMapping(value="/produit_V2/add",method=RequestMethod.POST )
	public ResponseEntity<ProduitDTO> add(@RequestBody ProduitDTO p){
			return  serviceProduit.add(p);		
	}
	
	@RequestMapping(value="/produit/getByCriteria",method=RequestMethod.GET )
	public List<ProduitDTO> get(@RequestParam(name="designation" , defaultValue="") String designation){
			return  serviceProduit.findAllByDesignation(designation)  ;		
	}
}
