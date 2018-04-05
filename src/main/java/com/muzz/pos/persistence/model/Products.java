package com.muzz.pos.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(nullable = false)
    private String code;
	
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private double unitPrice;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(nullable = false)
    private boolean onSale;
    
    @Column(nullable = false)
    private double discount;
    
    @Column(nullable = false)
    private boolean byBulk;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isByBulk() {
		return byBulk;
	}

	public void setByBulk(boolean byBulk) {
		this.byBulk = byBulk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
