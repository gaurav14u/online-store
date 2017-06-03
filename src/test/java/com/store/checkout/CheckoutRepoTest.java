package com.store.checkout;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.checkout.model.Product;
import com.store.checkout.model.TaxCategory;
import com.store.checkout.repo.ProductJpaRepository;
import com.store.checkout.repo.TaxCategoryJpaRepository;
import org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutRepoTest {
    
    @Autowired
    TaxCategoryJpaRepository taxCategoryJpaRepository;

    @Autowired
    ProductJpaRepository productCategoryJpaRepository;

    
    /**
     * Check if Tax data loaded correctly.
     */
    @Test
    public void taxLoadDataTest() {
    	List<TaxCategory> findAll = taxCategoryJpaRepository.findAll();
    	
    	assertEquals(3, findAll.size());
    	
    	List<String> collect = findAll.stream().map(tax -> tax.getCategory()).collect(Collectors.toList());
    	assertTrue(collect.contains("A"));
    	assertTrue(collect.contains("B"));
    	assertTrue(collect.contains("C"));
    	assertFalse(collect.contains("D"));
    	
    }
    
    /**
     * check if product data is loaded correctly.
     */
    @Test
    public void productLoadDataTest() {
    	List<Product> findAll = productCategoryJpaRepository.findAll();
    	
    	org.junit.Assert.assertEquals(4, findAll.size());
    }
   
}
