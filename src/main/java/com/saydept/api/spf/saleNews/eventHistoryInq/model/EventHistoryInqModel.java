package com.saydept.api.spf.saleNews.eventHistoryInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class EventHistoryInqModel extends SayEnvModel{

	private String dbType;
	private String startDt; 	   	/*조회일*/
	private String eventCd;     	//행사코드
	private String eventNm;   		//이벤트명
	private String eventstartDt;  	//이벤트시작일
	private String eventendDt; 		//이벤트종요일
	private String Dqty;			//일수
	
}