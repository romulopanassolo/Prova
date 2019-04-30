package com.prova.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prova.dto.WorstSalesmanDto;
import com.prova.entity.Item;
import com.prova.entity.Sale;
import com.prova.entity.Salesman;

public class ApplicationBusiness {

	private List<Salesman> salesmans;
	
	private List<Sale> sales;

	public ApplicationBusiness(List<Salesman> salesmans, List<Sale> sales) {
		this.salesmans = salesmans;
		this.sales = sales;
	}
	
	
	public WorstSalesmanDto findWorstSalesman() {
		List<WorstSalesmanDto> possiblesWorst = new ArrayList<WorstSalesmanDto>();
		
		salesmans.forEach(s -> possiblesWorst.add(new WorstSalesmanDto(s.getName(), findTotal(sales, s.getName()))));
		possiblesWorst.sort((pw1, pw2) -> Double.compare(pw1.getTotalSale(), pw2.getTotalSale()));
		
		return possiblesWorst.get(0);
	}

	protected Double findTotal(List<Sale> sales, String name) {
		
		List<Sale> salesSalesman = sales.stream().filter(s -> s.getSalesName().equals(name))
				.collect(Collectors.toList());
		
		if (!salesSalesman.isEmpty()) {
			if (salesSalesman.size() == 0) {
				return new Double(0);
			} else {
				if (salesSalesman.size() == 1) {
					return salesSalesman.get(0).getTotal();
				} else {
					return salesSalesman.stream().mapToDouble(i -> i.getTotal()).sum();
				}
			}
		}
		return new Double(0);
	}

	public Long findMostExpensiveSale() {
		sales.forEach(s -> s.setTotal(totalize(s.getItem())));
		sales.sort((s1, s2) -> Double.compare(s1.getTotal(), s2.getTotal()));
		
		return sales.get(sales.size() - 1).getSaleId();
	}

	protected Double totalize(List<Item> item) {
		Double sum = item.stream().mapToDouble(i -> i.getPrice().doubleValue() * i.getQuantity()).sum();

		return sum;
	}


	public List<Salesman> getSalesmans() {
		return salesmans;
	}


	public void setSalesmans(List<Salesman> salesmans) {
		this.salesmans = salesmans;
	}


	public List<Sale> getSales() {
		return sales;
	}


	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	
}
