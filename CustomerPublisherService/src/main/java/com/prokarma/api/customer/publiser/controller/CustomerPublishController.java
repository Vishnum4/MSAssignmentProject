package com.prokarma.api.customer.publiser.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.api.customer.publiser.converter.Converter;
import com.prokarma.api.customer.publiser.converterImpl.CustomerDetailsMaskConverter;
import com.prokarma.api.customer.publiser.domain.CustomerRequest;
import com.prokarma.api.customer.publiser.domain.CustomerResponse;
import com.prokarma.api.customer.publiser.kafka.KafkaPublisher;
import com.prokarma.api.customer.publiser.util.PublisherUtil;

@RestController
@RequestMapping("api/v1")
public class CustomerPublishController {

	private static Logger log = LoggerFactory.getLogger(CustomerPublishController.class);
	
	@Value("${spring.kafka.publishing_topic}")
	private String Publishingtopic;

	@Autowired
	private Converter converter;
	
	@Autowired
	private KafkaPublisher kafkaPublisher;


	@PostMapping(path = "/customer-register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponse> publishCustomerDetails(
			@RequestHeader(value = "AuthorizationId") String authorization,
			@RequestHeader(value = "Transaction-Id") String transactionId,
			@RequestHeader(value = "Activity-Id") String activityId, @RequestBody @Valid CustomerRequest customer) {
		CustomerRequest maskedCustomer = converter.convert(customer);
		String customerRequestJson = PublisherUtil.convertingObjectToJson(maskedCustomer);
		log.info("Customer Details Request {}",customerRequestJson);
		CustomerResponse response=kafkaPublisher.sendMessageTokafka(maskedCustomer, Publishingtopic);
		String CustomerResponseJson=PublisherUtil.convertingObjectToJson(response);
		log.info("Customer Response {}",CustomerResponseJson);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
