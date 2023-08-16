package com.example.data.jpa.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Voucher {

	@Id
	@GeneratedValue
	private Integer id;

	private String msisdn;

	private int status;

	private Date dateCreated;

	protected Voucher() {
	}

	public Voucher(String msisdn, int status) {
		this.id = null;
		this.msisdn = msisdn;
		this.status = status;
		this.dateCreated = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Voucher voucher = (Voucher) o;
		return status == voucher.status && Objects.equals(id, voucher.id) && Objects.equals(msisdn, voucher.msisdn)
				&& Objects.equals(dateCreated, voucher.dateCreated);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, msisdn, status, dateCreated);
	}

	@Override
	public String toString() {
		return "Voucher{" + "id=" + id + ", msisdn='" + msisdn + '\'' + ", status=" + status + ", dateCreated="
				+ dateCreated + '}';
	}

}
