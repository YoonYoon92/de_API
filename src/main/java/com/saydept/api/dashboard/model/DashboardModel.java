package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.AccountModel;
import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DashboardModel extends SayEnvModel{
	private AccountModel account;  //로그인 정보
	
	private String saleDate;	//조회일자
}
