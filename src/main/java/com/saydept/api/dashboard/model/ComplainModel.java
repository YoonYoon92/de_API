package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ComplainModel extends SayEnvModel{

	private String rcpDate; //접수일
	private String endDate; //종료일
	private String rcpSeq;	//접수번호
	private String bu;		//발생부서
	private String title; 	//발생내용
	private String yn;		//처리완료여부
	private String desc; 	//내용
	private String desc2; 	//내용
	private String desc3; 	//내용
	
	
}
