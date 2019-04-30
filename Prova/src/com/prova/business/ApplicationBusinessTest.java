package com.prova.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prova.dto.WorstSalesmanDto;
import com.prova.entity.Item;
import com.prova.entity.Sale;
import com.prova.entity.Salesman;

public class ApplicationBusinessTest {

	private List<Salesman> salesman = new ArrayList<Salesman>();

	private List<Item> item8 = new ArrayList<Item>();

	private List<Item> item10 = new ArrayList<Item>();

	private List<Sale> sales = new ArrayList<Sale>();

	private ApplicationBusiness applicationBusiness;

	@Before
	public void init() {
		salesman.add(new Salesman(Long.valueOf(1), Long.valueOf("12345678942"), "Ricardo", new BigDecimal(4500.00)));
		salesman.add(new Salesman(Long.valueOf(1), Long.valueOf("98765432186"), "Ronaldo", new BigDecimal(5000.00)));

		item8.add(new Item(Long.valueOf(1), Integer.valueOf(1), new BigDecimal(300)));

		item10.add(new Item(Long.valueOf(2), Integer.valueOf(1), new BigDecimal(400)));

		Sale sale1 = new Sale(Long.valueOf(8), item8, "Ricardo");
		sale1.setTotal(Double.valueOf(300));

		Sale sale2 = new Sale(Long.valueOf(10), item10, "Ronaldo");
		sale2.setTotal(Double.valueOf(400));

		sales.add(sale1);

		sales.add(sale2);

		applicationBusiness = new ApplicationBusiness(salesman, sales);

	}

	@Test
	public void findWorstSalesmanTest() {

		WorstSalesmanDto wsdtoExpected = new WorstSalesmanDto("Ricardo", Double.valueOf(300));

		WorstSalesmanDto wsdtoAtual = applicationBusiness.findWorstSalesman();

		Assert.assertEquals(wsdtoExpected.toString(), wsdtoAtual.toString());

	}


	@Test
	public void findTotalTest() {

		Double valueExpected = Double.valueOf(300);

		Double valueSalesActual = applicationBusiness.findTotal(sales, "Ricardo");

		Assert.assertEquals(valueExpected, valueSalesActual);
	}

	
	
	@Test
	public void findMostExpensivelSaleTest() {

		Long idExpected = Long.valueOf(10);

		Long idSalesActual = applicationBusiness.findMostExpensiveSale();

		Assert.assertEquals(idExpected, idSalesActual);
	}

	@Test
	public void totalizeEquals() {

		List<Item> item = new ArrayList<Item>();
		item.add(new Item(Long.valueOf(1), Integer.valueOf(10), new BigDecimal(300)));

		Double total = Double.valueOf(3000);

		Double totalItem = applicationBusiness.totalize(item);
		Assert.assertEquals(total, totalItem);

	}

	@Test
	public void totalizeNotEquals() {

		List<Item> item = new ArrayList<Item>();
		item.add(new Item(Long.valueOf(1), Integer.valueOf(10), new BigDecimal(300)));

		Double total = Double.valueOf(4000);

		Double totalItem = applicationBusiness.totalize(item);
		Assert.assertNotEquals(total, totalItem);

	}
}
