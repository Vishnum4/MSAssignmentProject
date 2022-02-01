package com.prokarma.api.customer.publiser.converter;

import com.prokarma.api.customer.publiser.domain.CustomerRequest;

public interface Converter {

	CustomerRequest convert(CustomerRequest customerRequest);

}
