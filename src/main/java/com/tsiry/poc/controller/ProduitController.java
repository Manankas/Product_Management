package com.tsiry.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.DTO.ProduitDTO;
import com.tsiry.poc.commun.Message;
import com.tsiry.poc.commun.ResponseDTO;
import com.tsiry.poc.service.categorie.ServiceCategorie;
import com.tsiry.poc.service.produit.ServiceProduit;

@RestController
public class ProduitController {

	@Autowired
	ServiceProduit serviceProduit;
	
	@RequestMapping(value="/produit/add",method=RequestMethod.POST )
	public ResponseDTO add(@RequestBody ProduitDTO p){
			return  serviceProduit.add(p);		
	}
	
	@RequestMapping(value="/produit/get",method=RequestMethod.GET )
	public ResponseDTO get(@RequestParam(name="id" , defaultValue="0") Long id) {
			return  serviceProduit.get(id);	
	}
	
	@RequestMapping(value="/produit/update",method=RequestMethod.POST )
	public ResponseDTO update(@RequestBody ProduitDTO p){
			return  serviceProduit.update(p);		
	}
	
	@RequestMapping(value="/produit/delete",method=RequestMethod.DELETE )
	public String delete(@RequestParam(name="id" , defaultValue="-1") Long id) {
			return  serviceProduit.delete(id);	
	}
	
	@RequestMapping(value="/produit/list",method=RequestMethod.GET )
	public List<ProduitDTO> getAll(@RequestParam(name="page" , defaultValue="0") int page ,
							       @RequestParam(name="size" , defaultValue="3")int size){
			return  serviceProduit.getAll(page, size);	
	}
	
	@RequestMapping(value="/produit/search",method=RequestMethod.GET )
	public List<ProduitDTO> searchByDesignation(@RequestParam(name="designation" , defaultValue="") String d ,
												@RequestParam(name="page" , defaultValue="0") int page ,
												@RequestParam(name="size" , defaultValue="3")int size){
			return  serviceProduit.searchByDesignation(d, page, size);		
	}
}
