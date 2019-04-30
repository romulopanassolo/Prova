package com.prova.entity;

import java.util.List;

public class Sale {

	
	private Long saleId;
	
	private List<Item> item;
	
	private String salesName;
	
	private Double total;

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Sale(Long saleId, List<Item> item, String salesName) {
		this.saleId = saleId;
		this.item = item;
		this.salesName = salesName;
	}

	
	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
}
