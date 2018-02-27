package com.tsiry.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tsiry.poc.DO.Categorie;
import com.tsiry.poc.DO.Produit;
import com.tsiry.poc.repository.CategorieRepository;
import com.tsiry.poc.repository.ProduitRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// spring context est utile pour la gestion des objets, les retrouver
		// s'ils sont déjà créer
		ApplicationContext ctx = SpringApplication.run(Application.class, args); // demarrage
																							// de
																							// spring

		// Seulement pour test
		/*
		 * CategorieRepository categorieRepository =
		 * ctx.getBean(CategorieRepository.class); ProduitRepository
		 * produitRepository = ctx.getBean(ProduitRepository.class);
		 * 
		 * Categorie c = new Categorie("categorie 1");
		 * categorieRepository.save(c); produitRepository.save(new
		 * Produit("Asus", 1000, c));
		 */

	}
}
