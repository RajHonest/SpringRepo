package com.airport.mgmt.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@NotEmpty
	@Column(name="AGE")
	private Integer age;
	
	@NotEmpty
	@Column(name="GENDER")
	private String gender;
	
	
	@Column(name="DOB")
	private String dateOfBirth;
	
	@NotEmpty
	@Column(name="CONTACT_NO")
	private Integer contactNo;
	
	@Column(name="ALT_CONTACT_NO")
	private Integer altContactNo;
	
	@NotEmpty
	@Column(name="EMAIL")
	private String email;
	
}
