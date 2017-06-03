package com.store.checkout;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.checkout.controller.CheckoutController;
import com.store.checkout.model.ProductPrice;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutControllerTest {

	@Autowired
	CheckoutController checkoutController;
	
    /**
     * Check if Tax data loaded correctly.
     */
    @Test
    public void productPriceTest() {
    	 List<ProductPrice> products = checkoutController.getProducts();
    	 
    	 //check products are retrieved.
     	 org.junit.Assert.assertEquals(4, products.size());
     	 
     	 // check if correct tax is applied.
     	 for (ProductPrice productPrice : products) {
			if(productPrice.getCode() == 1){
				org.junit.Assert.assertEquals(10, productPrice.getTax().intValue());
			}
			if(productPrice.getCode() == 2){
				org.junit.Assert.assertEquals(10, productPrice.getTax().intValue());
			}
			if(productPrice.getCode() == 3){
				org.junit.Assert.assertEquals(20, productPrice.getTax().intValue());
			}
			if(productPrice.getCode() == 4){
				org.junit.Assert.assertEquals(0, productPrice.getTax().intValue());
			}

		}
    }
}
