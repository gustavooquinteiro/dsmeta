package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate oneYearAgo = today.minusYears(1);
		
		LocalDate min = (minDate.equals(""))? oneYearAgo : LocalDate.parse(minDate);
		LocalDate max = (maxDate.equals("")) ? today : LocalDate.parse(maxDate);
		
		return repository.findAll(min, max, pageable);
	}
	
	
}
