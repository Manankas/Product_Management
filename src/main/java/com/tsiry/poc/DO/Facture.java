package com.tsiry.poc.DO;

import java.util.Collection;
import java.util.Date;

/**
 * @author tsiriniavo
 * @version 1.0
 * @created 21-fevr.-2018 17:42:01
 */
public class Facture {

	private String numero;
	private Date date;
	private Client client;
	private Collection<Produit> produit;

	public Facture() {
		super();
	}

}