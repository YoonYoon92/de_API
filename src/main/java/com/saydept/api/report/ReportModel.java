package com.saydept.api.report;

import lombok.Data;

@Data
public class ReportModel {

	private String dbType;
	private String baseName;
	private String name;
	private String color;
	
	private String itemId;
	private int	   price;
	
	private String startDt; 		
	private String endDt;   		
	private String comboVal;   		
	private String textFieldVal;	
	private String urlFieldVal;		
	private String emailFieldVal;	
	private String numFieldVal;		
	private String checkVal;		
	private String toggleVal;		
	private String dateVal;		    
	private String storeLvCd;       
	private String storeLvNm;      
	private String paramLvCd;      
}
