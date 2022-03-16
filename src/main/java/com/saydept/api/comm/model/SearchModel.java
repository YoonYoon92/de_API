package com.saydept.api.comm.model;

import lombok.Data;

@Data
public class SearchModel extends SayEnvModel{

	private String startDt;		//시작일
	private String endDt;		//종료일
	private String posNo;		//POS번호
	
	
	private int page;			//page no
	private int start;			//시작 row num
	private int limit;			//마지막 row num
}
