package com.saydept.api.spf.saleNews.clsDanPumCdInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsDanPumCdInqModel extends SayEnvModel{

	private String DanpumNo; 				//점
	private String DanpumNm; 				//점명
	private String DanpumCd;             //부
	private double WonGa;             //부명
	private double MaeGa;             //팀
	private String ClsNo1;               //팀명
	private String ClsNo2;               //세분류
	private String BuNm;               //세분류명
	private String TmNm;               //세분류명
	private String PcNm;               //세분류명
	private String ClsNm;               //세분류명
	private double MarginYul;              //코너
	private String EachUnit;
	
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
