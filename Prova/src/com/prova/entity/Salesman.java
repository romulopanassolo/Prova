package com.prova.entity;

import java.math.BigDecimal;

public class Salesman {

	private Long id;
	
	private Long cpf;
	
	private String name;
	
	private BigDecimal salary;
	
	
	public Salesman(Long id, Long cpf, String name, BigDecimal salary) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
}
