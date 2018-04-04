package com.muzz.pos.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(nullable = false)
    private String code;
	
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private double price;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(nullable = false)
    private boolean onSale;
    
    @Column(nullable = false)
    private int discount;
    
    @Column(nullable = false)
    private boolean byWeight;
    
    @Column(nullable = false)
    private String weightDescription;
}
