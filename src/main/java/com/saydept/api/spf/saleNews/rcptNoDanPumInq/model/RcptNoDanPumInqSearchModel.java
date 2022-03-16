package com.saydept.api.spf.saleNews.rcptNoDanPumInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class RcptNoDanPumInqSearchModel  extends SayEnvModel{

	private String jum;	 			/*점*/
	private String frDate; 		//레지조회날짜
//	private String maeDate; 		//날짜리턴
	private String regiNo; 			//영수증조회레지
	private String regiNm; 			//영수증조회이름
	private String rcptNo; 		//영수증리턴
	
//	private String startDt; 	   	/*조회일*/
//	private String bu;	 			/*점*/
//	private String pc;	 			/*점*/
//	private String pcNm;	 		/*PC명*/
//	private String eventcd1;     	//행사지역코드
//	private String eventcd2;    	//행사일련번호
//	private String eventNm;   		//이벤트명
//	private String eventstartDt;  	//이벤트시작일
//	private String eventendDt; 		//이벤트종요일
//	private String alleventcd; 		//이벤트종요일


}