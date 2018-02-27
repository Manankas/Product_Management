package com.tsiry.poc.commun;

public enum Message {

	addSuccess("ajout réussi"),
	addError("Erreur ajout"),
	addErrorProd_Cat404("Erreur, catégorie introuvable"),
	errorProd_404("Erreur, produit introuvable"),
	
	success("Success");
	
	private String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
