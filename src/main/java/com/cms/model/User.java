package com.cms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email =:email")

@NamedQuery(name = "User.getAllUser", query = "SELECT new com.cms.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) from User u where u.role='user'")

@NamedQuery(name = "User.updateStatus", query = "UPDATE User u set u.status =: status where u.id=:id")

@NamedQuery(name = "User.getAllAdmin", query = "SELECT u.email from User u where u.role='admin'")



@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final long serialVariableUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	
	@Column(name = "contactNumber")
	private String contactNumber;

	
	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@Column(name = "role")
	private String role;

}
