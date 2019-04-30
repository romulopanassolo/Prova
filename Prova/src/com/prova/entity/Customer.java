package com.prova.entity;

public class Customer {

	private Long id;
	
	private Long cnpj;
	
	private String name;
	
	private String businessArea;

	public Customer(Long id, Long cnpj, String name, String businessArea) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	
	
}
