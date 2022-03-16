package com.saydept.api.spf.excel.dayAggregation.model;

import lombok.Data;

@Data
public class DayAggregationParamModel {
	
	
	
	private String startDt;
	private String lastyearstartDt;
	private String mmDt; //월1일
	private String lastyearmmDt; //작년월1일
	private String mmEndDt; //월말
	private String lastyearmmEndDt; //월말
	private String yyDt; //월말
	private String lastyearyyDt; //작년월1일
	private String jum;
	private String bu;
	private String tim;
	
	
	
}