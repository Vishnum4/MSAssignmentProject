package com.prokarma.api.customer.publiser.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.prokarma.api.customer.publiser.converterImpl.CustomerDetailsMaskConverter;
import com.prokarma.api.customer.publiser.domain.CustomerAddress;
import com.prokarma.api.customer.publiser.domain.CustomerRequest;
import com.prokarma.api.customer.publiser.domain.CustomerRequest.CustomerStatusEnum;

@Tag("unit")
public class CustomerDetailsMaskConverterTest {

	private CustomerDetailsMaskConverter customerDetailsMaskConverter;

	@BeforeEach
	public void setUp() {
		customerDetailsMaskConverter = new CustomerDetailsMaskConverter();

	}

	@Test
	public void testPassingCustomerRequestShouldApplyMaskingLogicToRequestObjec()
	{
		CustomerRequest request = customerDetailsMaskConverter.convert(customerRequest());
		assertNotNull(request);
		assertEquals("E20000****", request.getCustomerId());
		assertEquals("**-**-1995", request.getBirthDate());
		assertEquals("***@gmail.com", request.getEmail());

	}

	private CustomerRequest customerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setCustomerId("E200000033");
		request.setFirstName("Vishnu");
		request.setLastName("mirupala");
		request.setEmail("Vishnu@gmail.com");
		request.setCustomerStatus(CustomerStatusEnum.OPEN);
		request.setCountry("india");
		request.setCountryCode("IN");
		request.setBirthDate("07-08-1995");
		request.setAddress(createCustomerAddress());
		return request;

	}

	private CustomerAddress createCustomerAddress() {
		CustomerAddress customerAdress = new CustomerAddress();
		customerAdress.setAddressLine1("parkal");
		customerAdress.setAddressLine2("parkal");
		customerAdress.setStreet("parkal");
		customerAdress.setPostalCode("50616");
		return customerAdress;
	}

}
