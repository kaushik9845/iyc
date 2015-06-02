package com.iyc.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name="Directory")
@NamedQuery(name="Directory.findAll", query="SELECT u FROM Directory u")
public class Directory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;
	
	private int important;
	
		@ManyToOne
		@JoinColumn(name="serviceId")
		private Services service;

		@ManyToOne
		@JoinColumn(name="areaId")
		private Area area;
		
		private String name;
		
		private BigInteger mobile;

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getImportant() {
		return important;
	}



	public void setImportant(int important) {
		this.important = important;
	}



	public Services getService() {
		return service;
	}



	public void setService(Services service) {
		this.service = service;
	}



	public Area getArea() {
		return area;
	}



	public void setArea(Area area) {
		this.area = area;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public BigInteger getMobile() {
		return mobile;
	}



	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	


	

	
	
	

	

}