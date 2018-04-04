package com.muzz.pos.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.muzz.pos.persistence.model.Product;

public interface IProductDao extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE LOWER(p.name) = LOWER(:name)")
	Product retrieveByName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p WHERE LOWER(p.code) = LOWER(:code)")
	Product retrieveByCode(@Param("code") String code);
}
