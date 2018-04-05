package com.muzz.pos.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.muzz.pos.persistence.model.Products;

public interface IProductsDao extends JpaRepository<Products, Long> {
	
	@Query("SELECT p FROM Products p WHERE LOWER(p.name) = LOWER(:name)")
	Products retrieveByName(@Param("name") String name);
	
	@Query("SELECT p FROM Products p WHERE LOWER(p.code) = LOWER(:code)")
	Products retrieveByCode(@Param("code") String code);
}
