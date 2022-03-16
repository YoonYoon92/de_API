package com.saydept.api.scd.custmer.dmEventHisInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class DmEventHisInqT03Model extends SayEnvModel{

	private String cond;                //구분
	private String condNm;              //구분명
	private String condDtl;             //세부내용
	
}