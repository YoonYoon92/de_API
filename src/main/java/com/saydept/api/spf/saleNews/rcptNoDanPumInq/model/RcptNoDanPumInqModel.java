package com.saydept.api.spf.saleNews.rcptNoDanPumInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class RcptNoDanPumInqModel extends SayEnvModel{

	private String maeDate;				//판매일
	private String rcptNo;				//영수증
	private String danCode;          //단품코드
	private String hsGuNm;           //구분
	private String regiNo;        //레지
	private String regiNm;        //레지명
	private String hsG1Nm;           //시재1
	private String clsNo;           //클래스
	private double danPum;         //단품
	private double danName;         //단품	
	private double cntPum;         //수량
	private double halGum;         //할인
	/*실적*/
//	private String clsNm;               //클래스명
//	private String smm;                 //조회일
//	private double thisYySplan;			//당년계획
//	private double thisYyNetsale;		//당년매출
//	private double lastYySplan;			//전년계획
//	private double lastYyNetsale;		//전년매출
//	private double achivmentrate;		//당년달성율
//	private double incrsrate;			//당년신장율

}
