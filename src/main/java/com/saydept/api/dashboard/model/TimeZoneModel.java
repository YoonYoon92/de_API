package com.saydept.api.dashboard.model;

import java.util.List;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TimeZoneModel extends SayEnvModel{

	private String saleDate;				//기준일
	private String oldWeekSaleDate;         //전주동요일	
	private String oldYearSaleDate;         //전년동요일	
	private List<String> dayTimeLable;		//차트 라벨
	private List<Long> daySale;				//당일
	private List<Long> lastWeekSale;		//전주
	private List<Long> lastYearSale ;		//전년
}