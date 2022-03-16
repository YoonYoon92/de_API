package com.saydept.api.spf.saleNews.corpSaleNews;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;
import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class CorpSaleNewsService {

	@Autowired
	private CorpSaleNewsMapper corpSaleNewsMapper;
	
	@Autowired
	private SayUtils sayUtils;

	

	
	/*	corpSaleNewsList
	 *  전체 조회 
	 */
	public List<CorpSaleNewsModel> corpSaleNewsList(CorpSaleNewsParamModel request) throws ParseException {
		// TODO Auto-generated method stub
		
		List<CorpSaleNewsModel> resultList = new ArrayList<CorpSaleNewsModel>();
		CorpSaleNewsModel resultSum = new CorpSaleNewsModel();
		resultSum.setBuName("합 계");
		
		//조회일자 전일, 당년당일 계산하기
		request.setBeforeDay( sayUtils.getCusomDay(request.getSearchDay(), -1 ) );
		request.setBeforeYear( sayUtils.getCusomYear(request.getSearchDay(), -1 ) );
		//오늘날짜 구하기
	    Date today = new Date();	        
	    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
	    String toDay = date.format(today);
	    //serchDay 보존
	    String sDay = request.getSearchDay();
	
		if( request.getSerchLevel().equals("jum") ) {	//등급이 점일때			
			/**
			 * 1. 해당 부 리스트 조회
			 */
			List<CorpSaleNewsModel> buList = corpSaleNewsMapper.getBulistCorp(request);
			for( CorpSaleNewsModel data :  buList) {		
				
				resultList.add( data );
			}			
			/**
			 * 2. 부 리스트 일 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				CorpSaleNewsModel daySaleGoal =  corpSaleNewsMapper.getDaySaleGoal(request);
				data.setDayTry( daySaleGoal == null ? 0 : daySaleGoal.getDayTry() );
			}			
			/**
			 * 3. 부 리스트 월 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				CorpSaleNewsModel monthSaleGoal =  corpSaleNewsMapper.getMonthSaleGoal(request);
				data.setMmTry( monthSaleGoal == null ? 0 : monthSaleGoal.getMmTry() );
				
				CorpSaleNewsModel monthSaleGoalMax =  corpSaleNewsMapper.getMonthSaleGoalMax(request);
				data.setMmTryMax( monthSaleGoalMax == null ? 0 : monthSaleGoalMax.getMmTryMax() );				
			}			
			/**
			 * 4. 부 리스트 년 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				CorpSaleNewsModel yearSaleGoal =  corpSaleNewsMapper.getYearSaleGoal(request);
				data.setYyTry( yearSaleGoal == null ? 0 : yearSaleGoal.getYyTry() );
				
				CorpSaleNewsModel yearSaleGoalMax =  corpSaleNewsMapper.getYearSaleGoalMax(request);
				data.setYyTryMax( yearSaleGoalMax == null ? 0 : yearSaleGoalMax.getYyTryMax() );				
			}			
			
			/**
			 * 4. 부 리스트 일 실적 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setDayDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setMmNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setMmDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setYyNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setYyDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				//일, 월, 년 실적 부분 천원 단위로 변경	 - sql에서 처리		 
//				data.setDayNetsale(data.getDayNetsale()/1000);
//				data.setMmNetsale(data.getMmNetsale()/1000);
//				data.setYyNetsale(data.getYyNetsale()/1000);
				//목표 대비 실적 차액 계산
				data.setDayDnfnt(data.getDayNetsale() - data.getDayTry());
			}
			
			/**
			 * 5. 부 리스트 당월, 당년 실적 조회 
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );							

				if( sDay.equals(toDay) ) {
					/* 조회일자가 당일이면 (조회일의 -1일<beforeDay>를 검색하여 4.에서 찾은 당일 데이터를 더해준다) */
					request.setSearchDay(request.getBeforeDay());
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					
					/* 월매출  -- 조회일자가 월초 '01' 일이면 당월매출데이터는 0으로 초기화후 더한다 */
					if( sDay.substring(6, 8).equals("01") )
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale());
					}	
					else
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getMmNetsale() );
					}
					/* 년매출 * -- 조회일 전일까지 매출 + 당일매출 */
					data.setYyNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getYyNetsale() );

				}
				else {
					/* 조회일자가 당일이 아니면 */					
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					data.setMmNetsale( monthSalePer == null ? 0 : monthSalePer.getMmNetsale() );
					data.setYyNetsale( monthSalePer == null ? 0 : monthSalePer.getYyNetsale() );
				}
				//일, 월, 년 실적 부분 천원 단위로 변경	 - sql에서 처리
//				data.setMmNetsale(data.getMmNetsale()/1000);
//				data.setYyNetsale(data.getYyNetsale()/1000);	
				//목표 대비 실적 차액 계산
				data.setMmDnfnt(data.getMmNetsale() - data.getMmTry());
				data.setYyDnfnt(data.getYyNetsale() - data.getYyTry());				
			}
			
			/**
			 * 6. 부 리스트 전년 당일 실적 조회 
			 * 
			 */			
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );			
				request.setSearchDay( request.getBeforeYear() );
				
				//전년(일)
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayLastyearSplan( daySalePer == null ? 0 : daySalePer.getDayNetsale());
				
				//전년(월,년)
				CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
				data.setMmLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getMmNetsale());
				data.setYyLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getYyNetsale());
				
				//일, 월, 년 실적 부분 천원 단위로 변경			
