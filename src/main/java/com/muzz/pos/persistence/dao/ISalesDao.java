package com.muzz.pos.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.muzz.pos.persistence.model.Sales;

public interface ISalesDao extends JpaRepository<Sales, Long> {

}
