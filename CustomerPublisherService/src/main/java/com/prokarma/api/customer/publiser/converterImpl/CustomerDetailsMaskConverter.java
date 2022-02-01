package com.prokarma.api.customer.publiser.converterImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prokarma.api.customer.publiser.converter.Converter;
import com.prokarma.api.customer.publiser.domain.CustomerRequest;
import com.prokarma.api.customer.publiser.util.PublisherConstants;

@Component
public class CustomerDetailsMaskConverter implements Converter {
	
	public CustomerRequest convert(CustomerRequest customerRequest) {
		CustomerRequest customer = new CustomerRequest();
		customer.setCustomerId(customerRequest.getCustomerId().replaceAll(PublisherConstants.CUSTOMER_EXPRESSION, "*"));
		customer.setFirstName(customerRequest.getFirstName());
		customer.setLastName(customerRequest.getLastName());
		customer.setBirthDate(customerRequest.getBirthDate().replaceAll(PublisherConstants.DOB_EXPRESSION, "*"));
		customer.setCountry(customerRequest.getCountry());
		customer.setCountryCode(customerRequest.getCountryCode());
		customer.setMobileNumber(customerRequest.getMobileNumber());
		customer.setEmail(customerRequest.getEmail().replaceAll(PublisherConstants.EMAIL_EXPRESSION, "*"));
		customer.setCustomerStatus(customerRequest.getCustomerStatus());
		customer.address(customerRequest.getAddress());
		return customer;

	}

}
