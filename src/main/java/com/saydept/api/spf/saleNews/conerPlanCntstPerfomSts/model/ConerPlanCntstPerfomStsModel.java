package com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class ConerPlanCntstPerfomStsModel extends SayEnvModel{


	private String name;
	private String color;
	private String itemId;
	
	private String jum;	 			/*점*/
	private String bu;	 			/*부*/
	private String tim;	 			/*팀*/
	private String pc;	 			/*세분류*/	
	private String jumNm; 			/*점명*/
	private String buNm; 			/*부명*/
	private String timNm;   		//팀명
	private String pcNm; 			/*세분류명*/

	
	
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
	
	private String LastyearstartDt;		//작년조회일
	private String startDt;				//조회일
	private String mmDt;				//월1일
	private String yyDt;				//당년1월1일
	private String coner;   			//코너
	private String conerNm; 			//코너명
	private double lastyearSplan;     	    //전년일매출
	private double ddSplan;           	    //일매출
	private double mmSplan;         	    //월매출
	private double yySplan;  	 			//년매출	
	private double lastyearTry;           	//전년일목표
	private double ddTry;           	    //일목표
	private double mmTry;         	    	//월목표
	private double yyTry;  	 			//년목표
	private double ddAchivmentrate; 	//일달성율
	private double mmAchivmentrate;    	//월달성율
	private double yyAchivmentrate;     //년달성율
	private double lastyearAchivmentrate;     //전년달성율
	

}