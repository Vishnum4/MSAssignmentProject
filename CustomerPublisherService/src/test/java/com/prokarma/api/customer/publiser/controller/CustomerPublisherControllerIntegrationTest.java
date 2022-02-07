package com.prokarma.api.customer.publiser.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.prokarma.api.customer.publiser.converter.Converter;
import com.prokarma.api.customer.publiser.domain.CustomerAddress;
import com.prokarma.api.customer.publiser.domain.CustomerRequest;
import com.prokarma.api.customer.publiser.domain.CustomerRequest.CustomerStatusEnum;
import com.prokarma.api.customer.publiser.util.PublisherUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerPublisherControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private KafkaTemplate<String, Object> kafkaTemplate;

	@MockBean
	private Converter converter;

	@Test
	public void customerRequestDetailsTest() throws Exception {
		CustomerRequest request = customerRequest();
		String jsonBody = PublisherUtil.convertingObjectToJson(request);
		String accessToken = obtainAccessToken("Vishnu", "secret");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customer-register")
				.header("AuthorizationId", "bearer " + accessToken).header("Transaction-Id", "Trans1")
				.header("Activity-Id", "activity1").contentType(MediaType.APPLICATION_JSON).content(jsonBody))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	private String obtainAccessToken(String username, String password) throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "client_credentials");
		params.add("client_id", "Vishnu");
		params.add("username", username);
		params.add("password", password);
		ResultActions result = mockMvc
				.perform(post("/oauth/token").params(params).with(httpBasic("Vishnu", "secret"))
						.accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
		String resultString = result.andReturn().getResponse().getContentAsString();
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();

	}

	private CustomerRequest customerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setCustomerId("W200000033");
		request.setFirstName("Vishnuygtfrd");
		request.setLastName("Mirupalafrdes");
		request.setEmail("Vishnu@gmail.com");
		request.setCustomerStatus(CustomerStatusEnum.OPEN);
		request.setCountry("india");
		request.setMobileNumber("9676114532");
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
