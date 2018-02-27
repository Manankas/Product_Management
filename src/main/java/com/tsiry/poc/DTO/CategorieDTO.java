package com.tsiry.poc.DTO;

public class CategorieDTO {
	private Long id;
	private String label;

	public CategorieDTO(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public CategorieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieDTO(String label) {
		super();
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
