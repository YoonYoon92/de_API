package com.saydept.api.spf.saleNews.calendarSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CalendarSaleNewsParamModel extends SayEnvModel{

	private String inqYM;
	private String jum;
	private String bu;
	private String tim;

}