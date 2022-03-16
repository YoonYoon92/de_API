package com.saydept.api.spf.selng.salesByTypeInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class SalesByTypeInqDetailGridModel extends SayEnvModel{

	private String sortation;                  //구분
	private double detailNormal;               //정상
	private double detailEvent;                //행사
	private double detailUniform;              //균일
	private double detailTotal;                //합계

}