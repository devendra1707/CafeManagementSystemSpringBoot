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

//@NamedQuery(name = "Category.getAllCategory", query = "SELECT c from Category c")

@NamedQuery(name = "Category.getAllCategory", query = "SELECT c from Category c WHERE c.id in (SELECT p.category from Product p WHERE p.status='true')")


@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "category")

public class Category implements Serializable {

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
}
