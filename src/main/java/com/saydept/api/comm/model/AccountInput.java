package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class AccountInput extends SayEnvModel{
	
	
	private String userId;
	private String userPw;
	private String userIp;

}



