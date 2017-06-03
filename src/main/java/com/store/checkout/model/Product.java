package com.store.checkout.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "PRICE", nullable = false)
	private Double price;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToOne
    @JoinColumn(name = "TAX_CATEGORY_ID")	
	private TaxCategory taxCategory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}
	


}
