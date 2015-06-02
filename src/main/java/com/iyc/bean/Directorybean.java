package com.iyc.bean;

import java.math.BigInteger;

public class Directorybean {

	private int id;

	private String description;

	private int important;
	
	private String serviceName;

	private int serviceId;
	
	private String areaName;

	private int areaId;
	
	private String name;
	
	private BigInteger mobile;

	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
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
