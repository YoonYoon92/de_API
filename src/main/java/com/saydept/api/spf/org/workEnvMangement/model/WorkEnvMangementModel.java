package com.saydept.api.spf.org.workEnvMangement.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class WorkEnvMangementModel extends SayEnvModel{

	private String jum;
	private String startDt;
	private String workDay;
	private String workYN;
	private String workForm;
	private String workTemperature;
	private String workWeather;
	private String workCompareDt;
	private String workCarCnt;
	private String workcustomerCnt;
	private String toDay;
	
	

}