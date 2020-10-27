package com.init.loginusers.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {

	// Campos de la clase
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	@Column(name = "firstname")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "position", nullable = true, length = 10)
	@Enumerated(value = EnumType.STRING)
	private UserEnum userenum;


	/**
	 * Constructor para la clase user
	 * @param id
	 * @param name
	 * @param 
	 * @param 
	 */
	
	public User() {
	}

	public User(Integer id, String name, String lastname, String email, String password, String phone,
			UserEnum userenum, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.userenum = userenum;
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", userenum=" + userenum + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserEnum getUserenum() {
		return userenum;
	}

	public void setUserenum(UserEnum userenum) {
		this.userenum = userenum;
	}

	public Integer getId() {
		return id;
	}


	}






