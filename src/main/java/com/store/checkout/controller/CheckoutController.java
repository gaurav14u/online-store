package com.store.checkout.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.checkout.ExceptionHandler.ProductNotRetrievedException;
import com.store.checkout.model.ProductPrice;
import com.store.checkout.service.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	  private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private CheckoutService checkoutService;
	
	@RequestMapping(path="/repo", method = RequestMethod.GET)
	public @ResponseBody List<ProductPrice> getProducts(){
		
		try{
		Map<String, Double> taxes = checkoutService.getTaxes();
		List<ProductPrice> productPricesWithTax = checkoutService.getListOfProductWithTaxes(taxes);
		return productPricesWithTax;
		}catch(Exception e){
			throw new ProductNotRetrievedException();
		}
	}
	
	@ExceptionHandler(value = ProductNotRetrievedException.class)
    public String handleException(ProductNotRetrievedException p) {
		log.error("Exception occured ", p.getCause());
		return p.getMessage();
    }

}
