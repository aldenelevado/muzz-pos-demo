package com.muzz.pos;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.muzz.pos.persistence.model.Products;


public class GrocerStoreCheckoutCounterTest {

	private List<Products> salesList;

	@Before
	public void initializeProducts() {
		
		salesList = new ArrayList<>();
		
		Products product1 = new Products();
		product1.setCode("X0001");
		product1.setName("Pure Foods");
		product1.setByBulk(false);
		product1.setUnitPrice(74.50);
		product1.setQuantity(1);
		product1.setOnSale(false);
		
		Products product2 = new Products();
		product2.setCode("X0002");
		product2.setName("Coffee");
		product2.setByBulk(true);
		product2.setUnitPrice(40.50);
		product2.setQuantity(1);
		product2.setOnSale(false);
		
		Products product3 = new Products();
		product3.setCode("X0003");
		product3.setName("Pork Per Kilo");
		product3.setByBulk(true);
		product3.setUnitPrice(20.50);
		product3.setQuantity(1);
		product3.setOnSale(true);
		product3.setDiscount(20.0);
		
		Products product4 = new Products();
		product4.setCode("X0004");
		product4.setName("Coke Bonus");
		product4.setByBulk(false);
		product4.setUnitPrice(15.50);
		product4.setQuantity(1);
		product4.setOnSale(true);
		product4.setDiscount(20.0); //percent
		
		Products product5 = new Products();
		product5.setCode("X0005");
		product5.setName("Chicken Bonus");
		product5.setByBulk(true);
		product5.setUnitPrice(50.50);
		product5.setQuantity(1);
		product5.setOnSale(true);
		product5.setDiscount(20.0); //percent
		
		salesList.add(product1);
		salesList.add(product2);
		salesList.add(product3);
		salesList.add(product4);
		salesList.add(product5);
	}

	@Test
	public void calculateProductsSoldByPiece() {
		// Pure Foods Unit Price 74.50
		// Coke Bonus Unit Price 15.50
		// Total Price 90
        double totalPrice = salesList.stream().filter(val -> val.isByBulk() == false)
        	.mapToDouble( val -> val.getUnitPrice() * val.getQuantity()).sum();
        assertEquals("TotalPrice was not correct.", 90.0, totalPrice, 0);
	}

	@Test
	public void calculateProductsSoldByBulk() {
		// Coffee Unit Price 40.50
		// Pork Per Kilo Unit Price 20.50
		// Chicken Bonus Unit Price 50.50
		// Total Price 111.5
		double totalPrice = salesList.stream().filter(val -> val.isByBulk() == true)
				.mapToDouble(val -> val.getUnitPrice() * val.getQuantity()).sum();
		assertEquals("TotalPrice was not correct.", 111.5, totalPrice, 0);
	}

	@Test
	public void calculateProductsOnSale() {
		// (unit price - (unit price x discount)) x qty
		// Pork Per Killo discount 20%; Unit Price = 20.5 ------ Formula (20.5 - (20.5 * .20)) x 1 = Discounted Price 16.4
		// Coke Bonus 	 discount 20%;  Unit Price = 15.5 ------ Formula (15.5 - (15.5 * .20)) x 1= Discounted Price 12.4
		// Pork Per Killo discount 20%; Unit Price = 50.5 ------ Formula (50.5 - (50.5 * .20)) x 1= Discounted Price 40.4
		// TOtal price 69.20
		double totalPrice = salesList.stream().filter(val -> val.isOnSale() == true)
	        	.mapToDouble( val -> (val.getUnitPrice() - (val.getUnitPrice() * (val.getDiscount() / 100.0)) * val.getQuantity())).sum();
		DecimalFormat df = new DecimalFormat("###.##");
		assertEquals("TotalPrice was not correct.", "69.2", df.format(totalPrice));
	}

	@Test
	public void printReceipt() {
		StringBuilder sb = new StringBuilder();
		double totalPrice = 0.00;
		String s = String.format("%-20s %5s %10s\n", "Item", "Qty", "Price");
		String s1 = String.format("%-20s %5s %10s\n", "----", "---", "-----");
		sb.append(s).append(s1);
		
		for (Products item : salesList) {
			StringBuilder printSb = new StringBuilder();
			double unitPrice = 0.00;
			if (item.isOnSale()) {
				unitPrice = (item.getUnitPrice() - (item.getUnitPrice() * (item.getDiscount() / 100.0)) * item.getQuantity());
				printSb.append(String.format("%-20s %5s %10s\n", item.getName() + (item.isByBulk() ? " (Bulk)" : ""), item.getQuantity(), unitPrice));
			} else {
				unitPrice = item.getUnitPrice() * item.getQuantity();
				printSb.append(String.format("%-20s %5s %10s\n", item.getName() + (item.isByBulk() ? " (Bulk)" : ""), item.getQuantity(), unitPrice));
			}
			totalPrice = totalPrice + unitPrice;
			sb.append(printSb);
		}
		String footer = String.format("%-20s %5s %10s\n", "", "", "-----");
		DecimalFormat df = new DecimalFormat("###.##");
		String total = String.format("%-20s %5s %10s\n", "Total", "", df.format(totalPrice));
		sb.append(footer).append(total);
		System.out.println(sb);
	}
}
