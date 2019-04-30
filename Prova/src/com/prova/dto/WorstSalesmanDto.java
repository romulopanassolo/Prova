package com.prova.dto;

public class WorstSalesmanDto {

	private String salesmanName;
	
	private Double TotalSale;
	
	public WorstSalesmanDto(String salesmanName, Double totalSale) {
		this.salesmanName = salesmanName;
		TotalSale = totalSale;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public Double getTotalSale() {
		return TotalSale;
	}

	public void setTotalSale(Double totalSale) {
		TotalSale = totalSale;
	}

	@Override
	public String toString() {
		return " The Worst Salesman is " + getSalesmanName();
	}
	
	
	
	
}
