package com.saydept.api.admin.userProgListManagement.model;

import com.saydept.api.comm.model.SayEnvModel;


import lombok.Data;

@Data
public class UserProgListManagementModel extends SayEnvModel{

	private String zd0101  	; 	//메뉴그룹id
	private String zd0102  	; 	//메뉴id
	private String zd0102Com  	; 	//메뉴id
	private String zd0103  	; 	//메뉴명

	private String zd0201;
	private String zd0202;
	private String zd0203;
	private String zd0204;
	private String zd02Com;
	
}