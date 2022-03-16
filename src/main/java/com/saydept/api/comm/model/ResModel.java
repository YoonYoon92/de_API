package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class ResModel extends SayEnvModel{
	
	private String code;
	private String message;  
	private Object data;	

}