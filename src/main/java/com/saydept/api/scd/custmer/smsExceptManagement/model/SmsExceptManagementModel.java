package com.saydept.api.scd.custmer.smsExceptManagement.model;

import lombok.Data;

@Data
public class SmsExceptManagementModel {

	private String id;
	private String name;
	
	private String telNum;
	private String excetpTelNum;
	private String excetpTelDt;

}