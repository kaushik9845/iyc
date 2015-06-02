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
@Table(name="WebsiteCounter")
@NamedQuery(name="WebsiteCounter.findAll", query="SELECT u FROM WebsiteCounter u")
public class WebsiteCounter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;


	private String ip;

	private int counter; 

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	

	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public int getCounter() {
		return counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}







	
	
	

	

}