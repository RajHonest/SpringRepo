package com.airport.mgmt.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Plane",schema="AirportMgmtSystem")
public class Plane {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="OWNER_ID")
	private Integer ownerId;
	
	@NotEmpty
	@Column(name="OWNER_FIRSTNAME")
	@Size(min=2,max=30)
	private String ownerFirstName;
	
	@NotEmpty
	@Column(name="OWNER_LASTTNAME")
	@Size(min=2,max=30)
	private String ownerLastName;
	
	
	@Column(name="OWNER_CONTACT_NUMBER")
	//@NotNull @Min(10) @Max(10)
	private Integer ownerContactNumber;
	
	@NotEmpty
	@Column(name="OWNER_EMAIL")
	@Size(min=2,max=30)
	private String ownerEmail;
	
	@NotEmpty
	@Column(name="TYPE")
	@Size(min=2,max=30)
	private String planeType;
	
	@Column(name="CAPACITY")
	@NotNull @Min(0) @Max(100)
	private Integer planeCapacity;
	
	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plane(Integer id, Integer ownerId, String ownerFirstName, String ownerLastName, Integer ownerContactNumber, String ownerEmail,
			String planeType, Integer planeCapacity) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerContactNumber = ownerContactNumber;
		this.ownerEmail = ownerEmail;
		this.planeType = planeType;
		this.planeCapacity = planeCapacity;
		this.ownerEmail = ownerEmail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public Integer getOwnerContactNumber() {
		return ownerContactNumber;
	}
	public void setOwnerContactNumber(Integer ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public Integer getPlaneCapacity() {
		return planeCapacity;
	}
	public void setPlaneCapacity(Integer planeCapacity) {
		this.planeCapacity = planeCapacity;
	}
	
}
