package com.muzz.pos.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SalesDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String productCode;
	
	@Column(nullable = false)
	private int qty;
	
	@Column(nullable = false)
	private double unitPrice;

	@ManyToOne
	@JoinColumn(name = "id")
	private Sales sales;

}
