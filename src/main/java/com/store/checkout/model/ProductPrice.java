package com.store.checkout.model;

public class ProductPrice {

	Integer code;
	
	String name;
	
	Double price;
	
	Double tax;

	
	
	public ProductPrice(Integer code, String name, Double price, Double tax) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.tax = tax;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	
	
}
