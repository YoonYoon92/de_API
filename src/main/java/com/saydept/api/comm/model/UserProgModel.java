package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class UserProgModel extends SayEnvModel{

	private String userId;
	private String id;					//프로그램 ID
	private Boolean checked;	
}
