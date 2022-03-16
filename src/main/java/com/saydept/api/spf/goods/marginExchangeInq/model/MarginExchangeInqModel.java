package com.saydept.api.spf.goods.marginExchangeInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class MarginExchangeInqModel extends SayEnvModel{

	private String id;
	private String name;
	private String jum;
	private String bu;
	private String tim;
	private String pc;
	private String jumNm;
	private String buNm;
	private String timNm;
	private String pcNm;
	private String coner;		//코너
	private String conerNm;		//코너명

	private String cls1;         /*클래스1*/
	private String cls2;        /*클래스키*/
	private String clsNm;       /*클래스명*/
	private String marginBef;      /*마진변경전*/
	private String marginAf;     /*마진변경후*/
	private String updateDt;    /*변경일자*/
}