//				data.setDayLastyearSplan(data.getDayLastyearSplan()/1000);
//				data.setMmLastyearSplan(data.getMmLastyearSplan()/1000);
//				data.setYyLastyearSplan(data.getYyLastyearSplan()/1000);		
				
				System.out.println(data);
			}
			
			/**
			 * 7. 신장율, 달성율 , 진도율 계산
			 *    합계레코드 값 기초데이터 생성
			 */
			for( CorpSaleNewsModel result : resultList ) {				
//				일 달성율 = ( SPFI52PF.IS5213 일-순매출실적 / SPFI05PF.IS0506 일-매출계획목표 ) * 100
//				월 진도율 = ( SPFI53PF.IS5309 월-순매출실적 / SPFI06PF.IS0568 월-매출계획목표 ) * 100
//				년 진도율 = ( SPFI53PF.IS5315 년-순매출실적 / SPFI06PF.IS0630 년-매출계획목표 ) * 100				
				result.setDayAchivmentrate( ( result.getDayNetsale()  / result.getDayTry()) * 100 );	//일 달성율
				result.setMmAchivmentrate( ( result.getMmNetsale()  / result.getMmTry()) * 100 );		//월 달성율
				result.setYyAchivmentrate( ( result.getYyNetsale()  / result.getYyTry()) * 100 );		//년 달성율
				result.setMmProgresrate( ( result.getMmNetsale()  / result.getMmTryMax()) * 100 );		//월 진도율
				result.setYyProgresrate( ( result.getYyNetsale()  / result.getYyTryMax()) * 100 );		//년 진도율
				
//				일 신장율 = ( ( SPFI52PF.IS5213 당일실적 - SPFI52PF.IS5213 전년실적 ) / SPFI52PF.IS5213 전년실적 ) * 100
//				월 신장율 = ( ( SPFI53PF.IS5309 당월실적 - SPFI53PF.IS5309 전년실적 ) / SPFI53PF.IS5309 전년실적 ) * 100
//				년 신장율 = ( ( SPFI53PF.IS5315 당년실적 - SPFI53PF.IS5315 전년실적 ) / SPFI53PF.IS5315 전년실적 ) * 100				
				result.setDayIncrsrate( ( ( result.getDayNetsale() - result.getDayLastyearSplan() ) / Math.abs(result.getDayLastyearSplan()) ) * 100 );
				result.setMmIncrsrate( ( ( result.getMmNetsale() - result.getMmLastyearSplan() ) /  Math.abs(result.getMmLastyearSplan()) ) * 100 );
				result.setYyIncrsrate( ( ( result.getYyNetsale() - result.getYyLastyearSplan() ) /  Math.abs(result.getYyLastyearSplan()) ) * 100 );	
				
				//신장율, 달성율, 진도율 NULL 값일때 0으로 셋팅 처리
				if (Double.isNaN(result.getDayAchivmentrate())) 
		               result.setDayAchivmentrate(0);
		        if (Double.isNaN(result.getMmAchivmentrate()))
		               result.setMmAchivmentrate(0);
		        if (Double.isNaN(result.getYyAchivmentrate())) 
		               result.setYyAchivmentrate(0);	
		        if (Double.isNaN(result.getMmProgresrate()))
		               result.setMmProgresrate(0);
		        if (Double.isNaN(result.getYyProgresrate())) 
		               result.setYyProgresrate(0);			        
		        if (Double.isNaN(result.getDayIncrsrate())) 
		               result.setDayIncrsrate(0);
		        if (Double.isNaN(result.getMmIncrsrate())) 
		               result.setMmIncrsrate(0);
	            if (Double.isNaN(result.getYyIncrsrate())) 
		               result.setYyIncrsrate(0);
				
	            //전년대비 차액, 진도율목표대비 차액 구하기
	            result.setDayDnfnt2(result.getDayNetsale() - result.getDayLastyearSplan());
	            result.setMmDnfnt2(result.getMmNetsale() - result.getMmLastyearSplan());
	            result.setYyDnfnt2(result.getYyNetsale() - result.getYyLastyearSplan());
	            result.setMmDnfntMax(result.getMmTryMax() - result.getMmNetsale());
	            result.setYyDnfntMax(result.getYyTryMax() - result.getYyNetsale());	   
	            
				result.setSpace("|");
				
				/* 합계 레코드 (resultSum) 기초 데이터 만들기 */
				resultSum.setDayTry( resultSum.getDayTry() + result.getDayTry() ); 									//일 목표   
				resultSum.setDayNetsale( resultSum.getDayNetsale() + result.getDayNetsale() );						//일 매출
				resultSum.setDayDiscount( resultSum.getDayDiscount() + result.getDayDiscount() );					//일 할인
				resultSum.setMmTry( resultSum.getMmTry() + result.getMmTry() ); 									//월 목표   				
				resultSum.setMmNetsale( resultSum.getMmNetsale() + result.getMmNetsale() );							//월 매출
				resultSum.setMmDiscount( resultSum.getMmDiscount() + result.getMmDiscount() );						//월 할인
				resultSum.setYyTry( resultSum.getYyTry() + result.getYyTry() ); 									//월 목표   
				resultSum.setYyNetsale( resultSum.getYyNetsale() + result.getYyNetsale() );							//년 매출
				resultSum.setYyDiscount( resultSum.getYyDiscount() + result.getYyDiscount() );						//년 할인
				resultSum.setDayLastyearSplan( resultSum.getDayLastyearSplan() + result.getDayLastyearSplan() );	//전년 일 매출
				resultSum.setMmLastyearSplan( resultSum.getMmLastyearSplan() + result.getMmLastyearSplan() );		//전년 월 매출
				resultSum.setYyLastyearSplan( resultSum.getYyLastyearSplan() + result.getYyLastyearSplan() );		//전년 년 매출
				resultSum.setMmTryMax( resultSum.getMmTryMax() + result.getMmTryMax() ); 							//월 전체 목표
				resultSum.setYyTryMax( resultSum.getYyTryMax() + result.getYyTryMax() ); 							//월 전체 목표
				resultSum.setDayDnfnt2( resultSum.getDayDnfnt2() + result.getDayDnfnt2());
	            resultSum.setMmDnfnt2(resultSum.getMmDnfnt2() + result.getMmDnfnt2());								//전년대비 월 실적 차액
	            resultSum.setYyDnfnt2(resultSum.getYyDnfnt2() + result.getYyDnfnt2());								//전년대비 년 실적 차액
	            resultSum.setMmDnfntMax(resultSum.getMmDnfntMax() + result.getMmDnfntMax());						//진도목표대비 월 차액
	            resultSum.setYyDnfntMax(resultSum.getYyDnfntMax() + result.getYyDnfntMax());	   					//진도목표대비 년 차액
			}
			/*합계 레코드 계산 데이터 만들기 */ 
			resultSum.setDayDnfnt( resultSum.getDayNetsale() - resultSum.getDayTry() ); 																//일 차액
			resultSum.setMmDnfnt( resultSum.getMmNetsale() - resultSum.getMmTry() ); 																	//월 차액
			resultSum.setYyDnfnt( resultSum.getYyNetsale() - resultSum.getYyTry() ); 																	//년 차액
			resultSum.setDayAchivmentrate( ( resultSum.getDayNetsale()  / resultSum.getDayTry()) * 100 );												//일 달성율
			resultSum.setMmAchivmentrate( ( resultSum.getMmNetsale()  / resultSum.getMmTry()) * 100 );													//월 달성율
			resultSum.setYyAchivmentrate( ( resultSum.getYyNetsale()  / resultSum.getYyTry()) * 100 );													//년 달성율
			resultSum.setMmProgresrate( ( resultSum.getMmNetsale()  / resultSum.getMmTryMax()) * 100 );													//월 진도율
			resultSum.setYyProgresrate( ( resultSum.getYyNetsale()  / resultSum.getYyTryMax()) * 100 );													//년 진도율				
			resultSum.setDayIncrsrate( ( ( resultSum.getDayNetsale() - resultSum.getDayLastyearSplan() ) / Math.abs(resultSum.getDayLastyearSplan()) ) * 100 );	//일 신장율
			resultSum.setMmIncrsrate( ( ( resultSum.getMmNetsale() - resultSum.getMmLastyearSplan() ) / Math.abs(resultSum.getMmLastyearSplan()) ) * 100 );		//월 신장율
			resultSum.setYyIncrsrate( ( ( resultSum.getYyNetsale() - resultSum.getYyLastyearSplan() ) / Math.abs(resultSum.getYyLastyearSplan()) ) * 100 );		//년 신장율	
			/*합계 레코드 ADD하기 */
			resultList.add(resultSum);
			
			/**
			 * 실적대비 구성비 계산			 *   
			 */
			for( CorpSaleNewsModel result : resultList ) {
				result.setDayCompRate(result.getDayNetsale() / resultSum.getDayNetsale() * 100);
				result.setMmCompRate(result.getMmNetsale() / resultSum.getMmNetsale() * 100);
				result.setYyCompRate(result.getYyNetsale() / resultSum.getYyNetsale() * 100);
			}
			
		/* *등급이 부일때* *등급이 부일때*  *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* *등급이 부일때* */  
		}else if( request.getSerchLevel().equals("bu") ) {				
			System.out.println("-----//등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	/request/등급이 부일때	//등급이 부일때	//등급이 부일때	------");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(request);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			/**
			 * 1. 해당 팀 리스트 조회
			 */
			List<CorpSaleNewsModel> buList = corpSaleNewsMapper.getTimlistCorp(request);
			for( CorpSaleNewsModel data :  buList) {				
				resultList.add( data );
			}
			
			/**
			 * 2. 팀 리스트 일 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				CorpSaleNewsModel daySaleGoal =  corpSaleNewsMapper.getDaySaleGoal(request);
				data.setDayTry( daySaleGoal == null ? 0 : daySaleGoal.getDayTry() );
			}			
			/**
			 * 3. 팀 리스트 월 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				CorpSaleNewsModel monthSaleGoal =  corpSaleNewsMapper.getMonthSaleGoal(request);
				data.setMmTry( monthSaleGoal == null ? 0 : monthSaleGoal.getMmTry() );
				
				CorpSaleNewsModel monthSaleGoalMax =  corpSaleNewsMapper.getMonthSaleGoalMax(request);
				data.setMmTryMax( monthSaleGoalMax == null ? 0 : monthSaleGoalMax.getMmTryMax() );					
			}			
			/**
			 * 4. 팀 리스트 년 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				CorpSaleNewsModel yearSaleGoal =  corpSaleNewsMapper.getYearSaleGoal(request);
				data.setYyTry( yearSaleGoal == null ? 0 : yearSaleGoal.getYyTry() );
				
				CorpSaleNewsModel yearSaleGoalMax =  corpSaleNewsMapper.getYearSaleGoalMax(request);
				data.setYyTryMax( yearSaleGoalMax == null ? 0 : yearSaleGoalMax.getYyTryMax() );					
			}			
			
			/**
			 * 4. 팀 리스트 일 실적 조회
			 */			
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );				
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setDayDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setMmNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setMmDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setYyNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setYyDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );

				//목표 대비 실적 차액 계산
				data.setDayDnfnt(data.getDayNetsale() - data.getDayTry());
			}
			
			/**
			 * 5. 팀 리스트 당월 실적 조회 (종료일의 -1일)
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				
				if( sDay.equals(toDay) ) {
					/* 조회일자가 당일이면 (조회일의 -1일<beforeDay>를 검색하여 4.에서 찾은 당일 데이터를 더해준다) */
					request.setSearchDay(request.getBeforeDay());
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					
					/* 월매출  -- 조회일자가 월초 '01' 일이면 당월매출데이터는 0으로 초기화후 더한다 */
					if( sDay.substring(6, 8).equals("01") )
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale());
					}	
					else
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getMmNetsale() );
					}
					/* 년매출 * -- 조회일 전일까지 매출 + 당일매출 */
					data.setYyNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getYyNetsale() );

				}
				else {
					/* 조회일자가 당일이 아니면 */					
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					data.setMmNetsale( monthSalePer == null ? 0 : monthSalePer.getMmNetsale() );
					data.setYyNetsale( monthSalePer == null ? 0 : monthSalePer.getYyNetsale() );
				}

				//목표 대비 실적 차액 계산
				data.setMmDnfnt(data.getMmNetsale() - data.getMmTry());
				data.setYyDnfnt(data.getYyNetsale() - data.getYyTry());			
			}
			
			/**
			 * 6. 팀 리스트 당년(전월까지) 실적 조회 
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setSearchDay( request.getBeforeYear() );
				
				//전년(일)
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayLastyearSplan( daySalePer == null ? 0 : daySalePer.getDayNetsale());
				
				//전년(월,년)
				CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
				data.setMmLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getMmNetsale());
				data.setYyLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getYyNetsale());	
			}
			
			/**
			 * 7. 신장율, 달성률 계산
			 */
			for( CorpSaleNewsModel result : resultList ) {				
//				일 달성율 = ( SPFI52PF.IS5213 일-순매출실적 / SPFI05PF.IS0506 일-매출계획목표 ) * 100
//				월 진도율 = ( SPFI53PF.IS5309 월-순매출실적 / SPFI06PF.IS0568 월-매출계획목표 ) * 100
//				년 진도율 = ( SPFI53PF.IS5315 년-순매출실적 / SPFI06PF.IS0630 년-매출계획목표 ) * 100				
				result.setDayAchivmentrate( ( result.getDayNetsale()  / result.getDayTry()) * 100 );	//일 달성율
				result.setMmAchivmentrate( ( result.getMmNetsale()  / result.getMmTry()) * 100 );		//월 달성율
				result.setYyAchivmentrate( ( result.getYyNetsale()  / result.getYyTry()) * 100 );		//년 달성율
				result.setMmProgresrate( ( result.getMmNetsale()  / result.getMmTryMax()) * 100 );		//월 진도율
				result.setYyProgresrate( ( result.getYyNetsale()  / result.getYyTryMax()) * 100 );		//년 진도율
				
//				일 신장율 = ( ( SPFI52PF.IS5213 당일실적 - SPFI52PF.IS5213 전년실적 ) / SPFI52PF.IS5213 전년실적 ) * 100
//				월 신장율 = ( ( SPFI53PF.IS5309 당월실적 - SPFI53PF.IS5309 전년실적 ) / SPFI53PF.IS5309 전년실적 ) * 100
//				년 신장율 = ( ( SPFI53PF.IS5315 당년실적 - SPFI53PF.IS5315 전년실적 ) / SPFI53PF.IS5315 전년실적 ) * 100				
				result.setDayIncrsrate( ( ( result.getDayNetsale() - result.getDayLastyearSplan() ) / Math.abs(result.getDayLastyearSplan()) ) * 100 );
				result.setMmIncrsrate( ( ( result.getMmNetsale() - result.getMmLastyearSplan() ) /  Math.abs(result.getMmLastyearSplan()) ) * 100 );
				result.setYyIncrsrate( ( ( result.getYyNetsale() - result.getYyLastyearSplan() ) /  Math.abs(result.getYyLastyearSplan()) ) * 100 );	
				
				//신장율, 달성율, 진도율 NULL 값일때 0으로 셋팅 처리
				if (Double.isNaN(result.getDayAchivmentrate())) 
		               result.setDayAchivmentrate(0);
		        if (Double.isNaN(result.getMmAchivmentrate()))
		               result.setMmAchivmentrate(0);
		        if (Double.isNaN(result.getYyAchivmentrate())) 
		               result.setYyAchivmentrate(0);	
		        if (Double.isNaN(result.getMmProgresrate()))
		               result.setMmProgresrate(0);
		        if (Double.isNaN(result.getYyProgresrate())) 
		               result.setYyProgresrate(0);			        
		        if (Double.isNaN(result.getDayIncrsrate())) 
		               result.setDayIncrsrate(0);
		        if (Double.isNaN(result.getMmIncrsrate())) 
		               result.setMmIncrsrate(0);
	            if (Double.isNaN(result.getYyIncrsrate())) 
		               result.setYyIncrsrate(0);
				
	            //전년대비 차액, 진도율목표대비 차액 구하기
	            result.setDayDnfnt2(result.getDayNetsale() - result.getDayLastyearSplan());
	            result.setMmDnfnt2(result.getMmNetsale() - result.getMmLastyearSplan());
	            result.setYyDnfnt2(result.getYyNetsale() - result.getYyLastyearSplan());
	            result.setMmDnfntMax(result.getMmTryMax() - result.getMmNetsale());
	            result.setYyDnfntMax(result.getYyTryMax() - result.getYyNetsale());	   
	            
				result.setSpace("|");
				
				/* 합계 레코드 (resultSum) 기초 데이터 만들기 */
				resultSum.setDayTry( resultSum.getDayTry() + result.getDayTry() ); 									//일 목표   
				resultSum.setDayNetsale( resultSum.getDayNetsale() + result.getDayNetsale() );						//일 매출
				resultSum.setDayDiscount( resultSum.getDayDiscount() + result.getDayDiscount() );					//일 할인
				resultSum.setMmTry( resultSum.getMmTry() + result.getMmTry() ); 									//월 목표   				
				resultSum.setMmNetsale( resultSum.getMmNetsale() + result.getMmNetsale() );							//월 매출
				resultSum.setMmDiscount( resultSum.getMmDiscount() + result.getMmDiscount() );						//월 할인
				resultSum.setYyTry( resultSum.getYyTry() + result.getYyTry() ); 									//월 목표   
				resultSum.setYyNetsale( resultSum.getYyNetsale() + result.getYyNetsale() );							//년 매출
				resultSum.setYyDiscount( resultSum.getYyDiscount() + result.getYyDiscount() );						//년 할인
				resultSum.setDayLastyearSplan( resultSum.getDayLastyearSplan() + result.getDayLastyearSplan() );	//전년 일 매출
				resultSum.setMmLastyearSplan( resultSum.getMmLastyearSplan() + result.getMmLastyearSplan() );		//전년 월 매출
				resultSum.setYyLastyearSplan( resultSum.getYyLastyearSplan() + result.getYyLastyearSplan() );		//전년 년 매출
				resultSum.setMmTryMax( resultSum.getMmTryMax() + result.getMmTryMax() ); 							//월 전체 목표
				resultSum.setYyTryMax( resultSum.getYyTryMax() + result.getYyTryMax() ); 							//월 전체 목표
				resultSum.setDayDnfnt2( resultSum.getDayDnfnt2() + result.getDayDnfnt2());
	            resultSum.setMmDnfnt2(resultSum.getMmDnfnt2() + result.getMmDnfnt2());								//전년대비 월 실적 차액
	            resultSum.setYyDnfnt2(resultSum.getYyDnfnt2() + result.getYyDnfnt2());								//전년대비 년 실적 차액
	            resultSum.setMmDnfntMax(resultSum.getMmDnfntMax() + result.getMmDnfntMax());						//진도목표대비 월 차액
	            resultSum.setYyDnfntMax(resultSum.getYyDnfntMax() + result.getYyDnfntMax());	   					//진도목표대비 년 차액
			}
			/*합계 레코드 계산 데이터 만들기 */ 
			resultSum.setDayDnfnt( resultSum.getDayNetsale() - resultSum.getDayTry() ); 																//일 차액
			resultSum.setMmDnfnt( resultSum.getMmNetsale() - resultSum.getMmTry() ); 																	//월 차액
			resultSum.setYyDnfnt( resultSum.getYyNetsale() - resultSum.getYyTry() ); 																	//년 차액
			resultSum.setDayAchivmentrate( ( resultSum.getDayNetsale()  / resultSum.getDayTry()) * 100 );												//일 달성율
			resultSum.setMmAchivmentrate( ( resultSum.getMmNetsale()  / resultSum.getMmTry()) * 100 );													//월 달성율
			resultSum.setYyAchivmentrate( ( resultSum.getYyNetsale()  / resultSum.getYyTry()) * 100 );													//년 달성율
			resultSum.setMmProgresrate( ( resultSum.getMmNetsale()  / resultSum.getMmTryMax()) * 100 );													//월 진도율
			resultSum.setYyProgresrate( ( resultSum.getYyNetsale()  / resultSum.getYyTryMax()) * 100 );													//년 진도율				
			resultSum.setDayIncrsrate( ( ( resultSum.getDayNetsale() - resultSum.getDayLastyearSplan() ) / resultSum.getDayLastyearSplan() ) * 100 );	//일 신장율
			resultSum.setMmIncrsrate( ( ( resultSum.getMmNetsale() - resultSum.getMmLastyearSplan() ) / resultSum.getMmLastyearSplan() ) * 100 );		//월 신장율
			resultSum.setYyIncrsrate( ( ( resultSum.getYyNetsale() - resultSum.getYyLastyearSplan() ) / resultSum.getYyLastyearSplan() ) * 100 );		//년 신장율	
			/*합계 레코드 ADD하기 */
			resultList.add(resultSum);
			
			/**
			 * 실적대비 구성비 계산			 *   
			 */
			for( CorpSaleNewsModel result : resultList ) {
				result.setDayCompRate(result.getDayNetsale() / resultSum.getDayNetsale() * 100);
				result.setMmCompRate(result.getMmNetsale() / resultSum.getMmNetsale() * 100);
				result.setYyCompRate(result.getYyNetsale() / resultSum.getYyNetsale() * 100);
			}
			
		/* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때* *등급이 팀일때*  */ 			
		}else if( request.getSerchLevel().equals("tim") ) {			
			System.out.println("-----등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request 등급이 팀일때 request ------");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(request);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			
			/**
			 * 1. 해당 PC 리스트 조회
			 */
			List<CorpSaleNewsModel> buList = corpSaleNewsMapper.getPclistCorp(request);
			for( CorpSaleNewsModel data :  buList) {				
				resultList.add( data );
			}
			
			/**
			 * 2. PC 리스트 일 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setPc(data.getPc());
				CorpSaleNewsModel daySaleGoal =  corpSaleNewsMapper.getDaySaleGoal(request);
				data.setDayTry( daySaleGoal == null ? 0 : daySaleGoal.getDayTry() );
			}			
			/**
			 * 3. PC 리스트 월 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setPc(data.getPc());
				CorpSaleNewsModel monthSaleGoal =  corpSaleNewsMapper.getMonthSaleGoal(request);
				data.setMmTry( monthSaleGoal == null ? 0 : monthSaleGoal.getMmTry() );
				
				CorpSaleNewsModel monthSaleGoalMax =  corpSaleNewsMapper.getMonthSaleGoalMax(request);
				data.setMmTryMax( monthSaleGoalMax == null ? 0 : monthSaleGoalMax.getMmTryMax() );						
			}			
			/**
			 * 4. PC 리스트 년 목표 조회
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setPc(data.getPc());
				CorpSaleNewsModel yearSaleGoal =  corpSaleNewsMapper.getYearSaleGoal(request);
				data.setYyTry( yearSaleGoal == null ? 0 : yearSaleGoal.getYyTry() );
				
				CorpSaleNewsModel yearSaleGoalMax =  corpSaleNewsMapper.getYearSaleGoalMax(request);
				data.setYyTryMax( yearSaleGoalMax == null ? 0 : yearSaleGoalMax.getYyTryMax() );					
			}			
			
			/**
			 * 4. PC 리스트 일 실적 조회
			 */			
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );	
				request.setPc(data.getPc());
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setDayDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setMmNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setMmDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				
				data.setYyNetsale( daySalePer == null ? 0 : daySalePer.getDayNetsale() );
				data.setYyDiscount( daySalePer == null ? 0 : daySalePer.getDayDiscount() );
				//목표 대비 실적 차액 계산
				data.setDayDnfnt(data.getDayNetsale() - data.getDayTry());
			}
			
			/**
			 * 5. PC 리스트 당월 실적 조회 (종료일의 -1일)
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setPc(data.getPc());
				
				if( sDay.equals(toDay) ) {
					/* 조회일자가 당일이면 (조회일의 -1일<beforeDay>를 검색하여 4.에서 찾은 당일 데이터를 더해준다) */
					request.setSearchDay(request.getBeforeDay());
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					
					/* 월매출  -- 조회일자가 월초 '01' 일이면 당월매출데이터는 0으로 초기화후 더한다 */
					if( sDay.substring(6, 8).equals("01") )
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale());
					}	
					else
					{
						data.setMmNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getMmNetsale() );
					}
					/* 년매출 * -- 조회일 전일까지 매출 + 당일매출 */
					data.setYyNetsale( monthSalePer == null ? 0 : data.getDayNetsale()  + monthSalePer.getYyNetsale() );

				}
				else {
					/* 조회일자가 당일이 아니면 */					
					CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
					data.setMmNetsale( monthSalePer == null ? 0 : monthSalePer.getMmNetsale() );
					data.setYyNetsale( monthSalePer == null ? 0 : monthSalePer.getYyNetsale() );
				}

				//목표 대비 실적 차액 계산
				data.setMmDnfnt(data.getMmNetsale() - data.getMmTry());
				data.setYyDnfnt(data.getYyNetsale() - data.getYyTry());					
			}
			
			/**
			 * 6. PC 리스트 당년(전월까지) 실적 조회 
			 */
			for( CorpSaleNewsModel data: resultList ) {
				request.setBu( data.getBu() );
				request.setTim( data.getTim() );
				request.setPc(data.getPc());
				request.setSearchDay( request.getBeforeYear() );
				
				//전년(일)
				CorpSaleNewsModel daySalePer =  corpSaleNewsMapper.getDaySalePer(request);
				data.setDayLastyearSplan( daySalePer == null ? 0 : daySalePer.getDayNetsale());
				
				//전년(월,년)
				CorpSaleNewsModel monthSalePer =  corpSaleNewsMapper.getMonthSalePer(request);
				data.setMmLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getMmNetsale());
				data.setYyLastyearSplan( monthSalePer == null ? 0 : monthSalePer.getYyNetsale());
			}
			
			/**
			 * 7. 신장율, 달성률 계산
			 */
			for( CorpSaleNewsModel result : resultList ) {				
//				일 달성율 = ( SPFI52PF.IS5213 일-순매출실적 / SPFI05PF.IS0506 일-매출계획목표 ) * 100
//				월 진도율 = ( SPFI53PF.IS5309 월-순매출실적 / SPFI06PF.IS0568 월-매출계획목표 ) * 100
//				년 진도율 = ( SPFI53PF.IS5315 년-순매출실적 / SPFI06PF.IS0630 년-매출계획목표 ) * 100				
				result.setDayAchivmentrate( ( result.getDayNetsale()  / result.getDayTry()) * 100 );	//일 달성율
				result.setMmAchivmentrate( ( result.getMmNetsale()  / result.getMmTry()) * 100 );		//월 달성율
				result.setYyAchivmentrate( ( result.getYyNetsale()  / result.getYyTry()) * 100 );		//년 달성율
				result.setMmProgresrate( ( result.getMmNetsale()  / result.getMmTryMax()) * 100 );		//월 진도율
				result.setYyProgresrate( ( result.getYyNetsale()  / result.getYyTryMax()) * 100 );		//년 진도율
				
//				일 신장율 = ( ( SPFI52PF.IS5213 당일실적 - SPFI52PF.IS5213 전년실적 ) / SPFI52PF.IS5213 전년실적 ) * 100
//				월 신장율 = ( ( SPFI53PF.IS5309 당월실적 - SPFI53PF.IS5309 전년실적 ) / SPFI53PF.IS5309 전년실적 ) * 100
//				년 신장율 = ( ( SPFI53PF.IS5315 당년실적 - SPFI53PF.IS5315 전년실적 ) / SPFI53PF.IS5315 전년실적 ) * 100				
				result.setDayIncrsrate( ( ( result.getDayNetsale() - result.getDayLastyearSplan() ) / Math.abs(result.getDayLastyearSplan()) ) * 100 );
				result.setMmIncrsrate( ( ( result.getMmNetsale() - result.getMmLastyearSplan() ) /  Math.abs(result.getMmLastyearSplan()) ) * 100 );
				result.setYyIncrsrate( ( ( result.getYyNetsale() - result.getYyLastyearSplan() ) /  Math.abs(result.getYyLastyearSplan()) ) * 100 );	
				
				//신장율, 달성율, 진도율 NULL 값일때 0으로 셋팅 처리
				if (Double.isNaN(result.getDayAchivmentrate())) 
		               result.setDayAchivmentrate(0);
		        if (Double.isNaN(result.getMmAchivmentrate()))
		               result.setMmAchivmentrate(0);
		        if (Double.isNaN(result.getYyAchivmentrate())) 
		               result.setYyAchivmentrate(0);	
		        if (Double.isNaN(result.getMmProgresrate()))
		               result.setMmProgresrate(0);
		        if (Double.isNaN(result.getYyProgresrate())) 
		               result.setYyProgresrate(0);			        
		        if (Double.isNaN(result.getDayIncrsrate())) 
		               result.setDayIncrsrate(0);
		        if (Double.isNaN(result.getMmIncrsrate())) 
		               result.setMmIncrsrate(0);
	            if (Double.isNaN(result.getYyIncrsrate())) 
		               result.setYyIncrsrate(0);
				
	            //전년대비 차액, 진도율목표대비 차액 구하기
	            result.setDayDnfnt2(result.getDayNetsale() - result.getDayLastyearSplan());
	            result.setMmDnfnt2(result.getMmNetsale() - result.getMmLastyearSplan());
	            result.setYyDnfnt2(result.getYyNetsale() - result.getYyLastyearSplan());
	            result.setMmDnfntMax(result.getMmTryMax() - result.getMmNetsale());
	            result.setYyDnfntMax(result.getYyTryMax() - result.getYyNetsale());	   
	            
				result.setSpace("|");
				
				/* 합계 레코드 (resultSum) 기초 데이터 만들기 */
				resultSum.setDayTry( resultSum.getDayTry() + result.getDayTry() ); 									//일 목표   
				resultSum.setDayNetsale( resultSum.getDayNetsale() + result.getDayNetsale() );						//일 매출
				resultSum.setDayDiscount( resultSum.getDayDiscount() + result.getDayDiscount() );					//일 할인
				resultSum.setMmTry( resultSum.getMmTry() + result.getMmTry() ); 									//월 목표   				
				resultSum.setMmNetsale( resultSum.getMmNetsale() + result.getMmNetsale() );							//월 매출
				resultSum.setMmDiscount( resultSum.getMmDiscount() + result.getMmDiscount() );						//월 할인
				resultSum.setYyTry( resultSum.getYyTry() + result.getYyTry() ); 									//월 목표   
				resultSum.setYyNetsale( resultSum.getYyNetsale() + result.getYyNetsale() );							//년 매출
				resultSum.setYyDiscount( resultSum.getYyDiscount() + result.getYyDiscount() );						//년 할인
				resultSum.setDayLastyearSplan( resultSum.getDayLastyearSplan() + result.getDayLastyearSplan() );	//전년 일 매출
				resultSum.setMmLastyearSplan( resultSum.getMmLastyearSplan() + result.getMmLastyearSplan() );		//전년 월 매출
				resultSum.setYyLastyearSplan( resultSum.getYyLastyearSplan() + result.getYyLastyearSplan() );		//전년 년 매출
				resultSum.setMmTryMax( resultSum.getMmTryMax() + result.getMmTryMax() ); 							//월 전체 목표
				resultSum.setYyTryMax( resultSum.getYyTryMax() + result.getYyTryMax() ); 							//월 전체 목표
				resultSum.setDayDnfnt2( resultSum.getDayDnfnt2() + result.getDayDnfnt2());
	            resultSum.setMmDnfnt2(resultSum.getMmDnfnt2() + result.getMmDnfnt2());								//전년대비 월 실적 차액
	            resultSum.setYyDnfnt2(resultSum.getYyDnfnt2() + result.getYyDnfnt2());								//전년대비 년 실적 차액
	            resultSum.setMmDnfntMax(resultSum.getMmDnfntMax() + result.getMmDnfntMax());						//진도목표대비 월 차액
	            resultSum.setYyDnfntMax(resultSum.getYyDnfntMax() + result.getYyDnfntMax());	   					//진도목표대비 년 차액
	            resultSum.setSpace("|");
			}
			/*합계 레코드 계산 데이터 만들기 */ 
			resultSum.setDayDnfnt( resultSum.getDayNetsale() - resultSum.getDayTry() ); 																//일 차액
			resultSum.setMmDnfnt( resultSum.getMmNetsale() - resultSum.getMmTry() ); 																	//월 차액
			resultSum.setYyDnfnt( resultSum.getYyNetsale() - resultSum.getYyTry() ); 																	//년 차액
			resultSum.setDayAchivmentrate( ( resultSum.getDayNetsale()  / resultSum.getDayTry()) * 100 );												//일 달성율
			resultSum.setMmAchivmentrate( ( resultSum.getMmNetsale()  / resultSum.getMmTry()) * 100 );													//월 달성율
			resultSum.setYyAchivmentrate( ( resultSum.getYyNetsale()  / resultSum.getYyTry()) * 100 );													//년 달성율
			resultSum.setMmProgresrate( ( resultSum.getMmNetsale()  / resultSum.getMmTryMax()) * 100 );													//월 진도율
			resultSum.setYyProgresrate( ( resultSum.getYyNetsale()  / resultSum.getYyTryMax()) * 100 );													//년 진도율				
			resultSum.setDayIncrsrate( ( ( resultSum.getDayNetsale() - resultSum.getDayLastyearSplan() ) / resultSum.getDayLastyearSplan() ) * 100 );	//일 신장율
			resultSum.setMmIncrsrate( ( ( resultSum.getMmNetsale() - resultSum.getMmLastyearSplan() ) / resultSum.getMmLastyearSplan() ) * 100 );		//월 신장율
			resultSum.setYyIncrsrate( ( ( resultSum.getYyNetsale() - resultSum.getYyLastyearSplan() ) / resultSum.getYyLastyearSplan() ) * 100 );		//년 신장율	
			/*합계 레코드 ADD하기 */
			resultList.add(resultSum);
			
			/**
			 * 실적대비 구성비 계산			 *   
			 */
			for( CorpSaleNewsModel result : resultList ) {
				result.setDayCompRate(result.getDayNetsale() / resultSum.getDayNetsale() * 100);
				result.setMmCompRate(result.getMmNetsale() / resultSum.getMmNetsale() * 100);
				result.setYyCompRate(result.getYyNetsale() / resultSum.getYyNetsale() * 100);
			}
			
		/* 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 등급이 PC 일때 코너조회 */	
		}else if( request.getSerchLevel().equals("pc") ) {
			//등급이 세분류일때
			System.out.println("-----등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request 등급이 PC일때 request ------");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(request);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
			
			/**
			 * 1. 코너 매출 조회 (일,월,년)
			 */
			resultList =  corpSaleNewsMapper.getConerlistTotal(request);

//		}else if( request.getSerchLevel().equals("coner") ) {
//			//등급이 코너일때
//		}else {
//			resultList = new ArrayList<CorpSaleNewsModel>();
		}
		System.out.println(resultList);
		return resultList;
	}


}
