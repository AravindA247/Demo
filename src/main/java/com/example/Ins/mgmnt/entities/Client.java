package com.example.Ins.mgmnt.entities;



import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Client")
public class Client {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int client_id;

	private String name;
	
	private OffsetDateTime DateOfBirth;

	private String address;
	
	private String ContactInformation;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OffsetDateTime getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(OffsetDateTime dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInformation() {
		return ContactInformation;
	}

	public void setContactInformation(String contactInformation) {
		ContactInformation = contactInformation;
	}
}

//	public int getId() {
//		return client_id;
//	}
//
//	public void setId(int client_id) {
//		this.client_id = client_id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Date getDateOfBirth() {
//		return DateOfBirth;
//	}
//
//	public void setDateOfBirth(Date dateOfBirth) {
//		DateOfBirth = dateOfBirth;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getContactInformation() {
//		return ContactInformation;
//	}
//
//	public void setContactInformation(String contactInformation) {
//		ContactInformation = contactInformation;
//	}
//}
