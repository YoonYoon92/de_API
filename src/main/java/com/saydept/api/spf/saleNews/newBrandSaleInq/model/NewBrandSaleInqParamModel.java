package com.saydept.api.spf.saleNews.newBrandSaleInq.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class NewBrandSaleInqParamModel extends SayEnvModel{

   
   private String startDt; 	       /*시작일*/
   private String endDt;           /*종료일*/
   private String jum;			   /*점*/
   private String bu;              /*부*/
   private String tim;             /*팀*/

}