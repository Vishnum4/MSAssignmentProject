package com.prokarma.api.customer.publiser.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.prokarma.api.customer.publiser.domain.CustomerRequest;
import com.prokarma.api.customer.publiser.domain.CustomerResponse;
import com.prokarma.api.customer.publiser.kafka.KafkaPublisher;
import com.prokarma.api.customer.publiser.util.PublisherConstants;

@Component
public class KafkaPublisherImpl implements KafkaPublisher {

	@SuppressWarnings("rawtypes")
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Value("${spring.kafka.publishing_topic}")
	private String Publishingtopic;

	@SuppressWarnings("unchecked")
	public CustomerResponse sendMessageTokafka(CustomerRequest request) {
		kafkaTemplate.send(Publishingtopic, request);
		return customerResponse();
	}

	private CustomerResponse customerResponse() {
		CustomerResponse response = new CustomerResponse();
		response.setStatus(PublisherConstants.SUCCESS);
		response.setMessage("Pushed Message to kafka sucessfully");
		return response;
	}

}
