package com.saydept.api.spf.selng.receiptInfoInq.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ReceiptInfoInqTrModel extends SayEnvModel{
	
	private String P01HWCC  ; //wcc
	private String P01HSYY  ; //년
	private String P01HSMM  ; //월
	private String P01HSDD  ; //일
	private String P01HTHH  ; //시
	private String P01HTMM  ; //분
	private String P01HTSS  ; //초
	private String P01HSCD  ; //점
	private String P01HRNO  ; //레지번호
	private String P01HTNO  ; //영수증번호
	private String P01HSEQ  ; //일련번호
	private String P01HOPN  ; //담당자번호
	private String P01HICN  ; //item등록수
	private String P01HJCN  ; //전표등록수
	private String P01HSGU  ; //판매구분
	private String P01HSG1  ; //시재구분1
	private double P01HSM1  ; //시재금액1
	private String P01HSG2  ; //시재구분2
	private double P01HSM2  ; //시재금액2
	private String P01HSG3  ; //시재구분3
	private double P01HSM3  ; //시재금액3
	private String P01HSG4  ; //시재구분4
	private double P01HSM4  ; //시재금액4
	private String P01HSG5  ; //시재구분5
	private double P01HSM5  ; //시재금액5
	private double P01HEGM  ; //에누리
	private String P01CODG  ; //cod구분
	private String P01CODN  ; //cod전표번호
	private String P01DATA1 ; //매출데이터1
	private String P01DATA2 ; //매출데이터2
	private String P01DATA3 ; //매출데이터3
	private String P01DATA4 ; //매출데이터4
	private String P01DATA5 ; //매출데이터5
	private String P01DATA6 ; //매출데이터6
	private String P01DATA7 ; //매출데이터7
	private String P01DATA8 ; //매출데이터8
	private String P01DATA9 ; //매출데이터9
	private String P01RDATE ; //수신일자
	private String P01RTIME ; //수신시각
	         
	

}