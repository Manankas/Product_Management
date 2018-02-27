package com.tsiry.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.commun.ResponseDTO;
import com.tsiry.poc.service.categorie.ServiceCategorie;

@RestController
public class CategorieController {
	
	@Autowired
	ServiceCategorie serviceCategorie;
	
	@RequestMapping(value="/categorie/add",method=RequestMethod.POST )
	public ResponseDTO add(@RequestBody CategorieDTO c){
		return serviceCategorie.add(c);
	}
	
	@RequestMapping(value="/categorie/delete",method=RequestMethod.DELETE )
	public String delete(@RequestParam(name="id" , defaultValue="-1") Long id) {
			return  serviceCategorie.delete(id);	
	}
	
	@RequestMapping(value="/categorie/list",method=RequestMethod.GET )
	public List<CategorieDTO> getAll(@RequestParam(name="page" , defaultValue="0") int page ,
									 @RequestParam(name="size" , defaultValue="3")int size){
			return  serviceCategorie.getAll(page, size)	;
	}
}
