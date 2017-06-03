package com.store.checkout.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Products can not be retrieved.")  // 404
public class ProductNotRetrievedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
