package com.saydept.api.comm.pwdChg.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class PwdChgModel extends SayEnvModel{

	private String userId;
	private String userName;
	private String password;
	private String chgPw;
	private String chgPw2;
	

}