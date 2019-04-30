package com.prova.repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.prova.entity.Customer;
import com.prova.entity.Item;
import com.prova.entity.Sale;
import com.prova.entity.Salesman;

public class FileReaderStream implements Repository {

	private static final String ITEM_SEPARATOR = "-";

	private static final String ITENS_SEPARATOR = ",";

	private static final String SALESMAN_CODE = "001";

	private static final String CUSTOMER_CODE = "002";

	private static final String SALES_CODE = "003";

	private static final String SEPARATOR_FILE = "ç";

	private List<Salesman> salesmans;

	private List<Customer> customers;

	private List<Sale> sales;

	public FileReaderStream(Path path) {
		try {
			List<String> listLines = Files.lines(path, StandardCharsets.ISO_8859_1).collect(Collectors.toList());
			generateSalesManList(listLines);
			generateCustomerList(listLines);
			generateSalesList(listLines);
		} catch (IOException e) {
			e.getMessage();
		}

	}

	private List<List<String>> CreateList(List<String> listLines, String code) {
		List<String> salesmanLines = listLines.stream().filter(l -> l.startsWith(code)).collect(Collectors.toList());
		List<List<String>> salesmanValues = salesmanLines.stream()
				.map((line) -> Arrays.asList(line.split(SEPARATOR_FILE))).collect(Collectors.toList());
		return salesmanValues;
	}

	private void generateSalesManList(List<String> listLines) {
		List<List<String>> salesmanValues = CreateList(listLines, SALESMAN_CODE);
		salesmans = new ArrayList<Salesman>();
		salesmanValues.forEach(list -> salesmans.add(
				new Salesman(null, Long.valueOf(list.get(1)), list.get(2).toString(), new BigDecimal(list.get(3)))));
	}

	private void generateCustomerList(List<String> listLines) {
		List<List<String>> customerValues = CreateList(listLines, CUSTOMER_CODE);
		customers = new ArrayList<Customer>();
		customerValues.forEach(cv -> customers.add(new Customer(null, Long.valueOf(cv.get(1)), cv.get(2), cv.get(3))));
	}

	private void generateSalesList(List<String> listLines) {
		List<List<String>> salesValues = CreateList(listLines, SALES_CODE);
		sales = new ArrayList<>();
		salesValues
				.forEach(sv -> sales.add(new Sale(Long.valueOf(sv.get(1)), returnItens(sv.get(2)), sv.get(3))));
	}

	private static List<Item> returnItens(String string) {
		List<String> itemLines = Arrays.asList(string.substring(1, string.length() - 1));
		List<List<String>> itemsValues = itemLines.stream().map((line) -> Arrays.asList(line.split(ITENS_SEPARATOR)))
				.collect(Collectors.toList());
		List<String> values = itemsValues.get(0);

		List<List<String>> itemValues = values.stream().map((line) -> Arrays.asList(line.split(ITEM_SEPARATOR)))
				.collect(Collectors.toList());
		List<Item> itens = new ArrayList<Item>();

		itemValues.forEach(iv -> itens
				.add(new Item(Long.valueOf(iv.get(0)), Integer.valueOf(iv.get(1)), new BigDecimal(iv.get(2)))));

		return itens;
	}

	@Override
	public List<Salesman> getSalesmans() {
		return salesmans;
	}

	public void setSalesmans(List<Salesman> salesmans) {
		this.salesmans = salesmans;
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

}
