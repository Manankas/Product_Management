package com.tsiry.poc.service.categorie;

import java.util.List;

import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.commun.ResponseDTO;;

public interface IserviceCategorie {
	//CRUD
		public ResponseDTO add(CategorieDTO c);
		
		public String delete(Long idCategorie);
		
		public List<CategorieDTO> getAll(int page , int size);
		
}

