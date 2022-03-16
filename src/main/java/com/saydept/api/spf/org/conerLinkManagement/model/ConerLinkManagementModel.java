package com.saydept.api.spf.org.conerLinkManagement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerLinkManagementModel extends SayEnvModel{
	private String startDt;
	private String jum;
	private String coner;
	private String conerNm;
	private String linkConerNm;
	private String linkConer;
	private String regiDt;
}