package com.saydept.api.component.searchCcpy.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchCcpyParamModel extends SayEnvModel{
	
	private String jum;
	private String searchCcpy;
	
	private String searchCcpyUpper;
	private String searchCcpyLower;
	
	private String searchCcpyFullChar;
	private String searchCcpyFullCharUpper;
	private String searchCcpyFullCharLower;

}