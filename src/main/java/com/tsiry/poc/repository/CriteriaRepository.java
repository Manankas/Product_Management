package com.tsiry.poc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tsiry.poc.DO.Produit;


@Repository
public class CriteriaRepository {
	@PersistenceContext
	private EntityManager entityManager; 
	
	public List<Produit> find(String label){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produit> criteriaQuery = builder.createQuery(Produit.class);
		Root<Produit> root = criteriaQuery.from(Produit.class);  //table de reference
		criteriaQuery.where(builder.equal(root.get("designation"), label));
		
		List<Produit> produits = entityManager.createQuery(criteriaQuery).getResultList();
		return produits;
	
	}
}
