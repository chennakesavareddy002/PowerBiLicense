package com.pbi.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="PBILICENSE")
@GenericGenerator(name="incrementGenerator",strategy="increment")
public class UserEntity {

	@Id
	@GeneratedValue(generator="incrementGenerator")
	private Integer requestId=null;
	private String aliasName=null;
	private String emailAddress=null;
	private String typeOfLicense=null;
	private String requestedDate=null;
	
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	
	
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getTypeOfLicense() {
		return typeOfLicense;
	}
	public void setTypeOfLicense(String typeOfLicense) {
		this.typeOfLicense = typeOfLicense;
	}
	
}
