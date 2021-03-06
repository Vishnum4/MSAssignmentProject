package com.prokarma.api.customer.publiser.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CustomerResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-13T14:05:19.351Z[GMT]")

public class CustomerResponse {
	@JsonProperty("status")
	private String status = null;

	@JsonProperty("message")
	private String message = null;

	public CustomerResponse status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Sucess
	 * 
	 * @return status
	 **/
	@Schema(required = true, description = "Sucess")
	@NotNull

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerResponse message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * message pushed to kafka
	 * 
	 * @return message
	 **/
	@Schema(required = true, description = "message pushed to kafka")
	@NotNull

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerResponse customerResponse = (CustomerResponse) o;
		return Objects.equals(this.status, customerResponse.status)
				&& Objects.equals(this.message, customerResponse.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, message);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CustomerResponse {\n");

		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
