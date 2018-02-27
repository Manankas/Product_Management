package com.tsiry.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tsiry.poc.DO.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	@Query("select c from Categorie c where c.label = :label")
	public Categorie findByLabel(@Param("label") String l);
}
