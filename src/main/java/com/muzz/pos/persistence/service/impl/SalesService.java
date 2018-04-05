package com.muzz.pos.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muzz.pos.persistence.dao.ISalesDao;
import com.muzz.pos.persistence.model.Sales;
import com.muzz.pos.persistence.service.ISalesService;
import com.muzz.pos.persistence.service.common.AbstractService;

@Service
@Transactional
public class SalesService extends AbstractService<Sales> implements ISalesService {

	@Autowired
	private ISalesDao dao;
	
	@Override
	protected PagingAndSortingRepository<Sales, Long> getDao() {
		return dao;
	}

}
