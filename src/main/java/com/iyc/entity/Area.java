package com.iyc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the areaNames database table.
 * 
 */
@Entity
@Table(name="Area")
@NamedQuery(name="Area.findAll", query="SELECT u FROM Area u")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;


	private String areaName;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAreaName() {
		return areaName;
	}



	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	
	
	

	

}