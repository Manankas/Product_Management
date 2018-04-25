package com.tsiry.poc.service.categorie;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.commun.ResponseDTO;;

public interface IserviceCategorie {
	//CRUD
		public ResponseDTO add(CategorieDTO c,BindingResult result);
		
		public String delete(Long idCategorie);
		
		public List<CategorieDTO> getAll(int page , int size);
		
}

