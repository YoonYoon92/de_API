package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class SayEnvModel {
	private String dbType;
	
	public 	SayEnvModel() {
		dbType = DbConfig.getInstance().getDbType();
	}
}
