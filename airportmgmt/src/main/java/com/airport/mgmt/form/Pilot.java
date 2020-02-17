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
@Table(name="PILOT",schema="AirportMgmtSystem")
public class Pilot {

	@Id
	@Column(name="PILOT_ID")
	private Integer pilotId;
	
	@NotEmpty
	@Column(name="PILOT_NAME")
	@Size(min=2,max=30)
	private String pilotName;
	
	@NotEmpty
	@Column(name="LICENSE_NO")
	@Size(min=2,max=30)
	private String licenseNo;
	
	@NotEmpty
	@Column(name="ADDRESS_LINE1")
	@Size(min=2,max=30)
	private String addressLine1;
	
	@NotEmpty
	@Column(name="ADDRESS_LINE2")
	@Size(min=2,max=30)
	private String addressLine2;
	
	@NotEmpty
	@Column(name="CITY")
	@Size(min=2,max=30)
	private String city;
	
	@NotEmpty
	@Column(name="STATE")
	@Size(min=2,max=30)
	private String state;
	
	@Column(name="ZIPCODE")
	@NotNull @Min(0) @Max(10)
	private String zipCode;
	

	@Column(name="SSN")
	@NotNull @Min(0) @Max(100)
	private Integer ssn;

	public Integer getPilotId() {
		return pilotId;
	}

	public void setPilotId(Integer pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	
	
	
	
}
