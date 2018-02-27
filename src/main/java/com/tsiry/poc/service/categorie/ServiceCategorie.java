package com.tsiry.poc.service.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsiry.poc.DO.Categorie;
import com.tsiry.poc.DTO.CategorieDTO;
import com.tsiry.poc.commun.Message;
import com.tsiry.poc.commun.ResponseDTO;
import com.tsiry.poc.repository.CategorieRepository;

@Service("serviceCategorie")
public class ServiceCategorie implements IserviceCategorie {

	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public ResponseDTO add(CategorieDTO c) {
		ResponseDTO resp;
		if (c != null && c.getLabel() != "") {
			// dto to do
			Categorie categorie = new Categorie(c.getLabel());
			categorie = categorieRepository.save(categorie);

			c.setId(categorie.getId());
			resp = new ResponseDTO(Message.addSuccess.getMessage(), c);
		} else {
			resp = new ResponseDTO(Message.addError.getMessage(), null);
		}

		return resp;

	}

	@Override
	public String delete(Long idCategorie) {
		if (idCategorie == -1)
			return "insert categorie id";

		if (categorieRepository.exists(idCategorie)) {
			categorieRepository.delete(idCategorie);
			return Message.success.getMessage();

		} else
			return Message.addErrorProd_Cat404.getMessage();
	}

}
