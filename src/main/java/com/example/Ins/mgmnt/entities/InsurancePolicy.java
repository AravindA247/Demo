package com.example.Ins.mgmnt.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="InsurancePolicy")
public class InsurancePolicy {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insurancePolicy_id;
	
	private String policyNumber;
	
	private String type;
	
	private BigDecimal coverageamount;
	
	private BigDecimal premium;
	
	private OffsetDateTime Startdate;
	
	private OffsetDateTime enddate;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;

	public int getId() {
		return insurancePolicy_id;
	}

	public void setId(int insurancePolicy_id) {
		this.insurancePolicy_id = insurancePolicy_id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCoverageamount() {
		return coverageamount;
	}

	public void setCoverageamount(BigDecimal coverageamount) {
		this.coverageamount = coverageamount;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public OffsetDateTime getStartdate() {
		return Startdate;
	}

	public void setStartdate(OffsetDateTime startdate) {
		Startdate = startdate;
	}

	public OffsetDateTime getEnddate() {
		return enddate;
	}

	public void setEnddate(OffsetDateTime enddate) {
		this.enddate = enddate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}