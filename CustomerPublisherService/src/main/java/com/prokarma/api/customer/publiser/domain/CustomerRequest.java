package com.prokarma.api.customer.publiser.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.prokarma.api.customer.publiser.domain.CustomerAddress;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CustomerRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-13T14:05:19.351Z[GMT]")

public class CustomerRequest {
	@JsonProperty("customerId")
	private String customerId = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")
	private String lastName = null;

	@JsonProperty("birthDate")
	private String birthDate = null;

	@JsonProperty("countryCode")
	private String countryCode = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("mobileNumber")
	private Integer mobileNumber = null;

	/**
	 * Customer Status
	 */
	public enum CustomerStatusEnum {
		OPEN("Open"),

		CLOSED("Closed"),

		SUSPENDED("Suspended"),

		RESTORED("Restored");

		private String value;

		CustomerStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CustomerStatusEnum fromValue(String text) {
			for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("customerStatus")
	private CustomerStatusEnum customerStatus = null;

	@JsonProperty("address")
	private CustomerAddress address = null;

	public CustomerRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	/**
	 * customerID format Alphanumeric :C000000001
	 * 
	 * @return customerId
	 **/
	@Schema(required = true, description = "customerID format Alphanumeric :C000000001")
	@NotNull

	@Size(max = 10)
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public CustomerRequest firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * customer firstName
	 * 
	 * @return firstName
	 **/
	@Schema(required = true, description = "customer firstName")
	@NotNull

	@Size(min = 10, max = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public CustomerRequest lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * customer LastName
	 * 
	 * @return lastName
	 **/
	@Schema(required = true, description = "customer LastName")
	@NotNull

	@Size(min = 10, max = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerRequest birthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Date of Birth of customer of format DD-MM-YYYY
	 * 
	 * @return birthDate
	 **/
	@Schema(required = true, description = "Date of Birth of customer of format DD-MM-YYYY")
	@NotNull

	@Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$")
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public CustomerRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * Country Code of customer
	 * 
	 * @return countryCode
	 **/
	@Schema(required = true, description = "Country Code of customer")
	@NotNull

	@Size(max = 2)
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public CustomerRequest country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * customer Country name
	 * 
	 * @return country
	 **/
	@Schema(required = true, description = "customer Country name")
	@NotNull

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerRequest email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Must be Email ID of customer
	 * 
	 * @return email
	 **/
	@Schema(required = true, description = "Must be Email ID of customer")
	@NotNull

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerRequest mobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	/**
	 * customer mobile Number
	 * 
	 * @return mobileNumber
	 **/
	@Schema(required = true, description = "customer mobile Number")
	@NotNull

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerRequest customerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
		return this;
	}

	/**
	 * Customer Status
	 * 
	 * @return customerStatus
	 **/
	@Schema(required = true, description = "Customer Status")
	@NotNull

	public CustomerStatusEnum getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
	}

	public CustomerRequest address(CustomerAddress address) {
		this.address = address;
		return this;
	}

	/**
	 * Get address
	 * 
	 * @return address
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerRequest customerRequest = (CustomerRequest) o;
		return Objects.equals(this.customerId, customerRequest.customerId)
				&& Objects.equals(this.firstName, customerRequest.firstName)
				&& Objects.equals(this.lastName, customerRequest.lastName)
				&& Objects.equals(this.birthDate, customerRequest.birthDate)
				&& Objects.equals(this.countryCode, customerRequest.countryCode)
				&& Objects.equals(this.country, customerRequest.country)
				&& Objects.equals(this.email, customerRequest.email)
				&& Objects.equals(this.mobileNumber, customerRequest.mobileNumber)
				&& Objects.equals(this.customerStatus, customerRequest.customerStatus)
				&& Objects.equals(this.address, customerRequest.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, firstName, lastName, birthDate, countryCode, country, email, mobileNumber,
				customerStatus, address);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CustomerRequest {\n");

		sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
		sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
