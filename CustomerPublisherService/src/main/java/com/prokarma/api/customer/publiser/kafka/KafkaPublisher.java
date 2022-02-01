package com.prokarma.api.customer.publiser.kafka;

import com.prokarma.api.customer.publiser.domain.CustomerRequest;

import com.prokarma.api.customer.publiser.domain.CustomerResponse;

public interface KafkaPublisher {

	CustomerResponse sendMessageTokafka(CustomerRequest request, String topicName);

}
