package com.prokarma.api.customer.publiser.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class PublisherUtil {

	 private static Logger log = LoggerFactory.getLogger(PublisherUtil.class);

	public static String convertingObjectToJson(Object Input) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = ow.writeValueAsString(Input);
		} catch (JsonProcessingException e) {
			log.error("Error occured during conversion Object To Json :",e);
			e.printStackTrace();
		}
		return json;

	}

}
