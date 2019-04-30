package com.prova.bean;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.prova.business.ApplicationBusiness;
import com.prova.dto.ResultDto;
import com.prova.entity.Customer;
import com.prova.entity.Sale;
import com.prova.entity.Salesman;
import com.prova.repository.FileReaderStream;
import com.prova.repository.FileWriterStream;
import com.prova.repository.Repository;

public class ApplicationManager {

	private static final String EXTENSION_DAT = ".dat";
	private Repository repository;

	public void start() {

		DirectoryStream<Path> stream;
		try {
			stream = Files.newDirectoryStream(Paths.get(System.getProperty("user.home"), "/data/in/"));
			for (Path path : stream) {
				if (path.toString().endsWith(EXTENSION_DAT)) {
					run(path);
				}
			}

		} catch (IOException e) {
			e.getMessage();
		}

	}

	public void run(Path path) {
		setRepository(new FileReaderStream(path));

		List<Salesman> salesmans = repository.getSalesmans();
		List<Customer> customers = repository.getCustomers();
		List<Sale> sales = repository.getSales();
		ResultDto result = new ResultDto();
		ApplicationBusiness business = new ApplicationBusiness(salesmans, sales);

		result.setClientesAmount(customers.size());
		result.setSalesAmount(sales.size());
		result.setMostExpensiveSale(business.findMostExpensiveSale());
		result.setWorstSalesman(business.findWorstSalesman());
	
		new FileWriterStream().fileWriter(path, result);

	}
	

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

}
