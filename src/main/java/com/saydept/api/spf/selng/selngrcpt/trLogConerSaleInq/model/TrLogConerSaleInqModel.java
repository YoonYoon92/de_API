package com.saydept.api.spf.selng.selngrcpt.trLogConerSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class TrLogConerSaleInqModel extends SayEnvModel{

	private String startDt;
	private String endDt;
	private String jum;
	private String pos;
	private String dt;
	private String regi;
	private String recipt;
	private int discount;
	private int netSale;
	private int totSale;
	private String div;
	private String coner;
	private String conerNm;
	private String prePayCheck;
	
}