package com.airport.mgmt.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER",schema="AirportMgmtSystem")
public class User {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@NotEmpty
	@Column(name="USER_NAME")
	private String userName;
	
	@NotEmpty
	@Column(name="PASSWORD")
	private String password;
	
	@NotEmpty
	@Column(name="ROLE")
	private String role;
	
	@NotEmpty
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@NotEmpty
	@Column(name="LASTTNAME")
	private String lastName;
	
	@Column(name="AGE")
	@NotNull @Min(0) @Max(150)
	private Integer age;
	
	@NotEmpty
	@Column(name="GENDER")
	private String gender;
	
	
	@Column(name="DOB")
	private String dateOfBirth;
	
	@NotNull @Min(0) @Max(100)
	@Column(name="CONTACT_NO")
	private Integer contactNo;
	
	@NotNull @Min(0) @Max(100)
	@Column(name="ALT_CONTACT_NO")
	private Integer altContactNo;
	
	@NotEmpty
	@Column(name="EMAIL")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(Integer altContactNo) {
		this.altContactNo = altContactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
