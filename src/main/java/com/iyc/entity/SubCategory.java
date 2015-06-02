package com.iyc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the subcategorys database table.
 * 
 */
@Entity
@Table(name="subcategory")
@NamedQuery(name="subcategory.findAll", query="SELECT u FROM SubCategory u")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String subcategory;
	
	//bi-directional many-to-one association to Securityquestion
		@ManyToOne
		@JoinColumn(name="categoryId")
		private Category category;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getSubcategory() {
		return subcategory;
	}



	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	

	

}