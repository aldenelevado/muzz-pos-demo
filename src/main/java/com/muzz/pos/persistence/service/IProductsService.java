package com.muzz.pos.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.muzz.pos.persistence.IOperations;
import com.muzz.pos.persistence.model.Products;

public interface IProductsService extends IOperations<Products> {
	
	 Products retrieveByName(String name);
	    
	 Page<Products> findPaginated(Pageable pageable);
}
