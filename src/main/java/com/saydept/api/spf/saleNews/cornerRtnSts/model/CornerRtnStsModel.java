package com.saydept.api.spf.saleNews.cornerRtnSts.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class CornerRtnStsModel extends SayEnvModel{
	
	private String jumCd;
	private String jumName;
	private String buCd;
	private String buName;
	private String timCd;
	private String timName;
	
	private String cornerNo;					/*코너번호*/
	private String cornerName;					/*코너명*/
	
	private long countOfCustChg;				/*고객변심 	건수*/ 		
	private long amtOfCustChg;   				/*      	금액*/
	private long countOfProductExchg;   		/*상품교환 	건수*/
	private long amtOfProductExchg;				/*			금액*/
	private long countOfPaymentChg;   			/*결제방법교체 	건수*/
	private long amtOfPaymentChg;				/*			금액*/
	private long countOfApplyDiscount;   		/*할인적용 	건수*/
	private long amtOfApplyDiscount;			/*			금액*/
	private long countOfCustomerComplaint;   	/*고객컴플레인 	건수*/
	private long amtOfCustomerComplaint;		/*			금액*/
	private long countOfNotPromise;   			/*약속불이행 	건수*/
	private long amtOfNotPromise;				/*			금액*/
	private long countOfSizeNotSuitable;   		/*사이즈부적합 	건수*/
	private long amtOfSizeNotSuitable;			/*			금액*/
	private long countOfEtc;   					/*기타		건수*/
	private long amtOfEtc;						/*			금액*/
	private long countOfTotal;   				/*합계		건수*/
	private long amtOfTotal;	  				/*			금액*/

}