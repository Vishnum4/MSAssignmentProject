package com.prokarma.api.customer.consumer.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "AUDIT_LOG")
public class Audit {

	@Id
	@GeneratedValue
	private int id;
	@Column
	@NonNull
	private String customerNumber;
	@Column(name = "payload", insertable = true, nullable = true, updatable = true, columnDefinition = "json")
	private String payload;

	public Audit(int id, String customerNumber, String payload) {
		super();
		this.id = id;
		this.customerNumber = customerNumber;
		this.payload = payload;
	}

	public Audit() {
		super();
		// TODO Auto-generated constructor stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Audit [id=" + id + ", customerNumber=" + customerNumber + ", payload=" + payload + "]";
	}

}
