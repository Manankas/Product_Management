package com.tsiry.poc.commun.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tsiry.poc.DTO.CategorieDTO;

public class CategorieValidator  implements Validator {

	@Override
	public boolean supports(Class clazz) {
		
		return CategorieDTO.class.equals(clazz);  //ce validator va valider CategorieDTO
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "label", "label empty");
		CategorieDTO c = (CategorieDTO)obj;
		 if (c.getLabel().length() < 3) {
	            e.rejectValue("label", "insignifiant label");
	           
	            //si on veut couper l'execution dès qu'on recontre une erreur
	            return;
	            
	        } 
		
	}

}
