package com.saydept.api.spf.saleNews.yearCornerSaleNews.model;

import com.saydept.api.comm.model.SayEnvModel;

import lombok.Data;

@Data
public class YearCornerSaleNewsModel extends SayEnvModel{

	private String jum;					//점
	private String jumNm;				//점명
	private String bu;                  //부
	private String buNm;                //부명
	private String tim;                 //팀
	private String timNm;               //팀명
	private String pc;                  //세분류
	private String pcNm;                //세분류명
	private String coner;               //코너
	private String conerNm;             //코너명
	private String cls;                 //클래스
	private String clsNm;               //클래스명
	private String date;                //날짜
	private String sep;					//필드구분자

	/*실적*/
	private String mmFrDate;			//총매출 시작일
	private String mmToDate;			//총매출 종료일
	private double mmTotsale;			//총매출 temp
	private double mmDiscount;			//에누리 temp
	private double mmNetsale;			//순매출 temp
	
	private String m12FrDate;			//매출 시작일
	private String m12ToDate;			//매출 종료일
	private double m12Totsale;			//총매출
	private double m12Discount;			//에누리
	private double m12Netsale;			//순매출
	private String m11FrDate;			//매출 시작일
	private String m11ToDate;			//매출 종료일
	private double m11Totsale;			//총매출
	private double m11Discount;			//에누리
	private double m11Netsale;			//순매출
	private String m10FrDate;			//매출 시작일
	private String m10ToDate;			//매출 종료일
	private double m10Totsale;			//총매출
	private double m10Discount;			//에누리
	private double m10Netsale;			//순매출
	private String m09FrDate;			//매출 시작일
	private String m09ToDate;			//매출 종료일
	private double m09Totsale;			//총매출
	private double m09Discount;			//에누리
	private double m09Netsale;			//순매출
	private String m08FrDate;			//매출 시작일
	private String m08ToDate;			//매출 종료일
	private double m08Totsale;			//총매출
	private double m08Discount;			//에누리
	private double m08Netsale;			//순매출
	private String m07FrDate;			//매출 시작일
	private String m07ToDate;			//매출 종료일
	private double m07Totsale;			//총매출
	private double m07Discount;			//에누리
	private double m07Netsale;			//순매출
	private String m06FrDate;			//매출 시작일
	private String m06ToDate;			//매출 종료일
	private double m06Totsale;			//총매출
	private double m06Discount;			//에누리
	private double m06Netsale;			//순매출
	private String m05FrDate;			//매출 시작일
	private String m05ToDate;			//매출 종료일
	private double m05Totsale;			//총매출
	private double m05Discount;			//에누리
	private double m05Netsale;			//순매출
	private String m04FrDate;			//매출 시작일
	private String m04ToDate;			//매출 종료일
	private double m04Totsale;			//총매출
	private double m04Discount;			//에누리
	private double m04Netsale;			//순매출
	private String m03FrDate;			//매출 시작일
	private String m03ToDate;			//매출 종료일
	private double m03Totsale;			//총매출
	private double m03Discount;			//에누리
	private double m03Netsale;			//순매출
	private String m02FrDate;			//매출 시작일
	private String m02ToDate;			//매출 종료일
	private double m02Totsale;			//총매출
	private double m02Discount;			//에누리
	private double m02Netsale;			//순매출
	private String m01FrDate;			//매출 시작일
	private String m01ToDate;			//매출 종료일
	private double m01Totsale;			//총매출
	private double m01Discount;			//에누리
	private double m01Netsale;			//순매출
	private String m00FrDate;			//매출 시작일
	private String m00ToDate;			//매출 종료일
	private double m00Totsale;			//총매출
	private double m00Discount;			//에누리
	private double m00Netsale;			//순매출

}
