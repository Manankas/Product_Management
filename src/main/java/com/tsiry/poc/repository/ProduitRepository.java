package com.tsiry.poc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tsiry.poc.DO.Categorie;
import com.tsiry.poc.DO.Produit;

public interface ProduitRepository  extends JpaRepository<Produit, Long> {
	
	@Query("select p from Produit p where p.designation like :d")
	public List<Produit> searchByDesignation(@Param("d") String designation, Pageable pageable);
	
	
	//REQUEST BY FUNCTION NAME
	public List<Produit> findAllByDesignationLike(String designation, Pageable pageable);
	public List<Produit> findAllByCategorie(Categorie cat, Pageable pageable);

}
