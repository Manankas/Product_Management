package com.tsiry.poc.service.categorie;

import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.commun.ResponseDTO;;

public interface IserviceCategorie {
	//CRUD
		public ResponseDTO add(CategorieDTO c);
		
		public String delete(Long idCategorie);
		
}

