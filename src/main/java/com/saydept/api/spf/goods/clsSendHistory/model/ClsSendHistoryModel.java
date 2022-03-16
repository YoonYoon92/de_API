package com.saydept.api.spf.goods.clsSendHistory.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ClsSendHistoryModel extends SayEnvModel{

	private String startDt;
	private String endDt;
	private String jum;
	private String cls1;
	private String cls2;
	private String sendDt;
	private String bu;
	private String tim;
	private String pc;
	private String cls;	
	private String clsNm;
	private String eventStartDt;
	private String eventEndDt;
	private String proc;
	private String disol;
 
}