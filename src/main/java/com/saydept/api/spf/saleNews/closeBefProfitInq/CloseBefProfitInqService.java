package com.saydept.api.spf.saleNews.closeBefProfitInq;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqModel;
import com.saydept.api.spf.saleNews.closeBefProfitInq.model.CloseBefProfitInqParamModel;

	@Service
	public class CloseBefProfitInqService {

	@Autowired
	private CloseBefProfitInqMapper closeBefProfitInqMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CloseBefProfitInqModel> selectCloseBefProfitInqList(CloseBefProfitInqParamModel request)throws Exception {
		/* fromDate와 toDate를 가지고 fromDateL, toDateL, fromYYMM, toYYMM, fromYYMML, toYYMML, today 를 계산한다 */
		/* 오늘 날짜 구하기 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
               
        /* FROM 입력일 1년전 일자 구하기  */
        Date tempDate = null;
        tempDate = sdf.parse(request.getFromDate());
        c1.setTime(tempDate); 
    		/* 입력기간 체크위한 변수   day1은 시작월의 day, day1F는 시작월의 말일자, mon1은 fromMonth 숫자형타입  */
	     	int day1 = c1.get(Calendar.DAY_OF_MONTH);
	     	int day1F = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
	     	int mon1 = c1.get(Calendar.MONTH);
	     	int year1 = c1.get(Calendar.YEAR);
    	c1.add(Calendar.YEAR, -1);
    	request.setFromDateL(sdf.format(c1.getTime()));
    	
    	/* TO 입력일 1년전 일자 구하기  */
        tempDate = sdf.parse(request.getToDate());
        c1.setTime(tempDate);    
        	/* 입력기간 체크위한 변수   day2은 종료월의 day, day2F는 종료월의 말일자, mon2은 toMonth 숫자형타입  */
	     	int day2 = c1.get(Calendar.DAY_OF_MONTH);
	     	int day2F = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
	     	int mon2 = c1.get(Calendar.MONTH);
	     	int year2 = c1.get(Calendar.YEAR);
    	c1.add(Calendar.YEAR, -1);
    	request.setToDateL(sdf.format(c1.getTime()));
    	
    	System.out.println("FromDate=" + request.getFromDate() +"  "+  "ToDate=" + request.getToDate());
        System.out.println("lastFromDate=" + request.getFromDateL() +"  "+  "lastToDate=" + request.getToDateL());        
        
        /* from,to  YYMM 셋팅  insertTableI02() 에서 사용하는 값 */
		request.setFromYYMM(request.getFromDate().substring(0, 6));
		request.setFromYYMML(request.getFromDateL().substring(0, 6));
		request.setToYYMM(request.getToDate().substring(0, 6));
		request.setToYYMML(request.getToDateL().substring(0, 6));
		
		
		
		
        
		System.out.println("********************  request out  ***************************");
		System.out.println(request);
		
		System.out.println("******************** Create Table ***************************");
		//템프테이블의 존재유무 체크루틴필요 또는 템프테이블 크리에이션 에러나도 그냥 넘어가는 루틴이 있어야한다.
		createTempTable();
		
		System.out.println("******************** Delete Table ***************************");
		//deleteTable();
   	
		
				
		/* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */  /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */
		/* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */  /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */
		
		/* data가 위에서 이미 생성되었는지 체크하는 변수 dataChk */
		int dataChk = 0;
		
		/* TO 입력기간이 한달또는 그 이상인지 체크하여 I02우선 I01우선 분기  */
    	System.out.println("********************  fromDate가 월의 첫날, 1일일때만 I02를 가져온다 ***************************");   	
     	if (day1 == 1) 
     	{
     		System.out.println("********************  toDate가 말일 또는 입력기간이 1개월을 넘어가면 I02를 가져온다 ***************************");   	
     		if (((day2 == day2F )) || (mon1 != mon2))
			{     			
     			/* I02데이터 있는지 체크  */
	     		int mchk1 = closeBefProfitInqMapper.selectCloseBefProfitInqMchk(request);	
	     		System.out.println("I02 결과 월 갯수 : " + mchk1);
     		
	     		/* I02데이터가 있다면    */
	     		if (mchk1 > 0)
	     		{
	     			/* toDate가 말일이 아니면 toYYMM 을 -1 하고 I02데이터 생성  */
		     		if (day2 != day2F)
		     		{
		     			/* 마지막월의 1일 저장 - I01 YYMM을 -1하기 전에 미리 YYMMDD를 SET 한다 */
		     			request.setFromYYMMDD(request.getToYYMM()+"01");
		     			request.setFromYYMMDDL(request.getToYYMML()+"01");
		     			
		     			System.out.println("******************** toDate가 말일이 아니면 I02데이터 생성시 1개월 빼고 생성  ***************************");		     			
		     			tempDate = sdf.parse(request.getToDate());
		     			c1.setTime(tempDate);      
		     			c1.add(Calendar.MONTH, -1);
		     			String tempDay = sdf.format(c1.getTime());
		     			request.setToYYMM(tempDay.substring(0, 6));
		     	        /* 전년 구하기  */
		     	    	c1.add(Calendar.YEAR, -1);
		     	    	tempDay = sdf.format(c1.getTime());
		     	    	request.setToYYMML(tempDay.substring(0, 6));

		     			/******* INSERT I02 *********/
		     			System.out.println("******************** INSERT I02 - (1) ***************************");
		     			insertTableI02(request);
		     			
		     			/******* INSERT I01 *********/
		     			System.out.println("******************** INSERT I01 - (1) ***************************");
		     			insertTableI01(request);
		     			dataChk = 1;
		     		}
		     		/* I02데이터가 있고, toDate가 말일이면  temp_i02, temp_i02L 테이블에 insert,  말일이어도 i02가 생성되기 전일수 있으니 월카운트 비교해서 체크 */
		     		else
		     		{	
		     			/******* INSERT I02 *********/
		     			System.out.println("******************** INSERT I02 - (2) ***************************");
		     			insertTableI02(request);
		     			
			    		/* 두 날짜간의 월 차이 구하기 */
			            /* 해당년도에 12를 곱해서 총 개월수를 구하고 해당 월을 더 한다. */
			    		int month1 = (year1 * 12) + mon1;
			    		int month2 = (year2 * 12) + mon2;
			    		int mchk2 = month2 - month1;
			    		
			    		/* I02월 카운트가 입력기간의 월 카운트보다 작으면 마지막월 I02가 생성되기 전이므로 해당월 데이터는 I01로 */
			    		if (mchk1 < mchk2)
			    		{
				     		System.out.println("I02 결과 월 갯수 : " + mchk1 + "     / 입력기간 월 카운트 갯수:" + mchk2);
			     			/* 마지막월의 1일 부터 I01 */
			     			request.setFromYYMMDD(request.getToYYMM()+"01");			     			
			     			request.setFromYYMMDDL(request.getToYYMML()+"01");			
			     			System.out.println("******************** INSERT I01 - (2) ***************************");
			     			/******* INSERT I01 *********/
			     			insertTableI01(request);			     			
			    		}
			    		dataChk = 1;
		     		}		     		
	     		}		
			}    		
     	}

     	/* dataChk 가 0이면 위에서 생성된 데이터가 없으므로 순수 I01기준 가마감 데이터 생성 */
     	if (dataChk == 0)
     	{
     		System.out.println("******************** 순수 I01 가마감자료 생성  - INSERT I01 - (3) ***************************"); 			
 			request.setFromYYMMDD(request.getFromDate());
 			request.setFromYYMMDDL(request.getFromDateL());
 			/******* INSERT I01 *********/
 			insertTableI01(request);
     	}
   
     	
     	
     	System.out.println("********************* 기간 목표 테이블 내용 입력 - INSERT TB3  ***************************");
     	System.out.println("********************      	insertTableTB3(request);  ***************************");	
     	insertTableTBTRY(request);
     	
     	System.out.println("********************* I01,I01L, I02,I02L UNION 하여 최종 매출테이블 TB1 데이터 생성 (목표는 별도테이블 TB3) ***************************");
     	System.out.println("******************** insertFinalTable(request);***************************");		
     	insertFinalTable(request);
     	
     	
     	
     	
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */			
		System.out.println("******************** Select Table ***************************");		
    	System.out.println("FromDate=" + request.getFromDate() +"  "+  "ToDate=" + request.getToDate());    	
    	System.out.println(request);		
    	
    	List<CloseBefProfitInqModel> result = null;
    	
    	if(request.getPc() != null && request.getPc() != "")
    	{
    		result = closeBefProfitInqMapper.selectCloseBefProfitInqListLvPc(request);
		}
    	else
    	{
    		if(request.getTim() != null && request.getTim() != "")
    		{
        		result = closeBefProfitInqMapper.selectCloseBefProfitInqListLvTim(request);
    		}
    		else
    		{
    			
    			if(request.getBu() != null && request.getBu() != "")
    			{
    	    		result = closeBefProfitInqMapper.selectCloseBefProfitInqListLvBu(request);
    			}
    			else
    			{
    				if(request.getJum() != null && request.getJum() != "")
    				{
    		    		result = closeBefProfitInqMapper.selectCloseBefProfitInqListLvJum(request);
    				}
    				else
    				{
    					System.out.println("입력에러 : 최소한 jum 값은 들어와야함");
    				}
    			}
    		}    		
    	}
    	
    	
    	
		System.out.println(result);	
		return result;
	}

	
	
	
	
	
	

	/**
	 * 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트
	 * 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트
	 * 테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트테스트
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CloseBefProfitInqModel> selectCloseBefProfitInqListTest(CloseBefProfitInqParamModel request)throws Exception {
		/* fromDate와 toDate를 가지고 fromDateL, toDateL, fromYYMM, toYYMM, fromYYMML, toYYMML, today 를 계산한다 */
		/* 오늘 날짜 구하기 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
        String today = sdf.format(c1.getTime());
               
        /* FROM 입력일 1년전 일자 구하기  */
        Date tempDate = null;
        tempDate = sdf.parse(request.getFromDate());
        c1.setTime(tempDate); 
    		/* 입력기간 체크위한 변수   day1은 시작월의 day, day1F는 시작월의 말일자, mon1은 fromMonth 숫자형타입  */
	     	int day1 = c1.get(Calendar.DAY_OF_MONTH);
	     	int day1F = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
	     	int mon1 = c1.get(Calendar.MONTH);
	     	int year1 = c1.get(Calendar.YEAR);
    	c1.add(Calendar.YEAR, -1);
    	request.setFromDateL(sdf.format(c1.getTime()));
    	
    	/* TO 입력일 1년전 일자 구하기  */
        tempDate = sdf.parse(request.getToDate());
        c1.setTime(tempDate);    
        	/* 입력기간 체크위한 변수   day2은 종료월의 day, day2F는 종료월의 말일자, mon2은 toMonth 숫자형타입  */
	     	int day2 = c1.get(Calendar.DAY_OF_MONTH);
	     	int day2F = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
	     	int mon2 = c1.get(Calendar.MONTH);
	     	int year2 = c1.get(Calendar.YEAR);
    	c1.add(Calendar.YEAR, -1);
    	request.setToDateL(sdf.format(c1.getTime()));
    	
    	System.out.println("FromDate=" + request.getFromDate() +"  "+  "ToDate=" + request.getToDate());
        System.out.println("lastFromDate=" + request.getFromDateL() +"  "+  "lastToDate=" + request.getToDateL());   
        System.out.println("day1=" + day1 +"  "+  "day2=" + day2);
        System.out.println("mon1=" + mon1 +"  "+  "mon2=" + mon2);
        
        /* from,to  YYMM 셋팅  insertTableI02() 에서 사용하는 값 */
		request.setFromYYMM(request.getFromDate().substring(0, 6));
		request.setFromYYMML(request.getFromDateL().substring(0, 6));
		request.setToYYMM(request.getToDate().substring(0, 6));
		request.setToYYMML(request.getToDateL().substring(0, 6));
		
		
		
		
        
		System.out.println("********************  request out  ***************************");
		System.out.println(request);
		System.out.println("******************** Create Table ***************************");
		//createTempTable();
		System.out.println("******************** Delete Table ***************************");
		deleteTable();
   	
		
				
		/* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */  /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */
		/* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */  /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */   /* 가마감 데이터 생성 I02있으면 먼저, 이후 I01 */
		
		/* data가 위에서 이미 생성되었는지 체크하는 변수 dataChk */
		int dataChk = 0;
		
		/* TO 입력기간이 한달또는 그 이상인지 체크하여 I02우선 I01우선 분기  */
    	System.out.println("********************  fromDate가 월의 첫날, 1일일때만 I02를 가져온다 ***************************");   	
     	if (day1 == 1) 
     	{
     		System.out.println("********************  toDate가 말일 또는 입력기간이 1개월을 넘어가면 I02를 가져온다 ***************************");   	
     		if (((day2 == day2F )) || (mon1 != mon2))
			{     			
     			/* I02데이터 있는지 체크  */
	     		int mchk1 = closeBefProfitInqMapper.selectCloseBefProfitInqMchk(request);	
	     		System.out.println("I02 결과 월 갯수 : " + mchk1);
     		
	     		/* I02데이터가 있다면    */
	     		if (mchk1 > 0)
	     		{
	     			/* toDate가 말일이 아니면 toYYMM 을 -1 하고 I02데이터 생성  */
		     		if (day2 != day2F)
		     		{
		     			/* 마지막월의 1일 저장 - I01 YYMM을 -1하기 전에 미리 YYMMDD를 SET 한다 */
		     			request.setFromYYMMDD(request.getToYYMM()+"01");
		     			request.setFromYYMMDDL(request.getToYYMML()+"01");
		     			System.out.println("request.YYMMDD = " + request.getFromYYMMDD());
		     			
		     			System.out.println("******************** toDate가 말일이 아니면 I02데이터 생성시 1개월 빼고 생성  ***************************");		     			
		     			tempDate = sdf.parse(request.getToDate());
		     			c1.setTime(tempDate);      
		     			c1.add(Calendar.MONTH, -1);
		     			String tempDay = sdf.format(c1.getTime());
		     			request.setToYYMM(tempDay.substring(0, 6));
		     			tempDate = sdf.parse(request.getToDateL());
		     			c1.setTime(tempDate);      
		     			c1.add(Calendar.MONTH, -1);
		     			tempDay = sdf.format(c1.getTime());
		     			request.setToYYMML(tempDay.substring(0, 6));

		     			/******* INSERT I02 *********/
		     			System.out.println("******************** INSERT I02 - (1) ***************************");
		     			insertTableI02(request);
		     			
		     			/******* INSERT I01 *********/
		     			System.out.println("******************** INSERT I01 - (1) ***************************");
		     			insertTableI01(request);
		     			dataChk = 1;
		     		}
		     		/* I02데이터가 있고, toDate가 말일이면  temp_i02, temp_i02L 테이블에 insert,  말일이어도 i02가 생성되기 전일수 있으니 월카운트 비교해서 체크 */
		     		else
		     		{	
		     			/******* INSERT I02 *********/
		     			System.out.println("******************** INSERT I02 - (2) ***************************");
		     			insertTableI02(request);
		     			
			    		/* 두 날짜간의 월 차이 구하기 */
			            /* 해당년도에 12를 곱해서 총 개월수를 구하고 해당 월을 더 한다. */
			    		int month1 = (year1 * 12) + mon1;
			    		int month2 = (year2 * 12) + mon2;
			    		int mchk2 = month2 - month1;
			    		
			    		/* I02월 카운트가 입력기간의 월 카운트보다 작으면 마지막월 I02가 생성되기 전이므로 해당월 데이터는 I01로 */
			    		if (mchk1 < mchk2)
			    		{
				     		System.out.println("I02 결과 월 갯수 : " + mchk1 + "     / 입력기간 월 카운트 갯수:" + mchk2);
			     			/* 마지막월의 1일 부터 I01 */
			     			request.setFromYYMMDD(request.getToYYMM()+"01");
			     			request.setFromYYMMDDL(request.getToYYMML()+"01");
			     			System.out.println("******************** INSERT I01 - (2) ***************************");
			     			/******* INSERT I01 *********/
			     			insertTableI01(request);			     			
			    		}
			    		dataChk = 1;
		     		}		     		
	     		}		
			}    		
     	}

     	/* dataChk 가 0이면 위에서 생성된 데이터가 없으므로 순수 I01기준 가마감 데이터 생성 */
     	if (dataChk == 0)
     	{
     		System.out.println("******************** 순수 I01 가마감자료 생성  - INSERT I01 - (3) ***************************"); 			
 			request.setFromYYMMDD(request.getFromDate());
 			request.setFromYYMMDDL(request.getFromDateL());
 			/******* INSERT I01 *********/
 			insertTableI01(request);
     	}
   
     	
     	
     	System.out.println("********************* 기간 목표 테이블 내용 입력 - INSERT TB3  ***************************");
     	System.out.println("********************      	insertTableTB3(request);  ***************************");	
     	insertTableTBTRY(request);
     	
     	System.out.println("********************* I01,I01L, I02,I02L UNION 하여 최종 매출테이블 TB1 데이터 생성 (목표는 별도테이블 TB3) ***************************");
     	System.out.println("******************** insertFinalTable(request);***************************");		
     	insertFinalTable(request);
     	
     	
     	
     	
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */			
		System.out.println("******************** Select Table ***************************");		
		List<CloseBefProfitInqModel> resultTest = closeBefProfitInqMapper.selectCloseBefProfitInqList1(request);
		return resultTest;
	}

	
	
	
	
	
	/* ==================================================================================================================================================================*/
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */
	/* ==================================================================================================================================================================*/
	
	public void createTempTable()throws Exception {		
		closeBefProfitInqMapper.createCloseBefProfitInqI01();		
		closeBefProfitInqMapper.createCloseBefProfitInqI01L();
		closeBefProfitInqMapper.createCloseBefProfitInqI02();
		closeBefProfitInqMapper.createCloseBefProfitInqI02L();
		closeBefProfitInqMapper.createCloseBefProfitInqTB1();		
		closeBefProfitInqMapper.createCloseBefProfitInqTB2();	
		closeBefProfitInqMapper.createCloseBefProfitInqTB3();
	}	
	public void deleteTable()throws Exception {		
		closeBefProfitInqMapper.deleteCloseBefProfitInqI01();		
		closeBefProfitInqMapper.deleteCloseBefProfitInqI01L();
		closeBefProfitInqMapper.deleteCloseBefProfitInqI02();
		closeBefProfitInqMapper.deleteCloseBefProfitInqI02L();
		closeBefProfitInqMapper.deleteCloseBefProfitInqTB1();	
		closeBefProfitInqMapper.deleteCloseBefProfitInqTB2();	
		closeBefProfitInqMapper.deleteCloseBefProfitInqTB3();	
	}

	
	public void insertTableI01(CloseBefProfitInqParamModel request)throws Exception {
		System.out.println("******************** 당년 일 매출실적 Insert *********************");
		closeBefProfitInqMapper.insertCloseBefProfitInqI01(request);		
		System.out.println("******************** 전년 일 매출실적 Insert *******************");
		closeBefProfitInqMapper.insertCloseBefProfitInqI01L(request);
		
		System.out.println("******************** 일 매출 이익액 Update *******************");
		closeBefProfitInqMapper.updateCloseBefProfitInq21();
		closeBefProfitInqMapper.updateCloseBefProfitInq22();
	}	
		
	public void insertTableI02(CloseBefProfitInqParamModel request)throws Exception {
		System.out.println("******************** 당년 월 매출실적, 이익액 Insert *********************");
		closeBefProfitInqMapper.insertCloseBefProfitInqI02(request);		
		System.out.println("******************** 전년 월 매출실적, 이익액 Insert *******************");
		closeBefProfitInqMapper.insertCloseBefProfitInqI02L(request);	

	}	
	
	public void insertTableTBTRY(CloseBefProfitInqParamModel request)throws Exception {
		System.out.println("******************** 조직별 기간매출목표 Insert ***************************");
		closeBefProfitInqMapper.insertCloseBefProfitInq31(request);			
		System.out.println("******************** 코너별 기간매출목표 Insert ***************************");
		closeBefProfitInqMapper.insertCloseBefProfitInq32(request);	
		System.out.println("******************** 온라인 기간매출목표 Insert ***************************");
		closeBefProfitInqMapper.insertCloseBefProfitInq33(request);	
	}	
	
	
	public void insertFinalTable(CloseBefProfitInqParamModel request)throws Exception {	
		System.out.println("******************** 기간매출계 및 목표등 최종테이블 DataInsert***************************");
		Integer result41 = closeBefProfitInqMapper.insertCloseBefProfitInq41(request);
	}
	
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	