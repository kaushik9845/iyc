package com.iyc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the Infos database table.
 * 
 */
@Entity
@Table(name="Info")
@NamedQuery(name="Info.findAll", query="SELECT u FROM Info u")
public class Info implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String title;
	
	private String description;
	
	private String fileName;
	
	private Date updatedTime;
	
	
	
	public Date getUpdatedTime() {
		return updatedTime;
	}



	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}



		//bi-directional many-to-one association to Securityquestion
		@ManyToOne
		@JoinColumn(name="subCategoryId")
		private SubCategory subCategory;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public SubCategory getSubCategory() {
		return subCategory;
	}



	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	
	
	
	

	

}