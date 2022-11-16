package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	
}
