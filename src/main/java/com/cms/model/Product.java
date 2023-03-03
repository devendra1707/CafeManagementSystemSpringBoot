package com.cms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@NamedQuery(name = "Product.getAllProduct" , query = "SELECT new com.cms.wrapper.ProductWrapper(p.id,p.name,p.description,p.price, p.status, p.category.id, p.category.name) FROM Product p")

@NamedQuery(name = "Product.updateProductStatus" , query = "UPDATE Product p set p.status=:status WHERE p.id=:id ")

@NamedQuery(name = "Product.getProductByCategory" , query = "SELECT new com.cms.wrapper.ProductWrapper(p.id,p.name) FROM Product p WHERE p.category.id=:id and p.status='true' ")

@NamedQuery(name = "Product.getProductById" , query = "SELECT new com.cms.wrapper.ProductWrapper(p.id,p.name,p.description,p.price) FROM Product p WHERE p.id=:id")


@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product")
public class Product implements Serializable {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_fk", nullable = false)
	private Category category;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "status")
	private String status;

}
