package com.saydept.api.spf.selng.generalCreditSalesInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class GeneralCreditSalesInqPDataModel extends SayEnvModel{
	
	private String SJB;              //   1      1 
	private String CHK;              //   2      2 
	private String DATA;             //   4     16 
	private String CDTYPE;           //   6      6 
	private String CDNO;             //   7     22 
	private String GIFNO;            //   7     18 
	private String GIFNO_PTNR;       //   7     19 
	private String POINTER;          //   2     17 
	private String BACOD;            //  17     23 
	private String CLASS1;           //  17     23 
	private double TG;               //  24     31 
	private String CLSSJB;           //  27     33 
	private double NO;               //  32     34 
	private String GIFCD;            //  34     41 
	private double HAL;              //  38     44 
	private String HANGUM;           //  45     52 
	private String GIFCLASS;   	     //  49     55 
	private String CDHK;             //  66     74 
	
}