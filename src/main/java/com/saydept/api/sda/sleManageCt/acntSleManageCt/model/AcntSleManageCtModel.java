package com.saydept.api.sda.sleManageCt.acntSleManageCt.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class AcntSleManageCtModel extends SayEnvModel{

	private String actCdDetail;		   //계정코드
	private String actNm1;			   //계정중
	private String actNm2;             //계정소
	private String buNm;               //부서명
	private String saGu;               //사업장구분
	/*실적*/
	private double balM01;             //01
	private double balM02;             //02
	private double balM03;             //03
	private double balM04;             //04
	private double balM05;             //05
	private double balM06;             //06
	private double balM07;             //07
	private double balM08;             //08
	private double balM09;             //09
	private double balM10;             //10
	private double balM11;             //11
	private double balM12;             //12
	private double balMTot;            //전체

}
