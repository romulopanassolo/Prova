package com.prova.dto;

public class ResultDto {

	private Integer clientesAmount;
	
	private Integer salesAmount;

	private Long mostExpensiveSale;
	
	private WorstSalesmanDto worstSalesman;

	public Integer getClientesAmount() {
		return clientesAmount;
	}

	public void setClientesAmount(Integer clientesAmount) {
		this.clientesAmount = clientesAmount;
	}

	public Integer getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(Integer salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Long getMostExpensiveSale() {
		return mostExpensiveSale;
	}

	public void setMostExpensiveSale(Long mostExpensiveSale) {
		this.mostExpensiveSale = mostExpensiveSale;
	}

	public WorstSalesmanDto getWorstSalesman() {
		return worstSalesman;
	}

	public void setWorstSalesman(WorstSalesmanDto worstSalesman) {
		this.worstSalesman = worstSalesman;
	}

	@Override
	public String toString() {
		return String.format("The amount of clients is %d. \n "
				+ "The amount of salesman is %d. \n "
				+ "The Id of the most expensive sale is %d. \n "
				+ " %s ", getClientesAmount(), getSalesAmount(), getMostExpensiveSale(), getWorstSalesman().toString());
	
	}
}
