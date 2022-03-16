package com.saydept.api.app.appSayPlusSale;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleModel;
import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleParamModel;
//import com.saydept.api.app.weekTimeSaleNews.model.WeekTimeSaleNewsParamModel;
import com.saydept.utils.SayUtils;

@Service
public class AppSayPlusSaleService {

	@Autowired
	private AppSayPlusSaleMapper appSayPlusSaleMapper;
	
	@Autowired
	private SayUtils sayUtils;

	public List<AppSayPlusSaleModel> appSayPlusSaleList(AppSayPlusSaleParamModel request) throws ParseException {
		// TODO Auto-generated method stub

		// 작년일자
//		request.setFrDateLy(sayUtils.getCusomYear(request.getFrDate(), -1 ));
//	    request.setToDateLy(sayUtils.getCusomYear(request.getToDate(), -1 ));
//	    System.out.println("LastDay"); 					//로그 찍기
//	    System.out.println(request); 					//로그 찍기
	    
		List<AppSayPlusSaleModel> resultList = new ArrayList<AppSayPlusSaleModel>();
    
//		String beforeDay = sayUtils.getCusomDay(request.getSearchDay(), -1 );
//		String beforeYear = sayUtils.getCusomYear(request.getSearchDay(), -1 );
//		System.out.println("before jum");
//		if( request.getSerchLevel().equals(null)		//등급이 null일때
//				) {	
			System.out.println("SerchLevel: all"); 					// 조회레벨 출력
			
			if(request.getJum() == null || request.getJum() == "") {
			request.setJum("01");
		}
			//if(request.getBu() == null) {
//			request.setBu("");
//		}
//			if(request.getTim() == null) {
//				request.setTim("");
//			}

			List<AppSayPlusSaleModel> appSayPlusSaleList = appSayPlusSaleMapper.getAppSayPlusSalelist(request);
			for( AppSayPlusSaleModel data :  appSayPlusSaleList) {
				AppSayPlusSaleModel model = new AppSayPlusSaleModel();
				model.setJum( data.getJum() );
				model.setCdNo( data.getCdNo() );
				model.setSaleDate( data.getSaleDate() );
				model.setSlpNo( data.getSlpNo() );
				model.setClsNm( data.getClsNm() );
				model.setUptCd( data.getUptCd() );
				
				model.setTotAmt( data.getTotAmt() );
				model.setHalAmt( data.getHalAmt() );
				model.setSaleAmt( data.getSaleAmt() );
				model.setSalePoint( data.getSalePoint() );
				
				model.setSaleTime( data.getSaleTime() );
				
				resultList.add( model );
			}
//			System.out.println("all list end");
			
//		} /* -- null end */

		return resultList;
	}
}
