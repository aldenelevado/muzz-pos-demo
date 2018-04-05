package com.muzz.pos.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muzz.pos.persistence.dao.IProductsDao;
import com.muzz.pos.persistence.model.Products;
import com.muzz.pos.persistence.service.IProductsService;
import com.muzz.pos.persistence.service.common.AbstractService;

@Service
@Transactional
public class ProductsService extends AbstractService<Products> implements IProductsService {

	@Autowired
	private IProductsDao dao;

	public ProductsService() {
		super();
	}

	@Override
	public Products retrieveByName(String name) {
		return dao.retrieveByName(name);
	}

	@Override
	public Page<Products> findPaginated(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	protected PagingAndSortingRepository<Products, Long> getDao() {
		return dao;
	}

}
