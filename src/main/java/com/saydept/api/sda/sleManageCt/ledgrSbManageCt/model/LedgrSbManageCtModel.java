package com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class LedgrSbManageCtModel extends SayEnvModel{

	private String actCdDetail;		   //계정코드
	private String actNm1;			   //계정중
	private String actNm2;             //계정소
	private String slpNo;               //부서명
	private String slpSeq;               //부서명
	private String buCd;               //부서명
	private String buNm;               //부서명
	private String balYmd;               //부서명
	private String actYmd;               //부서명
	private String custNo;               //사업장구분
	private String custNm;               //사업장구분
	private String saGu;               //사업장구분
	private String dcKind;               //사업장구분
	private String reMark;               //사업장구분
	/*실적*/
	private double slpAmt;             //01
	private double ildAmt;             //02
	private double ilcAmt;             //03
}
