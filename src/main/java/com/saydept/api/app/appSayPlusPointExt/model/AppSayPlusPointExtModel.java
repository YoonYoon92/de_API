package com.saydept.api.app.appSayPlusPointExt.model;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
//public class AppSayPlusPointExtModel extends SayEnvModel{
public class AppSayPlusPointExtModel {

	private String jum;					//점
	private String cdNo;				//회원번호
	private String maedate;			//매출일자
	private String extdate;			//매출일자
	private double extpoint; 				//총매출
	private double usedpoint;				//할인
	private double extrealpoint;				//순매출
	
}
