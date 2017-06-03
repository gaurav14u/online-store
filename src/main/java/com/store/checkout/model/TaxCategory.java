package com.store.checkout.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TAX_CATEGORY")
public class TaxCategory {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;

	@Column(name = "TAX", nullable = false)
	private Double tax;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}
