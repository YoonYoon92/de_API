package com.saydept.api.component.searchConer.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchConerParamModel extends SayEnvModel{
	
	private String jum;
	private String searchConer;
	
	private String searchConerUpper;
	private String searchConerLower;
	
	private String searchConerFullChar;
	private String searchConerFullCharUpper;
	private String searchConerFullCharLower;

}