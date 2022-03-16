package com.saydept.api.component.searchClass.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchClassParamModel extends SayEnvModel{
	
	private String jum;
	private String searchClass;
	
	private String searchClassUpper;
	private String searchClassLower;
	
	private String searchClassFullChar;
	private String searchClassFullCharUpper;
	private String searchClassFullCharLower;

}