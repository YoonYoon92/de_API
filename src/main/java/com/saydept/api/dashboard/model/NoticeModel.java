package com.saydept.api.dashboard.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class NoticeModel extends SayEnvModel{

	private String noticeDate;	//년도
	private String seq;			//순번
	private String userId; 		//사번
	private String title;		//제목
	private String desc; 		//내용
	private String readYn;  	//읽음여부
	
	//달력형식 필요 model
	private String start;		//시작일
	private String end;			//종료일
	private String endOrg;		//종료일
}
