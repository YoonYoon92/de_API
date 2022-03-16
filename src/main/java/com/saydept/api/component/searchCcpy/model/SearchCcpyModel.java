package com.saydept.api.component.searchCcpy.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SearchCcpyModel extends SayEnvModel{
	
	private String jum;       			//점
	private String ccpy;      			//협력업체번호
	private String bizrNo;    			//사업자번호
	private String cmpNm;     			//거래처명
	private String rprsntvNm; 			//대표자명
	private String tel;       			//전화번호
	private String addr1;				//주소1	

}