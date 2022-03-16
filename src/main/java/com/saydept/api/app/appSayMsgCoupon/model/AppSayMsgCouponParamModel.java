package com.saydept.api.app.appSayMsgCoupon.model;

//import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
//public class AppSayMsgCouponParamModel extends SayEnvModel{
public class AppSayMsgCouponParamModel {

	private String jum;				//점
	private String frDate;          //시작검색일자
	private String toDate;          //종료검색일자
	private String onlineChk;		//입력
}
