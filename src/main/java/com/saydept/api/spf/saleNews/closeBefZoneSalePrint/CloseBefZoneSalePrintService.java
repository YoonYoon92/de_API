package com.saydept.api.spf.saleNews.closeBefZoneSalePrint;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintModel;
import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintParamModel;

	@Service
	public class CloseBefZoneSalePrintService {

	@Autowired
	private CloseBefZoneSalePrintMapper CloseBefZoneSalePrintMapper;


	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintList(CloseBefZoneSalePrintParamModel request)throws Exception {
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
	     		int mchk1 = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintMchk(request);	
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
    	
    	List<CloseBefZoneSalePrintModel> result = null;
    	
    	if(request.getPc() != null && request.getPc() != "")
    	{
    		result = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintListLvPc(request);
		}
    	else
    	{
    		if(request.getTim() != null && request.getTim() != "")
    		{
        		result = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintListLvTim(request);
    		}
    		else
    		{
    			
    			if(request.getBu() != null && request.getBu() != "")
    			{
    	    		result = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintListLvBu(request);
    			}
    			else
    			{
    				if(request.getJum() != null && request.getJum() != "")
    				{
    		    		result = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintListLvJum(request);
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
	public List<CloseBefZoneSalePrintModel> selectCloseBefZoneSalePrintListTest(CloseBefZoneSalePrintParamModel request)throws Exception {
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
	     		int mchk1 = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintMchk(request);	
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
    	
    	List<CloseBefZoneSalePrintModel> result = null;
     	
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */
     	/* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */  /* 데이터 생성완료 Select 로 데이터 가져오기  */			
		System.out.println("******************** Select Table ***************************");		
		List<CloseBefZoneSalePrintModel> resultTest = CloseBefZoneSalePrintMapper.selectCloseBefZoneSalePrintList1(request);
		System.out.println(result);	    
		return resultTest;
	}

	
	
	
	
	
	/* ==================================================================================================================================================================*/
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       
	/* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */       /* 서브함수 시작  */
	/* ==================================================================================================================================================================*/
	
	public void createTempTable()throws Exception {		
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintI01();		
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintI01L();
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintI02();
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintI02L();
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintTB1();		
		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintTB2();	
//		CloseBefZoneSalePrintMapper.createCloseBefZoneSalePrintTB3();
	}	
	public void deleteTable()throws Exception {		
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintI01();		
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintI01L();
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintI02();
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintI02L();
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintTB1();	
		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintTB2();	
//		CloseBefZoneSalePrintMapper.deleteCloseBefZoneSalePrintTB3();	
	}

	
	public void insertTableI01(CloseBefZoneSalePrintParamModel request)throws Exception {
		System.out.println("******************** 당년 일 매출실적 Insert *********************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrintI01(request);		
		System.out.println("******************** 전년 일 매출실적 Insert *******************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrintI01L(request);
		
		System.out.println("******************** 일 매출 이익액 Update *******************");
		CloseBefZoneSalePrintMapper.updateCloseBefZoneSalePrint21();
		CloseBefZoneSalePrintMapper.updateCloseBefZoneSalePrint22();
	}	
		
	public void insertTableI02(CloseBefZoneSalePrintParamModel request)throws Exception {
		System.out.println("******************** 당년 월 매출실적, 이익액 Insert *********************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrintI02(request);		
		System.out.println("******************** 전년 월 매출실적, 이익액 Insert *******************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrintI02L(request);	

	}	
	
	public void insertTableTBTRY(CloseBefZoneSalePrintParamModel request)throws Exception {
		System.out.println("******************** 조직별 기간매출목표 Insert ***************************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrint31(request);			
		System.out.println("******************** 코너별 기간매출목표 Insert ***************************");
		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrint32(request);	
		System.out.println("******************** 온라인 기간매출목표 Insert ***************************");
//		CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrint33(request);	
	}	
	
	
	public void insertFinalTable(CloseBefZoneSalePrintParamModel request)throws Exception {	
		System.out.println("******************** 기간매출계 및 목표등 최종테이블 DataInsert***************************");
		Integer result41 = CloseBefZoneSalePrintMapper.insertCloseBefZoneSalePrint41(request);
	}
	
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	