package com.store.checkout.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.checkout.model.Product;
import com.store.checkout.model.ProductPrice;
import com.store.checkout.model.TaxCategory;
import com.store.checkout.repo.ProductJpaRepository;
import com.store.checkout.repo.TaxCategoryJpaRepository;

@Service
public class CheckoutService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Autowired
	private TaxCategoryJpaRepository taxCategoryJpaRepository;

	public Map<String, Double> getTaxes() {
		List<TaxCategory> taxes = taxCategoryJpaRepository.findAll();
		
		log.info(taxes.size() + " tax categories found.");
		
		Map<String, Double> taxCategories = taxes.stream()
				.collect(Collectors.toMap(TaxCategory::getCategory, TaxCategory::getTax));

		return taxCategories;
	}

	public List<ProductPrice> getListOfProductWithTaxes(Map<String, Double> taxes) {
		List<Product> products = productJpaRepository.findAll();
		
		log.info(products.size() + "products found.");

		List<ProductPrice> productPricesWithTax = products.stream()
				.map(p -> new ProductPrice(p.getId(), p.getName(), p.getPrice(), p.getTaxCategory().getTax()))
				.collect(Collectors.toList());
		return productPricesWithTax;
	}
}
